package com.grupo5.practica_android_1_evaluacion_grupo_5;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void pedirCita(){
        Intent i = new Intent(this, Citas.class );
        startActivity(i);
    }
}
