package cis3334.conceptconnector;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

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
    }
}