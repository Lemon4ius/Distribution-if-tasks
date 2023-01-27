package com.example.distributionoftasks.ViewPage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.distributionoftasks.R;
import com.example.distributionoftasks.RecycleViewAddapter;


public class MainMenu extends Fragment {

    RecycleViewAddapter viewAddapter;
    public MainMenu() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_menu, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recycleView = view.findViewById(R.id.recycleView);
        viewAddapter = new RecycleViewAddapter("1", "1", "1");
        recycleView.setAdapter(viewAddapter);
        recycleView.setLayoutManager(new LinearLayoutManager(view.getContext()));

    }



}