package com.aknur.recyclerviewsaveintanse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private final String KEY="Chack";
    private ArrayList<ListItem> listItems=new ArrayList<>();
    private EditText editText;
    private Button button;
    private RecyclerView recyclerView;
    private MainAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        setClick();
        adapter = new MainAdapter(this, listItems);
        recyclerView.setAdapter(adapter);
    }

    public void init(){
        editText=findViewById(R.id.editer);
        button=findViewById(R.id.buttoner);
        recyclerView=findViewById(R.id.recycler_view);
    }

    public void setClick(){
        button.setOnClickListener(view -> {
                listItems.add(new ListItem(editText.getText().toString()));
                editText.setText(null);
                adapter.notifyDataSetChanged();
                editText.requestFocus();
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList(KEY,listItems);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        listItems.addAll(savedInstanceState.getParcelableArrayList(KEY));
    }
}