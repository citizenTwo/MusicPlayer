package xyz.mrdeveloper.playgirl;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Lakshay Raj on 15-04-2017.
 */

public class MusicRetriever {
    ContentResolver contentResolver;
    Context context;

    HashMap<Long, Integer> albumListDirectory;
    ArrayList<Song> songList;
    ArrayList<Album> albumList;

    public MusicRetriever(ContentResolver contentResolver, Context context) {
        this.context = context;
        this.contentResolver = contentResolver;
        songList = new ArrayList<>();
        albumList = new ArrayList<>();
        albumListDirectory = new HashMap<>();
    }

    public void GenerateList() {

        ContentResolver musicResolver = contentResolver;
        Uri musicUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        Cursor musicCursor = musicResolver.query(musicUri, null, null, null, null);

        if (musicCursor != null && musicCursor.moveToFirst()) {

            int titleColumn = musicCursor.getColumnIndex(MediaStore.Audio.Media.TITLE);
            int idColumn = musicCursor.getColumnIndex(MediaStore.Audio.Media._ID);
            int artistColumn = musicCursor.getColumnIndex(MediaStore.Audio.Media.ARTIST);
            int pathColumn = musicCursor.getColumnIndex(MediaStore.Audio.Media.DATA);
            int albumColumn = musicCursor.getColumnIndex(MediaStore.Audio.Media.ALBUM);
            int albumidColumn = musicCursor.getColumnIndex(MediaStore.Audio.Media.ALBUM_ID);

            do {
                long thisId = musicCursor.getLong(idColumn);
                String thisTitle = musicCursor.getString(titleColumn);
                String thisArtist = musicCursor.getString(artistColumn);
                String thisPath = musicCursor.getString(pathColumn);
                String thisAlbum = musicCursor.getString(albumColumn);
                long thisAlbumID = musicCursor.getLong(albumidColumn);

                songList.add(new Song(thisId, thisTitle, thisArtist, thisPath, context));

                if (albumListDirectory.containsKey(thisAlbumID)) {
                    Album album = albumList.get(albumListDirectory.get(thisAlbumID));
                    album.AddSong(new Song(thisId, thisTitle, thisArtist, thisPath, context));

                } else {
                    Album album = new Album(thisAlbum, thisArtist, thisPath);
                    album.AddSong(new Song(thisId, thisTitle, thisArtist, thisPath, context));

                    albumList.add(album);
                    albumListDirectory.put(thisAlbumID, albumList.size() - 1);
                }
            }
            while (musicCursor.moveToNext());
        } else {
            Log.d("Check", "The musicCursor is null or not able to move to first");
        }
    }

    public ArrayList<Album> getAlbumList() {
        return albumList;
    }

    public ArrayList<Song> getSongList() {
        return songList;
    }
}
