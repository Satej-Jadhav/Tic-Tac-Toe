package com.example.tic_tac_toe;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Game extends AppCompatActivity implements View.OnClickListener
{
    public Button[][] buttons = new Button[3][3];
    private boolean player1Turn = true;
    private int roundCount;

    public String player1;
    public String player2;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        //Getting name of players...
        TextView textView = (TextView) findViewById(R.id.player01);
        TextView textView1 = (TextView) findViewById(R.id.player02);

        Intent intent = getIntent();
        player1 = intent.getStringExtra("player1");
        textView.setText(player1);

        player2 = intent.getStringExtra("player2");
        textView1.setText(player2);
        //DONE

        //Going through all the buttons
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                String buttonID = "button_" + i + j;
                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                buttons[i][j] = findViewById(resID);
                buttons[i][j].setOnClickListener(this::onClick);
            }
        }


    }

    @Override
    public void onClick(View v)
    {
        if (!((Button) v).getText().toString().equals(""))
        {
            return;
        }
        if (player1Turn)
        {
            ((Button) v).setText("X");
        } else {
            ((Button) v).setText("O");
        }
        roundCount++;
        if (checkForWin())
        {
            if (player1Turn)
            {
                player1Wins();
            } else
            {
                player2Wins();
            }
        } else if (roundCount == 9)
        {
            draw();
        } else
        {
            player1Turn = !player1Turn;
        }
    }

    private boolean checkForWin()
    {
        String[][] field = new String[3][3];
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                field[i][j] = buttons[i][j].getText().toString();
            }
        }
        for (int i = 0; i < 3; i++)
        {
            if (field[i][0].equals(field[i][1])
                    && field[i][0].equals(field[i][2])
                    && !field[i][0].equals(""))
            {
                return true;
            }
        }
        for (int i = 0; i < 3; i++)
        {
            if (field[0][i].equals(field[1][i])
                    && field[0][i].equals(field[2][i])
                    && !field[0][i].equals(""))
            {
                return true;
            }
        }
        if (field[0][0].equals(field[1][1])
                && field[0][0].equals(field[2][2])
                && !field[0][0].equals(""))
        {
            return true;
        }
        if (field[0][2].equals(field[1][1])
                && field[0][2].equals(field[2][0])
                && !field[0][2].equals(""))
        {
            return true;
        }
        return false;
    }

    private void player1Wins()
    {
        AlertDialog.Builder builder= new AlertDialog.Builder(Game.this);
        builder.setMessage(player1 + " WINS ")
                .setPositiveButton("Play Again", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        for (int i = 0; i < 3; i++) {
                            for (int j = 0; j < 3; j++) {
                                buttons[i][j].setText("");
                            }
                        }
                        roundCount = 0;
                        player1Turn = true;
                    }
                })
                .setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(Game.this,Name_Page.class);
                        startActivity(intent);
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();

    }

    private void player2Wins()
    {
        AlertDialog.Builder builder= new AlertDialog.Builder(Game.this);
        builder.setMessage(player2 + " WINS ")
                .setPositiveButton("Play Again", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        for (int i = 0; i < 3; i++) {
                            for (int j = 0; j < 3; j++) {
                                buttons[i][j].setText("");
                            }
                        }
                        roundCount = 0;
                        player1Turn = true;
                    }
                })
                .setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(Game.this,Name_Page.class);
                        startActivity(intent);
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }

    private void draw()
    {
        AlertDialog.Builder builder= new AlertDialog.Builder(Game.this);
        builder.setMessage(" DRAW ")
                .setPositiveButton("Play Again", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        for (int i = 0; i < 3; i++) {
                            for (int j = 0; j < 3; j++) {
                                buttons[i][j].setText("");
                            }
                        }
                        roundCount = 0;
                        player1Turn = true;
                    }
                })
                .setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(Game.this,Name_Page.class);
                        startActivity(intent);
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }
}

