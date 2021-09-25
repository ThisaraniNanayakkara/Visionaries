package com.mad2021.sethsaha;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

public class EditProduct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editproduct);

        final EditText addPD = findViewById(R.id.addPD);
        final EditText addPname = findViewById(R.id.addPname);
        final EditText addPrice = findViewById(R.id.addPrice);
        final EditText addWeight = findViewById(R.id.addWeight);
        final EditText addDate = findViewById(R.id.addDate);
        final EditText addDes = findViewById(R.id.addDes);
        Button btn_submit = findViewById(R.id.btnsubmit);
        DAOProducts daoProducts = new DAOProducts();
        btn_submit.setOnClickListener(v->
        {
                HashMap<String,Object> hashMap = new HashMap<>();
                hashMap.put("ProductID",addPD.getText().toString());
                hashMap.put("Productname",addPname.getText().toString());
                hashMap.put("ProductPrice",Integer.parseInt(addPrice.getText().toString()));
                hashMap.put("Productweight",Integer.parseInt(addWeight.getText().toString()));
                hashMap.put("Expiredate",addDate.getText().toString());
                hashMap.put("Description",addDes.getText().toString());


            daoProducts.update("-MkM0pGbo9k5FCL3XecG",hashMap).addOnSuccessListener(suc->
            {
                Toast.makeText(this, "Record updated", Toast.LENGTH_SHORT).show();
            }).addOnFailureListener(er->
            {
                Toast.makeText(this, ""+er.getMessage(), Toast.LENGTH_SHORT).show();
            });
        });




//        Button btn_edit = findViewById(R.id.btnsubmit);
//
//        DAOProducts daoProducts = new DAOProducts();
//        Products pro_edit =(Products) getIntent().getSerializableExtra("EDIT");
//        if(pro_edit != null)
//        {
//            btn_edit.setText("UPDATE");
//            addPD.setText(pro_edit.getID());
//            addPname.setText(pro_edit.getPname());
//            addPrice.setText(pro_edit.getPrice());
//            //btn_open.setVisibility(View.GONE);
//
//        }
//        else
//        {
//            btn_edit.setText("EDIT");
//            //btn_open.setVisibility(View.VISIBLE);
//
//        }
//        btn_edit.setOnClickListener(v->
//        {
//            Products products = new Products(addPD.getText().toString(),addPname.getText().toString(),Integer.parseInt(addPrice.getText().toString()),Integer.parseInt(addWeight.getText().toString()),addDate.getText().toString(),addDes.getText().toString());
//            if(pro_edit == null)
//            {
//                daoProducts.add(products).addOnSuccessListener(suc ->
//                {
//                    Toast.makeText(this, "Record inserted", Toast.LENGTH_SHORT).show();
//                }).addOnFailureListener(er ->
//                {
//                    Toast.makeText(this, "" + er.getMessage(), Toast.LENGTH_SHORT).show();
//                });
//            }
//            else
//            {
//                HashMap<String,Object> hashMap = new HashMap<>();
//                hashMap.put("ProductID",addPD.getText().toString());
//                hashMap.put("Productname",addPname.getText().toString());
//                hashMap.put("ProductPrice",Integer.parseInt(addPrice.getText().toString()));
//                hashMap.put("Productweight",Integer.parseInt(addWeight.getText().toString()));
//                hashMap.put("Expiredate",addDate.getText().toString());
//                hashMap.put("Description",addDes.getText().toString());
//
//
//                daoProducts.update(pro_edit.getKey(),hashMap).addOnSuccessListener(suc->
//                {
//                    Toast.makeText(this, "Record updated", Toast.LENGTH_SHORT).show();
//                    finish();
//                }).addOnFailureListener(er->
//                {
//                    Toast.makeText(this, ""+er.getMessage(), Toast.LENGTH_SHORT).show();
//                });
//            }
//        });

    }
}