/**
 * LossActivity represents the activity displayed when the player loses the game.
 *
 * @author Diego Garcia (ici506)
 * UTSA CS 3443 - Fire Runner Project
 * Fall 2023
 */
package edu.utsa.cs3443.firerunner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class LossActivity extends AppCompatActivity {

    /**
     * Called when the activity is first created. Sets the content view, sets up the UI.
     *
     * @param savedInstanceState contains the activity's previously saved state.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loss);

        new Handler().postDelayed(() -> {
            Intent intent;
            intent = new Intent(LossActivity.this, MainMenuActivity.class);
            startActivity(intent);
            finish();
        }, 2000);
    }
}