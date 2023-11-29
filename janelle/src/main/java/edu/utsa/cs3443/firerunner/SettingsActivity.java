/*package edu.utsa.cs3443.firerunner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import edu.utsa.cs3443.firerunner.model.BackgroundMusicPlayer;
import androidx.appcompat.app.AppCompatDelegate;



public class SettingsActivity extends NightActivity {

    private boolean isMusicOn = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        setupButtons();
    }*/

    /*private void setupButtons() {
        TextView textViewMainMenu = findViewById(R.id.buttonMain);
        textViewMainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToMainMenuActivity();
            }
        });

        TextView textViewEasy = findViewById(R.id.buttonEasy);
        textViewEasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToGameEasyActivity();
            }
        });

        TextView textViewMedium = findViewById(R.id.buttonMedium);
        textViewMedium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToGameMediumActivity();
            }
        });

        TextView textViewHard = findViewById(R.id.buttonHard);
        textViewHard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToGameHardActivity();
            }
        });

        TextView textViewNightMode = findViewById(R.id.buttonDayNight);
        textViewNightMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toggle night mode without recreating the activity
                toggleNightModeWithoutRecreate();
            }
        });

    }*/

    /*private void setupButtons() {
        TextView textViewMainMenu = findViewById(R.id.buttonMain);
        textViewMainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToMainMenuActivity();
            }
        });

        TextView textViewEasy = findViewById(R.id.buttonEasy);
        textViewEasy.setOnClickListener(v -> startLoadingScreen("easy"));
        textViewEasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToGameEasyActivity();
            }
        });

        TextView textViewMedium = findViewById(R.id.buttonMedium);
        textViewMedium.setOnClickListener(v -> startLoadingScreen("medium"));
        textViewMedium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToGameMediumActivity();
            }
        });

        TextView textViewHard = findViewById(R.id.buttonHard);
        textViewHard.setOnClickListener(v -> startLoadingScreen("hard"));
        textViewHard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToGameHardActivity();
            }
        });

        TextView textViewNightMode = findViewById(R.id.buttonDayNight);
        textViewNightMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toggle night mode without recreating the activity
                toggleNightModeWithoutRecreate();
            }
        });

    }

    private void toggleNightModeWithoutRecreate() {
        int currentNightMode = getResources().getConfiguration().uiMode
                & android.content.res.Configuration.UI_MODE_NIGHT_MASK;

        if (currentNightMode == android.content.res.Configuration.UI_MODE_NIGHT_YES) {
            getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        } else {
            getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }

        applyNightMode(); // Apply night mode without recreating the activity
    }



    private void navigateToMainMenuActivity() {
        finish();
    }

    private void startLoadingScreen(String difficulty) {
        Intent intent = new Intent(SettingsActivity.this, LoadingActivity.class);
        intent.putExtra("difficulty", difficulty);
        startActivity(intent);
    }

    private void navigateToGameEasyActivity() {
        Intent gameIntent = new Intent(SettingsActivity.this, GameEasyActivity.class);
        startActivity(gameIntent);
    }

    private void navigateToGameMediumActivity() {
        Intent gamemediumIntent = new Intent(SettingsActivity.this, GameMediumActivity.class);
        startActivity(gamemediumIntent);
    }

    private void navigateToGameHardActivity() {
        Intent gamehardIntent = new Intent(SettingsActivity.this, GameHardActivity.class);
        startActivity(gamehardIntent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void onMusicOnButtonClick(View view) {
        if (!BackgroundMusicPlayer.isMusicOn()) {
            BackgroundMusicPlayer.start(this, R.raw.wiimusic);
        }
        BackgroundMusicPlayer.setMusicOn(true);
    }

    public void onMusicOffButtonClick(View view) {
        if (BackgroundMusicPlayer.isMusicOn()) {
            BackgroundMusicPlayer.stop();
        }
        BackgroundMusicPlayer.setMusicOn(false);
    }

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

}*/

package edu.utsa.cs3443.firerunner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import edu.utsa.cs3443.firerunner.model.BackgroundMusicPlayer;
import androidx.appcompat.app.AppCompatDelegate;



public class SettingsActivity extends NightActivity {

    private boolean isMusicOn = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        setupButtons();
    }

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
        /*textViewEasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToGameEasyActivity();
            }
        });*/

        TextView textViewMedium = findViewById(R.id.buttonMedium);
        textViewMedium.setOnClickListener(v -> startLoadingScreen("medium"));
        /*textViewMedium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToGameMediumActivity();
            }
        });*/

        TextView textViewHard = findViewById(R.id.buttonHard);
        textViewHard.setOnClickListener(v -> startLoadingScreen("hard"));
        /*textViewHard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navigateToGameHardActivity();
            }
        });*/

        TextView textViewNightMode = findViewById(R.id.buttonDayNight);
        textViewNightMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toggle night mode without recreating the activity
                toggleNightModeWithoutRecreate();
            }
        });

    }

    private void toggleNightModeWithoutRecreate() {
        int currentNightMode = getResources().getConfiguration().uiMode
                & android.content.res.Configuration.UI_MODE_NIGHT_MASK;

        if (currentNightMode == android.content.res.Configuration.UI_MODE_NIGHT_YES) {
            getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        } else {
            getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }

        applyNightMode(); // Apply night mode without recreating the activity
    }



    private void navigateToMainMenuActivity() {
        finish();
    }

    private void startLoadingScreen(String difficulty) {
        Intent intent = new Intent(SettingsActivity.this, LoadingActivity.class);
        intent.putExtra("difficulty", difficulty);
        startActivity(intent);
    }
    private void navigateToGameEasyActivity() {
        Intent gameIntent = new Intent(SettingsActivity.this, LoadingActivity.class);
        startActivity(gameIntent);
    }

    private void navigateToGameMediumActivity() {
        Intent gamemediumIntent = new Intent(SettingsActivity.this, LoadingActivity.class);
        startActivity(gamemediumIntent);
    }

    private void navigateToGameHardActivity() {
        Intent gamehardIntent = new Intent(SettingsActivity.this, LoadingActivity.class);
        startActivity(gamehardIntent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void onMusicOnButtonClick(View view) {
        if (!BackgroundMusicPlayer.isMusicOn()) {
            BackgroundMusicPlayer.start(this, R.raw.wiimusic);
        }
        BackgroundMusicPlayer.setMusicOn(true);
    }

    public void onMusicOffButtonClick(View view) {
        if (BackgroundMusicPlayer.isMusicOn()) {
            BackgroundMusicPlayer.stop();
        }
        BackgroundMusicPlayer.setMusicOn(false);
    }

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