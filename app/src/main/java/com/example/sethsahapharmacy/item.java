package com.example.sethsahapharmacy;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class item extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item);



        EditText cName = findViewById(R.id.cName);
        EditText card_num = findViewById(R.id.card_num);
        EditText card_expiry = findViewById(R.id.card_expiry);
        EditText card_name = findViewById(R.id.card_name);
        EditText cvv = findViewById(R.id.cvv);
        Button btn = findViewById(R.id.btn_save);
        Cardcruds cardcruds = new Cardcruds();


        btn.setOnClickListener(v->
        {

            Cardstore cardstore = new Cardstore(cName.getText().toString(), Integer.parseInt(card_num.getText().toString()), Integer.parseInt(card_expiry.getText().toString()),card_name.getText().toString(),Integer.parseInt(cvv.getText().toString()));
            cardcruds.add(cardstore).addOnSuccessListener(suc ->{
                Toast.makeText(this,"Record in",Toast.LENGTH_SHORT).show();
            }).addOnFailureListener(er ->{
                Toast.makeText(this,""+er.getMessage(), Toast.LENGTH_SHORT).show();
            });
        });



    }
}