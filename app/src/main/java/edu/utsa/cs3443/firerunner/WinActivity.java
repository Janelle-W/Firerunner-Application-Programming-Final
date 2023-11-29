package edu.utsa.cs3443.firerunner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class WinActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);

        new Handler().postDelayed(() -> {
            Intent intent;
            intent = new Intent(WinActivity.this, MainMenuActivity.class);
            startActivity(intent);
            finish();
        }, 2000);
    }
}