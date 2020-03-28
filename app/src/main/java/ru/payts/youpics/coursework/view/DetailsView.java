package ru.payts.youpics.coursework.view;

import moxy.MvpView;
import moxy.viewstate.strategy.AddToEndSingleStrategy;
import moxy.viewstate.strategy.StateStrategyType;

public interface DetailsView extends MvpView {
    @StateStrategyType(value = AddToEndSingleStrategy.class)
    void updateImageView();
    void setImage(String url);
}
