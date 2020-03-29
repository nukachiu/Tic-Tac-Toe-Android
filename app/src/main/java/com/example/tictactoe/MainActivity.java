package com.example.tictactoe;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tictactoe.Presenter.MenuPresenter;

public class MainActivity extends AppCompatActivity {

    MenuPresenter p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        p = new MenuPresenter(this);
        Button pvpBtn = (Button) findViewById(R.id.pvpBtn);
        Button hardBtn = (Button) findViewById(R.id.hardBtn);
        Button easyBtn = (Button) findViewById(R.id.easyBtn);

        pvpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    p.pvpGame();
                }
        });

        hardBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                p.hardGame();
            }
        });

        easyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                p.easyGame();
            }
        });
    }
}
