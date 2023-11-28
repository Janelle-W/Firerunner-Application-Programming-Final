package edu.utsa.cs3443.firerunner;

import androidx.appcompat.app.AppCompatActivity;
import edu.utsa.cs3443.firerunner.R;
import android.os.Bundle;
import android.view.View;
import android.content.res.Configuration;
import androidx.core.content.ContextCompat;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import android.widget.Toast;

public class GameEasyActivity extends AppCompatActivity implements View.OnClickListener {
    private final int[] buttonsIDs = {
            R.id.button_11,
            R.id.button_12,
            R.id.button_13,
            R.id.button_14,
            R.id.button_15,
            R.id.button_16,
            R.id.button_17,

            R.id.button_21,
            R.id.button_22,
            R.id.button_23,
            R.id.button_24,
            R.id.button_25,
            R.id.button_26,
            R.id.button_27,

            R.id.button_31,
            R.id.button_32,
            R.id.button_33,
            R.id.button_34,
            R.id.button_35,
            R.id.button_36,
            R.id.button_37,

            R.id.button_41,
            R.id.button_42,
            R.id.button_43,
            R.id.button_44,
            R.id.button_45,
            R.id.button_46,
            R.id.button_47,

            R.id.button_51,
            R.id.button_52,
            R.id.button_53,
            R.id.button_54,
            R.id.button_55,
            R.id.button_56,
            R.id.button_57,

            R.id.button_61,
            R.id.button_62,
            R.id.button_63,
            R.id.button_64,
            R.id.button_65,
            R.id.button_66,
            R.id.button_67,

            R.id.button_71,
            R.id.button_72,
            R.id.button_73,
            R.id.button_74,
            R.id.button_75,
            R.id.button_76,
            R.id.button_77,

            R.id.button_81,
            R.id.button_82,
            R.id.button_83,
            R.id.button_84,
            R.id.button_85,
            R.id.button_86,
            R.id.button_87
    };

    private final Handler handler = new Handler();
    private final Random random = new Random();
    private final Set<Integer> treeButtonIndexes = new HashSet<>();
    private boolean isGameOver = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameeasy);

        setupButtons();
        //startGame();
    }

    private void setupButtons() {
        for (int buttonID : buttonsIDs) {
            ImageButton button = findViewById(buttonID);
            button.setOnClickListener(this);
        }
    }

    /*private void startGame() {
        for (int i = 0; i < buttonsIDs.length; i++) {
            treeButtonIndexes.add(i);
            ImageButton treeImageView = findViewById(buttonsIDs[i]);
            treeImageView.setImageResource(R.drawable.tree2);
        }
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (!isGameOver) {
                    int randomIndex = getRandomTreeIndex(); //Picks a random Tree button
                    treeButtonIndexes.remove(randomIndex); //Removes the Tree from that button
                    ImageButton fireImageView = findViewById(buttonsIDs[randomIndex]); //Assigns Fire button to the randomly chosen button
                    fireImageView.setImageResource(R.drawable.fire5); //Puts the Fire image on button

                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            //If Fire is NOT pressed turn another button on fire
                            if (!isGameOver && buttonsIDs[randomIndex] == fireImageView) {
                                int randomIndex = getRandomTreeIndex(); //Picks another random Tree button
                                treeButtonIndexes.remove(randomIndex); //Removes the Tree from that button
                                ImageButton fireImageView = findViewById(buttonsIDs[randomIndex]); //Assigns Fire button to the randomly chosen button
                                fireImageView.setImageResource(R.drawable.fire5); //Puts the Fire image on button

                                run();
                            }

                            if (!isGameOver && )

                            else (fireImageView.setImageResource(R.drawable.tree2); //Changes Fire button to Tree button)
                        }
                    }, 2000); // Delay to change fire back to tree
                }
            }
        }, 5000); // Initial delay before starting the game
    }*/

    private int getRandomTreeIndex() {
        int randomIndex;
        do {
            randomIndex = random.nextInt(buttonsIDs.length);
        } while (!treeButtonIndexes.contains(randomIndex));
        return randomIndex;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.button_water) {
            extinguishFire();
        } else if (view instanceof ImageButton && !isGameOver) {
            ImageButton clickedButton = (ImageButton) view;
            if (clickedButton.getDrawable().getConstantState().equals(getResources().getDrawable(R.drawable.fire5).getConstantState())) {
                // User clicked on a fire button
                clickedButton.setImageResource(R.drawable.tree2); // Extinguish the fire
                checkGameOver();
            }
        }
    }

    private int lastClickedFireIndex = -1;
    private void extinguishFire() {
        if (lastClickedFireIndex != -1) {
            ImageButton lastClickedFireButton = findViewById(buttonsIDs[lastClickedFireIndex]);
            lastClickedFireButton.setImageResource(R.drawable.tree2);
            lastClickedFireIndex = -1;
        }
    }

    private void checkGameOver() {
        if (treeButtonIndexes.isEmpty()) {
            isGameOver = true;
            showToast("Game Over! All trees have been through the fire.");
        }
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }


}
