package com.example.proyectoecohelper.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {

    //Constructor para instanciar mi database
    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    //Es donde voy a crear mis tablas y campos (modelo relacional)
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE talleres (codigo int primary key, taller text, nivel text)");
    }

    //Se utiliza para realizar cambios esquemáticos en la database
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
}
