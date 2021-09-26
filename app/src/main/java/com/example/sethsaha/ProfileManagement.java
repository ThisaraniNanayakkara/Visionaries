package com.example.sethsaha;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;

public class ProfileManagement extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profilemanagement);
    }

    public void DeleteAccount(View view) {
        ShowDialog();
    }
    private void ShowDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(ProfileManagement.this);
        builder.setTitle("Delete");
        builder.setMessage("Are you sure about deleting the profile?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                documentReference.delete()
                        .addOnSuccessListener(new OnSuccessListener<Void>(){

                            @Override
                            public void onSuccess(Void unused) {
                                public void onSuccess(Void aVoid){

                                }
                            }
                        });
            }
        });
    }
}