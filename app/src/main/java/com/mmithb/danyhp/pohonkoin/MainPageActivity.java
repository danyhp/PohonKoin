package com.mmithb.danyhp.pohonkoin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainPageActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView koinPutihValue, koinHijauValue, koinMerahValue;
    private Button bulletinBtn, settingBtn, merchantBtn, koinPutihBtn, koinHijauBtn, koinMerahBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

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

            default:
                break;
        }
    }
}
