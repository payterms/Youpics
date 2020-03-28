package ru.payts.youpics.coursework.app;

import android.app.Application;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;
import ru.payts.youpics.coursework.model.PhotoData;
import ru.payts.youpics.coursework.model.entity.PhotoSet;
import ru.payts.youpics.coursework.model.retrofit.ApiHelper;

@Module
public class YoupicsAppModule {
    private final Application application;

    public YoupicsAppModule(Application application) {
        this.application = application;
    }

    @Provides
    ApiHelper provideApiHelper() {
        return new ApiHelper();
    }

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


}
