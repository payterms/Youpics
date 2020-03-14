package ru.payts.youpics.recycler.presenter;

import android.util.Log;

import java.util.List;

import ru.payts.youpics.R;
import ru.payts.youpics.recycler.model.Data;
import ru.payts.youpics.recycler.view.IViewHolder;


public class ThreePresenter {
    private static final String TAG = "ThreePresenter";

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

        @Override
        public void imgClicked(int ID) {
            int val = data.getElementValueAtIndex(ID);
            val++;
            data.setElementValueAtIndex(ID, val);
            Log.d(TAG, String.format("Cat %d clicked %d time(s)", ID, val));
        }
    }

    public RecyclerThreePresenter getRecyclerMainPresenter() {
        return recyclerMainPresenter;
    }


}
