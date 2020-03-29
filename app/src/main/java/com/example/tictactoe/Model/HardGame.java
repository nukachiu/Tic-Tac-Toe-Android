package com.example.tictactoe.Model;

import android.content.Context;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

public class HardGame extends AbstractGame {

    public HardGame(Button[][] buttons, Context context)
    {
        super(buttons, context);
    }

    @Override
    protected void player2Move(@Nullable View v) {
        if(buttons[1][1].getText().toString().equals("")){
            buttons[1][1].setText(PLAYER_2_SYMBOL);
            playersMoves++;
            return;
        }

        String[][] field = new String[3][3];

        for(int i = 0; i < 3; i ++){
            for(int j = 0; j < 3; j ++){
                field[i][j] = buttons[i][j].getText().toString();
            }
        }

        int bestVal = -1000;
        int bestRow = -1;
        int bestCol = -1;

        for(int i = 0; i < 3; i ++){
            for(int j = 0; j < 3; j ++){
                if(field[i][j].equals("")){
                    field[i][j] = PLAYER_2_SYMBOL;
                    int moveVal = minimax(field, 0, false);
                    field[i][j] = "";
                    if(moveVal > bestVal){
                        bestRow = i;
                        bestCol = j;
                        bestVal = moveVal;
                    }
                }
            }
        }
        playersMoves++;
        buttons[bestRow][bestCol].setText(PLAYER_2_SYMBOL);
    }

    private int minimax(String[][] board, int depth, boolean isMax){

        Verification verification = new Verification();
        int score = verification.checkForWin(board);

        if(score == verification.getPLAYER2_WINNER())
        {
            return 10;
        }
        else if(score == verification.getPLAYER1_WINNER())
        {
            return -10;
        }

        int best = 0;
        if(!isMax) {
            for(int i = 0; i < 3; i ++){
                for(int j = 0; j < 3; j ++){
                    if(board[i][j].equals("")){
                        board[i][j] = PLAYER_1_SYMBOL;
                        int rez = minimax(board,depth+1,true);
                        board[i][j] = "";
                        if(best > rez){
                            return rez;
                        }
                    }
                }
            }
        }

        return best;
    }

    @Override
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
