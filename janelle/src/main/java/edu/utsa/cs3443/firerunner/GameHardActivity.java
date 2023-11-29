package edu.utsa.cs3443.firerunner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class GameHardActivity extends AppCompatActivity implements View.OnClickListener {
    private final int[] buttonsIDs = {
            R.id.button_11, R.id.button_12, R.id.button_13, R.id.button_14, R.id.button_15, R.id.button_16, R.id.button_17,
            R.id.button_21, R.id.button_22, R.id.button_23, R.id.button_24, R.id.button_25, R.id.button_26, R.id.button_27,
            R.id.button_31, R.id.button_32, R.id.button_33, R.id.button_34, R.id.button_35, R.id.button_36, R.id.button_37,
            R.id.button_41, R.id.button_42, R.id.button_43, R.id.button_44, R.id.button_45, R.id.button_46, R.id.button_47,
            R.id.button_51, R.id.button_52, R.id.button_53, R.id.button_54, R.id.button_55, R.id.button_56, R.id.button_57,
            R.id.button_61, R.id.button_62, R.id.button_63, R.id.button_64, R.id.button_65, R.id.button_66, R.id.button_67,
            R.id.button_71, R.id.button_72, R.id.button_73, R.id.button_74, R.id.button_75, R.id.button_76, R.id.button_77,
            R.id.button_81, R.id.button_82, R.id.button_83, R.id.button_84, R.id.button_85, R.id.button_86, R.id.button_87
    };

    final Handler handler = new Handler();
    private final Random random = new Random();
    private final Set<Integer> fireButtonIndexes = new HashSet<>();
    private int fireCounter = 0;
    private boolean isGameActive = true;

    final Runnable r = new Runnable() {
        @Override
        public void run() {
            spawnFire();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gamehard);

        setupButtons();
        initializeGame();
        startGame();
    }

    private void setupButtons() {
        //Sets up the Back Button while in game
        TextView textViewMainMenu = findViewById(R.id.button_Main);
        textViewMainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToMainMenuActivity();
            }
        });

        //Sets all Tree buttons in game
        for (int buttonID : buttonsIDs) {
            ImageButton button = findViewById(buttonID);
            button.setOnClickListener(this);
            // Set all buttons to trees at the start
            button.setImageResource(R.drawable.tree2);
        }
    }

    private void initializeGame() {
        // Start with 1 random fire
        //spawnFire();
    }

    private void startGame() {
        // Schedule the first run of spawnFire after 3 seconds
        handler.postDelayed(r, 3000);
    }

    private void spawnFire() {
        // If game over condition is met, stop spawning fires
        if (isGameActive == false || fireCounter >= 15) {
            return;
        }

        int randomIndex = getRandomTreeIndex();
        fireButtonIndexes.add(randomIndex);
        ImageButton fireImageView = findViewById(buttonsIDs[randomIndex]);
        fireImageView.setImageResource(R.drawable.fire5);
        fireCounter++;

        // Schedule the next run of spawnFire after 3 seconds
        handler.postDelayed(r, 500);
    }

    @Override
    public void onClick(View view) {

        int clickedButtonId = view.getId();

        // Check if the clicked button is an ImageButton
        if (view instanceof ImageButton && isGameActive) {
            ImageButton clickedButton = (ImageButton) view;

            // Check if the clicked button is currently on fire
            Drawable.ConstantState fireDrawableState = ContextCompat.getDrawable(this, R.drawable.fire5).getConstantState();
            if (clickedButton.getDrawable().getConstantState().equals(fireDrawableState)) {
                // Extinguish the fire by setting the image to a tree
                if (isGameActive) {
                    clickedButton.setImageResource(R.drawable.tree2);
                    fireButtonIndexes.remove(clickedButtonId);
                    fireCounter--;

                    // Check game over condition
                    checkGameOver();
                }
                else {
                    clickedButton.setImageResource(R.drawable.fire5);
                    // Handle the case when a button that is not on fire is clicked
                    // For example, you can display a message or perform other actions
                    //clickedButton.getDrawable().getConstantState()
                }
            }
        }
    }

    private int getRandomTreeIndex() {
        int randomIndex;
        do {
            randomIndex = random.nextInt(buttonsIDs.length);
        } while (fireButtonIndexes.contains(randomIndex));
        return randomIndex;
    }

    private void checkGameOver() {
        if (fireCounter >= 15 && isGameActive) {
            isGameActive = false; // Set game as inactive to prevent further user interaction
            showToast("Game Over! More than 15 fires on the screen.");
        }
        if (fireCounter == 0 && isGameActive) {
            isGameActive = false; // Set game as inactive to prevent further user interaction
            gameWon();
            // Stop further execution of spawnFire by removing callbacks from the handler
            handler.removeCallbacks(r);
        }
    }

    private void gameWon() {
        showToast("You Win! No fires left on the screen.");
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void navigateToMainMenuActivity() {
        finish();
    }
}