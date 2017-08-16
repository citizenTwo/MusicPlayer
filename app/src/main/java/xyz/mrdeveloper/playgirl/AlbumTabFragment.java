package xyz.mrdeveloper.playgirl;

import android.content.ContentResolver;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Lakshay Raj on 15-04-2017.
 * Constructs for the ViewPager tab a fragment regarding Albums
 */

public class AlbumTabFragment extends Fragment {
    private ArrayList<Album> albumList;
    private RecyclerView albumView;
    private AlbumAdapter albumAdapter;
    private MusicRetriever musicRetriever;

    public void setMusicRetriever(MusicRetriever musicRetriever) {
        this.musicRetriever = musicRetriever;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        albumList = new ArrayList<>();
        albumList = musicRetriever.getAlbumList();
        albumAdapter = new AlbumAdapter(albumList);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recycler, container, false);
        albumView = (RecyclerView) view.findViewById(R.id.recycler_list);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        albumView.setLayoutManager(mLayoutManager);
        albumView.setItemAnimator(new DefaultItemAnimator());
        albumView.setAdapter(albumAdapter);

        return view;
    }
}
