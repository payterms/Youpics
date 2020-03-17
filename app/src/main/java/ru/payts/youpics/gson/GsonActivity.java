package ru.payts.youpics.gson;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import butterknife.BindView;
import ru.payts.youpics.R;

public class GsonActivity extends AppCompatActivity {

    private static final String TAG = "GsonActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gson);

        String json = "{\n" +
                " \"time_of_year\": \"summer\",\n" +
                " \"year\": 2019\n"+
                "}";

        Gson gson = new GsonBuilder().create();
        Season season = gson.fromJson(json, Season.class);

        Log.d(TAG, "Time of year: " + season.time_of_year);
        Log.d(TAG, "Year: " + season.year);
    }
}
