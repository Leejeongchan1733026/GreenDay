package com.example.greenday;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;

    private Fragment fragment0;
    private Fragment fragment1;
    private Fragment fragment2;
    private Fragment fragment3;
    private Fragment fragment4;
    private Fragment fragment5;
    private Fragment fragment6;
    private Fragment fragment7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragment0 = new Fragment0();
        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();
        fragment4 = new Fragment4();
        fragment5 = new Fragment5();
        fragment6 = new Fragment6();
        fragment7 = new Fragment7();

        getSupportFragmentManager().beginTransaction().add(R.id.framelayout, fragment0).commit();

        tabLayout = findViewById(R.id.tablayout);
        tabLayout.addTab(tabLayout.newTab().setText("tab 1"));
        TabLayout.Tab tab = tabLayout.newTab();
        tab.setText("tab 2");
        tabLayout.addTab(tab);
        tabLayout.addTab(tabLayout.newTab().setText("tab 3"));
        tabLayout.addTab(tabLayout.newTab().setText("tab 4"));
        tabLayout.addTab(tabLayout.newTab().setText("tab 5"));
        tabLayout.addTab(tabLayout.newTab().setText("tab 6"));
        tabLayout.addTab(tabLayout.newTab().setText("tab 7"));
        tabLayout.addTab(tabLayout.newTab().setText("tab 8"));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                Fragment selected = null;

                if (position == 0) {
                    selected = fragment0;
                } else if (position == 1) {
                    selected = fragment1;
                } else if (position == 2) {
                    selected = fragment2;
                } else if (position == 3) {
                    selected = fragment3;
                } else if (position == 4){
                    selected = fragment4;
                } else if (position == 5){
                    selected = fragment5;
                } else if (position == 6){
                    selected = fragment6;
                } else if (position == 7){
                    selected = fragment7;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, selected).commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}