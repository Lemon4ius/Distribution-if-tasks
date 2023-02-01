package com.example.distributionoftasks.ViewPage;

import static android.content.ContentValues.TAG;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.distributionoftasks.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpResponse;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpStatus;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.StatusLine;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.ClientProtocolException;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.HttpClient;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.client.methods.HttpGet;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.impl.client.DefaultHttpClient;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.logging.type.HttpRequest;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import io.grpc.internal.JsonParser;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class CreaterUsers extends Fragment implements View.OnClickListener {
    FirebaseAuth mAuth;

    EditText Email, Password, Name;
    String Iuser ;

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
        mAuth = FirebaseAuth.getInstance();
        Email = view.findViewById(R.id.loginCr);
        Password = view.findViewById(R.id.passwordCr);
        Name = view.findViewById(R.id.nameCr);
        Button button = view.findViewById(R.id.createUser);
        button.setOnClickListener(this);
        Iuser = mAuth.getCurrentUser().getUid();
    }
    private final OkHttpClient httpClient = new OkHttpClient();
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.createUser:
                String query = "http://10.0.2.2:8080/createUser";

                new RequestTask().execute(query);
                try {
                    GetPost(query);
                } catch (Exception e) {
                    Toast.makeText(v.getContext(), "Error request", Toast.LENGTH_SHORT).show();
                }

                break;
        }
    }

    public void GetPost(String query) {
        HashMap<String, String> data = new HashMap<String, String>();
        data.put("name", Name.getText().toString());
        data.put("email", Email.getText().toString());
        data.put("password", Password.getText().toString());
        AsyncHttpPost asyncHttpPost = new AsyncHttpPost(data);
        asyncHttpPost.setListener(new AsyncHttpPost.Listener(){
            @Override
            public void onResult(String result) {
                // do something, using return value from network
            }
        });
        asyncHttpPost.execute(query);

    }
}

