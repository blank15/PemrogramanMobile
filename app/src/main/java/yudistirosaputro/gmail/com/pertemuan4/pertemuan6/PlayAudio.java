package yudistirosaputro.gmail.com.pertemuan4.pertemuan6;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import yudistirosaputro.gmail.com.pertemuan4.R;

/**
 * Created by blank15 on 18/04/2018.
 */

public class PlayAudio extends Service {

    MediaPlayer mediaPlayer;


    public void onCreate() {
        super.onCreate();
        mediaPlayer = MediaPlayer.create(this, R.raw.twinkle);
    }


    public int onStartCommand(Intent intent, int flags, int startId) {
        mediaPlayer.start();

        if(mediaPlayer.isLooping()!=true){
            Log.d("TAG","Error play");
        }
        return 1;
    }

    public void onStop(){
        mediaPlayer.stop();
        mediaPlayer.release();
    }

    public void onPause(){
        mediaPlayer.stop();
        mediaPlayer.release();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mediaPlayer.stop();
        mediaPlayer.release();
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
