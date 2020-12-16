package com.azapps.cis_intermediate_task;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.azapps.cis_intermediate_task.pojo.Utils;
import com.azapps.cis_intermediate_task.ui.CartFragment;
import com.azapps.cis_intermediate_task.ui.HomeFragment;
import com.azapps.cis_intermediate_task.ui.NotificationFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {
    public static final int CONTAINER = R.id.container_frame_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Utils.replaceFragments(HomeFragment.newInstance(), getSupportFragmentManager(), CONTAINER);

        BottomNavigationView navigationView = findViewById(R.id.bottom_nav_view);
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch (item.getItemId()) {
                    case R.id.nav_home:
                        fragment = HomeFragment.newInstance();
                        break;
                    case R.id.nav_notification:
                        fragment = NotificationFragment.newInstance();
                        break;

                    case R.id.nav_cart:
                        fragment = CartFragment.newInstance();
                        break;
                }
                Utils.replaceFragments(fragment, getSupportFragmentManager(), CONTAINER);
                return true;
            }
        });
    }
}