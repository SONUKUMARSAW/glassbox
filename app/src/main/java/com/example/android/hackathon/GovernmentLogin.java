package com.example.android.hackathon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GovernmentLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_government_login);

        Button govSubmit = findViewById(R.id.govsubmit);

        govSubmit.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {
                Intent governmentPage = new Intent(GovernmentLogin.this, government.class);
                startActivity(governmentPage);
            }
        });
    }
}
