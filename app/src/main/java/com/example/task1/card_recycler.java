package com.example.task1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class card_recycler extends AppCompatActivity {
ArrayList<rowModel> rowModelArrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_recycler);

        RecyclerView recyclerView = findViewById(R.id.cardRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        rowModelArrayList.add(new rowModel(R.drawable.ic_1, "A", "lorem ipsum" ));
        rowModelArrayList.add(new rowModel(R.drawable.ic_2, "B", "lorem ipsum" ));
        rowModelArrayList.add(new rowModel(R.drawable.ic_3, "C", "lorem ipsum" ));
        rowModelArrayList.add(new rowModel(R.drawable.ic_4, "D", "lorem ipsum" ));
        rowModelArrayList.add(new rowModel(R.drawable.ic_1, "A", "lorem ipsum" ));
        rowModelArrayList.add(new rowModel(R.drawable.ic_2, "B", "lorem ipsum" ));
        rowModelArrayList.add(new rowModel(R.drawable.ic_3, "C", "lorem ipsum" ));
        rowModelArrayList.add(new rowModel(R.drawable.ic_4, "D", "lorem ipsum" ));
        rowModelArrayList.add(new rowModel(R.drawable.ic_1, "A", "lorem ipsum" ));
        rowModelArrayList.add(new rowModel(R.drawable.ic_2, "B", "lorem ipsum" ));
        rowModelArrayList.add(new rowModel(R.drawable.ic_3, "C", "lorem ipsum" ));
        rowModelArrayList.add(new rowModel(R.drawable.ic_4, "D", "lorem ipsum" ));
        rowModelArrayList.add(new rowModel(R.drawable.ic_1, "A", "lorem ipsum" ));
        rowModelArrayList.add(new rowModel(R.drawable.ic_2, "B", "lorem ipsum" ));
        rowModelArrayList.add(new rowModel(R.drawable.ic_3, "C", "lorem ipsum" ));
        rowModelArrayList.add(new rowModel(R.drawable.ic_4, "D", "lorem ipsum" ));

        RecyclerAdapter adapter = new RecyclerAdapter(this, rowModelArrayList); // call this line after setting the array list else blank arraylist will be passed
        recyclerView.setAdapter(adapter);
    }
}