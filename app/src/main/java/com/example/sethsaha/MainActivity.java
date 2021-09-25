package com.example.sethsaha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textviewR, name, mail, mob, ad, un, pw, bt_reg;
    private EditText nb, email, mobile, address, username, password;

        private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        textviewR = (TextView) findViewById(R.id.textviewR);
        textviewR.setOnClickListener(this);

        name = (TextView) findViewById(R.id.name);
        name.setOnClickListener(this);

        mail = (TextView) findViewById(R.id.mail);
        mail.setOnClickListener(this);

        mob = (TextView) findViewById(R.id.mob);
        mob.setOnClickListener(this);

        ad = (TextView) findViewById(R.id.ad);
        ad.setOnClickListener(this);

        un = (TextView) findViewById(R.id.un);
        un.setOnClickListener(this);

        pw = (TextView) findViewById(R.id.pw);
        pw.setOnClickListener(this);


        bt_reg = (Button) findViewById(R.id.regbutton);
        bt_reg.setOnClickListener(this);

        nb = (EditText) findViewById(R.id.nb);
        email = (EditText) findViewById(R.id.email);
        mobile = (EditText) findViewById(R.id.mobile);
        address = (EditText) findViewById(R.id.address);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.textviewR:
                startActivity(new Intent(this, Login.class));
                break;
            case R.id.regbutton:
                regbutton();
                break;
        }

    }

    private void regbutton() {
        String nb = null;
        nb = nb.getText().toString().trim();
        String email = email.getText().toString().trim();
        String mobile = mobile.getText().toString().trim();
        String address = address.getText().toString().trim();
        String username = username.getText().toString().trim();
        String password = password.getText().toString().trim();

        if(nb.isEmpty()){
            editTextnb.setError("name is required");
            editTextnb.requestFocus();
            return;
        }
    }
}