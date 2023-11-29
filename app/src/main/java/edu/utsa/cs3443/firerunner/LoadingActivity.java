package edu.utsa.cs3443.firerunner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class LoadingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        String difficulty = getIntent().getStringExtra("difficulty");

        new Handler().postDelayed(() -> {
            Intent intent;
            switch (difficulty) {
                case "start":
                    intent = new Intent(LoadingActivity.this, GameEasyActivity.class);
                    break;
                case "easy":
                    intent = new Intent(LoadingActivity.this, GameEasyActivity.class);
                    break;
                case "medium":
                    intent = new Intent(LoadingActivity.this, GameMediumActivity.class);
                    break;
                case "hard":
                    intent = new Intent(LoadingActivity.this, GameHardActivity.class);
                    break;
                default:
                    throw new IllegalStateException("Unexpected difficulty level: " + difficulty);
            }
            startActivity(intent);
            finish();
        }, 2000); // 3000 miliseconds delay
    }

}