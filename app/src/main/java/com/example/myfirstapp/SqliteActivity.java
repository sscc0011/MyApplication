package com.example.myfirstapp;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class SqliteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);

    }
    public void findSmc(View view){
        Log.i("test","**************************************************************");
        EditText et1= (EditText) findViewById(R.id.edit_sqlite);
        String et_name= et1.getText().toString();
        SQLiteDatabase db= openOrCreateDatabase("hksmc.db", Context.MODE_PRIVATE, null);
        Cursor c = db.rawQuery("SELECT * FROM smcprice WHERE name=?",new String[]{et_name});
        while (c.moveToNext()){
            int id = c.getInt(c.getColumnIndex("id"));
            String name = c.getString(c.getColumnIndex("name"));
            String price = c.getString(c.getColumnIndex("price"));
            String supply = c.getString(c.getColumnIndex("supply"));
            Log.i("db", id + "%%%%%%%%" + name + "%%%%%%%%" + price + "%%%%%%%%" + supply);
        }
        c.close();
        db.close();
    }

}
