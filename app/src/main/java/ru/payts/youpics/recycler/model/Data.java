package ru.payts.youpics.recycler.model;

import java.util.ArrayList;
import java.util.List;

public class Data {

    private List<Integer> mList;

    public Data() {
        mList = new ArrayList<>();
    }

    public Data(int cnt) {
        mList = new ArrayList<>(100);
        for (int i = 0; i < cnt ; i++) {
            mList.add(0);
        }
    }

    public int getElementValueAtIndex(int _index){
        return mList.get(_index);
    }

    public void setElementValueAtIndex(int _index, int value){
        mList.set(_index, value);
    }

    public List<Integer> getmList() {
        return mList;
    }
}
