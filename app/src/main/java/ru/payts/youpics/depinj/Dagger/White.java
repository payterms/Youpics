package ru.payts.youpics.depinj.Dagger;

import android.util.Log;

import javax.inject.Inject;

import ru.payts.youpics.depinj.Dagger.app.DaggApp;

public class White {
    private static final String TAG = "White";

    @Inject
    Green green;

    public White() {
        DaggApp.getAppComponent().inject(this);
        Log.d(TAG, "White: " + green.getColor());
        Log.i(TAG, "White: " + green);
    }
}
