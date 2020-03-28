package ru.payts.youpics.depinj.noDI;

import android.util.Log;

public class White {
    private static final String TAG = "White";

    public White() {
        Green green = new Green();
        Log.d(TAG, "White: " + green.getColor());
        Log.i(TAG, "White : " + green);
    }
}
