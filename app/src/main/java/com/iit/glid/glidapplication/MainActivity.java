package com.iit.glid.glidapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.iit.glid.glidapplication.fragment.FragmentWithList;
import com.iit.glid.glidapplication.fragment.FragmentWithRecycler;
import com.iit.glid.glidapplication.fragment.MainFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.main_layout, FragmentWithRecycler.newInstance())
                .commit();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        boolean result = true;

        switch (item.getItemId()) {
            case R.id.action_list:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main_layout, FragmentWithList.newInstance())
                        .commit();
                Log.v("IIT", "action_list clicked in activity");
                result = true;
                break;
            case R.id.action_recycler:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main_layout, FragmentWithRecycler.newInstance())
                        .commit();
                break;
            case R.id.action_add:
                result = false;
                break;


        }


        return result;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v("IIT","on destroy called");
    }
}
