package com.example.distributionoftasks;

import static android.content.ContentValues.TAG;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import java.util.HashMap;
import java.util.Map;

public class AddingTasks extends AppCompatActivity {
    EditText Title, Discription;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding_tasks);
    }

    public void addingInDb(View view) {
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = mAuth.getCurrentUser();

        Title = findViewById(R.id.titleAdd);
        Discription = findViewById(R.id.discriptionAdd);

        Map<String, Object> user = new HashMap<>();
        user.put("tit", Title.getText().toString());
        user.put("dis", Discription.getText().toString());

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        db.collection("users")
                .document(firebaseUser.getUid())
                .collection("tasks")
                .add(user)
                .addOnSuccessListener(documentReference -> Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference))
                .addOnFailureListener(e -> Log.w(TAG, "Error adding document", e));


        ShowPopUp.showPopupWindow(view);
    }

}