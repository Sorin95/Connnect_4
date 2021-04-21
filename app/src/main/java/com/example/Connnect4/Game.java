package com.example.Connnect4;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class Game extends Fragment {

//    int[][] mat = { { 0, 0, 0, 0, 0, 0, 0 },
//                    { 0, 0, 0, 0, 0, 0, 0 },
//                    { 0, 0, 0, 0, 0, 0, 0 },
//                    { 0, 0, 0, 0, 0, 0, 0 },
//                    { 0, 0, 0, 0, 0, 0, 0 },
//                    { 0, 0, 0, 0, 0, 0, 1 },};

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
}