package com.mmithb.danyhp.pohonkoin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MerchantLoginActivity extends AppCompatActivity {

    private Button signUpMerchantBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_merchant_login);

        signUpMerchantBtn = findViewById(R.id.btn_signup_merchant);
        signUpMerchantBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MerchantLoginActivity.this, SignupMerchantActivity.class));
            }
        });
    }
}
