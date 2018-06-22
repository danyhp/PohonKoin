package com.mmithb.danyhp.pohonkoin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    Button logout;
    TextView userEmailShow;
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logout = (Button) findViewById(R.id.logout);
        userEmailShow = (TextView) findViewById(R.id.user_email);

        firebaseAuth = FirebaseAuth.getInstance();

        if (firebaseAuth.getCurrentUser() == null) {
            finish();

            Intent intent = new Intent(MainActivity.this, login.class);
            startActivity(intent);

            Toast.makeText(this, "Please Log in to continue", Toast.LENGTH_LONG).show();
        }

        firebaseUser = firebaseAuth.getCurrentUser();

        userEmailShow.setText("Successfully Logged In, Your Email = " + firebaseUser.getEmail());

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.signOut();
                finish();

                Intent intent = new Intent(MainActivity.this, login.class);
                startActivity(intent);

                Toast.makeText(MainActivity.this, "Logged Out Successfully", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
