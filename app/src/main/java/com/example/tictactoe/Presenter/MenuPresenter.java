package com.example.tictactoe.Presenter;

import android.content.Context;
import android.content.Intent;

import com.example.tictactoe.GameActivity;
import com.example.tictactoe.MainActivity;
import com.example.tictactoe.Model.GameFactory;

public class MenuPresenter {

    private final int PVP_INDEX = 1;
    private final int HARD_INDEX = 2;
    private final int EASY_INDEX = 3;

    private Context context;

    public MenuPresenter(Context context){
        this.context = context;
    }

    public void pvpGame(){
        Intent intent = new Intent(context,GameActivity.class);
        intent.putExtra("INDEX", PVP_INDEX);
        context.startActivity(intent);
    }

    public void hardGame(){
        Intent intent = new Intent(context,GameActivity.class);
        intent.putExtra("INDEX", HARD_INDEX);
        context.startActivity(intent);
    }

    public void easyGame(){
        Intent intent = new Intent(context,GameActivity.class);
        intent.putExtra("INDEX", EASY_INDEX);
        context.startActivity(intent);
    }
}
