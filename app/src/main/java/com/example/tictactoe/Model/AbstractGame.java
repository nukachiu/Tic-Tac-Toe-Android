package com.example.tictactoe.Model;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;

import android.os.Handler;

public abstract class AbstractGame implements View.OnClickListener {

    protected final String PLAYER_1_SYMBOL = "X";
    protected final String PLAYER_2_SYMBOL = "0";
    private final String PLAYER_1_WINS_MESSAGE = "Player 1 wins";
    private final String PLAYER_2_WINS_MESSAGE = "Player 2 wins";
    private final String DRAW_MESSAGE = "Draw";
    protected boolean player1Turn = true;
    protected int playersMoves = 0;
    protected boolean stillPlay = true;

    protected Button[][] buttons;
    private Context context;

    public AbstractGame(Button [][] buttons, Context context){
        this.buttons = buttons;
        this.context = context;
    }

    protected void player1Move(View v){
        if(player1Turn){
            ((Button) v).setText(PLAYER_1_SYMBOL);
            playersMoves ++;
        }
    }

    protected void player1Wins(){
        Toast.makeText(this.context,PLAYER_1_WINS_MESSAGE, Toast.LENGTH_SHORT).show();
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable(){
            @Override
            public void run(){
                resetBoard();
            }
        },1500);
    }

    protected void player2Wins(){
        Toast.makeText(this.context,PLAYER_2_WINS_MESSAGE, Toast.LENGTH_SHORT).show();
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable(){
            @Override
            public void run(){
                resetBoard();
            }
        },1500);
    }

    protected void draw(){
        Toast.makeText(this.context,DRAW_MESSAGE, Toast.LENGTH_SHORT).show();
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable(){
            @Override
            public void run(){
                resetBoard();
            }
        },1500);
    }

    private void resetBoard(){
        for(int i = 0; i < 3; i ++){
            for(int j = 0; j < 3; j ++){
                buttons[i][j].setText("");
            }
        }

        player1Turn = true;
        playersMoves = 0;
        stillPlay = true;
    }

    protected abstract void player2Move(@Nullable View v);
}
