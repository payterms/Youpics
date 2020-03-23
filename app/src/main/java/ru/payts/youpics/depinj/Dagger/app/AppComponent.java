package ru.payts.youpics.depinj.Dagger.app;

import javax.inject.Singleton;

import dagger.Component;
import ru.payts.youpics.depinj.Dagger.DaggerActivity;
import ru.payts.youpics.depinj.Dagger.Red;
import ru.payts.youpics.depinj.Dagger.White;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    void inject(DaggerActivity daggerActivity);
    void inject(Red red);
    void inject(White white);
}
