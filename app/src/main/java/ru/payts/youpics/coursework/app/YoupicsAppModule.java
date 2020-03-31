package ru.payts.youpics.coursework.app;

import android.app.Application;
import android.content.Context;

import androidx.room.Room;

import java.util.ArrayList;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.payts.youpics.coursework.model.GlideLoader;
import ru.payts.youpics.coursework.model.PhotoData;
import ru.payts.youpics.coursework.model.database.YoupicsDatabase;
import ru.payts.youpics.coursework.model.entity.PhotoSet;
import ru.payts.youpics.coursework.model.retrofit.ApiHelper;
import ru.payts.youpics.coursework.presenter.DetailsPresenter;
import ru.payts.youpics.coursework.presenter.I2RecyclerMain;
import ru.payts.youpics.coursework.presenter.MainPresenter;
import ru.payts.youpics.coursework.view.MainAdapter;

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
    GlideLoader provideGlideLoader() {
        return new GlideLoader();
    }

    @Singleton
    @Provides
    MainPresenter provideMainPresenter(Context context) {
        return new MainPresenter(context);
    }

    @Singleton
    @Provides
    DetailsPresenter provideDetailsPresenter(Context context) {
        return new DetailsPresenter(context);
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
