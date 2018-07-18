package com.mmithb.danyhp.pohonkoin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainPageActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView koinPutihValue, koinHijauValue, koinMerahValue, emailTxt, nameTxt;
    private Button bulletinBtn, settingBtn, merchantBtn, koinPutihBtn, koinHijauBtn, koinMerahBtn;
    private LinearLayout profileLink;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        //get firebase auth instance
        auth = FirebaseAuth.getInstance();

        //get current user
        final FirebaseUser user = auth.getCurrentUser();


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

        profileLink = findViewById(R.id.ll_profile);
        profileLink.setOnClickListener(this);

        emailTxt = findViewById(R.id.txt_email);
        nameTxt = findViewById(R.id.txt_name);

        emailTxt.setText(user.getEmail());


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

            case R.id.btn_bulletin:
                startActivity(new Intent(MainPageActivity.this, BulletinActivity.class));
                break;

            case R.id.btn_setting:
                startActivity(new Intent(MainPageActivity.this, SettingsActivity.class));
                break;

            case R.id.ll_profile:
                startActivity(new Intent(MainPageActivity.this, ProfileActivity.class));
                break;

            default:
                break;
        }
    }
}
