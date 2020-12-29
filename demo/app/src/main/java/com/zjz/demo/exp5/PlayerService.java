package com.zjz.demo.exp5;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import com.zjz.demo.R;

public class PlayerService extends Service {
    private MediaPlayer mediaPlayer;
    public IBinder onBind(Intent intent){
        return null;
    }
    public int onStartCommand(Intent intent, int flags, int startId){
        String action = intent.getStringExtra("action");
        switch (action) {
            case "play":
                playMusic();
                break;
            case "stop":
                stopMusic();
                break;
            case "pause":
                pauseMusic();
                break;
        }
        return super.onStartCommand(intent, flags, startId);
    }
    private void playMusic() {
        if (mediaPlayer == null)
            //调⽤MediaPlayer的静态⽅法create
            mediaPlayer = MediaPlayer.create(this, R.raw.music);
        mediaPlayer.start();
    }
    private void stopMusic() {
        if (mediaPlayer != null) {
            mediaPlayer.stop(); //停⽌
            mediaPlayer.reset(); //重置
            mediaPlayer.release(); //释放资源
            mediaPlayer = null; //重新赋值为空
        }
    }
    private void pauseMusic() {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
        }
    }
    @Override
    public void onDestroy() {
        stopMusic();
        super.onDestroy();
    }
}
