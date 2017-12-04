package com.grupo5.practica_android_1_evaluacion_grupo_5;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.grupo5.practica_android_1_evaluacion_grupo_5.cuentas.Usuario;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;

import static android.view.Gravity.CENTER;
import static android.view.Gravity.CENTER_VERTICAL;

public class Principal extends AppCompatActivity{

    EditText txtUserName, txtPass;
    CheckBox recordar;
    File fichero;
    Usuario cuenta;
    private Toast Toast1;
    private Toast Toast2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Intent intencion = getIntent();
        if(intencion.getExtras() != null){
            if(intencion.getExtras().getByteArray("usuario") != null){
                cuenta = conversorUsuario(intencion.getExtras().getByteArray("usuario"));
            }

        }

        txtUserName = (EditText) findViewById(R.id.txtUsuario);
        txtPass = (EditText) findViewById(R.id.txtPass);
        recordar = (CheckBox) findViewById(R.id.cbRecordar);
        if(cuenta == null){
            fichero = new File(getApplicationContext().getFilesDir().getPath()
                    + "/user.dat");
            cuenta = Usuario.cargarCuenta(fichero);
        }
        else {
            cuenta.guardarCuenta(new File(getApplicationContext().getFilesDir().getPath()
                    + "/user.dat"));
        }
        if(cuenta != null){
            txtUserName.setText(cuenta.obtenerNombre());
        }
    }

    public void conexion(View v){
        if(cuenta.verificacion(txtUserName.getText().toString(), txtPass.getText().toString())){
            Toast1 = Toast.makeText(getApplicationContext(), getString(R.string.msgLogin), Toast.LENGTH_SHORT);
            Toast1.setGravity(0,0,0);
            Toast1.show();
            if(recordar.isChecked()){
                cuenta.establecerRecuerdo(true);
            }
            else{
                cuenta.establecerRecuerdo(false);
            }
            cuenta.guardarCuenta(new File(getApplicationContext().getFilesDir().getPath()
                    + "/user.dat"));
            Intent intencion = new Intent(this, Menu.class);
            startActivity(intencion);
        }
        else{
           Toast2 =  Toast.makeText(getApplicationContext(), getString(R.string.msgErrorLogin), Toast.LENGTH_SHORT);
            Toast2.setGravity(0,0,0);
            Toast2.show();
        }
    }

    public void registrarse(View v){
        Intent intencion = new Intent(this, Registro.class);
        startActivity(intencion);
    }
    private Usuario conversorUsuario(byte[] array){
        Usuario cuenta = null;
        try{
            ByteArrayInputStream entrada = new ByteArrayInputStream(array);
            ObjectInputStream objeto = new ObjectInputStream(entrada);
            cuenta = (Usuario) objeto.readObject();
            entrada.close();
            objeto.close();
        }
        catch (IOException e){
            //Nada
        }
        catch (ClassNotFoundException cnfe){
            //Nada
        }
        return cuenta;
    }
}
