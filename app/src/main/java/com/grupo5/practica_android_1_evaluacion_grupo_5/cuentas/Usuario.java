package com.grupo5.practica_android_1_evaluacion_grupo_5.cuentas;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Usuario {
    private String nombre, contraseña, email;
    private boolean devolverNombre;

    public Usuario(String nombre, String contraseña, String email){
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.email = email;
        this.devolverNombre = false;
    }

    public String obtenerNombre(){
        if(devolverNombre){
            return nombre;
        }
        else{
            return "";
        }
    }
    public void establecerRecuerdo(boolean devolverNombre){
        this.devolverNombre = devolverNombre;
    }
    public boolean verificacion(String nombre, String contraseña){
        if(this.nombre == nombre && this.contraseña == contraseña){
            return true;
        }
        else{
            return false;
        }
    }
    public void guardarCuenta(File fichero){
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
