package com.example.proyectoecohelper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class Info_act extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
    }

    //Intent implícito
    public void Marcar(View view)
    {
        Intent i = new Intent(Intent.ACTION_DIAL);//acción para el llamado telefónico
        i.setData(Uri.parse("tel:" + "990199760"));
        startActivity(i);
    }

    //Intent explícito
    public void Maps(View view)
    {
        Intent i = new Intent(this, MapsActivity.class);
        startActivity(i);
    }

    public void Volver(View view){
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }
}