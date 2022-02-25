package com.example.mylistapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String s1[], s2[];
        int images[] = {R.drawable.usa, R.drawable.canada, R.drawable.mexico, R.drawable.russia, R.drawable.germany, R.drawable.spain, R.drawable.france, R.drawable.china, R.drawable.japan, R.drawable.newzealand, R.drawable.egypt, R.drawable.greece};

        ListView list = (ListView) findViewById(R.id.theList);

        s1 = getResources().getStringArray(R.array.Countries);
        s2 = getResources().getStringArray(R.array.Region);

        ArrayAdapter adapterA = new ArrayAdapter(this, android.R.layout.simple_list_item_1, s1);
        list.setAdapter(adapterA);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //String temp = " is the best country ever!";
                //Toast.makeText(context.getApplicationContext(), data1[position] + temp, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), MoreInfoActivity.class);
                intent.putExtra("idx", i);
                intent.putExtra("data1", s1);
                intent.putExtra("data2", s2);
                intent.putExtra("imgs", images);
                startActivity(intent);
            }
        });
    }
}