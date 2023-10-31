package cis3334.conceptconnector;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
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
    TextView textViewCurrent;
    TextView textViewConcepts;
    EditText editTextConcept;
    RecyclerView recyclerViewCurrent;
    RecyclerView recyclerViewConcepts;
    DropdownItemRepository dropdownItemRepository;
    DropdownItemAdapter dropdownItemAdapter;
    CurrentItemsAdapter currentItemsAdapter;
    String[] currentItems;
    Integer currentItemsLength = 1;
    List<String> currentItemsList;
    List<String> currentConceptsList;

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
        textViewCurrent = findViewById(R.id.textViewCurrent);
        textViewConcepts = findViewById(R.id.textViewConcepts);
//        recyclerViewCurrent = findViewById(R.id.recyclerViewCurrent); // A recycler view for the current link being built
//        recyclerViewConcepts = findViewById(R.id.recyclerViewConcepts); // A recycler view for the overall stored concepts from database
        currentItemsList = new ArrayList<>();
        currentItemsList.add("-------------------------\n");
        currentConceptsList = new ArrayList<>();

        // Initialize the list of current concepts with a line separator

        buttonAddConcept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: Clear text box when inserting item
                // Insert the item into the database.
                dropdownItemRepository.insert(new DropdownItem(editTextConcept.getText().toString()));
                dropdownItemAdapter.notifyDataSetChanged();
            }
        });

        buttonInsertFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentItemsList.add(currentItemsList.indexOf("-------------------------\n"), spinnerFirst.getSelectedItem().toString() + "\n");
                String listString = "";
                for(int i = 0; i < currentItemsList.size(); i++){
                    listString += currentItemsList.get(i);
                }
                textViewCurrent.setText(listString);
            }
        });

        buttonInsertSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentItemsList.add(spinnerSecond.getSelectedItem().toString() + "\n");
                String listString = "";
                for(int i = 0; i < currentItemsList.size(); i++){
                    listString += currentItemsList.get(i);
                }
                textViewCurrent.setText(listString);
            }
        });

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(currentConceptsList.size() > 0){
                     currentConceptsList.add("\n");
                }
                for(int i = 0; i < currentItemsList.size(); i++){
                    currentConceptsList.add(currentItemsList.get(i));
                }
                String listString = "";
                for(int i = 0; i < currentConceptsList.size(); i++){
                    listString += currentConceptsList.get(i);
                }
                textViewConcepts.setText(listString);
                textViewCurrent.setText("-------------------------\n");
                currentItemsList = new ArrayList<>();
                currentItemsList.add("-------------------------\n");
            }
        });

        populateSpinners();
        initializeFirstRecyclerView();
        initializeSecondRecyclerView();
    }

    public void initializeFirstRecyclerView() {

    }

    public void initializeSecondRecyclerView() {

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