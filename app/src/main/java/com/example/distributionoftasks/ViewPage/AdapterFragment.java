package com.example.distributionoftasks.ViewPage;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;

public class AdapterFragment extends FragmentStateAdapter  {
    ArrayList<Fragment> fragment = new ArrayList<>();



    public AdapterFragment(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
        fragment.add(new MainMenu());
        fragment.add(new CreaterUsers());
        fragment.add(new AddingTasks());
        fragment.add(new Profile());
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        return fragment.get(position);
    }

    @Override
    public int getItemCount() {
        return 4;
    }

}
