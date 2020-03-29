package com.example.tictactoe.Model;

import android.content.Context;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

//The Null Pattern
public class NullGame extends AbstractGame {

    public NullGame(Button[][] buttons, Context context){
        super(buttons, context);
    }

    protected void player2Move(@Nullable View v) {
        if(!player1Turn){
            ((Button) v).setText("");
            playersMoves ++;
        }
    }

    @Override
    public void onClick(View v) {

        if (!((Button) v).getText().toString().equals("")) {
            return;
        }

        player2Move(v);
    }
}
