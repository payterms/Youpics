package ru.payts.youpics.depinj.noDI;

import android.util.Log;

public class Red {
    private static final String TAG = "Red";

    public Red() {
        Green green = new Green();
        Log.d(TAG, "Red: " + green.getColor());
        Log.i(TAG, "Red : " + green);
    }
}
