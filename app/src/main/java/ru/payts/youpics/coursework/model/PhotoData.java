package ru.payts.youpics.coursework.model;

import java.util.List;

import javax.inject.Inject;

import ru.payts.youpics.coursework.model.entity.Hit;
import ru.payts.youpics.coursework.model.entity.PhotoSet;

public class PhotoData {
    private PhotoSet photoSet;

    @Inject
    public PhotoData(PhotoSet photoSetRef) {
        this.photoSet = photoSetRef;
    }

    public List<Hit> getList() {
        return photoSet.hits;
    }

    public void setList(List<Hit> hitList) {
        photoSet.hits = hitList;
    }

    public int getTotal() {
        return photoSet.total;
    }

    public int getTotalHits() {
        return photoSet.totalHits;
    }

    public void setTotal(int total) {
        this.photoSet.total = total;
    }

    public void setTotalHits(int totalHits) {
        this.photoSet.totalHits = totalHits;
    }

    public Hit getElementValueAtIndex(int _index) {
        return photoSet.hits.get(_index);
    }

    public void setElementValueAtIndex(int _index, Hit value) {
        photoSet.hits.set(_index, value);
    }

    public int getHitListSize(){
        int size = 0;
        if (photoSet!= null){
            size = photoSet.hits.size();
        }
        return size;
    }

}
