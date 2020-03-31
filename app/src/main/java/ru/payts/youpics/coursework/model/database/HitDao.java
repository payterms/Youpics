package ru.payts.youpics.coursework.model.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import io.reactivex.Single;

@Dao
public interface HitDao {

    @Query("SELECT * FROM table_hits")
    Single<List<HitRec>> getAll();

    @Query("SELECT * FROM table_hits WHERE id = :id")
    Single<List<HitRec>> getAllById(int id);

    @Query("SELECT * FROM table_hits WHERE picId = :picId")
    Single<List<HitRec>> getAllByPicId(String picId);

    @Insert
    Single<Long> insert(HitRec hit);

    @Insert
    Single<List<Long>> insertList(List<HitRec> hitRecs);

    @Delete
    Single<Integer> delete(HitRec hit);

    @Update
    Single<Integer> update(HitRec hit);


}
