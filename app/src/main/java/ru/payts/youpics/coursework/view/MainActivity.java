package ru.payts.youpics.coursework.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;
import moxy.presenter.ProvidePresenter;
import ru.payts.youpics.R;
import ru.payts.youpics.coursework.app.YoupicsApp;
import ru.payts.youpics.coursework.presenter.MainPresenter;

public class MainActivity extends MvpAppCompatActivity implements MainView {

    private static final String TAG = "MainActivity";

    private MainAdapter mainAdapter;

    @BindView(R.id.recycler_view_activity_main)
    RecyclerView recyclerView;

    @InjectPresenter
    MainPresenter presenter;

    @ProvidePresenter
    public MainPresenter providePresenter() {
        return new MainPresenter(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmvp);
        YoupicsApp.getAppComponent().injectMainActivity(this);
        ButterKnife.bind(this);
        initRecyclerView();
    }

    private void initRecyclerView() {
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        mainAdapter = new MainAdapter(this, presenter.getRecyclerMain());
        recyclerView.setAdapter(mainAdapter);
    }

    @Override
    public void updateRecyclerView() {
        Log.d(TAG, "updateRecyclerView: ");
        mainAdapter.notifyDataSetChanged();
    }

    @Override
    public void startDetailsActivity() {
        startActivity(new Intent(this, DetailsActivity.class));
    }
}
