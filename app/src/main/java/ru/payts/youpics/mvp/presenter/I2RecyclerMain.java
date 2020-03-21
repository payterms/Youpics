package ru.payts.youpics.mvp.presenter;

import ru.payts.youpics.mvp.view.IViewHolder;

public interface I2RecyclerMain {
    void bindView(IViewHolder iViewHolder);
    int getItemCount();
    void imgClicked(int itemPos);
}
