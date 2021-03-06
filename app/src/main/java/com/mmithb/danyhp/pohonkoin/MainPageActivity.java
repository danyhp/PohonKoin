package com.mmithb.danyhp.pohonkoin;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class MainPageActivity extends AppCompatActivity implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {

    private TextView koinPutihValue, koinHijauValue, koinMerahValue, emailTxt, nameTxt;
    private Button bulletinBtn, settingBtn, merchantBtn, koinPutihBtn, koinHijauBtn, koinMerahBtn;
    private FirebaseAuth auth;
    private FirebaseAuth.AuthStateListener authListener;

    private static ViewPager mPager;
    private static int currentPage = 0;
    private static final Integer[] XMEN = {R.drawable.cointree1, R.drawable.cointree2, R.drawable.cointree3};
    private ArrayList<Integer> XMENArray = new ArrayList<Integer>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        init();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        //get firebase auth instance
        auth = FirebaseAuth.getInstance();

        //get current user
        final FirebaseUser user = auth.getCurrentUser();

        authListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (user == null) {
                    // user auth state is changed - user is null
                    // launch login activity
                    startActivity(new Intent(MainPageActivity.this, EmailLoginActivity.class));
                    finish();
                }
            }
        };


        koinPutihValue = findViewById(R.id.jml_koin_putih);
        koinPutihValue.setOnClickListener(this);
        koinPutihBtn = findViewById(R.id.btn_koin_putih);
        koinPutihBtn.setOnClickListener(this);

        koinHijauValue = findViewById(R.id.jml_koin_hijau);
        koinHijauValue.setOnClickListener(this);
        koinHijauBtn = findViewById(R.id.btn_koin_hijau);
        koinHijauBtn.setOnClickListener(this);

        koinMerahValue = findViewById(R.id.jml_koin_merah);
        koinMerahValue.setOnClickListener(this);
        koinMerahBtn = findViewById(R.id.btn_koin_merah);
        koinMerahBtn.setOnClickListener(this);

        merchantBtn = findViewById(R.id.btn_merchant_login);
        merchantBtn.setOnClickListener(this);

        bulletinBtn = findViewById(R.id.btn_bulletin);
        bulletinBtn.setOnClickListener(this);

        settingBtn = findViewById(R.id.btn_setting);
        settingBtn.setOnClickListener(this);

        View headerView = navigationView.getHeaderView(0);

        emailTxt = headerView.findViewById(R.id.emailTextView);
        nameTxt = headerView.findViewById(R.id.nameTextView);

        emailTxt.setText(user.getEmail());

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

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.navigation, menu);
//        return true;
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_account) {
            startActivity(new Intent(MainPageActivity.this, ProfileActivity.class));
        } else if (id == R.id.nav_bulletin) {
            startActivity(new Intent(MainPageActivity.this, BulletinPageActivity.class));
        } else if (id == R.id.nav_settings) {
            startActivity(new Intent(MainPageActivity.this, SettingsActivity.class));
        } else if (id == R.id.nav_logout) {
            signOut();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //TODO: intent pindah activity

            case R.id.jml_koin_putih:
                startActivity(new Intent(MainPageActivity.this, KoinPageActivity.class));
                break;

            case R.id.btn_koin_putih:
                startActivity(new Intent(MainPageActivity.this, KoinPageActivity.class));
                break;

            case R.id.btn_merchant_login:
                startActivity(new Intent(MainPageActivity.this, MerchantLoginActivity.class));
                break;

            default:
                break;
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        auth.addAuthStateListener(authListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (authListener != null) {
            auth.removeAuthStateListener(authListener);
        }
    }

    //sign out method
    public void signOut() {
        auth.signOut();
        finish();
        Intent intent = new Intent(MainPageActivity.this, EmailLoginActivity.class);
        startActivity(intent);
    }

    private void init() {
        for (int i = 0; i < XMEN.length; i++)
            XMENArray.add(XMEN[i]);

        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setAdapter(new ImageSliderAdapter(MainPageActivity.this, XMENArray));
        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);
        indicator.setViewPager(mPager);

        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == XMEN.length) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 3000, 3000);
    }
}
