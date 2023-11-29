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


        int viewId = view.getId();

        if(viewId == R.id.start_button){
            startLoadingScreen("start");
            finish();
        }
        else if (viewId == R.id.settings_button){
            Intent settingsIntent = new Intent(MainMenuActivity.this, SettingsActivity.class);
            startActivity(settingsIntent);
            finish();
        }
        else if (viewId == R.id.quit_button) {
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

    private void startLoadingScreen(String difficulty) {
        Intent intent = new Intent(MainMenuActivity.this, LoadingActivity.class);
        intent.putExtra("difficulty", difficulty);
        startActivity(intent);
    }

}