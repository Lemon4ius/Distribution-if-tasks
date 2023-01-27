package com.example.distributionoftasks;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.distributionoftasks.ViewPage.AdapterFragment;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.Arrays;
import java.util.List;

public class ViewPagerClass extends AppCompatActivity {
    List<Integer> list = Arrays.asList(R.drawable.ic_outline_home_24, R.drawable.ic_baseline_person_add_alt_24, R.drawable.plus, R.drawable.ic_outline_people_alt_24);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager2);


        TabLayout tabLayout = findViewById(R.id.Table);
        ViewPager2 viewPager2 = findViewById(R.id.pager);

        AdapterFragment fragment = new AdapterFragment(getSupportFragmentManager(), getLifecycle());
        viewPager2.setAdapter(fragment);


        new TabLayoutMediator(tabLayout, viewPager2, (tab, position) ->{
            tab.setIcon(list.get(position));
        }).attach();
    }
}
