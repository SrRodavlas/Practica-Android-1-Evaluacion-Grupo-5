package com.grupo5.practica_android_1_evaluacion_grupo_5.citas;

public class Cita {
    public static String CONSULTA = "5A";
    private String dia, hora, descripcion;

    public Cita(String dia, String hora, String descripcion){
        this.dia = dia;
        this.hora = hora;
        this.descripcion = descripcion;
    }
    public void establecerDia(String dia){
        this.dia = dia;
    }
    public void establecerHora(String hora){
        this.hora = hora;
    }
    public void establecerDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
    public String obtenerDia(){
        return dia;
    }
    public String obtenerHora(){
        return hora;
    }
    public String obtenerDescripcion(){
        return descripcion;
    }
}
