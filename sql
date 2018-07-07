package com.example.ashwin.crud;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText ed1,ed2,ed3;
    Button b1,b2,b3,b4;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1=(EditText)findViewById(R.id.editText);
        ed2=(EditText)findViewById(R.id.editText2);
        ed3=(EditText)findViewById(R.id.editText3);
        b1=(Button)findViewById(R.id.button);
        b2=(Button)findViewById(R.id.button2);
        b3=(Button)findViewById(R.id.button3);
        b4=(Button)findViewById(R.id.button4);

        db=openOrCreateDatabase("xyz.db",MODE_PRIVATE,null);
        db.execSQL("create table if not exists emp(id varchar(10),name varchar(10))");


    }

    public void insert(View view) {
        db.execSQL("insert into emp values('"+ed1.getText().toString()+"','"+ed2.getText().toString()+"');");
    }

    public void delete(View view) {
        db.execSQL("delete from emp where id=('"+ed1.getText().toString()+"');");
    }

    public void update(View view) {
        db.execSQL("update emp set name=('"+ed2.getText().toString()+"') where id=('"+ed1.getText().toString()+"');");
    }

    public void display(View view) {
        ed3.setText("");
        Cursor c=db.rawQuery("select * from emp where id='"+ed1.getText().toString()+"';",null);
        while (c.moveToNext()){
            ed3.append(c.getString(0)+","+c.getString(1));
        }
    }
}
