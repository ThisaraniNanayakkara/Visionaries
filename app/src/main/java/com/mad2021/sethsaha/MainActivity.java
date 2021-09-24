package com.mad2021.sethsaha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

//import com.mad2021.sethsaha.database.DBHelper;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText addPD = findViewById(R.id.addPD);
        final EditText addPname = findViewById(R.id.addPname);
        final EditText addPrice = findViewById(R.id.addPrice);
        final EditText addWeight = findViewById(R.id.addWeight);
        final EditText addDate = findViewById(R.id.addDate);
        final EditText addDes = findViewById(R.id.addDes);
        Button btn_submit = findViewById(R.id.btnsubmit);
        Button btn_open = findViewById(R.id.btnopen);
        btn_open.setOnClickListener(v->
        {
            Intent intent =new Intent(MainActivity.this,RVActivity2.class);
            startActivity(intent);
        });

        DAOProducts daoProducts = new DAOProducts();
        Products pro_edit =(Products) getIntent().getSerializableExtra("EDIT");
        if(pro_edit != null)
        {
            btn_submit.setText("UPDATE");
            addPD.setText(pro_edit.getID());
            addPname.setText(pro_edit.getPname());
            addPrice.setText(pro_edit.getPrice());
            btn_open.setVisibility(View.GONE);

        }
        else
        {
            btn_submit.setText("SUBMIT");
            btn_open.setVisibility(View.VISIBLE);

        }
        btn_submit.setOnClickListener(v->
        {
            Products products = new Products(addPD.getText().toString(),addPname.getText().toString(),addPrice.getText().length(),addWeight.getText().length(),addDate.getText().length(),addDes.getText().toString());
            if(pro_edit == null)
            {
                daoProducts.add(products).addOnSuccessListener(suc ->
                {
                    Toast.makeText(this, "Record inserted", Toast.LENGTH_SHORT).show();
                }).addOnFailureListener(er ->
                {
                    Toast.makeText(this, "" + er.getMessage(), Toast.LENGTH_SHORT).show();
                });
            }
            else
            {
                HashMap<String,Object> hashMap = new HashMap<>();
                hashMap.put("ProductID",addPD.getText().toString());
                hashMap.put("Productname",addPname.getText().toString());
                hashMap.put("ProductPrice",addPrice.getText().length());
                hashMap.put("Productweight",addWeight.getText().length());
                hashMap.put("Expiredate",addDate.getText().length());
                hashMap.put("Description",addDes.getText().toString());


                daoProducts.update(pro_edit.getKey(),hashMap).addOnSuccessListener(suc->
                {
                    Toast.makeText(this, "Record updated", Toast.LENGTH_SHORT).show();
                    finish();
                }).addOnFailureListener(er->
                {
                    Toast.makeText(this, ""+er.getMessage(), Toast.LENGTH_SHORT).show();
                });
            }
        });

    }

}