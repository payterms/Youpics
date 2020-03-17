package ru.payts.youpics.retrofit;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ru.payts.youpics.R;

public class RetrofitActivity extends AppCompatActivity implements RetrofitActivityView {

    private static final String TAG = "RetrofitDifActivity";

    private RetrofitPresenter retrofitPresenter;

    @BindView(R.id.imageViewUser)
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);

        ButterKnife.bind(this);

        retrofitPresenter = new RetrofitPresenter(this);
    }

    @OnClick(R.id.button_activity_retrofit)
    public void onClickButton(View view) {
        Log.d(TAG, "onClickButton: ");
        retrofitPresenter.loadUserProfile();
    }

    @Override
    public void showUserImage(String x) {
        Picasso
                .get()
                .load(x)
                .into(imageView);
    }

    @Override
    public void clearImage() {
        imageView.setImageResource(R.drawable.blackcode);
    }
}
