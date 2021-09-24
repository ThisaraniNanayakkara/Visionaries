package com.mad2021.sethsaha;

import android.os.Bundle;
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
//        btn_submit.setOnClickListener(v->
//        {
//            HashMap<String,Object> hashMap = new HashMap<>();
//            hashMap.put("ProductID",addPD.getText().toString());
//            hashMap.put("Productname",addPname.getText().toString());
//            hashMap.put("ProductPrice",addPrice.getText().length());
//            hashMap.put("Productweight",addWeight.getText().length());
//            hashMap.put("Expiredate",addDate.getText().length());
//            hashMap.put("Description",addDes.getText().toString());
//
//
//            daoProducts.update("-MkM0pGbo9k5FCL3XecG",hashMap).addOnSuccessListener(suc->
//            {
//                Toast.makeText(this, "Record updated", Toast.LENGTH_SHORT).show();
//            }).addOnFailureListener(er->
//            {
//                Toast.makeText(this, ""+er.getMessage(), Toast.LENGTH_SHORT).show();
//            });
//        });
    }
}