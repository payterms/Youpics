package ru.payts.youpics.recycler.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import ru.payts.youpics.R;
import ru.payts.youpics.recycler.presenter.IRecyclerThreePresenter;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private static final String TAG = "RecyclerView";
    private IRecyclerThreePresenter iRecyclerMainPresenter;

    MyAdapter(IRecyclerThreePresenter iRecyclerMainPresenter) {
        this.iRecyclerMainPresenter = iRecyclerMainPresenter;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_three, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.position = position;
        iRecyclerMainPresenter.bindView(holder);
    }

    @Override
    public int getItemCount() {
        return iRecyclerMainPresenter.getItemCount();
    }


    class MyViewHolder extends RecyclerView.ViewHolder implements IViewHolder {

        private ImageView imgView;
        private int position = 0;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imgView = itemView.findViewById(R.id.img_view);
        }

        @Override
        public void setView(int resID) {
            imgView.setImageResource(resID);
            imgView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    iRecyclerMainPresenter.imgClicked(position);
                }
            });
        }
        @Override
        public int getPos() {
            return position;
        }
    }
}
