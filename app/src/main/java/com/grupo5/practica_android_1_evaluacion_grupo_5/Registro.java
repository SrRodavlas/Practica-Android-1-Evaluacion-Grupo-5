package com.grupo5.practica_android_1_evaluacion_grupo_5;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.grupo5.practica_android_1_evaluacion_grupo_5.cuentas.Usuario;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

//https://developer.android.com/training/basics/firstapp/starting-activity.html


public class Registro extends AppCompatActivity {

    private EditText nombreUsuario, email, contraseña;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        nombreUsuario = (EditText) findViewById(R.id.txtUserName);
        email = (EditText) findViewById(R.id.txtEmail);
        contraseña = (EditText) findViewById(R.id.txtPass);

    }

    public void registrarse(View v){
        Intent intencion = new Intent(this, Principal.class );
        intencion.putExtra("usuario", conversorByte());
        startActivity(intencion);
    }
    public void condiciones(View v){
        Intent intencion = new Intent(Intent.ACTION_VIEW);
        intencion.setData(Uri.parse("http://www.google.com"));
        startActivity(intencion);
    }

    private Usuario crearCuenta(){
        Usuario cuenta = new Usuario(nombreUsuario.getText().toString(),
                contraseña.getText().toString(), email.getText().toString());
        return cuenta;
    }
    private byte[] conversorByte(){
        byte[] objeto= null;
        try{
            ByteArrayOutputStream array = new ByteArrayOutputStream();
            ObjectOutput salida = new ObjectOutputStream(array);
            salida.writeObject(crearCuenta());
            objeto = array.toByteArray();
            array.close();
            salida.close();
        }
        catch(IOException e){
            //Nada
        }
        return objeto;
    }
}
