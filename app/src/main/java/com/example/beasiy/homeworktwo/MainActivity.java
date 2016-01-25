package com.example.beasiy.homeworktwo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> toDoList;
    ArrayAdapter<String> toDoAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    private void initialize() {
        toDoList = new ArrayList<String>();
        toDoAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, toDoList);
        ListView list = (ListView)findViewById(R.id.list);
        list.setAdapter(toDoAdapter);
        list.setOnItemLongClickListener(
                new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int index, long rowID) {
                        toDoList.remove(index);
                        toDoAdapter.notifyDataSetChanged();
                        return true;
                    }
                }
        );
    }


    public void addItem(View view) {
        EditText item = (EditText)findViewById(R.id.addition);
        toDoList.add(item.getText().toString());
        toDoAdapter.notifyDataSetChanged();
    }
}
