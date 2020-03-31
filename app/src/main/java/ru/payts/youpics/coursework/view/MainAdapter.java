package ru.payts.youpics.coursework.view;

import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.payts.youpics.R;
import ru.payts.youpics.coursework.app.YoupicsApp;
import ru.payts.youpics.coursework.model.GlideLoader;
import ru.payts.youpics.coursework.model.entity.Hit;
import ru.payts.youpics.coursework.presenter.I2RecyclerMain;


public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {

    private static final String TAG = "MainAdapter";

    private I2RecyclerMain i2RecyclerMain;

    @Inject
    GlideLoader glideLoader;

    MainAdapter(Context context, I2RecyclerMain i2RecyclerMain) {
        this.i2RecyclerMain = i2RecyclerMain;
        YoupicsApp.getAppComponent().injectMainAdapter(this);
        //glideLoader = new GlideLoader(context);
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

        MainViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public void setImageSize(int width,int height) {
            FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) imageView.getLayoutParams();
            params.width = width;
            params.height = height;
            imageView.setLayoutParams(params);
        }
        @Override
        public void setImage(Hit hit) {
            glideLoader.loadImage(hit, imageView);
            imageView.setOnClickListener(v -> i2RecyclerMain.imgClicked(position));
        }

        @Override
        public int getPos() {
            return position;
        }
    }
}
