package cis3334.conceptconnector;

import android.content.Context;
import android.util.Log;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {DropdownItem.class}, version = 1)
public abstract class DropdownItemDatabase extends RoomDatabase {
    public abstract DropdownItemDao dropdownItemDao();
    private static DropdownItemDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static DropdownItemDatabase getDatabase(final Context context) {
        Log.d("CIS 3334", "DropdownItemDatabase in getDatabase()");
        if (INSTANCE == null) {
            synchronized (DropdownItemDatabase.class) {
                if (INSTANCE == null) {
                    Log.d("CIS 3334", "DropdownItemDatabase in getDatabase() calling databaseBuilder");
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    DropdownItemDatabase.class, "dropdownItem_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}
