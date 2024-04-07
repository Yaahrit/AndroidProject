package com.nisha.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddPlayer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_player);

        EditText playerOne = findViewById(R.id.playerOne);
        EditText playerTwo = findViewById(R.id.playerTwo);
        Button startGameButton = findViewById(R.id.startGameButton);

        startGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String playerOneName = playerOne.getText().toString();
                String playerTwoName = playerTwo.getText().toString();

                if (playerOneName.isEmpty() || playerTwoName.isEmpty()) {
                    Toast.makeText(AddPlayer.this, " Please enter player name? ", Toast.LENGTH_LONG).show();
                } else {
                    Intent i = new Intent(AddPlayer.this, MainActivity.class);
                    i.putExtra("PlayerOne", playerOneName);
                    i.putExtra("PlayerTwo", playerTwoName);
                    startActivity(i);
                }
            }
        });
    }
}