package com.mad2021.sethsaha;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;



public class Login extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
//        EditText edtName = findViewById(R.id.edtName);
//        EditText edtPassword = findViewById(R.id.edtPassword);
//        Button btn_login = findViewById(R.id.btn_login);
//        btn_login.setOnClickListener(v->
//        {
//
//        });
    }

//    public void saveUser(View view){
//        String name =edtName.getText().toString();
//        String password = edtPassword.getText().toString();
//        DBHelper dbHelper = new DBHelper(this);
//
//        if(name.isEmpty() || password.isEmpty()){
//            Toast.makeText(this, "Enter values", Toast.LENGTH_SHORT).show();
//        }else{
//            dbHelper.addInfo(name,password);
//        }
//    }
}