package xyz.mrdeveloper.playgirl;

import android.app.Activity;
import android.graphics.Bitmap;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Lakshay Raj on 15-04-2017.
 */

public class CollapsedController {
    public RelativeLayout controller;
    public ImageView playback;

    private Activity activity;
    private ImageView art;
    private TextView duration;
    private TextView title;


    public CollapsedController (Activity activity){

        this.activity = activity;
        controller = (RelativeLayout) this.activity.findViewById(R.id.collapsed_controller);
        art = (ImageView) this.activity.findViewById(R.id.collapsed_song_art);
        playback = (ImageView) this.activity.findViewById(R.id.collapsed_playback);
        title = (TextView) this.activity.findViewById(R.id.collapsed_song_title);
        duration = (TextView) this.activity.findViewById(R.id.collapsed_song_duration);

    }

    public void setPlayback(String status) {
        if(status.equals("Pause"))
            playback.setImageResource(R.drawable.button_pause);
        else
            playback.setImageResource(R.drawable.button_play);
    }

    public void setDuration(String duration) {
        Log.d("TimerUpdate","Updating Timer");
        this.duration.setText(duration);
    }

    public void setArt(Bitmap bitmap) {
        this.art.setImageBitmap(bitmap);
    }

    public void setTitle(String title) {
        this.title.setText(title);
    }

}
