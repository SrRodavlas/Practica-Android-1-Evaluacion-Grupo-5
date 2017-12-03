package com.grupo5.practica_android_1_evaluacion_grupo_5;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

//https://developer.android.com/training/basics/firstapp/starting-activity.html


public class Registro extends AppCompatActivity {

    public static final String nombrePorDefecto = "com.grupo5.practica_android_1_evaluacion_grupo_5.nombreUsuario";

    private EditText userName;
    EditText nombreUsuario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);



    }

    public void registrarse(){
        Intent i = new Intent(this, Principal.class );
       EditText ed = (EditText) findViewById(R.id.txtUserName);
        String nombreUsuario = ed.getText().toString();
        getIntent().putExtra(nombrePorDefecto, nombreUsuario);
        startActivityForResult(i,0);
    }



}
