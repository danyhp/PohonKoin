package com.mmithb.danyhp.pohonkoin;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.mmithb.danyhp.pohonkoin.Model.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CreatedTreeActivity extends AppCompatActivity {

    private TableLayout tableLayout;
    private TableLayout tableHeader;
    private TableRow fixedHeader;
    private Context context;
    private TextView totalKoinDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_created_tree);

        totalKoinDisplay = findViewById(R.id.koin_total_amount);

        context = this;
        tableLayout = findViewById(R.id.table_content);
        tableHeader = findViewById(R.id.table_header);
        fixedHeader = findViewById(R.id.fixed_header);

        fixedHeader.setBackgroundColor(Color.parseColor("#c0c0c0"));

        TableRow rowHeader = new TableRow(context);
        rowHeader.setBackgroundColor(Color.parseColor("#c0c0c0"));
        rowHeader.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT));

        ViewGroup.LayoutParams params = rowHeader.getLayoutParams();
        params.height = 0;

        String[] headerText = {"Tree Code", "Remaining Hours", "Collected Koin", "Status"};

        for (String c : headerText) {
            TextView tv = new TextView(this);
            tv.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                    TableRow.LayoutParams.WRAP_CONTENT));
            tv.setGravity(Gravity.CENTER);
            tv.setTextSize(18);
            tv.setPadding(5, 5, 5, 5);
            tv.setText(c);
            fixedHeader.addView(tv);
        }

        for (String c : headerText) {
            TextView tv = new TextView(this);
            tv.setGravity(Gravity.CENTER);
            tv.setTextSize(18);
            tv.setPadding(5, 5, 5, 5);
            tv.setText(c);
            tv.setLayoutParams(params);
            rowHeader.addView(tv);
        }
        tableLayout.addView(rowHeader);


        // DUMMY DATA MERCHANT
        ArrayList<Tree> listTree = new ArrayList<>();
        int maxHours = 480;
        int minHours = 1;
        int maxColKoin = 9000000;
        int minColKoin = 23456;
        Random rand = new Random();
        List<String> listStatus = new ArrayList<String>();
        listStatus.add("Active");
        listStatus.add("Close");
        listStatus.add("Collected");

        for (int i = 1; i < 50; i++) {
            listTree.add(new Tree(Integer.toString(i), rand.nextInt(maxHours - minHours) + 1,
                    rand.nextInt(maxColKoin - minColKoin) + minColKoin, listStatus.get(rand.nextInt(listStatus.size()))));
        }


        // DATA ROWS
        if (listTree.size() > 0) {
            int totalKoin = 0;

            for (int i = 0; i < listTree.size(); i++) {
                TableRow row = new TableRow(context);
                row.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,
                        TableRow.LayoutParams.WRAP_CONTENT));
                String[] colText = {listTree.get(i).getTreeCode(), Integer.toString(listTree.get(i).getRemainingHours()),
                        Integer.toString(listTree.get(i).getCollectedKoin()), listTree.get(i).getStatus()};
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
                totalKoin += listTree.get(i).getCollectedKoin();
            }

            totalKoinDisplay.setText(Integer.toString(totalKoin));
        }

    }

}
