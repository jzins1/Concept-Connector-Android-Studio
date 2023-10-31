package cis3334.conceptconnector;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class CurrentItemsViewHolder extends RecyclerView.ViewHolder{
    public TextView textView;

    public CurrentItemsViewHolder(View itemView) {
        super(itemView);

        TextView textView = (TextView) itemView;
    }
}
