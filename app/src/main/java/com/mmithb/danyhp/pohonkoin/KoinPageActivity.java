package com.mmithb.danyhp.pohonkoin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class KoinPageActivity extends AppCompatActivity implements View.OnClickListener {

    private Button sendKoinBtn, receiveKoinBtn, createTreeBtn, createdTreeBtn, merchantKoinBtn, koinHistoryBtn;
    private TextView koinDisplay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_koin_page);

        sendKoinBtn = findViewById(R.id.btn_send_koin);
        sendKoinBtn.setOnClickListener(this);

        receiveKoinBtn = findViewById(R.id.btn_receive_koin);
        receiveKoinBtn.setOnClickListener(this);

        createTreeBtn = findViewById(R.id.btn_create_tree);
        createTreeBtn.setOnClickListener(this);

        createdTreeBtn = findViewById(R.id.btn_created_tree);
        createdTreeBtn.setOnClickListener(this);

        merchantKoinBtn = findViewById(R.id.btn_merchant_koin);
        merchantKoinBtn.setOnClickListener(this);

        koinHistoryBtn = findViewById(R.id.btn_koin_history);
        koinHistoryBtn.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        //TODO: intent pindah activity
        switch (v.getId()) {

            case R.id.btn_send_koin:
                break;

            case R.id.btn_receive_koin:
                break;

            case R.id.btn_create_tree:
                break;

            case R.id.btn_created_tree:
                break;

            case R.id.btn_merchant_koin:
                break;

            case R.id.btn_koin_history:
                break;

            default:
                break;
        }
    }
}
