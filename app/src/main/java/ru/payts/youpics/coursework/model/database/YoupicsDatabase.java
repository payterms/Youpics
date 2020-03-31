package ru.payts.youpics.coursework.model.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import ru.payts.youpics.roomdb.User;
import ru.payts.youpics.roomdb.UserDao;

@Database(entities = {HitRec.class}, version = 1, exportSchema = false)
public abstract class YoupicsDatabase extends RoomDatabase {
    public abstract HitDao hitDao();
}
