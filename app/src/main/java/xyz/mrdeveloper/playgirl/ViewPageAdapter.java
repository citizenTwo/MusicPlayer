package xyz.mrdeveloper.playgirl;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Lakshay Raj on 15-04-2017.
 * Creates View Pagers for the Main Screen View
 */

class ViewPageAdapter extends FragmentStatePagerAdapter {
    private String[] tabsTitle = {"Albums", "Song"};
    private MusicRetriever musicRetriever;

    public ViewPageAdapter(FragmentManager fm, MusicRetriever musicRetriever) {
        super(fm);
        this.musicRetriever = musicRetriever;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                AlbumTabFragment albumTabFragment = new AlbumTabFragment();
                albumTabFragment.setMusicRetriever(musicRetriever);
                return albumTabFragment;

            case 1:
                SongTabFragment songTabFragment = new SongTabFragment();
                songTabFragment.setMusicRetriever(musicRetriever);
                return songTabFragment;
        }
        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabsTitle[position];
    }

    @Override
    public int getCount() {
        return 2;
    }
}
