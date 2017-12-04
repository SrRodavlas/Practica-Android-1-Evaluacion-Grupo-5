package com.grupo5.practica_android_1_evaluacion_grupo_5.cuentas;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Usuario {
    private String nombre, contraseña, email;
    private boolean devolverNombre;

    public Usuario(String nombre, String contraseña, String email, boolean devolverNombre){
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.email = email;
        this.devolverNombre = devolverNombre;
    }

    public String obtenerNombre(){
        if(devolverNombre){
            return nombre;
        }
        else{
            return "";
        }
    }
    private void guardarCuenta(File fichero){
        try {
            ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(fichero));
            salida.writeObject(this);
            salida.close();
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
    public static Usuario cargarCuenta(File fichero){
        Usuario cuenta = null;
        try {
            ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(fichero));
            cuenta = (Usuario) entrada.readObject();
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
        catch (ClassNotFoundException i){
            System.out.println(i.getMessage());
        }
        return cuenta;
    }
}
