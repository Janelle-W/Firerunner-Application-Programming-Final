package edu.utsa.cs3443.firerunner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        setupButtons();
    }

    /*public void onClick(View view) {
        if (view.getId() == R.id.imageButtonMainMenu) {
            navigateToMainMenuActivity();
        } /*else if (view.getId() == R.id.button2) {
            // Handle button2 click (if needed)
        }
    }*/

    private void setupButtons() {
        ImageButton imageButtonMainMenu = findViewById(R.id.imageButtonMainMenu);
        imageButtonMainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToMainMenuActivity();
            }
        });
    }

    private void navigateToMainMenuActivity() {
        Intent intent = new Intent(this, MainMenuActivity.class);
        startActivity(intent);
    }
}
