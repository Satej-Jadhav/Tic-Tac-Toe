package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

import static android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN;

public class MainActivity extends AppCompatActivity
{
    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(FLAG_FULLSCREEN,
                FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        timer = new Timer();
        timer.schedule(new TimerTask()
        {
            @Override
            public void run()
            {
                Intent intent = new Intent(MainActivity.this, Name_Page.class);
                startActivity(intent);
                finish();
            }
        },2000);
    }
}