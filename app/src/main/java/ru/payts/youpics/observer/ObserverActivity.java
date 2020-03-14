package ru.payts.youpics.observer;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import ru.payts.youpics.R;

public class ObserverActivity extends AppCompatActivity {

    private Mailing mailing = new Mailing();
    private Subscriber subscriber = new Subscriber();
    private int msgID = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_observer);
    }

    public void register(View view) {
        mailing.registerObserver(subscriber);
    }

    public void unregister(View view) {
        mailing.unregisterObserver(subscriber);
    }

    public void emitter(View view) {
        mailing.newMail("Spam message", Integer.toString(msgID));
        msgID++;
    }
}
