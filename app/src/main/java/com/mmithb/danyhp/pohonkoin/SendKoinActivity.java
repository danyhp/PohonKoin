package com.mmithb.danyhp.pohonkoin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class SendKoinActivity extends AppCompatActivity {

    private Button createQRBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_koin);

        createQRBtn = findViewById(R.id.btn_create_qrcode);
        createQRBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(SendKoinActivity.this, QRCodeSendKoinActivity.class));
            }
        });
    }
}
