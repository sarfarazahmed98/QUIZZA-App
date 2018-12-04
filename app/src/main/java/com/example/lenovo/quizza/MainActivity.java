package com.example.lenovo.quizza;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public Spinner spinner;
    int number=0;
    public static final String[] paths = {"Science & Technology", "Sports", "Entertainment"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_item,paths);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> parentView,
                                       View selectedItemView, int position, long id) {
                // Object item = parentView.getItemAtPosition(position);

                number = spinner.getSelectedItemPosition();

            }
            public void onNothingSelected(AdapterView<?> arg0) { // do nothing
            }
        });
    }
    public void onClick(View v)
    {
        EditText userName = (EditText) findViewById(R.id.sname);
        if( userName.getText().toString().length() == 0 )
            userName.setError( "Name should be entered!" );
        else {
            Intent i;
            switch (number){
                case 0:
                    i=new Intent(MainActivity.this, QuestionActivity.class);
                    i.putExtra("name",userName.getText().toString());
                    startActivity(i);
                    break;
                case 1:
                    i=new Intent(MainActivity.this, SQuestionActivity.class);
                    i.putExtra("name",userName.getText().toString());
                    startActivity(i);
                    break;
                case 2:
                    i=new Intent(MainActivity.this, EQuestionActivity.class);
                    i.putExtra("name",userName.getText().toString());
                    startActivity(i);
                    break;
            }

        }
    }
}
