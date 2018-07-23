package com.mmithb.danyhp.pohonkoin;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.mmithb.danyhp.pohonkoin.Model.Merchant;

import java.util.ArrayList;

public class MerchantActivity extends AppCompatActivity {

    private TableLayout tableLayout;
    //    private TableRow rowHeader;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_merchant);

        context = this;
        tableLayout = findViewById(R.id.table_merchant);
//        rowHeader = findViewById(R.id.row_header);

        TableRow rowHeader = new TableRow(context);
        rowHeader.setBackgroundColor(Color.parseColor("#c0c0c0"));
        rowHeader.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,
                TableLayout.LayoutParams.WRAP_CONTENT));
        String[] headerText = {"Merchant Number", "Bank Line", "WA Number", "Status"};

        for (String c : headerText) {
            TextView tv = new TextView(this);
            tv.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                    TableRow.LayoutParams.WRAP_CONTENT));
            tv.setGravity(Gravity.CENTER);
            tv.setTextSize(18);
            tv.setPadding(5, 5, 5, 5);
            tv.setText(c);
            rowHeader.addView(tv);
        }
        tableLayout.addView(rowHeader);


        // DUMMY DATA MERCHANT
        ArrayList<Merchant> listMerchant = new ArrayList<>();
        for (int i = 1; i < 50; i++) {
            listMerchant.add(new Merchant(Integer.toString(i), Integer.toString(i), "08123456789"));
        }


        // DATA ROWS
        if (listMerchant.size() > 0) {

            for (int i = 0; i < listMerchant.size(); i++) {
                TableRow row = new TableRow(context);
                row.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,
                        TableRow.LayoutParams.WRAP_CONTENT));
                String[] colText = {listMerchant.get(i).getMerchantNumber(), listMerchant.get(i).getBankLine(), listMerchant.get(i).getWaNumber(), listMerchant.get(i).getStatus()};
                for (String text : colText) {
                    TextView tv = new TextView(this);
                    tv.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                            TableRow.LayoutParams.WRAP_CONTENT));
                    tv.setGravity(Gravity.CENTER);
                    tv.setTextSize(16);
                    tv.setPadding(5, 5, 5, 5);
                    tv.setText(text);
                    row.addView(tv);
                }
                tableLayout.addView(row);
            }

        }


    }
}
