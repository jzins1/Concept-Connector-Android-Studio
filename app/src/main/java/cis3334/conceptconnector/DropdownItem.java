package cis3334.conceptconnector;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class DropdownItem {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String item;

    public DropdownItem(String item) {
        this.item = item;
    }

    public String getItem() {
        return item;
    }

    public String toString() {
        return item;
    }
}
