package xyz.mrdeveloper.playgirl;

import android.app.Activity;
import android.media.MediaPlayer;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Lakshay Raj on 15-04-2017.
 */

public class PlaybackController {
    private Activity activity;
    static int currentSongIndex = 0;
    public MediaPlayer mediaPlayer;
    public CollapsedController collapsedController;
    private static ArrayList<Song> playList;

    public PlaybackController(ArrayList<Song> playList, Activity activity, CollapsedController collapsedController){

        this.activity = activity;
        mediaPlayer = new MediaPlayer();
        this.playList = playList;
        this.collapsedController = collapsedController;

    }

    public void StartSong() {

        mediaPlayer.reset();

        try {
            Log.d("Check", "Now Playing : " + playList.get(currentSongIndex).getTitle());

            mediaPlayer.setDataSource(playList.get(currentSongIndex).getPath());
            mediaPlayer.prepare();
            mediaPlayer.start();

            collapsedController.setTitle(playList.get(currentSongIndex).getTitle());
            collapsedController.setPlayback("Pause");
            collapsedController.setArt(playList.get(currentSongIndex).getArt());

        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void PauseSong(){
        mediaPlayer.pause();
        collapsedController.setPlayback("Play");
    }

    public void ContinueSong(){
        mediaPlayer.start();
        collapsedController.setPlayback("Pause");
    }

    public void NextSong(){
        currentSongIndex += 1;
        StartSong();
    }

    public void PreviousSong(){
        currentSongIndex -= 1;
        StartSong();
    }

    public void SongCompleted(){

        Log.d("Check","Song has Completed Playing");
        collapsedController.setPlayback("Play");

        if(currentSongIndex < (playList.size() - 1)){
            currentSongIndex += 1;
            StartSong();
        }
        else
        {
            currentSongIndex = 0;
            StartSong();
        }
    }
}
