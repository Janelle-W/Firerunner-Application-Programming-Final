package edu.utsa.cs3443.firerunner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenuActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupButtons();
    }

    @Override
    public void onClick(View view) {

        Button clickedButton = (Button) view;
        String buttonText = clickedButton.getText().toString().toLowerCase();
        if(buttonText.equalsIgnoreCase("start game")){
            Intent gameIntent = new Intent(MainMenuActivity.this, GameActivity.class);
            startActivity(GameActivity);
        }else if (buttonText.equalsIgnoreCase("settings")){
            Intent settingsIntent = new Intent(MainMenuActivity.this, SettingsActivity.class);
            startActivity(SettingsActivity);
        }else if (buttonText.equalsIgnoreCase("quit game")) {
            Intent quitIntent = new Intent(MainMenuActivity.this, QuitActivity.class);
            startActivity(QuitActivity);
        }
    }

    private void setupButtons() {

        int[] buttonIDs = {R.id.start_button, R.id.settings_button, R.id.quit_button};
        String[] buttonText = {"Start Game", "Settings", "Quit Game"};
        for(int i = 0; i < buttonIDs.length; i++){
            Button button = findViewById(buttonIDs[i]);
            button.setText(buttonText[i]);
            button.setOnClickListener(this);
        }
    }
}