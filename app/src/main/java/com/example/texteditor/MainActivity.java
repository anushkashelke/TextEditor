package com.example.texteditor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Typeface;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.os.Bundle;

import java.util.Collections;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    String[] size={"11","12","14","16","18","20"};
    String[] color={"Purple","Teal","Blue","Black"};
    String[] colors={"#FFBB86FC"};
    EditText text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text=findViewById(R.id.editText);
        Spinner spin_text = (Spinner) findViewById(R.id.text);
        spin_text.setOnItemSelectedListener(this);
        Spinner spin_color= (Spinner) findViewById(R.id.color);
        spin_color.setOnItemSelectedListener(this);
        ArrayAdapter ad=new ArrayAdapter(this,android.R.layout.simple_spinner_item,size);
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin_text.setAdapter(ad);
        ArrayAdapter ad2=new ArrayAdapter(this,android.R.layout.simple_spinner_item,color);
        ad2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin_color.setAdapter(ad2);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
         System.out.println("Entered"+size[position]+" ");
         text.setTextSize(Integer.parseInt(size[position]));
         text.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.teal_200));
         text.setTypeface(null, Typeface.ITALIC);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}