package com.grupo5.practica_android_1_evaluacion_grupo_5;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

public class Menu extends AppCompatActivity {

    TextView txtUsuario;
    ListView lvCitas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Intent intencion = getIntent();
        txtUsuario = (TextView) findViewById(R.id.txtvUsuario);
        txtUsuario.setText(intencion.getExtras().getString("nombre"));

    }

    public void pedirCita(View v){
        Intent intencion = new Intent(this, Citas.class );
        startActivity(intencion);
    }
    public void deconexion(View v){
        Intent intencion = new Intent(this, Principal.class );
        startActivity(intencion);
    }
}
