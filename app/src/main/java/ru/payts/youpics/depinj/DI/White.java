package ru.payts.youpics.depinj.DI;

import android.util.Log;

class White {
    private static final String TAG = "White";

    private Green green;

    White(Green green_di) {
        this.green = green_di;
        Log.d(TAG, "White: " + green.getColor());
        Log.i(TAG, "White : " + green);
    }
}
