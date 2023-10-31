package cis3334.conceptconnector;

import android.content.Context;
import android.util.Log;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {CurrentItem.class}, version = 1)
public abstract class CurrentItemDatabase extends RoomDatabase {
    public abstract CurrentItemsDao currentItemsDao();
    private static CurrentItemDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static CurrentItemDatabase getDatabase(final Context context) {
        Log.d("CIS 3334", "CurrentItemDatabase in getDatabase()");
        if (INSTANCE == null) {
            synchronized (CurrentItemDatabase.class) {
                if (INSTANCE == null) {
                    Log.d("CIS 3334", "CurrentItemDatabase in getDatabase() calling databaseBuilder");
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    CurrentItemDatabase.class, "currentItem_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
