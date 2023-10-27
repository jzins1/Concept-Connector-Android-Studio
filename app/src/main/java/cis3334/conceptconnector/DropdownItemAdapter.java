package cis3334.conceptconnector;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class DropdownItemAdapter extends ArrayAdapter<DropdownItem> {
    public DropdownItemAdapter(Context context, List<DropdownItem> dropdownItems) {
        super(context, android.R.layout.simple_spinner_item, dropdownItems);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Context context = getContext();

        // Create a new TextView.
        TextView textView = new TextView(context);

        // Set the text of the TextView.
        textView.setText(getItem(position).toString());

        return textView;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getView(position, convertView, parent);
    }
}