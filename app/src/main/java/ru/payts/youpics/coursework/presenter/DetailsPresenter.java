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
import ru.payts.youpics.coursework.view.DetailsView;

@InjectViewState
public class DetailsPresenter extends MvpPresenter<DetailsView> {

    private static final String TAG = "DetailsPresenter";


    @Inject
    ApiHelper apiHelper;

    @Inject
    PhotoData photoData;

    Context context;

    public DetailsPresenter(Context ct) {
        YoupicsApp.getAppComponent().injectDetailsPresenter(this);
        Log.d(TAG, "DetailsPresenter: ");

        context = ct;
    }

    @Override
    protected void onFirstViewAttach() {
        Log.d(TAG, "DetailsPresenter: onFirstViewAttach ");
        //getSinglePhoto(1);
    }

    public void getSinglePhoto(int id) {
        String apiKey = context.getString(R.string.pixabay_api_key);
        Observable<PhotoSet> single = apiHelper.requestServer(apiKey);

        Disposable disposable = single.observeOn(AndroidSchedulers.mainThread()).subscribe(photoSet -> {
            photoData.setTotal(photoSet.total);
            photoData.setTotalHits(photoSet.totalHits);
            photoData.setList(photoSet.hits);
        }, throwable -> {
            Log.e(TAG, "onError " + throwable);
        });
    }

    public String getPhotoUrlByPos(int index) {
        return photoData.getElementValueAtIndex(index).webformatURL;
    }

    private class ActionDetails implements I2Details {
        @Override
        public void imgClicked(int ID) {
            Hit hit = photoData.getElementValueAtIndex(ID);
            hit.views++;
            photoData.setElementValueAtIndex(ID, hit);
            Log.d(TAG, String.format("Img %d clicked %s time(s)", ID, hit.views));
        }
    }


}
