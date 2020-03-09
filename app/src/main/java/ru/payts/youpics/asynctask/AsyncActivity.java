package ru.payts.youpics.asynctask;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.TimeUnit;

import ru.payts.youpics.R;

public class AsyncActivity extends AppCompatActivity {

    private static final String TAG = "AsyncActivity";

    private MyAsyncTask myAsyncTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async);
    }

    public void onClickButton(View view) {
        myAsyncTask = new MyAsyncTask();
        myAsyncTask.execute();
        Log.d(TAG, "onClickButton() from " + Thread.currentThread().getName() + " thread is completed ");
    }

    private static class MyAsyncTask extends AsyncTask<Void, Void, Void> {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Log.d(TAG, "AsyncTask is started from " + Thread.currentThread().getName() + " thread");
        }

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                for (int i = 0; i < 5; i++) {
                    TimeUnit.SECONDS.sleep(1);
                    Log.d(TAG, "This is message #: "  + i + " from " + Thread.currentThread().getName());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            Log.d(TAG, "AsyncTask is completed in " + Thread.currentThread().getName() + " thread");

        }
    }
}
