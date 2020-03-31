package ru.payts.youpics.coursework.view;

import ru.payts.youpics.coursework.model.entity.Hit;

public interface IViewHolder {
    int getPos();
    void setImage(Hit hit);
    void setImageSize(int width,int height);
}
