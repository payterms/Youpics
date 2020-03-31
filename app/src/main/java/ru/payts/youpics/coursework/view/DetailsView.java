package ru.payts.youpics.coursework.view;

import moxy.MvpView;
import moxy.viewstate.strategy.AddToEndSingleStrategy;
import moxy.viewstate.strategy.StateStrategyType;
import ru.payts.youpics.coursework.model.entity.Hit;

public interface DetailsView extends MvpView {
    @StateStrategyType(value = AddToEndSingleStrategy.class)
    void updateImageView();
    void setImage(Hit hit);
}
