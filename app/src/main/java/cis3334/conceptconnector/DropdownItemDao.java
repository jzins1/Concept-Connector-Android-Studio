package cis3334.conceptconnector;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DropdownItemDao {
    @Query("SELECT * FROM DropdownItem")
    LiveData<List<DropdownItem>> getAll();

    @Query("SELECT * FROM DropdownItem WHERE id = :Id")
    DropdownItem getByIds(int Id);

    @Insert
    void insert(DropdownItem dropdownItem);

    @Delete
    void delete(DropdownItem dropdownItem);
}
