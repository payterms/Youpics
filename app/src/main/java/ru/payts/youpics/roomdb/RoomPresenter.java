package ru.payts.youpics.roomdb;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


class RoomPresenter {

    private static final String TAG = "RoomPresenter";

    private UserDao userDao;

    RoomPresenter() {
        userDao = YoupicsAppRoom.getAppDatabase().fruitDao();
    }


    void addUser() {
        User user = new User();
        user.name = "John";
        user.surname = "Smith";
        user.age = 33;

        Disposable disposable = userDao.insert(user).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(id -> {
                    Log.d(TAG, "addUser: " + id);
                }, throwable -> {
                    Log.d(TAG, "addUser: " + throwable);
                });
    }

    void addUsers() {
        List<User> users = new ArrayList<>();
        User user = new User();
        user.name = "George";
        user.surname = "Byron";
        user.age = 44;
        users.add(user);
        user.name = "Ada";
        user.surname = "Lovelace";
        user.age = 22;
        users.add(user);

        Disposable disposable = userDao.insertList(users).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(id -> {
                    for (Long itemId : id) {
                        Log.d(TAG, "addUsers: " + itemId);
                    }
                }, throwable -> {
                    Log.d(TAG, "addUsers: " + throwable);
                });
    }

    void deleteUser() {
        User user = new User();
        user.id = 3;
        Disposable disposable = userDao.delete(user).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(id -> {
                    Log.d(TAG, "deleteUser: " + id);
                }, throwable -> {
                    Log.d(TAG, "deleteUser: " + throwable);
                });

    }

    void updateUser() {
        User user = new User();
        user.id = 1;
        user.name = "John";
        user.surname = "Lennon";
        user.age = 34;

        Disposable disposable = userDao.update(user).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(users -> {
                    Log.d(TAG, "updateUser: " + users + " " + Thread.currentThread().getName());
                }, throwable -> {
                    Log.d(TAG, "updateUser: " + throwable);
                });
    }


}
