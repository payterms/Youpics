package ru.payts.youpics.coursework.view;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;
import moxy.presenter.ProvidePresenter;
import ru.payts.youpics.R;
import ru.payts.youpics.coursework.app.YoupicsApp;
import ru.payts.youpics.coursework.presenter.DetailsPresenter;

public class DetailsActivity extends MvpAppCompatActivity implements DetailsView {

    private static final String TAG = "MainActivity";

    @BindView(R.id.detailsImageView)
    ImageView detailsView;

    @InjectPresenter
    DetailsPresenter presenter;

    @ProvidePresenter
    public DetailsPresenter providePresenter() {
        return new DetailsPresenter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailsmvp);
        YoupicsApp.getAppComponent().injectDetailsActivity(this);
        ButterKnife.bind(this);
        initViews();
    }

    private void initViews(){
        Log.d(TAG, "initViews details: ");
        detailsView.setImageResource(R.drawable.blackcode);
    }

    @Override
    public void updateImageView() {
        Log.d(TAG, "updateRecyclerView: ");
    }
}
