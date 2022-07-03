package com.udinus.uas_13037_13038_13048_13065;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailBukuActivity extends AppCompatActivity {

    public static final String ITEM_EXTRA = "item_extra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_buku);
        ImageView imgBook = findViewById(R.id.imgBook);
        TextView tvJudulBuku = findViewById(R.id.tvJudulBuku);
        TextView tvDetailBuku = findViewById(R.id.tvDetailBuku);

        ListBook listBook = getIntent().getParcelableExtra(ITEM_EXTRA);
        if (listBook != null){
            Glide.with(this)
                    .load(listBook.getPhoto())
                    .into(imgBook);
            tvJudulBuku.setText(listBook.getJudul());
            tvDetailBuku.setText(listBook.getDetail());
        }
        if (getSupportActionBar() != null){
            getSupportActionBar().setTitle("Detail Buku");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    public void clickPinjam (View view){
        Intent i = new Intent(DetailBukuActivity.this, PinjamActivity.class);
        startActivity(i);
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}