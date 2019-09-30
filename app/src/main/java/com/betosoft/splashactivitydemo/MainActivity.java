package com.betosoft.splashactivitydemo;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;


public class MainActivity extends Activity {

    MediaPlayer myPlayer;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(myPlayer != null)
            myPlayer.release();    // Liberar Recursos
        myPlayer = MediaPlayer.create(this, R.raw.jet);
        myPlayer.seekTo(0);
        myPlayer.start();

        Thread timer = new Thread() {

            @Override
            public void run() {
                try {
                    sleep(5000);
                } catch(InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    Intent openStartingPoint = new Intent();
                    openStartingPoint.setClassName("com.betosoft.splashactivitydemo","com.betosoft.splashactivitydemo.SecondActivity");
                    startActivity(openStartingPoint);
                }
            }

        };
        timer.start();

    }


    @Override
    protected void onPause() {
        super.onPause();
        myPlayer.release();
        finish();
    }



}