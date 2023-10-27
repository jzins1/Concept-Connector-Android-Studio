package cis3334.conceptconnector;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class DropdownItemRepository {
    private DropdownItemDao dropdownItemDao;
    private LiveData<List<DropdownItem>> dropdownItems;          // list of pizzas ordered so far

    DropdownItemRepository(Application application) {
        DropdownItemDatabase db = DropdownItemDatabase.getDatabase(application);
        dropdownItemDao = db.dropdownItemDao();
        dropdownItems = dropdownItemDao.getAll();
    }

    LiveData<List<DropdownItem>> getAll() {
        DropdownItemDatabase.databaseWriteExecutor.execute(() -> {
            dropdownItems = dropdownItemDao.getAll();
        });
        return dropdownItems;
    }

    void insert(DropdownItem dropdownItem) {
        DropdownItemDatabase.databaseWriteExecutor.execute(() -> {
            dropdownItemDao.insert(dropdownItem);
        });
    }


}
