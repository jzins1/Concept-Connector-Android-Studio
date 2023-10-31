package cis3334.conceptconnector;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface CurrentItemsDao {
    @Query("SELECT * FROM CurrentItem")
    List<CurrentItem> getAll();

    @Query("SELECT * FROM CurrentItem WHERE id = :Id")
    CurrentItem getByIds(int Id);

    @Insert
    void insert(CurrentItem currentItem);

    @Delete
    void delete(CurrentItem currentItem);

    @Update
    void update(CurrentItem currentItem);
}
