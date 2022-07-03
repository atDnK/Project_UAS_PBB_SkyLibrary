package com.udinus.uas_13037_13038_13048_13065;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class ListBookActivity extends AppCompatActivity {
    private RecyclerView rvBook;
    private ArrayList<ListBook> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_book);
        rvBook = findViewById(R.id.rv_book);
        rvBook.setHasFixedSize(true);

        list.addAll(DataBuku.getListData());
        showRecyclerList();
    }

    private void showRecyclerList(){
        rvBook.setLayoutManager(new LinearLayoutManager(this));
        ListBookAdapter listBookAdapter = new ListBookAdapter(list);
        rvBook.setAdapter(listBookAdapter);

        listBookAdapter.setOnItemClickCallback(new ListBookAdapter.OnItemClickCallback(){
            @Override
            public void onItemClicked(ListBook listBook){
                Intent moveIntent = new Intent(ListBookActivity.this, DetailBukuActivity.class);
                moveIntent.putExtra(DetailBukuActivity.ITEM_EXTRA, listBook);
                startActivity(moveIntent);
            }
        });
    }
}