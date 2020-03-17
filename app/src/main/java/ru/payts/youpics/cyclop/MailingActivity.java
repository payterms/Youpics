package ru.payts.youpics.cyclop;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import ru.payts.youpics.R;


public class MailingActivity extends AppCompatActivity {

    private static final String TAG = "MailingActivity";

    private MailingPresenter mailingPresenter;
    private Observable<String> observable;
    private Single<String> single;

    private Disposable disposableSingle;

    // Машу каслом не испортишь (Butterknife)
    @BindView(R.id.text_view_activity_cyclop)
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cyclop);

        mailingPresenter = new MailingPresenter();
        single = mailingPresenter.getOneMail();

        ButterKnife.bind(this);
    }

    @OnClick(R.id.buttonCyclop) // Цепляем слушатель на кнопку циклопки. Кнопка одна - от того и циклопка
    public void subscribeSingle(View view) {
        disposableSingle = single.observeOn(AndroidSchedulers.mainThread()).subscribe(message -> {
            //onSuccess code
            Log.d(TAG, "onSuccess: " + Thread.currentThread().getName() + ": " + message);
            textView.setText(message);
        }, throwable -> {
            //onError code
            Log.e(TAG, "onError: " + throwable);
        });
        Log.d(TAG, "subscribe: end " + Thread.currentThread().getName());
    }

}
