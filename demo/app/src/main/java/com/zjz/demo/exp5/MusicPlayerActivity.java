package com.zjz.demo.exp5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.zjz.demo.HomeActivity;
import com.zjz.demo.R;

public class MusicPlayerActivity extends AppCompatActivity {
    private TextView back;
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.musicplayer_layout);
    }
    public void playMusic(View v) {
        if (mediaPlayer==null)
            mediaPlayer = MediaPlayer.create(this, R.raw.music);
        mediaPlayer.start();
    }
    public void pauseMusic(View v) {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
        }
    }
    public void stopMusic(View v) {
        if (mediaPlayer != null) {
            mediaPlayer.stop(); //停⽌
            mediaPlayer.reset(); //重置
            mediaPlayer.release(); //释放资源
            mediaPlayer = null; //重新赋值为空
        }
    }
    public void exitMusic(View view) {
        stopMusic(view);
        finish();
    }
    public void back(View v) {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
}