package ru.payts.youpics.mvp.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.payts.youpics.R;
import ru.payts.youpics.mvp.model.GlideLoader;
import ru.payts.youpics.mvp.presenter.I2RecyclerMain;


public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {

    private static final String TAG = "MainAdapter";

    private I2RecyclerMain i2RecyclerMain;
    private GlideLoader glideLoader;

    public MainAdapter(Context context, I2RecyclerMain i2RecyclerMain) {
        this.i2RecyclerMain = i2RecyclerMain;
        glideLoader = new GlideLoader(context);
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_mainmvp, viewGroup, false);
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder mainViewHolder, int position) {
        mainViewHolder.position = position;
        i2RecyclerMain.bindView(mainViewHolder);
    }

    @Override
    public int getItemCount() {
        return i2RecyclerMain.getItemCount();
    }

    class MainViewHolder extends RecyclerView.ViewHolder implements IViewHolder {

        private int position = 0;

        @BindView(R.id.pix_img_view)
        ImageView imageView;

        public MainViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public void setImage(String url) {
            glideLoader.loadImage(url, imageView);
            imageView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    i2RecyclerMain.imgClicked(position);
                }
            });
        }

        @Override
        public int getPos() {
            return position;
        }
    }
}
