package ru.payts.youpics.observer;

public interface Observable {
    void registerObserver(Observer observer);
    void unregisterObserver(Observer observer);
    void notifyAllObservers();
}
