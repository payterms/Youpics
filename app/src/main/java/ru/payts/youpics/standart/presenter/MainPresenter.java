package ru.payts.youpics.standart.presenter;

import android.util.Log;

import ru.payts.youpics.standart.model.Model;
import ru.payts.youpics.standart.view.MainView;


public class MainPresenter {

    private static final String TAG = "MainPresenter";

    private Model model;
    private MainView mainView;

    public MainPresenter(MainView mainView) {
        Log.d(TAG, "MainPresenter: ");
        this.mainView = mainView;
        model = new Model();
    }

    private String doMagic(String oldString, String addOnString) {
        String result = "";
        if ((oldString != null)) {
			result = result + oldString;
        }
        if (addOnString != null) {
			result = result + addOnString;
        }
        return result;
    }

    public void onButtonClick(String addOnString) {
        if (model != null) {
            String oldString = model.getResultString();
            String newString = doMagic(oldString, addOnString);
            model.setResultString(newString);
            mainView.setResultText(newString);
            mainView.clearEditText();
        }
    }
}
