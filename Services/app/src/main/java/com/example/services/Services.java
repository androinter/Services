package com.example.services;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class Services extends Service {

    MediaPlayer mediaPlayer;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        Toast.makeText(this, "Service Start", Toast.LENGTH_SHORT).show();
        mediaPlayer = MediaPlayer.create(this,R.raw.song);
        mediaPlayer.start();
        mediaPlayer.setLooping(true);
    }


    @Override
    public void onDestroy() {
        Toast.makeText(this, "Service Stop", Toast.LENGTH_SHORT).show();

        if (mediaPlayer!=null && mediaPlayer.isPlaying()){
            mediaPlayer.stop();
        }
    }
}
