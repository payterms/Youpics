package ru.payts.youpics.cyclop;

import android.util.Log;

import io.reactivex.Single;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.schedulers.Schedulers;

class MailingPresenter {

    private static final String TAG = "MailingPresenter";

    Single<String> getOneMail() {
        // использование синтаксического сахара(лямбды-выражения) не приводит к синтаксическому диабету
        Single<String> single = Single.create((SingleOnSubscribe<String>) emitter -> {
            String mail = "You've got a single mail";
            Log.d(TAG, "getSomeMail: " + Thread.currentThread().getName() + ": " + mail);
            emitter.onSuccess(mail);
        }).subscribeOn(Schedulers.io());// делаем в потоке io
        return single;
    }

}
