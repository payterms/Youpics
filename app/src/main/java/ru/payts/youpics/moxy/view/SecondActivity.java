package ru.payts.youpics.moxy.view;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;
import ru.payts.youpics.R;
import ru.payts.youpics.moxy.presenter.SecondPresenter;

public class SecondActivity extends MvpAppCompatActivity implements SecondView {

    private static final String TAG = "SecondActivity";

    private Button button;
    private EditText editText;
    private TextView resultText;

    @InjectPresenter
    SecondPresenter presenter;


//    @ProvidePresenter
//    public SecondPresenter providePresenter() {
//        return new SecondPresenter();
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.d(TAG, "onCreate: ");
        button = findViewById(R.id.button_activity_second);
        editText = findViewById(R.id.editText);
        resultText = findViewById(R.id.resultTextView);
    }

    public void buttonClick(View view) {
        String addOn = editText.getText().toString();
        presenter.onButtonClick(addOn);
    }

    @Override
    public void setResultText(String x) {
        resultText.setText(x);
    }

    @Override
    public void clearEditText() {
        editText.setText("");
    }


}
