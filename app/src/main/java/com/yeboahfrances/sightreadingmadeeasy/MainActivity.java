package com.yeboahfrances.sightreadingmadeeasy;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);

        //Fragment firstFragment = new About();
        Fragment about = new About();
        Fragment alto = new AltoClef();
        Fragment bass = new BassClef();
        Fragment home = new Home();
        Fragment treble = new TrebleClef();

        setCurrentFragment(home);
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if(itemId == R.id.about_nav){
                setCurrentFragment(about);
            }
            else if(itemId == R.id.alto_nav){
                setCurrentFragment(alto);
            }
            else if(itemId == R.id.bass_nav){
                setCurrentFragment(bass);
            }
            else if(itemId == R.id.home_nav){
                setCurrentFragment(home);
                Button surprise_button = findViewById(R.id.surprise_button);
                //on button click change to surprise view
                //call surpriseButton()
            }
            else if(itemId == R.id.treble_nav){
                setCurrentFragment(treble);
            }
            return true;

        });

    }

    private void setCurrentFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
    }

    private void surpriseButton(){

    }
}