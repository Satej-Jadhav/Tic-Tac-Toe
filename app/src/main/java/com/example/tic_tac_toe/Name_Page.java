package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Timer;
import java.util.TimerTask;

import static android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN;

public class Name_Page extends AppCompatActivity
{
    public String player_01;
    public String player_02;

    public EditText p1;
    public EditText p2;

    public Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_namepage);
        p1 = (EditText) findViewById(R.id.player_01);
        p2 = (EditText) findViewById(R.id.player_02);

        btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Name_Page.this, Game.class);

                player_01 = p1.getText().toString();
                intent.putExtra("player1",player_01);

                player_02 = p2.getText().toString();
                intent.putExtra("player2",player_02);
                startActivity(intent);


            }
        });
    }
}