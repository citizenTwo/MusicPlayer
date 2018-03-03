package xyz.mrdeveloper.playgirl;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by Lakshay Raj on 16-04-2017.
 */

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.ViewHolder> {

    private ArrayList<Song> songList;
    private Context context;

    public class ViewHolder extends RecyclerView.ViewHolder{
        RelativeLayout layout;
        TextView songDuration;
        TextView songView;
        TextView artistView;
        ImageView artView;

        public ViewHolder(View view) {
            super(view);
            songDuration = (TextView) view.findViewById(R.id.song_duration);
            songView = (TextView) view.findViewById(R.id.song_title);
            artistView = (TextView) view.findViewById(R.id.song_artist);
            artView = (ImageView) view.findViewById(R.id.song_art);
            layout = (RelativeLayout) view.findViewById(R.id.song_list_item);
        }
    }

    public SongAdapter(ArrayList<Song> songList) {
        this.songList = songList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.song, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Song song = songList.get(position);
        holder.songView.setText(song.getTitle());
        holder.artistView.setText(song.getArtist());
        holder.songDuration.setText(song.getDuration());
//        Picasso.with(context)
//                .load("file://"+song.getPath())
//                .config(Bitmap.Config.RGB_565)
//                .resize(70, 70)
//                .fit().centerCrop()
//                .into(holder.artView);
    }

    @Override
    public int getItemCount() {
        return songList.size();
    }


}
