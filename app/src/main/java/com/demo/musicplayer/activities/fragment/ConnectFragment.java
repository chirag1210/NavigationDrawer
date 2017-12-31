package com.demo.musicplayer.activities.fragment;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.demo.musicplayer.R;

import java.io.IOException;

/**
 * Created by anupamchugh on 10/12/15.
 */
public class ConnectFragment extends Fragment implements View.OnClickListener{

    private Button lPlay,lStop;
   private View rootView;
  private MediaPlayer mMediaPlayer;

    public ConnectFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_connect, container, false);
        initViews();
        return rootView;
    }

    private void initViews() {
        lPlay = rootView.findViewById(R.id.play);
        lPlay.setOnClickListener(this);

        lStop = rootView.findViewById(R.id.stop);
        lStop.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.play:
                String url ="http://programmerguru.com/android-tutorial/wp-content/uploads/2013/04/hosannatelugu.mp3";
                mMediaPlayer = new MediaPlayer();
                mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
                try {
                    mMediaPlayer.setDataSource(url);
                    mMediaPlayer.prepare(); // might take long! (for buffering, etc)
                    mMediaPlayer.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

            case R.id.stop:
                if(mMediaPlayer!=null && mMediaPlayer.isPlaying()){
                    mMediaPlayer.stop();
                }
                break;
        }
    }



}
