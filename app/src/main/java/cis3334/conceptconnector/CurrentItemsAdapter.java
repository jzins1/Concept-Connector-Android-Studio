package cis3334.conceptconnector;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CurrentItemsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private List<CurrentItem> currentItems;

    public CurrentItemsAdapter(List<CurrentItem> currentItems) {
        this.currentItems = currentItems;
    }

    @Override


    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)

    {
        // Create a new view.
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_current_item_view, parent, false);

        // Return a new ViewHolder object.
//        return new CurrentItemViewHolder(view);
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        // Get the data for the current position.
        CurrentItem currentItem = currentItems.get(position);

        // Bind the data to the view.
//        ((CurrentItemViewHolder) holder).textView.setText(currentItem.getName());
    }

    @Override
    public int getItemCount() {
        return currentItems.size();
    }

}
