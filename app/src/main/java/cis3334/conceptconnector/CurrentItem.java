package cis3334.conceptconnector;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class CurrentItem {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String item;

    public CurrentItem(String item) {
        this.item = item;
    }

    public String getItem() {
        return item;
    }

    public String toString() {
        return item;
    }
}
