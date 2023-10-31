package cis3334.conceptconnector;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class CurrentItemsRepository {
    private CurrentItemsDao currentItemsDao;
    private List<CurrentItem> currentItems;          // list of current items

    CurrentItemsRepository(Application application) {
        CurrentItemDatabase db = CurrentItemDatabase.getDatabase(application);
        currentItemsDao = db.currentItemsDao();
        currentItems = currentItemsDao.getAll();
    }

    List<CurrentItem> getAll() {
        return currentItemsDao.getAll();
    }

    void insert(CurrentItem currentItem) {
        currentItemsDao.insert(currentItem);
    }
}