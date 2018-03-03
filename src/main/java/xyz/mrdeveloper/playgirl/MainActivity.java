package xyz.mrdeveloper.playgirl;

import android.content.ContentResolver;
import android.media.MediaPlayer;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import com.astuetz.PagerSlidingTabStrip;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity implements
        MediaPlayer.OnCompletionListener,
        View.OnClickListener{

    private static PlaybackController playbackController;
    private CollapsedController collapsedController;
    private MusicRetriever musicRetriever;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("PlayGirl");
        setSupportActionBar(toolbar);

        ContentResolver contentResolver = getContentResolver();
        musicRetriever = new MusicRetriever(contentResolver, this);
        musicRetriever.GenerateList();

        collapsedController = new CollapsedController(this);
        playbackController = new PlaybackController(musicRetriever.getSongList(), this, collapsedController);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new ViewPageAdapter(getSupportFragmentManager(), musicRetriever));

        PagerSlidingTabStrip tabStrip = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        tabStrip.setViewPager(viewPager);

        playbackController.mediaPlayer.setOnCompletionListener(this);
        collapsedController.playback.setOnClickListener(this);
        collapsedController.controller.setOnClickListener(this);

        collapsedController.controller.setOnTouchListener(new OnSwipeTouchListener(MainActivity.this){
            public void onSwipeLeft(){
                Log.d("Check","Pushing Left");
                playbackController.NextSong();
            }

            public void onSwipeRight(){
                Log.d("Check","Pushing Right");
                playbackController.PreviousSong();
            }

            public void onSwipeTop(){

            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.collapsed_playback:
                if (playbackController.mediaPlayer.isPlaying())
                    playbackController.PauseSong();
                else
                    playbackController.ContinueSong();
                break;

            case R.id.collapsed_controller:
                Log.d("Check", "I'm controlling the collapse controller");
                break;
        }
    }

    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {
        playbackController.SongCompleted();
    }

    public static void BeginSong(){
        playbackController.StartSong();
    }
}
