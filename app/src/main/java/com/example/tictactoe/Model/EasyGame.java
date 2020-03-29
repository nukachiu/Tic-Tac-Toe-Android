package com.example.tictactoe.Model;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import java.util.Random;

import androidx.annotation.Nullable;

public class EasyGame extends AbstractGame {

    public EasyGame(Button[][] buttons, Context context){
        super(buttons, context);
    }

    protected void player2Move(@Nullable View v) {
        int[] symbols = new int[10];
        int indexSymbols = 0;
        for(int i = 0; i < 3; i ++) {
            for (int j = 0; j < 3; j++) {
                if(buttons[i][j].getText().toString().equals(""))
                {
                    symbols[indexSymbols] = 3 * i + j;
                    indexSymbols ++;
                }
            }
        }

        Random rand = new Random();

        int randomIndex;
        try
        {
            randomIndex = rand.nextInt(indexSymbols);
        }
        catch (Exception e){
            return;
        }

        buttons[(symbols[randomIndex] / 3)][symbols[randomIndex] % 3].setText(PLAYER_2_SYMBOL);
        playersMoves++;
    }

    public void onClick(View v){
        if(!stillPlay){
            return;
        }

        if(!((Button)v).getText().toString().equals("")){
            return;
        }

        Verification verification = new Verification();
        int winner = 0;

        if(player1Turn){
            player1Move(v);
            winner = verification.checkForWin(buttons); // check for wining after player1's move
            if(playersMoves != 9 && winner == 0)        // player 2 can play only if player1 doesn't win and there are available moves
                player2Move(v);
        }

        //if player1 doesn't win we must check the player2's move
        if(winner == 0)
            winner = verification.checkForWin(buttons);

        if(winner == 1){
            player1Wins();
            stillPlay = false;
            return;
        }
        else if(winner == -1){
            player2Wins();
            stillPlay = false;
            return;
        }

        if(9 == playersMoves){
            draw();
            return;
        }
    }

}
