

package com.example.android.jpmc_cwp;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


public class HealthProgramActivity extends AppCompatActivity {

    SQLiteDatabase db;
    EditText s1,s2,s3,s4,s5,s6;
    Button b;
    int DISE;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_program);
        Intent intent = getIntent();
        DISE = intent.getIntExtra("DISE_Code",0);
        db=openOrCreateDatabase("cwf.db",MODE_PRIVATE,null);
        db.execSQL("create table if not exists healthprogram(Davailibility varchar(10),Drequirement varchar(10),Dnew varchar(10),Eavailibility varchar(10),Erequirement varchar(10),Enew varchar(10))");
        s1= (EditText) findViewById(R.id.editText5);
        s2= (EditText) findViewById(R.id.editText6);
        s3= (EditText) findViewById(R.id.editText7);
        s4= (EditText) findViewById(R.id.editText4);
        s5= (EditText) findViewById(R.id.editText8);
        s6= (EditText) findViewById(R.id.editText9);
        b=(Button)findViewById(R.id.button);
        String[] items = new String[]{"Yes","No"};
        try {

            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //String s=s1.getSelectedItem().toString();

                    db.execSQL("insert into healthprogram values('" + s1.getText().toString() + "','" + s2.getText().toString() + "','" + s3.getText().toString() + "','" + s4.getText().toString() + "','" + s5.getText().toString() + "','" + s6.getText().toString() + "');");
                    Toast.makeText(getApplicationContext(),"succesfully inserted", Toast.LENGTH_LONG).show();
                }
            });
        }catch(Exception e){
            Toast.makeText(getApplicationContext(),"failed",Toast.LENGTH_LONG).show();;
        }
    }
}
