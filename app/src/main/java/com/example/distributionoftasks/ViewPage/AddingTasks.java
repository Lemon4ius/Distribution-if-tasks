package com.example.distributionoftasks.ViewPage;

import static android.content.ContentValues.TAG;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.distributionoftasks.R;
import com.example.distributionoftasks.ShowPopUp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


public class AddingTasks extends Fragment {

     EditText Title, Discription;
    public AddingTasks() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_adding_tasks, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
    public void addingInDb(View view) {
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = mAuth.getCurrentUser();
        Title = view.findViewById(R.id.titleAdd);
        Discription = view.findViewById(R.id.discriptionAdd);
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