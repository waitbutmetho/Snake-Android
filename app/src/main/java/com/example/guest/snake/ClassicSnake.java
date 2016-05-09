package com.example.guest.snake;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class ClassicSnake extends AppCompatActivity {

    private boolean playMusic;
    private MediaPlayer musicPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classic_snake);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
        decorView.setSystemUiVisibility(uiOptions);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
    }

    private void musicOnOff(){
        SharedPreferences preferences = getApplicationContext().getSharedPreferences("SnakePreferences", Context.MODE_PRIVATE);
        playMusic = preferences.getBoolean("PlayMusic", true);
        musicPlayer = MediaPlayer.create(ClassicSnake.this, R.raw.music);
        if (playMusic){
            musicPlayer.setLooping(true);
            musicPlayer.start();
        }else {
            musicPlayer.stop();
        }
    }

}
