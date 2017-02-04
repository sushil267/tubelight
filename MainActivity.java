package com.example.dell.hackathon;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_account)
        {
         startActivity(new Intent(this,before_login.class));
            return true;
        }
        else if (id == R.id.action_baby)
        {
            startActivity(new Intent(this,BabyMainActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
       String[] list;
        Intent intent;
        if (id == R.id.first)
        { list= new String[]
                {"week1", "Week2", "Week3", "Week4", "Week5", "Week6", "Week7", "Week8", "Week9",
                        "Week10","Week11", "Week12", "Week13"};
            intent=new Intent(this,ListViewClass.class);
            intent.putExtra("name",list);
            intent.putExtra("tri","first");
            startActivity(intent);
        } else if (id == R.id.second) {
            list= new String[]
                    {"Week14", "Week15", "Week16", "Week17", "Week18", "Week19", "Week20", "Week21",
                            "Week22","Week23","Week24", "Week25", "Week26"};
            intent=new Intent(this,ListViewClass.class);
            intent.putExtra("name",list);
            intent.putExtra("tri","second");
            startActivity(intent);
        } else if (id == R.id.third) {
            list= new String[]
                    {"Week27", "Week28", "Week29", "Week30", "Week31", "Week32", "Week33", "Week34",
                            "Week35","Week36","Week37", "Week38", "Week39","Week40"};
            intent=new Intent(this,ListViewClass.class);
            intent.putExtra("name",list);
            intent.putExtra("tri","third");
            startActivity(intent);
        } else if (id == R.id.remainder) {

        } else if (id == R.id.calendar) {
             intent=new Intent(this,cal.class);
            startActivity(intent);
        } else if (id == R.id.symptoms)
        {


        } else if (id == R.id.week) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        assert drawer != null;
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
