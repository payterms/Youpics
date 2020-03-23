package ru.payts.youpics.depinj.DI;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import ru.payts.youpics.R;

public class DiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_depinj);

        Green green = new Green();
        Red red = new Red(green);
        White white = new White(green);

    }
}
