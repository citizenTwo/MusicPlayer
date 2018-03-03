package xyz.mrdeveloper.playgirl;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Lakshay Raj on 16-04-2017.
 */

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.ViewHolder> {

    private ArrayList<Album> albumList;
    public class ViewHolder extends RecyclerView.ViewHolder{

        RelativeLayout layout;
        TextView albumCount;
        TextView albumView;
        TextView artistView;
        ImageView artView;

        public ViewHolder(View view) {
            super(view);
            albumCount = (TextView) view.findViewById(R.id.album_count);
            albumView = (TextView) view.findViewById(R.id.album_title);
            artistView = (TextView) view.findViewById(R.id.album_artist);
            artView = (ImageView) view.findViewById(R.id.album_art);
            layout = (RelativeLayout) view.findViewById(R.id.album_list_item);
        }
    }

    public AlbumAdapter(ArrayList<Album> albumList) {
        this.albumList = albumList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.album, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Album album = albumList.get(position);
        holder.albumView.setText(album.getTitle());
        holder.artistView.setText(album.getArtist());
        holder.albumCount.setText(album.getCount());
    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }


}

