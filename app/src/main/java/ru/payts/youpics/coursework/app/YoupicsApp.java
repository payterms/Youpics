package ru.payts.youpics.coursework.app;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

public class YoupicsApp extends Application {

    private static YoupicsAppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
//        if (LeakCanary.isInAnalyzerProcess(this)) {
//            return;
//        }
//        LeakCanary.install(this);

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
