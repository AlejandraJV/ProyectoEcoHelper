package com.example.proyectoecohelper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import Objetos.Administrador;
import Objetos.Insumos;

public class MainActivity extends AppCompatActivity {

    private EditText user, pass;
    private TextView msj;
    private Button btn;
    private ProgressBar barra;
    private Administrador adm = new Administrador();
    private Insumos in = new Insumos();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = findViewById(R.id.etUser);
        pass = findViewById(R.id.etPass);
        msj = findViewById(R.id.msjError);
        btn = findViewById(R.id.btn);
        barra = findViewById(R.id.pb);

        msj.setVisibility(View.INVISIBLE); //maneja la invisibilidad
        barra.setVisibility(View.INVISIBLE); //Hago invisible la barra

        //lo que va a hacer mi botón
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Correr mi tarea asincrona
                new Task().execute();
            }
        });


    }

    //Tarea asíncrona
    class Task extends AsyncTask<String,Void, String> {
        //Configuración inicial de mi tarea
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            barra.setVisibility(View.VISIBLE); //aparece barra
        }

        //Realizará el proceso en segundo plano
        @Override
        protected String doInBackground(String... strings) {
            try {
                for (int i = 0; i <= 10; i++) {
                    Thread.sleep(500);//Tiempo de espera de mi barra
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        //Elegimos qué va a ocurrir cuando termine la tarea pesada
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            barra.setVisibility(View.INVISIBLE);

            //Inicio Sesión

            String usuario = user.getText().toString().trim();
            String contrasena = pass.getText().toString().trim();

            String userObj = adm.getUser().trim();
            String passObj = adm.getPass().trim();

            switch (usuario) {
                case "Alejandra":
                    if (usuario.equals(userObj) && contrasena.equals(passObj)) {
                        //inicio sesión
                        msj.setVisibility(View.INVISIBLE);
                        Intent i = new Intent(getBaseContext(), Home_act.class);
                        startActivity(i);
                    }
                    break;
                case "":
                    if (usuario.equals("") && contrasena.equals("")) {
                        //Campos vacíos
                        msj.setVisibility(View.VISIBLE);
                        msj.setText("Los campos están vacíos, intente nuevamente, por favor.");
                    }
                    break;
                default:
                    if (!usuario.equals(userObj) && !contrasena.equals(passObj)) {
                        //Campos incorrectos
                        msj.setVisibility(View.VISIBLE);
                        msj.setText("Datos incorrectos, intente nuevamente, por favor.");
                    }
            }

        }
    }


    public void Facebook(View view){
        Intent i = new Intent(Intent.ACTION_VIEW); //Acción que abre un sitio web
        i.setData(Uri.parse("https://www.facebook.com/"));
        startActivity(i);
    }

    public void Twitter(View view){
        Intent i = new Intent(Intent.ACTION_VIEW); //Acción que abre un sitio web
        i.setData(Uri.parse("https://www.twitter.com/"));
        startActivity(i);
    }

    public void Youtube(View view){
        Intent i = new Intent(Intent.ACTION_VIEW); //Acción que abre un sitio web
        i.setData(Uri.parse("https://www.youtube.com/"));
        startActivity(i);
    }

    public void Info(View view){
        Intent i = new Intent(this,Info_act.class);
        startActivity(i);
    }
}