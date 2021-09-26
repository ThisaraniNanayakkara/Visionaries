package com.example.sethsaha;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Notification extends AppCompatActivity {
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification);

            }
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_submit:
                startActivity(new Intent(this, AdminPrescribedProducts.class));
                break;

        }

    }


}