package ru.payts.youpics.coursework.presenter;

import ru.payts.youpics.coursework.view.IViewHolder;

public interface I2RecyclerMain {
    void bindView(IViewHolder iViewHolder);
    int getItemCount();
    void imgClicked(int itemPos);
}
