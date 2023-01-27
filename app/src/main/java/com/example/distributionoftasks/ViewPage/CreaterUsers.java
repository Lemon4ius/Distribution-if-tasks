package com.example.distributionoftasks.ViewPage;

import static android.content.ContentValues.TAG;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.distributionoftasks.R;
import com.google.firebase.auth.FirebaseAuth;

import java.util.concurrent.Executor;


public class CreaterUsers extends Fragment {
    FirebaseAuth mAuth;

    EditText Login, Password, Name;


    public CreaterUsers() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_creater_users, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mAuth= FirebaseAuth.getInstance();
        Login= view.findViewById(R.id.loginCr);
        Password= view.findViewById(R.id.passwordCr);
        Name= view.findViewById(R.id.nameCr);

    }

    public void CreateUsers(View view) {
        mAuth.createUserWithEmailAndPassword(Login.getText().toString(), Password.getText().toString())
                .addOnCompleteListener((Executor) this, task -> {
                    if (task.isSuccessful()) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d(TAG, "createUserWithEmail:success");

                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(TAG, "createUserWithEmail:failure", task.getException());
                        Toast.makeText(view.getContext(), "Authentication failed.",
                                Toast.LENGTH_SHORT).show();

                    }
                });

    }
}