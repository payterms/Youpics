package ru.payts.youpics.depinj.Dagger.app;

import android.app.Application;

public class DaggApp extends Application {

    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = generateAppComponent();
    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }

    public AppComponent generateAppComponent() {
        //чтобы убратиь ошибку " cannot resolve symbol DaggerAppComponent "
        // необходимо сбилдить проект (DaggerAppComponent будет в ap_generated_sources)
        return DaggerAppComponent
                .builder()
                .appModule(new AppModule(this))
                .build();
    }
}
