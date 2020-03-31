package ru.payts.youpics.coursework.model.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

import ru.payts.youpics.coursework.model.entity.Hit;

@Entity(tableName = "table_hits")
public class HitRec {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "picId")
    public String picId;

    @ColumnInfo(name = "webformatURL")
    public String webformatURL;

    @ColumnInfo(name = "imageWidth")
    public String imageWidth;

    @ColumnInfo(name = "imageHeight")
    public String imageHeight;

    @ColumnInfo(name = "imageSize")
    public String imageSize;

    @ColumnInfo(name = "views")
    public int views;

    @ColumnInfo(name = "user_id")
    public String userId;

    @ColumnInfo(name = "userImageURL")
    public String userImageURL;

    @NotNull
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", picId='" + picId + '\'' +
                ", webformatURL='" + webformatURL + '\'' +
                ", views='" + views + '\'' +
                '}';
    }

}
