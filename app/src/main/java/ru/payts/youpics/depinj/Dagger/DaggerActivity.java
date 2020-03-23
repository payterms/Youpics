package ru.payts.youpics.depinj.Dagger;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import javax.inject.Inject;

import ru.payts.youpics.R;
import ru.payts.youpics.depinj.Dagger.app.DaggApp;

public class DaggerActivity extends AppCompatActivity {

    private static final String TAG = "DaggerActivity";

    @Inject
    Green green;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_depinj);

        DaggApp.getAppComponent().inject(this);

        Red red = new Red();
        White white = new White();

        Log.d(TAG, "onCreate: " + green.getColor());
        Log.i(TAG, "onCreate: " + green);
    }
}
