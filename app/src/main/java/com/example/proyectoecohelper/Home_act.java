package com.example.proyectoecohelper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import Objetos.Insumos;

public class Home_act extends AppCompatActivity {

    private VideoView video;
    private Insumos in = new Insumos();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        video = findViewById(R.id.vw); //llama al video


        //Obtener la ruta del video
        String ruta ="android.resource://" + getPackageName() + "/" + R.raw.video;
        Uri uri = Uri.parse(ruta); //parseamos la ruta
        video.setVideoURI(uri); //le pasamos el video al videoView

        /*
        video.start(); //inicia el video
        */

        //Controles para video
        MediaController media = new MediaController(this);
        video.setMediaController(media);


    }
    //Método para ir a insumos
    public void Insumos(View view){
        Intent i = new Intent(this, Insumos_act.class);
        //Preparo los extras
        Bundle bun = new Bundle();
        bun.putStringArray("insumos", in.getInsumos());
        i.putExtras(bun); //Le paso el bundle al intent
        startActivity(i);
    }

    public void Talleres(View view)
    {
        Intent i = new Intent(this, Talleres_act.class);
        startActivity(i);
    }
}