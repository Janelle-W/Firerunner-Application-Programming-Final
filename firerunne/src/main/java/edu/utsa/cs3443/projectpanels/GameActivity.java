package edu.utsa.cs3443.projectpanels;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.Random;

import edu.utsa.cs3443.projectpanels.R;

public class GameActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
    }

    @Override
    public void onClick(View view) {

    }

    private void setupButtons() {
        int[] buttonsIDs = {
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

        for (int i = 0; i < buttonsIDs.length; i++) {
            Button button = findViewById(buttonsIDs[i]);
            button.setOnClickListener(this);
        }

        //GAME STARTS



        //RULES
        //In order to put out a fire, you must click the water button first (bottom of the map)
        //If a fire button is click after a water button turn that button to tree button
        //If a tree button is click after a water button nothing changes
        //Fire can move left ,right, up, or down (just left and right for now)

        //Easy Mode Function: 1 new fire button pops up every second for 30 seconds
        private void easyDifficulty() {
            //Make 1 random button (using randomizer) turn on fire
            while (int i < 30) {
                int randomIndex = new Random().nextInt(buttonsIDs.length);
                randomIndex = button_74;
                ImageButton fireImageView = findViewById(R.id.randomIndex);
                if (ImageButton fireImageView = findViewById(R.id.ButtonsIDs[randomIndex]) == water button) {
                    if (randomIndex is clicked) {
                        //turn it into a tree button
                    }
                else (do nothing)
                }
                else (do nothing)
                i++;
            }
        }

        //Medium Mode Function
        private void mediumDifficulty() { //2 new fire buttons pops up every second for 30 seconds
            //make 2 random buttons (using randomizer) turn on fire
            //if a fire button is NOT clicked on have 1 adjacent button catch on fire
            //if fire is clicked on before 1 sec turn back into tree
            //loop for 30 seconds
        }

        //Hard Mode Function
        private void hardDifficulty() { //3 new fires button pops up every second for 30 seconds
            //make 3 random buttons (using randomizer) turn on fire
            //if a fire is NOT clicked on have 1 adjacent button catch on fire
            //if fire is clicked on before 1 sec turn back into tree
            //loop for 30 seconds
        }
    }
}