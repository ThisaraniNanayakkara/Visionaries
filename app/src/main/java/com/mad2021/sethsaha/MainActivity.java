package com.mad2021.sethsaha;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
        DAOProducts daoProducts = new DAOProducts();
        btn_submit.setOnClickListener(v->
        {
            Products products = new Products(addPD.getText().toString(),addPname.getText().toString(),addPrice.getText().length(),addWeight.getText().length(),addDate.getText().length(),addDes.getText().toString());
            daoProducts.add(products).addOnSuccessListener(suc->
            {
                Toast.makeText(this, "Record inserted", Toast.LENGTH_SHORT).show();
            }).addOnFailureListener(er->
            {
                Toast.makeText(this, ""+er.getMessage(), Toast.LENGTH_SHORT).show();
            });
        });

    }

}