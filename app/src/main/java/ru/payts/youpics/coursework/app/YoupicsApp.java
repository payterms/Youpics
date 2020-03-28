package ru.payts.youpics.coursework.app;

import android.app.Application;

public class YoupicsApp extends Application {

    private static YoupicsAppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        //чтобы убратиь ошибку " cannot resolve symbol DaggerYoupicsAppComponent "
        // необходимо сбилдить проект (DaggerAppComponent будет в ap_generated_sources)
        appComponent = generateAppComponent();
    }

    public static YoupicsAppComponent getAppComponent() {
        return appComponent;
    }

    public YoupicsAppComponent generateAppComponent() {
        //чтобы убратиь ошибку " cannot resolve symbol DaggerAppComponent "
        // необходимо сбилдить проект (DaggerAppComponent будет в ap_generated_sources)
        return DaggerYoupicsAppComponent
                .builder()
                .youpicsAppModule(new YoupicsAppModule(this))
                .build();
    }
}
