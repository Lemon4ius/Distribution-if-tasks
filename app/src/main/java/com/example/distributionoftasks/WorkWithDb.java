package com.example.distributionoftasks;

import static android.content.ContentValues.TAG;

import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


public class WorkWithDb {
    FirebaseFirestore db;
    Map<String, Object> user;

    public WorkWithDb() {
        this.db = FirebaseFirestore.getInstance();
        user = new HashMap<>();
    }

    public  void AddTasks(){
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = mAuth.getCurrentUser();
        user.put("title", "Ada");
        user.put("last", "Lovelace");
        db.document(firebaseUser.getUid()).collection("test")
                .add(user)
                .addOnSuccessListener(documentReference -> Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId()))
                .addOnFailureListener(e -> Log.w(TAG, "Error adding document", e));
    }
}
