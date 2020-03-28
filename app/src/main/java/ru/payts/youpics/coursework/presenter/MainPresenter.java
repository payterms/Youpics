package ru.payts.youpics.coursework.presenter;

import android.content.Context;
import android.util.Log;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import moxy.InjectViewState;
import moxy.MvpPresenter;
import ru.payts.youpics.R;
import ru.payts.youpics.coursework.app.YoupicsApp;
import ru.payts.youpics.coursework.model.PhotoData;
import ru.payts.youpics.coursework.model.entity.Hit;
import ru.payts.youpics.coursework.model.entity.PhotoSet;
import ru.payts.youpics.coursework.model.retrofit.ApiHelper;
import ru.payts.youpics.coursework.view.IViewHolder;
import ru.payts.youpics.coursework.view.MainView;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {

    private static final String TAG = "MainPresenter";

    private RecyclerMain recyclerMain;

    @Inject
    ApiHelper apiHelper;

    @Inject
    PhotoData photoData;

    private Context context;


    public MainPresenter(Context ct) {
        YoupicsApp.getAppComponent().injectMainPresenter(this);
        Log.d(TAG, "MainPresenter: ");
        recyclerMain = new RecyclerMain();
        context = ct;
    }

    @Override
    protected void onFirstViewAttach() {
        getAllPhoto();
    }

    public void getAllPhoto() {
        String apiKey =  context.getString(R.string.pixabay_api_key);
        Observable<PhotoSet> single = apiHelper.requestServer(apiKey);

        Disposable disposable = single.observeOn(AndroidSchedulers.mainThread()).subscribe(photoSet -> {
            photoData.setTotal(photoSet.total);
            photoData.setTotalHits(photoSet.totalHits);
            photoData.setList(photoSet.hits);
            getViewState().updateRecyclerView();

        }, throwable -> {
            Log.e(TAG, "onError " + throwable);
        });
    }

    private class RecyclerMain implements I2RecyclerMain {

        @Override
        public void bindView(IViewHolder iViewHolder) {
            iViewHolder.setImage(photoData.getElementValueAtIndex(iViewHolder.getPos()).webformatURL);
        }

        @Override
        public int getItemCount() {
            if (photoData != null) {
                return photoData.getHitListSize();
            }
            return 0;
        }

        @Override
        public void imgClicked(int ID) {
            Hit hit = photoData.getElementValueAtIndex(ID);
            hit.views++;
            photoData.setElementValueAtIndex(ID, hit);
            Log.d(TAG, String.format("Img %d clicked %s time(s)", ID, hit.views));
            getViewState().startDetailsActivity();
        }
    }

    public RecyclerMain getRecyclerMain() {
        return recyclerMain;
    }
}
