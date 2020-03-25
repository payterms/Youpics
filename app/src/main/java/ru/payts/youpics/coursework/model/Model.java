package ru.payts.youpics.coursework.model;

import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.schedulers.Schedulers;

public class Model {

    private static final String TAG = "Model";

    public Observable<String> requestToServer() {

        Observable<String> observable = Observable.create((ObservableOnSubscribe<String>) emitter -> {
            String json = "{'name':'Вова', 'age':'18 лет'}";
            Log.d(TAG, "requestToServer: " + Thread.currentThread().getName() + ": " + json);
            emitter.onNext(json);
        }).subscribeOn(Schedulers.io());

        return observable;
    }
}
