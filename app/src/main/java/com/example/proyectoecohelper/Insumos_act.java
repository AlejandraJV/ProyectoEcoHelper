package com.example.proyectoecohelper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

import Objetos.Insumos;

public class Insumos_act extends AppCompatActivity {

    private Spinner insumos;
    private TextView result;
    private RatingBar calificar;
    private Insumos in = new Insumos();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insumos);

        insumos = findViewById(R.id.spnInsumos);
        result = findViewById(R.id.result);
        calificar = findViewById(R.id.rt);

        result.setVisibility(View.INVISIBLE);

        //Recibo los extras
        Bundle bun = getIntent().getExtras(); //recibo el intent
        String[] listado = bun.getStringArray("insumos"); //obtengo mi referencia

        ArrayAdapter adaptInsumos = new ArrayAdapter(this, android.R.layout.simple_list_item_1,listado);
        insumos.setAdapter(adaptInsumos);
    }

    //Método para calcular insumos
    public void Calcular(View view){
        String opcion = insumos.getSelectedItem().toString();//Obtener lo seleccionado
        int resultado = 0;
        int valor = 0;
        int stock = 0;

        //Recorre las opciones
        for(int i = 0; i < opcion.length(); i++) //(declaración, condición, incremento)
        {
            if(opcion.equals(in.getInsumos()[i]))
            {
                stock = in.getStock()[i];
                valor = in.getPrecios()[i]; //Obtener precio
                resultado = in.anadirAdicional(in.getPrecios()[i],650);
                calificar.setRating(i);
                break;
            }
        }
        result.setVisibility(View.VISIBLE);
        result.setText("La opción es: " + opcion + "\nStock: "+ stock +" unidades.\nEl precio es: "+ valor +"\nEl precio más envío es: " + resultado); //muestro las opciones
    }

    public void Volver(View view){
        Intent i = new Intent(this,Home_act.class);
        startActivity(i);
    }
}