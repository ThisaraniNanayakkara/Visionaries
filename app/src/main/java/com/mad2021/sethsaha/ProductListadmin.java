package com.mad2021.sethsaha;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ProductListadmin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.productlistadmin);
        Button btn_addlist = findViewById(R.id.add_btn);
        btn_addlist.setOnClickListener(v->
        {
            Intent intent =new Intent(ProductListadmin.this,MainActivity.class);
            startActivity(intent);
        });

        Button btn_editlist = findViewById(R.id.edit_btnlist);
        btn_editlist.setOnClickListener(v->
        {
            Intent intent =new Intent(ProductListadmin.this,EditProduct.class);
            startActivity(intent);
        });

        Button btn_deletelist = findViewById(R.id.btn_delete_list);
        btn_deletelist.setOnClickListener(v->
        {
            Intent intent =new Intent(ProductListadmin.this,DeleteProduct.class);
            startActivity(intent);
        });
    }
}