package com.udinus.uas_13037_13038_13048_13065;

import android.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PinjamActivity extends AppCompatActivity {

    DatabaseHelper myDb;
    EditText editJudul,editPenulis,editTahun,editTextId;
    Button btnAddData;
    Button btnViewAll;
    Button btnUpdate;
    Button btnDelete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pinjam);
        myDb = new DatabaseHelper(this);
        editJudul = (EditText)findViewById(R.id.editText_name);
        editPenulis = (EditText)findViewById(R.id.editText_surname);
        editTahun = (EditText)findViewById(R.id.editText_marks);
        editTextId = (EditText)findViewById(R.id.editTextId);
        btnAddData = (Button)findViewById(R.id.button_add);
        btnViewAll = (Button)findViewById(R.id.button_view);
        btnUpdate = (Button)findViewById(R.id.button_update);
        btnDelete = (Button)findViewById(R.id.button_delete);
        AddData();
        viewAll();
        UpdateData();
        deleteData();
    }

    //fungsi hapus
    public void deleteData() {
        btnDelete.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Integer deletedRows = myDb.deleteData(editTextId.getText().toString());
                        if (deletedRows > 0)
                            Toast.makeText(PinjamActivity.this,"Data Deleted",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(PinjamActivity.this,"Data Failed to Deleted!",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    //fungsi update
    public void UpdateData() {
        btnUpdate.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isUpdate = myDb.updateData(editTextId.getText().toString(),
                                editJudul.getText().toString(),
                                editPenulis.getText().toString(),
                                editTahun.getText().toString());
                        if(isUpdate == true)
                            Toast.makeText(PinjamActivity.this,"Data Updated",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(PinjamActivity.this,"Data Failed to Update",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    //fungsi tambah
    public void AddData() {
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDb.insertData(editJudul.getText().toString(),
                                editPenulis.getText().toString(),
                                editTahun.getText().toString());
                        if(isInserted == true) {
                            Toast.makeText(PinjamActivity.this, "Data Iserted", Toast.LENGTH_LONG).show();
                            Intent i = new Intent(PinjamActivity.this, SuccesActivity.class);
                            startActivity(i);
                        }
                        else
                            Toast.makeText(PinjamActivity.this,"Data Not Iserted",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    //fungsi menampilkan data
    public void viewAll() {
        btnViewAll.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        Cursor res = myDb.getAllData();
                        if(res.getCount() == 0) {
                            // show message
                            showMessage("Error","Noting Found");
                            return;
                        }
                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext() ) {
                            buffer.append("Id :"+ res.getString(0)+"\n");
                            buffer.append("Judul :"+ res.getString(1)+"\n");
                            buffer.append("Penulis :"+ res.getString(2)+"\n");
                            buffer.append("Tahun Terbit :"+ res.getString(3)+"\n");
                        }

                        // show all data
                        showMessage("Daftar Buku yang dipinjam",buffer.toString());
                    }
                }
        );
    }



    //membuat alert dialog

    public void showMessage(String title, String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}
