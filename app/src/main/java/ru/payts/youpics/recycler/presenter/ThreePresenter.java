package ru.payts.youpics.recycler.presenter;

import java.util.List;

import ru.payts.youpics.R;
import ru.payts.youpics.recycler.model.Data;
import ru.payts.youpics.recycler.view.IViewHolder;


public class ThreePresenter {

    private RecyclerThreePresenter recyclerMainPresenter = new RecyclerThreePresenter();

    private class RecyclerThreePresenter implements IRecyclerThreePresenter {
        final private int IMG_COUNT = 10;
        private Data data = new Data(IMG_COUNT);
        private List<Integer> list = data.getmList();

        @Override
        public void bindView(IViewHolder holder) {
            holder.setView(R.drawable.blackcode);
        }

        @Override
        public int getItemCount() {
            return list.size();
        }
    }

    public RecyclerThreePresenter getRecyclerMainPresenter() {
        return recyclerMainPresenter;
    }
}
