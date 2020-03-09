package ru.payts.youpics.observer;

import android.util.Log;

import java.util.ArrayList;

public class Mailing implements Observable {

    private static final String TAG = "Mailing";

    private ArrayList<Observer> arrayList;
    private String name;
    private String num;

    Mailing() {
        arrayList = new ArrayList<>();
    }

    void newMail(String name, String num) {
        this.name = name;
        this.num = num;

        notifyAllObservers();
    }


    @Override
    public void registerObserver(Observer observer) {
        Log.d(TAG, "registerObserver: ");
        if (!arrayList.contains(observer)) {
            arrayList.add(observer);
        }
        else{
            Log.d(TAG, "This subscriber already in list");
        }
    }

    @Override
    public void unregisterObserver(Observer observer) {
        Log.d(TAG, "unregisterObserver: ");
        arrayList.remove(observer);
    }

    @Override
    public void notifyAllObservers() {
        Log.d(TAG, "notifyAllObservers: ");
        for (int i = 0; i < arrayList.size(); i++) {
            Observer observer = arrayList.get(i);
            observer.updateData(name, num);
        }
    }
}
