package com.example.tictactoe.Model;

import android.content.Context;
import android.widget.Button;

public class GameFactory {

    public AbstractGame getGame(int index, Button[][] buttons, Context context){
        if(index == 1){
            return new PvpGame(buttons,context);
        }
        else if(index == 2){
            return new HardGame(buttons, context);
        }
        else if(index == 3){
            return new EasyGame(buttons, context);
        }
        return new NullGame(buttons, context);
    }
}
