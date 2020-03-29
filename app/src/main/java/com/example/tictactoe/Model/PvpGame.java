package com.example.tictactoe.Model;

import android.content.Context;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

public class PvpGame extends AbstractGame {

    public PvpGame(Button[][] buttons, Context context){
        super(buttons, context);
    }

    @Override
    protected void player2Move(@Nullable View v) {
        if(!player1Turn){
            ((Button) v).setText(PLAYER_2_SYMBOL);
            playersMoves ++;
        }
    }

    @Override
    public void onClick(View v){

        if(!stillPlay){
            return;
        }

        if(!((Button)v).getText().toString().equals("")){
            return;
        }

        if(player1Turn){
            player1Move(v);
        }
        else{
            player2Move(v);
        }

        Verification verification = new Verification();
        int winner = verification.checkForWin(buttons);

        if(winner == verification.getPLAYER1_WINNER()){
            player1Wins();
            stillPlay = false;
            return;
        }
        else if(winner == verification.getPLAYER2_WINNER()){
            player2Wins();
            stillPlay = false;
            return;
        }

        if(9 == playersMoves){
            draw();
            return;
        }

        player1Turn = !player1Turn;
    }
}
