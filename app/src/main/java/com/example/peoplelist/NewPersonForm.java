package com.example.peoplelist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewPersonForm extends AppCompatActivity {

    Button btn_ok, btn_cancel;
    EditText et_name, et_age, et_pictureNumber;

    int positionToEdit = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_person_form);

        btn_ok = findViewById(R.id.btn_ok);

        et_age = findViewById(R.id.et_age);
        et_name = findViewById(R.id.et_name);
        et_pictureNumber = findViewById(R.id.et_pictureNumber);

        //listen for incoming date
        Bundle incomingIntent = getIntent().getExtras();

        if( incomingIntent != null){
            String name = incomingIntent.getString("name");
            int age = incomingIntent.getInt("age");
            int pictureNumber = incomingIntent.getInt("pictureNumber");
            positionToEdit = incomingIntent.getInt("edit");

            //fill in the form
            et_name.setText(name);
            et_age.setText(Integer.toString(age));
            et_pictureNumber.setText(Integer.toString(pictureNumber));

        }

        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //get strings form et_ view objects
                String newName = et_name.getText().toString();
                String newAge = et_age.getText().toString();
                String newPictureNumber = et_pictureNumber.getText().toString();

                //put the strings into a message

                //start the main activity again


                Intent i = new Intent(v.getContext(), MainActivity.class);

                i.putExtra("edit", positionToEdit);
                i.putExtra("name", newName);
                i.putExtra("age", newAge);
                i.putExtra("pictureNumber", newPictureNumber);

                startActivity(i);
            }
        });
    }
}