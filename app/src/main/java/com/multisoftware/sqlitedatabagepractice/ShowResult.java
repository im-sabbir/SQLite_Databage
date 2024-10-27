package com.multisoftware.sqlitedatabagepractice;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ShowResult extends AppCompatActivity {

    TextView show_result;
    DatabaseHelper databaseHelper;

    @SuppressLint({"MissingInflatedId", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_result);


        show_result = findViewById(R.id.show_result);
        databaseHelper = new DatabaseHelper(ShowResult.this);

        Cursor cursor = databaseHelper.searchdatabyname("sabbir");

        show_result.setText("Total data " + cursor.getCount());


        if (cursor!=null && cursor.getCount()>0){
            while (cursor.moveToNext()){

                int id = cursor.getInt(0);
                String name = cursor.getString(1);
                String mobile = cursor.getString(2);
                show_result.append("\nid: "+id + "  name: "+name+"  mobile: "+mobile);
            }
        }else {
            show_result.setText("No result fund");
        }



    }
}