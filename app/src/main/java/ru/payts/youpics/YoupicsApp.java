package ru.payts.youpics;

import android.app.Application;

import androidx.room.Room;

import ru.payts.youpics.roomdb.AppDatabase;

public class YoupicsApp extends Application {

    private static AppDatabase appDatabase;

    @Override
    public void onCreate() {
        super.onCreate();
        // Экземпляр RoomDatabase очень дорогостоящий, поэтому лучше хранить единственный образец.
        // Можно создать его в любом месте, но удобнее в Application.
        appDatabase = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "room_database").build();
    }

    public static AppDatabase getAppDatabase() {
        return appDatabase;
    }
}
