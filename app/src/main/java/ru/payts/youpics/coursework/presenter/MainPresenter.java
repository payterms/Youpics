package ru.payts.youpics.coursework.presenter;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;

import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import moxy.InjectViewState;
import moxy.MvpPresenter;
import ru.payts.youpics.R;
import ru.payts.youpics.coursework.app.YoupicsApp;
import ru.payts.youpics.coursework.model.PhotoData;
import ru.payts.youpics.coursework.model.database.HitDao;
import ru.payts.youpics.coursework.model.database.HitRec;
import ru.payts.youpics.coursework.model.database.YoupicsDatabase;
import ru.payts.youpics.coursework.model.entity.Hit;
import ru.payts.youpics.coursework.model.entity.PhotoSet;
import ru.payts.youpics.coursework.model.retrofit.ApiHelper;
import ru.payts.youpics.coursework.view.IViewHolder;
import ru.payts.youpics.coursework.view.MainView;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {

    private static final String TAG = "MainPresenter";

    // ?? Inject для Dagger - будет создан 1 раз при создании MainPresenter
    private RecyclerMain recyclerMain;

    @Inject
    ApiHelper apiHelper;

    @Inject
    PhotoData photoData;

    @Inject
    YoupicsDatabase appDatabase;

    private HitDao hitDao;

    private Context context;

    public MainPresenter(Context ct) {
        YoupicsApp.getAppComponent().injectMainPresenter(this);
        Log.d(TAG, "MainPresenter: ");
        recyclerMain = new RecyclerMain();
        Log.d(TAG, "recyclerMain: ");
        context = ct;
        hitDao = appDatabase.hitDao();
    }

    @Override
    protected void onFirstViewAttach() {
        getAllHitsFromDatabase(photoData.getList());
    }

    public void getAllPhotoFromServer() {
        String apiKey = context.getString(R.string.pixabay_api_key);
        Observable<PhotoSet> single = apiHelper.requestServer(apiKey);

        Disposable disposable = single.observeOn(AndroidSchedulers.mainThread()).subscribe(photoSet -> {
            photoData.setTotal(photoSet.total);
            photoData.setTotalHits(photoSet.totalHits);
            photoData.setList(photoSet.hits);
            addHits2Database(photoSet.hits);
            getViewState().updateRecyclerView();

        }, throwable -> Log.e(TAG, "onError " + throwable));
    }

    private class RecyclerMain implements I2RecyclerMain {

        @Override
        public void bindView(IViewHolder iViewHolder) {
            int width = 480;
            int height = 640;
            DisplayMetrics metrics = new DisplayMetrics();
            WindowManager windowManager = (WindowManager) context
                    .getSystemService(Context.WINDOW_SERVICE);
            if (windowManager != null) {
                windowManager.getDefaultDisplay().getMetrics(metrics);
                width = metrics.widthPixels;
                height = metrics.heightPixels;
            }
            if (height > width) {
                // Vertical 2 span Grid layout
                iViewHolder.setImageSize(width / 2, width / 2);
            } else {
                // Landscape 3 span Grid layout
                iViewHolder.setImageSize(width / 3, width / 3);
            }
            iViewHolder.setImage(photoData.getElementValueAtIndex(iViewHolder.getPos()));
        }

        @Override
        public int getItemCount() {
            if (photoData != null) {
                return photoData.getHitListSize();
            }
            return 0;
        }

        @Override
        public void imgClicked(int itemPos) {
            Hit hit = photoData.getElementValueAtIndex(itemPos);
            hit.views++;
            photoData.setElementValueAtIndex(itemPos, hit);
            Log.d(TAG, String.format("Img %d clicked %s time(s)", itemPos, hit.views));
            getViewState().startDetailsActivity(itemPos);
        }
    }

    public RecyclerMain getRecyclerMain() {
        return recyclerMain;
    }

    private void addHits2Database(List<Hit> hits) {
        HitRec dbRec;
        for (Hit item : hits) {
            dbRec = new HitRec();
            dbRec.picId = item.id;
            dbRec.webformatURL = item.webformatURL;
            dbRec.imageWidth = item.imageWidth;
            dbRec.imageHeight = item.imageHeight;
            dbRec.imageSize = item.imageSize;
            dbRec.views = item.views;
            dbRec.userId = item.user_id;
            dbRec.userImageURL = item.userImageURL;

            Disposable disposable = hitDao.insert(dbRec).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                    .subscribe(id -> Log.d(TAG, "dbRec added: " + id), throwable -> Log.d(TAG, "dbRec err: " + throwable));
        }

    }

    private void getAllHitsFromDatabase(List<Hit> hitlist) {
        Disposable disposable;
        disposable = hitDao.getAll().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(hitRecs -> {
                    Hit hit;
                    for (HitRec hitRec : hitRecs) {
                        hit = new Hit();
                        hit.id = hitRec.picId;
                        hit.webformatURL = hitRec.webformatURL;
                        hit.imageWidth = hitRec.imageWidth;
                        hit.imageHeight = hitRec.imageHeight;
                        hit.imageSize = hitRec.imageSize;
                        hit.views = hitRec.views;
                        hit.user_id = hitRec.userId;
                        hit.userImageURL = hitRec.userImageURL;
                        // hitlist.add(hit);
                        // Если ссылка битая для картинки , то пытаемся ее обновить по ее ID
                        String apiKey = context.getString(R.string.pixabay_api_key);
                        Observable<PhotoSet> single = apiHelper.requestServerByID(apiKey, hit.id);
                        Disposable disposableUpd = single.observeOn(AndroidSchedulers.mainThread()).subscribe(photoSet -> {
                            hitlist.add(photoSet.hits.get(0));
                            if (hitlist.size() == hitRecs.size()) {
                                photoData.setTotal(hitRecs.size());
                                photoData.setTotalHits(hitRecs.size());
                                getViewState().updateRecyclerView();
                            }
                            updateItemsByPicIdInDatabase(photoSet.hits.get(0));
                        }, throwable -> Log.e(TAG, "onError " + throwable));

                    }
                    Log.d(TAG, "Got dbRec's items: " + hitRecs.size());
                    if (hitRecs.size() == 0) {
                        // Данных в базе нет - пытаемся получить их с сервера
                        getAllPhotoFromServer();
                    }
                }, throwable -> Log.d(TAG, "dbRec err: " + throwable));
    }

    void checkLinks(List<Hit> hitlist) {
        for (Hit hit : hitlist) {
            try {
                URL url = new URL(hit.webformatURL);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                try {

                    InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                    // Если исключения не возникло - и ссылка живая , то добавляем в список
                    hitlist.add(hit);
                } catch (FileNotFoundException e) {
                    String apiKey = context.getString(R.string.pixabay_api_key);
                    Observable<PhotoSet> single = apiHelper.requestServerByID(apiKey, hit.id);
                    Disposable disposableUpd = single.observeOn(AndroidSchedulers.mainThread()).subscribe(photoSet -> {
                        updateItemsByPicIdInDatabase(photoSet.hits.get(0));
                    }, throwable -> Log.e(TAG, "onError " + throwable));
                } finally {
                    if (urlConnection != null) {
                        urlConnection.disconnect();
                    }

                }
            } catch (Exception e) {
                Log.d(TAG, "checkLinks err " + e);
            }
        }
    }


    private void updateItemsByPicIdInDatabase(Hit item) {
        Disposable disposable = hitDao.getAllByPicId(item.id).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(dbRecs -> {
                    for (HitRec dbRec : dbRecs) {
                        dbRec.webformatURL = item.webformatURL;
                        dbRec.imageWidth = item.imageWidth;
                        dbRec.imageHeight = item.imageHeight;
                        dbRec.imageSize = item.imageSize;
                        dbRec.views = item.views;
                        dbRec.userId = item.user_id;
                        dbRec.userImageURL = item.userImageURL;

                        Disposable disposableUpd = hitDao.update(dbRec).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                                .subscribe(id -> {
                                    Log.d(TAG, "dbRec update " + id);
                                }, throwable -> Log.d(TAG, "dbRec update err: " + throwable));
                    }
                }, throwable -> Log.d(TAG, "dbRec update err: " + throwable));

    }
}
