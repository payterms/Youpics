package ru.payts.youpics.coursework.app;

import javax.inject.Singleton;

import dagger.Component;
import ru.payts.youpics.coursework.presenter.DetailsPresenter;
import ru.payts.youpics.coursework.presenter.MainPresenter;
import ru.payts.youpics.coursework.view.DetailsActivity;
import ru.payts.youpics.coursework.view.MainActivity;

@Singleton
@Component(modules = {YoupicsAppModule.class})
public interface YoupicsAppComponent {
    void injectMainActivity(MainActivity mainActivity);

    void injectDetailsActivity(DetailsActivity detailsActivity);

    void injectMainPresenter(MainPresenter mainPresenter);

    void injectDetailsPresenter(DetailsPresenter detailsPresenter);
}
