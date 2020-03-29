package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.example.tictactoe.Model.AbstractGame;
import com.example.tictactoe.Model.GameFactory;

public class GameActivity extends AppCompatActivity {

    private Button[][] buttons = new Button[3][3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        GameFactory gameFactory = new GameFactory();
        int index = getIntent().getIntExtra("INDEX", 0);
        AbstractGame game = gameFactory.getGame(index, buttons, this);

        for(int i = 0; i < 3; i ++){
            for(int j = 0; j < 3; j ++){
                String btnID = "button_" + i + j;
                int resID = getResources().getIdentifier(btnID, "id", getPackageName());
                buttons[i][j] = findViewById(resID);
                buttons[i][j].setOnClickListener(game);
            }
        }
    }
}
