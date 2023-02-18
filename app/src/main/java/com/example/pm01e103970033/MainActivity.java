package com.example.pm01e103970033;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.pm01e103970033.configuracion.SQLiteConexion;
import com.example.pm01e103970033.tabla.Transacciones;

public class MainActivity extends AppCompatActivity {
    private static final int PETICION_ACCESS_CAM = 201;
    Button salvar, salvados;
    EditText nombres, telefono,nota,pais;
    static final int peticion_captura_imagen = 100;

    ImageView imageView;
    Button btntakephoto;
    String PathImagen;
    private void config()
    {
        nombres = (EditText) findViewById(R.id.txtEditName);
        nota = (EditText) findViewById(R.id.txtEditNota);
        telefono = (EditText) findViewById(R.id.editarTel);
        pais = (EditText) findViewById(R.id.paises);
        salvar = (Button) findViewById(R.id.btnSalvar);
        salvados = (Button) findViewById(R.id.btnSalvados);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        config();

        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AgregarContactos();
            }
            //  Intent intent = new Intent(getApplicationContext(), ActivityLista.class);
            //  startActivity(intent);
        });

        salvados.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view)
            {

                Intent intent = new Intent(getApplicationContext(), ActivityList.class);
                startActivity(intent);
                //  Toast.makeText(MainActivity.this, " *_*", Toast.LENGTH_SHORT).show();

                //Intent intent = new Intent(getApplicationContext(),ActivityLista.class);

                //     intent.putExtra("nombre", nombres.getText().toString());
                //   intent.putExtra("telefono", telefono.getText().toString());

                startActivity(intent);

            }
        });

}

    private void AgregarContactos() {
        SQLiteConexion conexion = new SQLiteConexion(this, Transacciones.NameDatabase, null, 1);
        SQLiteDatabase db = conexion.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put(Transacciones.nombres, nombres.getText().toString());
        valores.put(Transacciones.nota, nota.getText().toString());
        valores.put(Transacciones.telefono, telefono.getText().toString());
        valores.put(Transacciones.pais, pais.getText().toString());

        Long listaContactos  = db.insert(Transacciones.TbContactos, Transacciones.id, valores);

        Toast.makeText(getApplicationContext(), "Contacto Ingresado: " + listaContactos.toString()
                , Toast.LENGTH_SHORT).show();

        db.close();

        ClearScreen();
    }

    private void tomarfoto() {
        Intent intentfoto = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        if(intentfoto.resolveActivity(getPackageManager())!= null)
        {
            startActivityForResult(intentfoto, peticion_captura_imagen);
        }
    }
    private void permiso()
    {
        // Metodo para obtener los permisos requeridos de la aplicacion
        if(ContextCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA},PETICION_ACCESS_CAM);
        }
        else
        {
            tomarfoto();
        }
    }

    private void ClearScreen(){
        nombres.setText("");
        nota.setText("");
        telefono.setText("");
        pais.setText("");
    }
}

