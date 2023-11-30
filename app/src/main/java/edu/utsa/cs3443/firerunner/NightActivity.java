/**
 * NightActivity is a class for activities in the Fire Runner project that implements night mode functionality.
 *
 * @author Janelle Wiggins (rqd886)
 * UTSA CS 3443 - Fire Runner Project
 * Fall 2023
 */
package edu.utsa.cs3443.firerunner;

import android.content.res.Configuration;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.appcompat.app.AppCompatDelegate;



public class NightActivity extends AppCompatActivity {

    /**
     * Called when the activity is first created. Sets the content view, sets up the UI.
     *
     * @param savedInstanceState contains the activity's previously saved state.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        applyNightMode();
    }

    /**
     * Applies night mode based on the device's current night mode setting.
     */
    protected void applyNightMode() {
        int currentNightMode = getResources().getConfiguration().uiMode
                & Configuration.UI_MODE_NIGHT_MASK;

        if (currentNightMode == Configuration.UI_MODE_NIGHT_YES) {
            setTheme(R.style.Theme_FireRunner_Night);
            getWindow().getDecorView().setBackgroundColor(ContextCompat.getColor(this, R.color.nightBackgroundColor));
        } else {
            setTheme(R.style.Theme_FireRunner_Day);
            getWindow().getDecorView().setBackgroundColor(ContextCompat.getColor(this, R.color.dayBackgroundColor));
        }
    }

    /**
     * Applies night mode based on the device's current night mode setting.
     */
    protected void toggleNightModeWithoutRecreate() {
        int currentNightMode = getResources().getConfiguration().uiMode
                & Configuration.UI_MODE_NIGHT_MASK;

        if (currentNightMode == Configuration.UI_MODE_NIGHT_YES) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }

    }

}