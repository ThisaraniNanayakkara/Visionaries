package com.example.sethsahapharmacy;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class Cardcruds {

    private static DatabaseReference databaseReference;
    public Cardcruds() {
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        databaseReference = db.getReference(Cardstore.class.getSimpleName());
    }

    public Task<Void> add(Cardstore cardstore)
    {
        //if (card == null) throw exception
        return databaseReference.push().setValue(cardstore);

    }
    //Delete
    public static Task<Void> remove(String key)
    {
        return databaseReference.child(key).removeValue();
    }


    public Query get() {

        return databaseReference.orderByKey();

    }




}
