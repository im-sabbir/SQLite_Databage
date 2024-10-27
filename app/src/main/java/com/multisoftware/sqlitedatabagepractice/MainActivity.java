package com.multisoftware.sqlitedatabagepractice;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    EditText ed_name, ed_mobile;
    Button Data_insert, Data_show;

    DatabaseHelper dbHelper;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


            ed_name = findViewById(R.id.ed_name);
        ed_mobile = findViewById(R.id.ed_mobile);
            Data_insert = findViewById(R.id.insert_button);
            Data_show = findViewById(R.id.show_button);
            dbHelper = new DatabaseHelper(MainActivity.this);



            Data_insert.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dbHelper.insertdata(ed_name.getText().toString(), ed_mobile.getText().toString());
                    Toast.makeText(MainActivity.this, "Data inserted", Toast.LENGTH_SHORT).show();
                }
            });



            Data_show.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(MainActivity.this, ShowResult.class));
                }
            });
    }
}