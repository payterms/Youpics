package ru.payts.youpics.mailing;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.schedulers.Schedulers;

class MailingPresenter {

    private static final String TAG = "TeaPresenter";

    Observable<String> getSomeMail() {

        Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                try {
                    for (int i = 0; i < 100; i++) {
                        TimeUnit.SECONDS.sleep(1);
                        String mail = "You've got: " + i + " mail(s)";
                        Log.d(TAG, "getSomeMail: " + Thread.currentThread().getName() + ": " + mail);
                        emitter.onNext(mail);
                    }
                    emitter.onComplete();
                } catch (InterruptedException e) {
                    Log.d(TAG, "getSomeMail: not disposed");
                }
            }
        }).subscribeOn(Schedulers.io());// делаем в потоке io

        return observable;
    }

}
