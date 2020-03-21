package ru.payts.youpics.roomdb;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import io.reactivex.Single;

@Dao
public interface UserDao {

    @Query("SELECT * FROM table_users")
    Single<List<User>> getAll();

    @Query("SELECT * FROM table_users WHERE id = :id")
    Single<List<User>> getAllById(int id);

    @Insert
    Single<Long> insert(User user);

    @Insert
    Single<List<Long>> insertList(List<User> users);

    @Delete
    Single<Integer> delete(User user);

    @Update
    Single<Integer> update(User user);


}
