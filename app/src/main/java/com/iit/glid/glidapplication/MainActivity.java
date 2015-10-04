package com.iit.glid.glidapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.iit.glid.glidapplication.fragment.MainFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.main_layout, MainFragment.newInstance())
                .commit();


    }
}
