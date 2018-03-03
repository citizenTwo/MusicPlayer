package xyz.mrdeveloper.playgirl;

import java.util.ArrayList;

/**
 * Created by Lakshay Raj on 15-04-2017.
 */

public class Album {
    private String ID;
    private String title;
    private String artist;
    private String art;
    private ArrayList<Song> song;

    public Album (String title,String artist, String art){
        this.title = title;
        this.artist = artist;
        this.art = art;
        song = new ArrayList<>();
    }

    public String getID() {
        return ID;
    }
    public String getArt() {
        return art;
    }
    public String getTitle() {
        return title;
    }
    public String getArtist() {
        return artist;
    }

    public void AddSong(Song song){
        this.song.add(song);
    }

    public String getCount(){
        Integer count = song.size();
        return count.toString();
    }
}
