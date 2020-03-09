package ru.payts.youpics.mailing;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import ru.payts.youpics.R;


public class MailingActivity extends AppCompatActivity {

    private static final String TAG = "MailingActivity";

    private MailingPresenter mailingPresenter;
    private Observable<String> observable;
    private Disposable disposable;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxmailing);

        textView = findViewById(R.id.text_view_activity_mailing);

        mailingPresenter = new MailingPresenter();
        observable = mailingPresenter.getSomeMail();
    }

    public void subscribe(View view) {
        //.observeOn(AndroidSchedulers.mainThread()) - мантра для вывода результата в основной поток
        // т.к. только из основного потока можно работать с View
        observable.observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<String>() {

            @Override
            public void onSubscribe(Disposable disposable) {
                Log.d(TAG, "onSubscribe: ");
                MailingActivity.this.disposable = disposable;
            }

            @Override
            public void onNext(String s) {
                Log.d(TAG, "onNext: " + Thread.currentThread().getName() + ": " + s);
                textView.setText(s);
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "onError: " + e);
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete: ");
            }
        });
        Log.d(TAG, "subscribe: end " + Thread.currentThread().getName());
    }

    public void unsubscribe(View view) {
        disposable.dispose();
    }
}
