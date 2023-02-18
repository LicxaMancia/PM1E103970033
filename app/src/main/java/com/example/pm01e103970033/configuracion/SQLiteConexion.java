package com.example.pm01e103970033.configuracion;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.pm01e103970033.tabla.Transacciones;

public class SQLiteConexion extends SQLiteOpenHelper {

    public SQLiteConexion(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(Transacciones.CreateTBPersonas);

    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(Transacciones.DropTablePersonas);

    }
}

