package edu.utsa.cs3443.firerunner.model;

import android.content.Context;
import android.media.MediaPlayer;

public class BackgroundMusicPlayer {
    private static MediaPlayer mediaPlayer;
    private static boolean isMusicOn = false;

    public static void start(Context context, int resourceId) {
        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer.create(context, resourceId);
            if (mediaPlayer != null) {
                mediaPlayer.setLooping(true);
            }
        }

        if (!mediaPlayer.isPlaying()) {
            mediaPlayer.start();
        }

        isMusicOn = true;
    }

    public static void setMusicOn(boolean musicOn) {
        isMusicOn = musicOn;
    }

    public static void stop() {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
        }

        isMusicOn = false;
    }

    public static void release() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    public static boolean isMusicOn() {
        return isMusicOn;
    }

}