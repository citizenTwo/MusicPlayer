package xyz.mrdeveloper.playgirl;

import android.app.Activity;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Lakshay Raj on 15-04-2017.
 */

public class Player {
    private Activity activity;

    private RelativeLayout player;
    private TextView titleView;
    private TextView detailsView;
    private TextView totalDurationView;
    private TextView currentDurationView;
    private ImageView artView;
    private ImageButton playbackButton;
    private ImageButton nextButton;
    private ImageButton previousButton;
    private ImageButton playListButton;

    public Player(Activity activity){

        this.activity = activity;

        player = (RelativeLayout) this.activity.findViewById(R.id.player);
        titleView = (TextView) this.activity.findViewById(R.id.player_song_title);
        detailsView = (TextView) this.activity.findViewById(R.id.player_song_details);
        totalDurationView = (TextView) this.activity.findViewById(R.id.player_song_duration);
        currentDurationView = (TextView) this.activity.findViewById(R.id.player_song_duration_current);
        playbackButton = (ImageButton) this.activity.findViewById(R.id.player_song_playback);
        nextButton = (ImageButton) this.activity.findViewById(R.id.player_song_next);
        previousButton = (ImageButton) this.activity.findViewById(R.id.player_song_prev);
        playListButton = (ImageButton) this.activity.findViewById(R.id.player_song_playlist);
        artView = (ImageView) this.activity.findViewById(R.id.player_song_art);
    }

}
