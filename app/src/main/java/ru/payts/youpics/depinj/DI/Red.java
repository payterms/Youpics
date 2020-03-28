package ru.payts.youpics.depinj.DI;

import android.util.Log;

class Red {
    private static final String TAG = "Red";

    private Green green;

    Red(Green green_di) {
        this.green = green_di;
        Log.d(TAG, "Red: " + green.getColor());
        Log.i(TAG, "Red : " + green);
    }
}
