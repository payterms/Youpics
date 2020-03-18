package ru.payts.youpics.retrofit;

import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

class RetrofitPresenter {

    private static final String TAG = "RetrofitDifPresenter";

    private RetrofitApi retrofitApi;
    private RetrofitActivityView mainView;


    RetrofitPresenter(RetrofitActivityView mainView) {
        retrofitApi = new RetrofitApi();
        this.mainView = mainView;
    }

    void loadUserProfile() {
        Observable<UsrProfile> single = retrofitApi.requestServer();
        Disposable disposable = single.observeOn(AndroidSchedulers.mainThread()).subscribe(user -> {
            mainView.showUserImage(user.avatar_url);
        }, throwable -> {
            Log.e(TAG, "onError");
        });
    }

}
