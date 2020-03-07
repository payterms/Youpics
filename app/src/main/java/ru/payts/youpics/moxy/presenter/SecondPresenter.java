package ru.payts.youpics.moxy.presenter;


import android.util.Log;

import moxy.InjectViewState;
import moxy.MvpPresenter;
import ru.payts.youpics.moxy.model.SecondModel;
import ru.payts.youpics.moxy.view.SecondView;

@InjectViewState
public class SecondPresenter extends MvpPresenter<SecondView> {

	private static final String TAG = "SecondPresenter";

	private SecondModel model;

	public SecondPresenter() {
		Log.d(TAG, "SecondPresenter: ");
		this.model = new SecondModel();
	}

	@Override
	protected void onFirstViewAttach() {
		super.onFirstViewAttach();
		Log.d(TAG, "onFirstViewAttach: ");
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

	public void onButtonClick(String addOnString){
		String oldString = model.getResultString();
		String newString = doMagic(oldString, addOnString);
		model.setResultString(newString);
		getViewState().setResultText(newString);
		getViewState().clearEditText();
	}

}
