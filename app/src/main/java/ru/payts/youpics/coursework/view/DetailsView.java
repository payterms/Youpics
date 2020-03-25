package ru.payts.youpics.coursework.view;

import moxy.MvpView;
import moxy.viewstate.strategy.SkipStrategy;
import moxy.viewstate.strategy.StateStrategyType;

public interface DetailsView extends MvpView {
    @StateStrategyType(value = SkipStrategy.class)
    void updateImageView();
}
