package ru.payts.youpics.coursework.model;

import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import io.reactivex.annotations.Nullable;
import ru.payts.youpics.R;
import ru.payts.youpics.coursework.model.entity.Hit;


public class GlideLoader {
    private static final String TAG = "GlideLoader";

    public void loadImage(Hit hit, ImageView imageView) {

        Glide
                .with(imageView.getContext())
                .load(hit.webformatURL)
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        Log.d(TAG, "onLoadFailed" + e.getMessage());
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        Log.d(TAG, "onResourceReady");
                        return false;
                    }
                })
                .error(R.drawable.notfound)
                .fitCenter()
                .into(imageView);
    }
}
