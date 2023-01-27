package com.example.distributionoftasks.ViewPage;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.distributionoftasks.R;
import com.example.distributionoftasks.SignUp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.squareup.picasso.Picasso;

import java.util.Objects;


public class Profile extends Fragment implements View.OnClickListener {

    FirebaseUser user;

    TextView Name, Mail;
    ImageView ProfIcon;


    public Profile() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Name = view.findViewById(R.id.namePtf);
        Mail = view.findViewById(R.id.mailPrf);
        ProfIcon = view.findViewById(R.id.iconPrf);
        Button button = view.findViewById(R.id.exit);
        button.setOnClickListener(this);
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

            if (photoUrl == null)
                ProfIcon.setImageResource(R.drawable.dog);
            else {
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


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.exit:
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(v.getContext(), SignUp.class);
                startActivity(intent);
                break;
        }
    }
}
