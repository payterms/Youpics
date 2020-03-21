package ru.payts.youpics.roomdb;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.payts.youpics.R;

public class RoomDbActivity extends AppCompatActivity {

    private RoomPresenter roomPresenter;

    @BindView(R.id.text_view_activity_room)
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roomdb);

        ButterKnife.bind(this);

        roomPresenter = new RoomPresenter();
    }

    public void addUser(View view) {
        roomPresenter.addUser();
    }

    public void addUsers(View view) {
        roomPresenter.addUsers();
    }

    public void updateUser(View view) {
        roomPresenter.updateUser();
    }

    public void deleteUser(View view) {
        roomPresenter.deleteUser();
    }


}
