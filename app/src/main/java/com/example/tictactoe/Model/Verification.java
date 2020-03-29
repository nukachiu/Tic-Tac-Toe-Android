package com.example.tictactoe.Model;

import android.widget.Button;

public class Verification {

    private final int PLAYER1_WINNER = 1;
    private final int PLAYER2_WINNER = -1;

    public int checkForWin(Button[][] buttons){
        String[][] field = new String[3][3];

        for(int i = 0; i < 3; i ++){
            for(int j = 0; j < 3; j ++){
                field[i][j] = buttons[i][j].getText().toString();
            }
        }

        //the lines
        if(field[0][0].equals(field[0][1]) && field[0][1].equals(field[0][2])){
            if(field[0][0].equals("X")){
                return PLAYER1_WINNER;
            }
            else if(field[0][0].equals("0")){
                return PLAYER2_WINNER;
            }
        }

        if(field[1][0].equals(field[1][1]) && field[1][1].equals(field[1][2])){
            if(field[1][0].equals("X")){
                return PLAYER1_WINNER;
            }
            else if(field[1][0].equals("0")){
                return PLAYER2_WINNER;
            }
        }

        if(field[2][0].equals(field[2][1]) && field[2][1].equals(field[2][2])){
            if(field[2][0].equals("X")){
                return PLAYER1_WINNER;
            }
            else if(field[2][0].equals("0")){
                return PLAYER2_WINNER;
            }
        }

        //the columns
        if(field[0][0].equals(field[1][0]) && field[1][0].equals(field[2][0])){
            if(field[0][0].equals("X")){
                return PLAYER1_WINNER;
            }
            else if(field[0][0].equals("0")){
                return PLAYER2_WINNER;
            }
        }

        if(field[0][1].equals(field[1][1]) && field[1][1].equals(field[2][1])){
            if(field[0][1].equals("X")){
                return PLAYER1_WINNER;
            }
            else if(field[0][1].equals("0")){
                return PLAYER2_WINNER;
            }
        }

        if(field[0][2].equals(field[1][2]) && field[1][2].equals(field[2][2])){
            if(field[0][2].equals("X")){
                return PLAYER1_WINNER;
            }
            else if(field[0][2].equals("0")){
                return PLAYER2_WINNER;
            }
        }

        //the diagonals
        if(field[0][0].equals(field[1][1]) && field[1][1].equals(field[2][2])){
            if(field[0][0].equals("X")){
                return PLAYER1_WINNER;
            }
            else if(field[0][0].equals("0")){
                return PLAYER2_WINNER;
            }
        }

        if(field[0][2].equals(field[1][1]) && field[1][1].equals(field[2][0])){
            if(field[0][2].equals("X")){
                return PLAYER1_WINNER;
            }
            else if(field[0][2].equals("0")){
                return PLAYER2_WINNER;
            }
        }

        return 0;
    }
    public int checkForWin(String[][] field){

        //the lines
        if(field[0][0].equals(field[0][1]) && field[0][1].equals(field[0][2])){
            if(field[0][0].equals("X")){
                return PLAYER1_WINNER;
            }
            else if(field[0][0].equals("0")){
                return PLAYER2_WINNER;
            }
        }

        if(field[1][0].equals(field[1][1]) && field[1][1].equals(field[1][2])){
            if(field[1][0].equals("X")){
                return PLAYER1_WINNER;
            }
            else if(field[1][0].equals("0")){
                return PLAYER2_WINNER;
            }
        }

        if(field[2][0].equals(field[2][1]) && field[2][1].equals(field[2][2])){
            if(field[2][0].equals("X")){
                return PLAYER1_WINNER;
            }
            else if(field[2][0].equals("0")){
                return PLAYER2_WINNER;
            }
        }

        //the columns
        if(field[0][0].equals(field[1][0]) && field[1][0].equals(field[2][0])){
            if(field[0][0].equals("X")){
                return PLAYER1_WINNER;
            }
            else if(field[0][0].equals("0")){
                return PLAYER2_WINNER;
            }
        }

        if(field[0][1].equals(field[1][1]) && field[1][1].equals(field[2][1])){
            if(field[0][1].equals("X")){
                return PLAYER1_WINNER;
            }
            else if(field[0][1].equals("0")){
                return PLAYER2_WINNER;
            }
        }

        if(field[0][2].equals(field[1][2]) && field[1][2].equals(field[2][2])){
            if(field[0][2].equals("X")){
                return PLAYER1_WINNER;
            }
            else if(field[0][2].equals("0")){
                return PLAYER2_WINNER;
            }
        }

        //the diagonals
        if(field[0][0].equals(field[1][1]) && field[1][1].equals(field[2][2])){
            if(field[0][0].equals("X")){
                return PLAYER1_WINNER;
            }
            else if(field[0][0].equals("0")){
                return PLAYER2_WINNER;
            }
        }

        if(field[0][2].equals(field[1][1]) && field[1][1].equals(field[2][0])){
            if(field[0][2].equals("X")){
                return PLAYER1_WINNER;
            }
            else if(field[0][2].equals("0")){
                return PLAYER2_WINNER;
            }
        }

        return 0;
    }

    public int getPLAYER1_WINNER() {
        return PLAYER1_WINNER;
    }

    public int getPLAYER2_WINNER(){
        return PLAYER2_WINNER;
    }
}
