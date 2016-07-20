package com.anastatia.testing.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.anastatia.testing.R;
import com.anastatia.testing.TestingApp;
import com.anastatia.testing.data.vos.AttractionVO;
import com.anastatia.testing.fragments.AttractionFragment;
import com.anastatia.testing.view.holders.AttractionViewHolder;

/**
 * Created by Nyein Nyein on 7/18/2016.
 */
public class AttractionActivity extends AppCompatActivity implements AttractionViewHolder.ControllerAttractionItem {

    public static Intent newIntent() {
        Intent intent = new Intent(TestingApp.getContext(), AttractionActivity.class);
        return intent;
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attraction);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        FloatingActionButton fabSearch = (FloatingActionButton) findViewById(R.id.fab);
        fabSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Search on Phandeeyar Events", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        if(savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fl_container, AttractionFragment.newInstance())
                    .commit();
        }
    }

    @Override
    public void onTapAttraction(AttractionVO attractionVO, ImageView imageView) {

        Intent intent = AttractionDetailActivity.newIntent(attractionVO.getTitle());
//        ActivityOptionsCompat activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(AttractionActivity.this,
//                new Pair(imageView, getString(R.id.action_settings)));
//        ActivityCompat.startActivity(this, intent, activityOptions.toBundle());
        startActivity(intent);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
