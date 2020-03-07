package ru.payts.youpics.recycler.presenter;


import ru.payts.youpics.recycler.view.IViewHolder;

public interface IRecyclerThreePresenter {
    void bindView(IViewHolder iViewHolder);

    int getItemCount();
}
