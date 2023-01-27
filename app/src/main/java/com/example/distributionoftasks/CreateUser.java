package com.example.distributionoftasks;

import static android.content.ContentValues.TAG;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
public class CreateUser extends AppCompatActivity {
    FirebaseAuth mAuth;

    EditText Login, Password, Name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);

        mAuth= FirebaseAuth.getInstance();
        Login= findViewById(R.id.loginCr);
        Password= findViewById(R.id.passwordCr);
        Name= findViewById(R.id.nameCr);

    }

    public void CreateUsers(View view) {
        mAuth.createUserWithEmailAndPassword(Login.getText().toString(), Password.getText().toString())
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d(TAG, "createUserWithEmail:success");

                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(TAG, "createUserWithEmail:failure", task.getException());
                        Toast.makeText(CreateUser.this, "Authentication failed.",
                                Toast.LENGTH_SHORT).show();

                    }
                });

    }


}