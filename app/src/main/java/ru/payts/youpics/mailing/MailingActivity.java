package ru.payts.youpics.mailing;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import ru.payts.youpics.R;


public class MailingActivity extends AppCompatActivity {

    private static final String TAG = "MailingActivity";

    private MailingPresenter mailingPresenter;
    private Observable<String> observable;
    private Disposable disposable;

    @BindView(R.id.text_view_activity_mailing)
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxmailing);

        mailingPresenter = new MailingPresenter();
        observable = mailingPresenter.getSomeMail();

        ButterKnife.bind(this);
    }
    @OnClick(R.id.buttonSubscribe)
    public void subscribe(View view) {
        //.observeOn(AndroidSchedulers.mainThread()) - мантра для вывода результата в основной поток
        // т.к. только из основного потока можно работать с View
        // "многокодовость" убираем с помощью лямбда-выражений
        disposable = observable.observeOn(AndroidSchedulers.mainThread()).subscribe(message -> {
            //onNext code
            Log.d(TAG, "onNext: " + Thread.currentThread().getName() + ": " + message);
            textView.setText(message);
        }, throwable -> {
            //onError code
            Log.e(TAG, "onError: " + throwable);
        }, () -> {
            //onComplete code
            Log.d(TAG, "onComplete: ");
        });
        Log.d(TAG, "subscribe: end " + Thread.currentThread().getName());
    }

    @OnClick(R.id.buttonUnSubscribe)
    public void unsubscribe(View view) {
        disposable.dispose();
    }
}
