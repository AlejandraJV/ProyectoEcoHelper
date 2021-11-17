package com.example.proyectoecohelper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyectoecohelper.database.AdminSQLiteOpenHelper;

public class Talleres_act extends AppCompatActivity {

    private EditText code, tal, lvl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_talleres);

        code = findViewById(R.id.code);
        tal = findViewById(R.id.tal);
        lvl = findViewById(R.id.lvl);
    }

    //Método para guardar taller
    public void guardarTalleres(View view)
    {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"ecohelper",null,1);
        SQLiteDatabase db = admin.getWritableDatabase(); //Le entrega permisos de sobreescritura

        //Valores que ingresa el cliente
        String codigo = code.getText().toString();
        String taller = tal.getText().toString();
        String nivel = lvl.getText().toString();

        if(!codigo.isEmpty() && !taller.isEmpty() && !nivel.isEmpty()){
            //guardo en la database
            ContentValues cont = new ContentValues(); //Me permite añadir valores
            cont.put("codigo", codigo);
            cont.put("taller", taller);
            cont.put("nivel", nivel);

            db.insert("talleres",null,cont); //Guardo en la database
            db.close();
            Clean(); //Método para limpiar campos
            Toast.makeText(getBaseContext(), "Has guardado un taller", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(getBaseContext(), "Tiene campos vacíos, por favor rellenar", Toast.LENGTH_SHORT).show();
        }

    }

    //Método para consultar talleres
    public void mostrarTalleres(View view)
    {
        //Obtener mi database
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"ecohelper",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String codigo = code.getText().toString();

        if (!codigo.isEmpty())
        {
            Cursor file =
                    db.rawQuery("SELECT taller, nivel FROM talleres WHERE codigo="+codigo,null);

            if(file.moveToFirst()) //Revisa si nuestra consulta tiene valores
            {
                //Mostramos los campos
                tal.setText(file.getString(0)); //consulta por posición
                lvl.setText(file.getString(1));
            }

        }else
        {
            Toast.makeText(getBaseContext(), "No hay taller asociado", Toast.LENGTH_SHORT).show();
        }

    }

    //Método para actualizar talleres
    public void actualizarTalleres(View view)
    {
        //Obtener mi database
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"ecohelper",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();

        //Valores que ingresa el cliente
        String codigo = code.getText().toString();
        String taller = tal.getText().toString();
        String nivel = lvl.getText().toString();

        if(!codigo.isEmpty() && !taller.isEmpty() && !nivel.isEmpty())
        {
            //Actualizar
            ContentValues cont = new ContentValues(); //Me permite añadir valores
            cont.put("codigo", codigo);
            cont.put("taller", taller);
            cont.put("nivel", nivel);

            db.update("talleres", cont,"codigo="+codigo,null);
            db.close();
            Clean(); //Método para limpiar campos
            Toast.makeText(getBaseContext(), "Has actualizado un taller", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(getBaseContext(), "Tiene campos vacíos, por favor rellenar ", Toast.LENGTH_SHORT).show();
        }

    }

    //Método para eliminar talleres
    public void eliminarTalleres(View view)
    {
        //Obtener mi database
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"ecohelper",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();

        String codigo = code.getText().toString();

        if(!codigo.isEmpty())
        {
            //Eliminamos
            db.delete("talleres","codigo="+codigo,null);
            db.close();
            Clean();
            Toast.makeText(getBaseContext(), "Has eliminado el taller: "+ codigo, Toast.LENGTH_SHORT).show();

        }else
        {
            Toast.makeText(getBaseContext(), "El código no debe venir vacío", Toast.LENGTH_SHORT).show();
        }
    }

    //Método para limpiar los campos
    public void Clean()
    {
        code.setText("");
        tal.setText("");
        lvl.setText("");
    }
}