package com.example.thegameawardsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Profile extends AppCompatActivity {

    private Button btnSave;
    private EditText editName;
    private EditText editFavGame;
    private final static String PREFERENCES = "preferences";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        btnSave = findViewById(R.id.saveInfo);
        editName = findViewById(R.id.editName);
        editFavGame = findViewById(R.id.editFavGame);

        btnSave.setOnClickListener( (v) -> {
            SharedPreferences preferences = getSharedPreferences(PREFERENCES, 0);
            SharedPreferences.Editor editor = preferences.edit();

            if(editName.getText().toString().equals("")){
                Toast.makeText(getApplicationContext(), "Preencha o nome!", Toast.LENGTH_SHORT).show();

            }else if(editFavGame.getText().toString().equals("")){
                Toast.makeText(getApplicationContext(), "Preencha o jogo favorito!", Toast.LENGTH_SHORT).show();
            }else{
                String nome = editName.getText().toString();
                String favGame = editFavGame.getText().toString();
                editor.putString("name", nome);
                editor.putString("favGame", favGame);
                editor.commit();
                Toast.makeText(getApplicationContext(), "Informações Salvas!", Toast.LENGTH_SHORT).show();
            }

        });
    }

    public void openMain(View view){
        Intent i = new Intent(Profile.this, MainActivity.class);
        startActivity(i);
    }

}