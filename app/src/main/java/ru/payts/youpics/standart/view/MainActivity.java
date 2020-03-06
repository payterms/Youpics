package ru.payts.youpics.standart.view;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import ru.payts.youpics.R;
import ru.payts.youpics.standart.presenter.MainPresenter;

public class MainActivity extends AppCompatActivity implements MainView {

    private static final String TAG = "MainActivity";

    private Button button;
    private EditText editText;
	private TextView resultText;
    private MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: ");
        button = findViewById(R.id.button_activity_main);
        editText = findViewById(R.id.editText);
		resultText = findViewById(R.id.resultTextView);

        mainPresenter = new MainPresenter(this);
    }


    public void buttonClick(View view) {
    	String addOn = editText.getText().toString();
        mainPresenter.onButtonClick(addOn);
    }

    public void setResultText(String x) {
		resultText.setText(x);
    }

	public void clearEditText() {
		editText.setText("");
	}


}
