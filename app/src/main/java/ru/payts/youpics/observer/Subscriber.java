package ru.payts.youpics.observer;

import android.util.Log;

public class Subscriber implements Observer {

    private static final String TAG = "Subscriber";

    public void updateData(String name, String num) {
        Log.d(TAG, "You've got: " + name + " number: " + num);
    }

}