package com.example.soundboardapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private ViewPager2 pager;
    private SliderAdapter adapter;
    private RecyclerView recyclerView;
    private TabLayout tabLayout;
    private DatabaseReference mRootReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
                   setContentView(R.layout.activity_main);
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        mRootReference = FirebaseDatabase.getInstance().getReference();
        tabLayout  =  (TabLayout)findViewById(R.id.TabLayout);
        pager = (ViewPager2)findViewById(R.id.pager);
        adapter = new SliderAdapter(this);
        pager.setAdapter(adapter);
        new TabLayoutMediator(tabLayout, pager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                if(position == 0) tab.setText("Preset Buttons");
                else tab.setText("Custom Buttons");
            }
        }).attach();
    }
    private class SliderAdapter extends FragmentStateAdapter{

        public SliderAdapter(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            if(position == 0) return  new PresetButtonFragment();
            else return new CustomButtonFragment();
        }

        @Override
        public int getItemCount() { return 2; }
    }
    @Override
    protected void onStop() { super.onStop();
    }
}