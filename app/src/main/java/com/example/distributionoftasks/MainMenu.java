package com.example.distributionoftasks;

import static android.content.ContentValues.TAG;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.HashMap;
import java.util.Map;

public class MainMenu extends AppCompatActivity {

    TextView textView;
    RecycleViewAddapter viewAddapter;

    ImageView imageView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);


        RecyclerView recycleView = findViewById(R.id.recycleView);
        viewAddapter = new RecycleViewAddapter("1", "1", "1");
        recycleView.setAdapter(viewAddapter);
        recycleView.setLayoutManager(new LinearLayoutManager(this));






    }

    public void addIndb(){
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        Map<String, Object> user = new HashMap<>();
        user.put("first", "Ada");
        user.put("last", "Lovelace");
        user.put("born", 1815);

// Add a new document with a generated ID
        db.collection("users")
                .add(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error adding document", e);
                    }
                });
    }


    public void opnAddingView(View view) {
        Intent intent = new Intent(this, AddingTasks.class);
        startActivity(intent);
    }

    public void opnProfileView(View view) {
        Intent intent = new Intent(this, Profile.class);
        startActivity(intent);
    }

    public void opnMainView(View view) {
        Intent intent = new Intent(this, MainMenu.class);
        startActivity(intent);
    }

    public void opnAddingPeopleView(View view) {
        Intent intent = new Intent(this, CreateUser.class);
        startActivity(intent);
    }
}