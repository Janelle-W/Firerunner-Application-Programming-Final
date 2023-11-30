/**
 * BackgroundMusicPlayer is a class that provides functionality for managing background music in the Fire Runner project
 *
 * @author Janelle Wiggins (rqd886)
 * UTSA CS 3443 - Fire Runner Project
 * Fall 2023
 */
package edu.utsa.cs3443.firerunner.model;

import android.content.Context;
import android.media.MediaPlayer;

public class BackgroundMusicPlayer {
    private static MediaPlayer mediaPlayer;
    private static boolean isMusicOn = false;

    /**
     * Starts the background music with the specified resource ID.
     *
     * @param context the context used to create the MediaPlayer.
     * @param resourceId the resource ID of the audio file to be played.
     */
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

    /**
     * Sets the state of the music, whether it is on or off
     *
     * @param musicOn true to turn on the music, false to turn it off.
     */
    public static void setMusicOn(boolean musicOn) {
        isMusicOn = musicOn;
    }

    /**
     * Stops the background music.
     */
    public static void stop() {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
        }

        isMusicOn = false;
    }

    /**
     * Releases the resources used by the MediaPlayer.
     */
    public static void release() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    /**
     * Checks if the background music is currently on.
     *
     * @return True if the background music is on, false if the music is off.
     */
    public static boolean isMusicOn() {
        return isMusicOn;
    }

}