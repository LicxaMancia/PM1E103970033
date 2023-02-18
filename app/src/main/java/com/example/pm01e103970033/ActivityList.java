package com.example.pm01e103970033;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.pm01e103970033.configuracion.SQLiteConexion;
import com.example.pm01e103970033.tabla.Transacciones;

import java.util.ArrayList;

public class ActivityList extends AppCompatActivity {
    SQLiteConexion conexion;
    // searchView Buscador;
    // TextView resultado;
    ListView contact;
    ArrayList<ListView> lista;
    ArrayList<String> listaconcatenada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_list);
        //    resultado = (TextView) findViewById(R.id.resultado);

        Bundle resultado = getIntent().getExtras();
        //   resultado.setText(resultado.getString("nombre"));

        conexion = new SQLiteConexion(this, Transacciones.NameDatabase, null, 1);

        contact = (ListView) findViewById(R.id.contact);
        GetlistaContactos();

        ArrayAdapter adp = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaconcatenada);
        contact.setAdapter(adp);
        //   listaContactos.setText(adp);
        contact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), listaconcatenada.get(i).toString(), Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(), listaconcatenada.get(i).toString(), Toast.LENGTH_SHORT).show();
            }
        });
        contact = (ListView) findViewById(R.id.contact);
        Intent intent = getIntent();

    }

    private void GetlistaContactos() {

        SQLiteDatabase db = conexion.getReadableDatabase(); // Base de datos en modo de lectura
        contact  = null;

        lista = new ArrayList<ListView>();  // Lista de Objetos del tipo personas

        Cursor cursor = db.rawQuery(Transacciones.GetContactos, null);

        while (cursor.moveToNext()) {
            //     contact = new ListView();
            contact.setId(cursor.getInt(0));
            //   contact.setNombres(cursor.getString(1));
            //   contact.setnota(cursor.getString(2));
            //  contact.settelefono(cursor.getInt(3));
            //  contact.setpais(cursor.getString(4));

            lista.add(contact);
        }

        cursor.close();

        LLenarLista();
    }

    private void LLenarLista() {
        listaconcatenada = new ArrayList<String>();

        for(int i =0;  i < lista.size(); i++)
        {
            //       listaconcatenada.add(lista.get(i).getNombres() + " " +
            //             lista.get(i).getNombres() + " - " +
            //           lista.get(i).getnota() + " - " +
            //         lista.get(i).gettelefono() + " - " +
            //       lista.get(i).getpais());
        }
    }
}