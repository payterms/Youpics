package ru.payts.youpics.coursework.app;

import android.app.Application;
import android.content.Context;

import androidx.room.Room;

import java.util.ArrayList;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.payts.youpics.coursework.model.cache.PicsCache;
import ru.payts.youpics.coursework.model.glide.GlideLoader;
import ru.payts.youpics.coursework.model.PhotoData;
import ru.payts.youpics.coursework.model.database.YoupicsDatabase;
import ru.payts.youpics.coursework.model.entity.PhotoSet;
import ru.payts.youpics.coursework.model.retrofit.ApiHelper;
import ru.payts.youpics.coursework.presenter.DetailsPresenter;
import ru.payts.youpics.coursework.presenter.MainPresenter;

@Module
public class YoupicsAppModule {
    private final Application application;

    public YoupicsAppModule(Application application) {
        this.application = application;
    }

    @Singleton
    @Provides
    ApiHelper provideApiHelper() {
        return new ApiHelper();
    }

    @Singleton
    @Provides
    PhotoData providePhotoData(PhotoSet photoSet) {
        return new PhotoData(photoSet);
    }

    @Provides
    PhotoSet providePhotoSet() {
        PhotoSet photoSet = new PhotoSet();
        photoSet.hits = new ArrayList<>();
        return photoSet;
    }

    @Singleton
    @Provides
    GlideLoader provideGlideLoader(PicsCache picsCache) {
        return new GlideLoader(picsCache);
    }

    @Singleton
    @Provides
    PicsCache provideImageCache() {
        return new PicsCache();
    }

    @Singleton
    @Provides
    MainPresenter provideMainPresenter(Context context) {
        return new MainPresenter(application.getApplicationContext());
    }

    @Singleton
    @Provides
    DetailsPresenter provideDetailsPresenter(Context context) {
        return new DetailsPresenter(application.getApplicationContext());
    }

    @Singleton
    @Provides
    YoupicsDatabase provideappDatabase() {
        return Room.databaseBuilder(application.getApplicationContext(),
                YoupicsDatabase .class, "youpics_database").build();
    }



 /*   @Singleton
    @Provides
    MainAdapter provideMainAdapter(Context context, I2RecyclerMain i2RecyclerMain) {
        return new MainAdapter(context, i2RecyclerMain);
    }*/

}
