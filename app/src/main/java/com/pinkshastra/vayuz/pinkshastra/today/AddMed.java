package com.pinkshastra.vayuz.pinkshastra.today;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.pinkshastra.vayuz.pinkshastra.R;
import com.pinkshastra.vayuz.pinkshastra.today.casepreviewtabs.DialogDate;
import com.pinkshastra.vayuz.pinkshastra.today.casepreviewtabs.Prescription;

import java.util.ArrayList;
import java.util.List;

import fr.ganfra.materialspinner.MaterialSpinner;

public class AddMed extends AppCompatActivity implements AdapterView.OnItemSelectedListener{


    MaterialSpinner spinner,spinner2,spinner3,spinner4,spinner5,spinner6,spinner7;
    EditText medname;
    Toolbar toolbar;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_med);
        toolbar=(Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            }
        });


        String[] ITEMS = {"1", "2", "3"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ITEMS);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner = (MaterialSpinner) findViewById(R.id.spinner);
        spinner.setAdapter(adapter);


        String[] ITEMS1 = {"1", "2", "3"};
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ITEMS1);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner2 = (MaterialSpinner) findViewById(R.id.spinner4);
        spinner2.setAdapter(adapter1);


        String[] ITEMS2 = {"Tablets", "Capsules", "syrup"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ITEMS2);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner3 = (MaterialSpinner) findViewById(R.id.spinner5);
        spinner3.setAdapter(adapter2);




        String[] ITEMS3 = {"Before meal", "After meal"};
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ITEMS3);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner4 = (MaterialSpinner) findViewById(R.id.spinner6);
        spinner4.setAdapter(adapter3);


        String[] ITEMS4 = {"1", "2", "3"};
        ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ITEMS4);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner5 = (MaterialSpinner) findViewById(R.id.spinner1);
        spinner5.setAdapter(adapter4);


        String[] ITEMS5 = {"Tablets", "Capsules", "syrup"};
        ArrayAdapter<String> adapter5 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ITEMS5);
        adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner6 = (MaterialSpinner) findViewById(R.id.spinner2);
        spinner6.setAdapter(adapter5);



        String[] ITEMS6 = {"Before meal", "After meal"};
        ArrayAdapter<String> adapter6 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ITEMS6);
        adapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner7 = (MaterialSpinner) findViewById(R.id.spinner3);
        spinner7.setAdapter(adapter6);



        medname = (EditText) findViewById(R.id.medname);

        DialogDate obj= new DialogDate();
        obj.setMedname(medname.getText().toString());


        submit =(Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddMed.this, Prescription.class));
            }
        });


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
