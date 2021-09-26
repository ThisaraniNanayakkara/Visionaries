package com.example.sethsaha;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.RestrictionsManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import com.example.sethsaha.databinding.AdminprescribedproductsBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;

public class AdminPrescribedProducts extends AppCompatActivity {

    AdminprescribedproductsBinding binding;
    StorageReference storageReference;
    ProgressDialog progressDialog;
    Button btn_submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = AdminprescribedproductsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.imageView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog = new ProgressDialog(AdminPrescribedProducts.this);
                progressDialog.setMessage("Fetching image...");
                progressDialog.setCancelable(false);
                progressDialog.show();

                String enterpres = binding.enterpres.getText().toString();
                storageReference = FirebaseStorage.getInstance().getReference("images/"+enterpres+".jpg");

                try {
                    File localfile = File.createTempFile("tempfile", ".jpg");
                    storageReference.getFile(localfile)
                            .addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                                @Override
                                public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                                    if (progressDialog.isShowing())
                                        progressDialog.dismiss();

                                    Bitmap bitmap = BitmapFactory.decodeFile(localfile.getAbsolutePath());
                                    binding.imageView5.setImageBitmap(bitmap);


                                }
                            }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            if(progressDialog.isShowing())
                                progressDialog.dismiss();
                            Toast.makeText(AdminPrescribedProducts.this, "Failed to retrieve", Toast.LENGTH_SHORT).show();

                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });

        btn_submit = findViewById(R.id.btn_submit);
        btn_submit.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                String message = "New message from SethSaha Pharmacy";
                NotificationCompat.Builder builder = new NotificationCompat.Builder(AdminPrescribedProducts.this

                )
                .setSmallIcon(R.drawable.ic_notification)
                .setContentText("New notification")
                .setContentText(message)
                        .setAutoCancel(true);

                Intent intent1 = new Intent(AdminPrescribedProducts.this,Notification.class);
                intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent1.putExtra("message", message);


                PendingIntent pendingIntent1 = PendingIntent.getActivity(AdminPrescribedProducts.this, 0, intent1,PendingIntent.FLAG_UPDATE_CURRENT);
                builder.setContentIntent(pendingIntent1);


                NotificationManager notificationManager = (NotificationManager)
                        getSystemService(
                                Context.NOTIFICATION_SERVICE
                        );
                notificationManager.notify(0,builder.build());
                }
        });
    }
}