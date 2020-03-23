package ru.payts.youpics.depinj.Dagger;

import android.util.Log;

import javax.inject.Inject;

import ru.payts.youpics.depinj.Dagger.app.DaggApp;

public class Red {
    private static final String TAG = "Red";

    @Inject
    Green green;

    public Red() {
        DaggApp.getAppComponent().inject(this);
        Log.d(TAG, "Red: " + green.getColor());
        Log.i(TAG, "Red: " + green);
    }
}
