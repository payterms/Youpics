package ru.payts.youpics.depinj.Dagger.app;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ru.payts.youpics.depinj.Dagger.Green;


@Module
public class AppModule {

    private final Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Singleton
    @Provides
    Green provideGreen() {
        return new Green();
    }

}
