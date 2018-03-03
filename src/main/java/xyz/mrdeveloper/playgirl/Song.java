package xyz.mrdeveloper.playgirl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;

/**
 * Created by Lakshay Raj on 15-04-2017.
 */

public class Song {
    private long id;
    private String path;
    private String title;
    private String artist;
    private String duration;
    private Bitmap art;
    private Context context;

    public Song(long songID, String songTitle, String songArtist, String songPath, Context thisContext) {
        id = songID;
        title = songTitle;
        artist = songArtist;
        path = songPath;
        context = thisContext;
    }


    /**
     * Function to Return values when needed
     */
    public long getID() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getDuration() {
        return duration;
    }

    public String getPath() {
        return path;
    }

    public Bitmap getArt() {
        return art;
    }

    public void setArt(int size) {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(path);

        Bitmap thisArt;
        byte[] art = mediaMetadataRetriever.getEmbeddedPicture();
        if (art != null) {

            BitmapFactory.Options option = new BitmapFactory.Options();
            option.inSampleSize = 2;

            thisArt = BitmapFactory.decodeByteArray(art, 0, art.length, option);
            thisArt = Bitmap.createScaledBitmap(thisArt, size, size, true);
        } else {
            thisArt = BitmapFactory.decodeResource(context.getResources(), R.drawable.play);
            thisArt = Bitmap.createScaledBitmap(thisArt, size, size, true);
        }

    }

}
