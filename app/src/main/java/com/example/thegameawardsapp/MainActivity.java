package com.example.thegameawardsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView iconProfile;
    private final static String PREFERENCES = "preferences";
    private TextView username;
    private TextView favoriteGame;
    private int eyes[];
    private Uri trailers[];

    @Override
    public void onResume(){
        super.onResume();

        loadSharedPreferences();
    }

    @Override
    public void onRestart(){
        super.onRestart();

        loadSharedPreferences();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iconProfile = findViewById(R.id.profile);
        username = findViewById(R.id.userName);
        favoriteGame = findViewById(R.id.favGame);

        eyes = new int[10];
        trailers = new Uri[10];

        createLinks();

        loadSharedPreferences();
    }


    public void openProfile(View view){
        Intent i = new Intent(MainActivity.this, Profile.class);
        startActivity(i);
    }

    protected void loadSharedPreferences(){
        SharedPreferences preferences = getSharedPreferences(PREFERENCES, 0);

        String name = preferences.getString("name", "");
        String favGame = preferences.getString("favGame", "");

        if(name.equals("")){
            username.setVisibility(View.GONE);
        } else {
            username.setText("Olá " + name);
            username.setVisibility(View.VISIBLE);
        }

        if(favGame.equals("")){
            favoriteGame.setVisibility(View.GONE);
        } else {
            favoriteGame.setText("jogo favorito de 2023: "+ favGame);
        }
    }



    protected void createLinks(){

        eyes[0] = R.id.eyeGoty;
        trailers[0] = Uri.parse("https://www.youtube.com/watch?v=1T22wNvoNiU&pp=ygUXYmFsZHVyJ3MgZ2F0ZSAzIHRyYWlsZXI%3D");

        eyes[1] = R.id.eyeOngoing;
        trailers[1] = Uri.parse("https://www.youtube.com/watch?v=ElVDHwbc6-U&pp=ygUmY3liZXJwdW5rIDIwNzcgcGhhbnRvbSBsaWJlcnR5IHRyYWlsZXI%3D");

        eyes[2] = R.id.eyeDirection;
        trailers[2] = Uri.parse("https://www.youtube.com/watch?v=dlQ3FeNu5Yw&pp=ygUTYWxhbiB3YWtlIDIgdHJhaWxlcg%3D%3D");

        eyes[3] = R.id.eyeAnticipated;
        trailers[3] = Uri.parse("https://www.youtube.com/watch?v=bo3Zjx3sR8k&pp=ygUdZmluYWwgZmFudGFzeSByZWJpcnRoIHRyYWlsZXI%3D");

        eyes[4] = R.id.eyeEsports;
        trailers[4] = Uri.parse("https://www.youtube.com/watch?v=e_E9W2vsRbQ&pp=ygUQdmFsb3JhbnQgdHJhaWxlcg%3D%3D");

        eyes[5] = R.id.eyeIndie;
        trailers[5] = Uri.parse("https://www.youtube.com/watch?v=iJL0-lDuJn8&pp=ygUUc2VhIG9mIHN0YXJzIHRyYWlsZXI%3D");

        eyes[6] = R.id.eyeFigthing;
        trailers[6] = Uri.parse("https://youtu.be/qqW4ENjH-pg");

        eyes[7] = R.id.eyeMobile;
        trailers[7] = Uri.parse("https://www.youtube.com/watch?v=w8vPZrMFiZ4&pp=ygUYaG9ua2FpIHN0YXIgcmFpbCB0cmFpbGVy");

        eyes[8] = R.id.eyeNarrative;
        trailers[8] = Uri.parse("https://www.youtube.com/watch?v=dlQ3FeNu5Yw&pp=ygUTYWxhbiB3YWtlIDIgdHJhaWxlcg%3D%3D");

        eyes[9] = R.id.eyeRpg;
        trailers[9] = Uri.parse("https://www.youtube.com/watch?v=1T22wNvoNiU&pp=ygUXYmFsZHVyJ3MgZ2F0ZSAzIHRyYWlsZXI%3D");



        for(int i = 0; i < 10; i++){
            ImageView eye = findViewById(eyes[i]);

            setEventListenersEyes(trailers[i], eye);
        }


    }

    protected void setEventListenersEyes(Uri uri, ImageView eye){
        eye.setOnClickListener((v) -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        });
    }
}