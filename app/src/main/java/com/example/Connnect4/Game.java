package com.example.Connnect4;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.google.android.material.snackbar.Snackbar;

public class Game extends Fragment {

    int[][] mat = { { 0, 0, 0, 0, 0, 0, 0 },
                    { 0, 0, 0, 0, 0, 0, 0 },
                    { 0, 0, 0, 0, 0, 0, 0 },
                    { 0, 0, 0, 0, 0, 0, 0 },
                    { 0, 0, 0, 0, 0, 0, 0 },
                    { 0, 0, 0, 0, 0, 0, 0 },};

    Boolean player1 = true;
    int gamestate = 1;
    Boolean draw = false;
    int value = 0; //pentru players
    int victory = 1;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.game_view, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button_second).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(Game.this)
                        .navigate(R.id.action_Game_to_Menu);
            }
        });
    }

    public void onClick(View view) {
        if (checkWin() == 1) {
            Snackbar.make(view, "Player 1 wins!", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        }
        if (checkWin() == 2) {
            Snackbar.make(view, "Player 2 wins!", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        }
        if (checkWin() == 3) {
            Snackbar.make(view, "Draw!", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        }
//           if (checkWin() == 4) {
//               //aici trebuia sa dea valori matricei
//           }

    }

    @NonNull
    public int checkWin() {
        draw = true;
        value = 0;
        if (horizontalCheck() || verticalCheck() || ascendingDiagonalCheck() || descendingDiagonalCheck()) {
            return value == victory ? 1 : 2;
        }
        // nobody won, return mDraw if it is, nothing if it's not
        return draw ? 3 : 4;
    }

    private boolean horizontalCheck() {
        // orizontal
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 6 - 3; j++) {
                value = mat[i][j];
                if (value == 0) draw = false;
                if (value != 0 && mat[i][j + 1] == value && mat[i][j + 2] == value && mat[i][j + 3] == value) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean verticalCheck() {
        // vertical
        for (int j = 0; j < 7; j++) {
            for (int i = 0; i < 6 - 3; i++) {
                value = mat[i][j];
                if (value == 0) draw = false;
                if (value != 0 && mat[i + 1][j] == value && mat[i + 2][j] == value && mat[i + 3][j] == value) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean ascendingDiagonalCheck() {
        // ca un fel de diagonala secundara
        for (int i = 3; i < 7; i++) {
            for (int j = 0; j < 6 - 3; j++) {
                value = mat[i][j];
                if (value == 0) draw = false;
                if (value != 0 && mat[i - 1][j + 1] == value && mat[i - 2][j + 2] == value && mat[i - 3][j + 3] == value) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean descendingDiagonalCheck() {
        // diagonala principala sor of
        for (int i = 3; i < 7; i++) {
            for (int j = 3; j < 6; j++) {
                value = mat[i][j];
                if (value == 0) draw = false;
                if (value != 0 && mat[i - 1][j - 1] == value && mat[i - 2][j - 2] == value && mat[i - 3][j - 3] == value) {
                    return true;
                }
            }
        }
        return false;
    }
}
