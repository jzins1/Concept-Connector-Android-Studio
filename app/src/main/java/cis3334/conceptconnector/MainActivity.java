package cis3334.conceptconnector;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Spinner spinnerFirst;
    Spinner spinnerSecond;
    Button buttonInsertFirst;
    Button buttonInsertSecond;
    Button buttonSubmit;
    Button buttonAddConcept;
    Button buttonClearLinks;
    Button buttonClearConcepts;
    EditText editTextConcept;
    RecyclerView recyclerViewCurrent;
    RecyclerView recyclerViewConcepts;
    DropdownItemRepository dropdownItemRepository;
    DropdownItemAdapter dropdownItemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerFirst = findViewById(R.id.spinnerFirst); // Dropdown first concept
        spinnerSecond = findViewById(R.id.spinnerSecond); // Dropdown second concept
        buttonInsertFirst = findViewById(R.id.buttonInsertFirst); // Add first current dropdown item to current link
        buttonInsertSecond = findViewById(R.id.buttonInsertSecond); // Add second current dropdown item to current link
        buttonSubmit = findViewById(R.id.buttonSubmit); // Submit current link to overall links
        buttonAddConcept = findViewById(R.id.buttonAddConcept); // Adds the current edit text to both spinner dropdowns
        buttonClearLinks = findViewById(R.id.buttonClearLinks); // Clear the currently stored overall links
        buttonClearConcepts = findViewById(R.id.buttonClearConcepts); // Clears all the concepts in the spinner dropdowns
        editTextConcept = findViewById(R.id.editTextConcept); // Type a new concept to add to the spinner dropdowns
        recyclerViewCurrent = findViewById(R.id.recyclerViewCurrent); // A recycler view for the current link being built
        recyclerViewConcepts = findViewById(R.id.recyclerViewConcepts); // A recycler view for the overall stored concepts from database

        buttonAddConcept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Insert the item into the database.
                dropdownItemRepository.insert(new DropdownItem(editTextConcept.getText().toString()));
                dropdownItemAdapter.notifyDataSetChanged();
            }
        });

        populateSpinners();
    }

    public void populateSpinners() {
        dropdownItemRepository = new DropdownItemRepository(getApplication());

        LiveData<List<DropdownItem>> dropdownItems = dropdownItemRepository.getAll();

        // Observe the LiveData list and, when it changes, update the spinner.
        dropdownItems.observe(this, new Observer<List<DropdownItem>>() {
            @Override
            public void onChanged(List<DropdownItem> dropdownItems) {
                dropdownItemAdapter = new DropdownItemAdapter(MainActivity.this, dropdownItems);
                // Update the spinner.
                spinnerFirst.setAdapter(dropdownItemAdapter);
                spinnerSecond.setAdapter(dropdownItemAdapter);
            }
        });

    }
}