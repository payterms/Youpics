package ru.payts.youpics.coursework.view;

import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.appcompat.app.ActionBar;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;
import moxy.presenter.ProvidePresenter;
import ru.payts.youpics.R;
import ru.payts.youpics.coursework.app.YoupicsApp;
import ru.payts.youpics.coursework.model.GlideLoader;
import ru.payts.youpics.coursework.model.entity.Hit;
import ru.payts.youpics.coursework.presenter.DetailsPresenter;

public class DetailsActivity extends MvpAppCompatActivity implements DetailsView {

    private static final String TAG = "DetailsActivity";

    private int selectedItemPos;

    @Inject
    GlideLoader glideLoader;

    @BindView(R.id.detailsImageView)
    ImageView detailsImageView;

    @InjectPresenter
    DetailsPresenter presenter;

    @ProvidePresenter
    public DetailsPresenter providePresenter() {
        return new DetailsPresenter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        prepareFullScreenWindow();
        setContentView(R.layout.activity_detailsmvp);
        YoupicsApp.getAppComponent().injectDetailsActivity(this);
        ButterKnife.bind(this);
        Bundle arguments = getIntent().getExtras();
        selectedItemPos = arguments.getInt("clickedItemPos");
        Log.d(TAG, "clickedItemPos: " + selectedItemPos);
        initViews();
    }

    private void initViews() {
        //glideLoader = new GlideLoader(this);
        Log.d(TAG, "initViews details: ");
        detailsImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        detailsImageView.setAdjustViewBounds(true);
        glideLoader.loadImage(presenter.getPhotoByPos(selectedItemPos), detailsImageView);
    }
    private void prepareFullScreenWindow() {
        // remove title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        ActionBar actionBar = getSupportActionBar ();
        if (actionBar!=null){
            actionBar.hide();
        }
    }
    @Override
    public void updateImageView() {
        Log.d(TAG, "updateRecyclerView: ");
    }

    @Override
    public void setImage(Hit hit) {
        glideLoader.loadImage(hit, detailsImageView);
        //detailsImageView.setOnClickListener(v -> presenter.getActionDetails().imgClicked(position));
    }
}
