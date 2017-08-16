package xyz.mrdeveloper.playgirl;

import android.content.ContentResolver;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import java.util.ArrayList;

import static xyz.mrdeveloper.playgirl.PlaybackController.currentSongIndex;

/**
 * Created by Lakshay Raj on 15-04-2017.
 */

public class SongTabFragment extends Fragment implements View.OnClickListener{

    public ArrayList<Song> songList;
    private RecyclerView songView;
    private int mPage;
    private SongAdapter songAdapter;
    private MusicRetriever musicRetriever;

    public void setMusicRetriever(MusicRetriever musicRetriever) {
        this.musicRetriever = musicRetriever;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        songList = new ArrayList<>();
        songList = musicRetriever.getSongList();
        songAdapter = new SongAdapter(songList);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recycler, container, false);
        songView = (RecyclerView) view.findViewById(R.id.recycler_list);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        songView.setLayoutManager(mLayoutManager);
        songView.setItemAnimator(new DefaultItemAnimator());
        songView.setAdapter(songAdapter);

        songView.addOnItemTouchListener(
                new RecyclerItemClickListener(getContext(), new RecyclerItemClickListener.OnItemClickListener(){
                    @Override
                    public void OnItemClick(View view, int position) {
                        currentSongIndex = position;
                        MainActivity.BeginSong();

                        Log.d("Check", "Current position " + position);
                    }
                })
        );

        return view;
    }

    @Override
    public void onClick(View view) {

    }
}
