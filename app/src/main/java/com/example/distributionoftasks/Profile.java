package com.example.distributionoftasks;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.squareup.picasso.Picasso;

import java.util.Objects;

public class Profile extends AppCompatActivity {


    FirebaseUser user;
    View view;
    TextView Name, Mail;
    ImageView ProfIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Name = findViewById(R.id.namePtf);
        Mail = findViewById(R.id.mailPrf);
        ProfIcon = findViewById(R.id.iconPrf);
        SetInformation();
    }

    private void SetInformation() {
         user = FirebaseAuth.getInstance().getCurrentUser();

        if (user != null) {
            // Name, email address, and profile photo Url

            String name = user.getDisplayName();
            String email = user.getEmail();
            Uri photoUrl = user.getPhotoUrl();

            Mail.setText(email);

            if (Objects.equals(name, ""))
                Name.setText("User");
            else
                Name.setText(name);

            if (photoUrl==null)
                ProfIcon.setImageResource(R.drawable.dog);
            else{
                Picasso
                        .get()
                        .load(photoUrl.toString())
                        .into(ProfIcon);
            }


            // The user's ID, unique to the Firebase project. Do NOT use this value to
            // authenticate with your backend server, if you have one. Use
            // FirebaseUser.getIdToken() instead.
            String uid = user.getUid();
        }
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


    public void ExitInApp(View view) {
    }
}