package com.teamvan.testingespresso;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;

    public static TextView name, email;
    public static MenuItem menuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initializing Toolbar and setting it as the actionbar
        toolbar = findViewById(R.id.toolbarTB);
        setSupportActionBar(toolbar);

        //Initializing NavigationView
        NavigationView navigationView = findViewById(R.id.navigation_viewNV);

        mFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();

        // mFragmentTransaction.replace(R.id.containerFL, new Fragment()).commit();

        View header = navigationView.getHeaderView(0);

        ImageView image = header.findViewById(R.id.profile_imageIv);
        name = header.findViewById(R.id.nameTv);
        email = header.findViewById(R.id.emailTv);

        //Setting Navigation View Item Selected Listener to handle the item click of the navigation menu
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            // This method will trigger on item Click of navigation menu
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                //Checking if the item is in checked state or not, if not make it in checked state
                if (menuItem.isChecked()) menuItem.setChecked(false);
                else menuItem.setChecked(true);

                //Closing drawer on item click
                drawerLayout.closeDrawers();

                //Check to see which item was being clicked and perform appropriate action
                switch (menuItem.getItemId()) {
                    case R.id.mn_scan:
                        Toast.makeText(MainActivity.this, "Scan", Toast.LENGTH_SHORT).show();
                        return true;

                    case R.id.mn_report_asset:
                        Toast.makeText(MainActivity.this, "Report Asset", Toast.LENGTH_SHORT).show();
                        return true;

                    case R.id.mn_logout:
                        Toast.makeText(MainActivity.this, "Log out", Toast.LENGTH_SHORT).show();
                        return true;
                }
                return true;
            }
        });

        // Initializing Drawer Layout and ActionBarToggle
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layoutDL);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.openDrawer, R.string.closeDrawer) {

            @Override
            public void onDrawerClosed(View drawerView) {
                // Code here will be triggered once the drawer closes as we dont want anything to happen so we leave this blank
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                // Code here will be triggered once the drawer open as we dont want anything to happen so we leave this blank

                super.onDrawerOpened(drawerView);
            }
        };

        //Setting the actionbarToggle to drawer layout
        drawerLayout.setDrawerListener(actionBarDrawerToggle);

        //calling sync state is necessary or else your hamburger icon won't show up
        actionBarDrawerToggle.syncState();
    }
}
