package com.mad2021.sethsaha;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;



public class Login extends AppCompatActivity {

//    EditText edtName, edtPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
//        edtName = findViewById(R.id.edtName);
//        edtPassword = findViewById(R.id.edtPassword);
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