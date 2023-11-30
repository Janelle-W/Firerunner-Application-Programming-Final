/**
 * SettingsActivity is a class that manages the settings in the Fire Runner project.
 *
 * @author Janelle Wiggins (rqd886)
 * UTSA CS 3443 - Fire Runner Project
 * Fall 2023
 */
package edu.utsa.cs3443.firerunner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import edu.utsa.cs3443.firerunner.model.BackgroundMusicPlayer;
import androidx.appcompat.app.AppCompatDelegate;



public class SettingsActivity extends NightActivity {

    private boolean isMusicOn = true;

    /**
     * Called when the activity is first created. Sets the content view, sets up the UI.
     *
     * @param savedInstanceState contains the activity's previously saved state.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        setupButtons();
    }

    /**
     * Sets up buttons for navigating to the main menu, selecting difficulty levels, toggling night mode, and managing music settings.
     */
    private void setupButtons() {
        TextView textViewMainMenu = findViewById(R.id.buttonMain);
        textViewMainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToMainMenuActivity();
            }
        });

        TextView textViewEasy = findViewById(R.id.buttonEasy);
        textViewEasy.setOnClickListener(v -> startLoadingScreen("easy"));

        TextView textViewMedium = findViewById(R.id.buttonMedium);
        textViewMedium.setOnClickListener(v -> startLoadingScreen("medium"));

        TextView textViewHard = findViewById(R.id.buttonHard);
        textViewHard.setOnClickListener(v -> startLoadingScreen("hard"));

        TextView textViewNightMode = findViewById(R.id.buttonDayNight);
        textViewNightMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toggle night mode without recreating the activity
                toggleNightModeWithoutRecreate();
            }
        });

    }

    /**
     * Toggles night mode without recreating the activity.
     */
    public void toggleNightModeWithoutRecreate() {
        int currentNightMode = getResources().getConfiguration().uiMode
                & android.content.res.Configuration.UI_MODE_NIGHT_MASK;

        if (currentNightMode == android.content.res.Configuration.UI_MODE_NIGHT_YES) {
            getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        } else {
            getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }

        applyNightMode(); // Apply night mode without recreating the activity
    }

    /**
     * Navigates to the main menu activity.
     */
    private void navigateToMainMenuActivity() {

        Intent mainIntent = new Intent (SettingsActivity.this, MainMenuActivity.class);
        startActivity(mainIntent);
        finish();
    }

    /**
     * Starts the loading screen activity with the specified difficulty level.
     *
     * @param difficulty the difficulty level for the game.
     */
    private void startLoadingScreen(String difficulty) {
        Intent intent = new Intent(SettingsActivity.this, LoadingActivity.class);
        intent.putExtra("difficulty", difficulty);
        startActivity(intent);
        finish();
    }

    /**
     * Called when the activity is being destroyed, cleans up.
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    /**
     * Handles the button click to turn on music.
     *
     * @param view The clicked view.
     */
    public void onMusicOnButtonClick(View view) {
        if (!BackgroundMusicPlayer.isMusicOn()) {
            BackgroundMusicPlayer.start(this, R.raw.wiimusic);
        }
        BackgroundMusicPlayer.setMusicOn(true);
    }

    /**
     * Handles the button click to turn off music.
     *
     * @param view The clicked view.
     */
    public void onMusicOffButtonClick(View view) {
        if (BackgroundMusicPlayer.isMusicOn()) {
            BackgroundMusicPlayer.stop();
        }
        BackgroundMusicPlayer.setMusicOn(false);
    }

    /**
     * Resumes the activity and checks if music should be playing based on the settings.
     */
    @Override
    protected void onResume() {
        super.onResume();

        // Check if the music is supposed to be on
        if (BackgroundMusicPlayer.isMusicOn()) {
            BackgroundMusicPlayer.start(this, R.raw.wiimusic);
        } else {
            // If music is supposed to be off, stop it
            BackgroundMusicPlayer.stop();
        }
    }

}