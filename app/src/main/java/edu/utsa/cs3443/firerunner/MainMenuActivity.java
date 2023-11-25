package edu.utsa.cs3443.firerunner;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import edu.utsa.cs3443.firerunner.model.BackgroundMusicPlayer;


public class MainMenuActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (!BackgroundMusicPlayer.isMusicOn()) {
            BackgroundMusicPlayer.start(this, R.raw.wiimusic);
        }

        setupButtons();
    }

    @Override
    public void onClick(View view) {

        TextView clickedButton = (TextView) view;
        String buttonText = clickedButton.getText().toString().toLowerCase();
        if(buttonText.equalsIgnoreCase("start game")){
            Intent gameIntent = new Intent(MainMenuActivity.this, GameEasyActivity.class);
            startActivity(gameIntent);
        }
        if (buttonText.equalsIgnoreCase("settings")){
            Intent settingsIntent = new Intent(MainMenuActivity.this, SettingsActivity.class);
            startActivity(settingsIntent);
        }
        if (buttonText.equalsIgnoreCase("quit game")) {
            finish(); //Finish the current activity
            System.exit(0); //Terminate the app's process
        }

    }

    private void setupButtons() {
        int[] buttonIDs = {R.id.start_button, R.id.settings_button, R.id.quit_button};
        String[] buttonText = {"START GAME", "SETTINGS", "QUIT GAME"};
        for(int i = 0; i < buttonIDs.length; i++){
            TextView button = findViewById(buttonIDs[i]);
            button.setText(buttonText[i]);
            button.setOnClickListener(this);
        }
    }

    @Override
    protected void onDestroy() {
        // Don't stop the music here; let it continue for other activities
        super.onDestroy();
    }

}