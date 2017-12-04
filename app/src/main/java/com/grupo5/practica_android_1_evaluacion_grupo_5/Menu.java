package com.grupo5.practica_android_1_evaluacion_grupo_5;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.grupo5.practica_android_1_evaluacion_grupo_5.citas.Cita;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Menu extends AppCompatActivity {

    TextView txtUsuario;
    ListView lvCitas;
    Button btnBorrar;
    ArrayList<Cita> citas;

    private Toast Toast1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Intent intencion = getIntent();
        if(intencion.getExtras() != null){
            /*if(intencion.getExtras().getByteArray("lista") != null){
                citas = conversorLista(intencion.getExtras().getByteArray("lista"));
            }*/

        }
        if(citas != null) {
            citas = new ArrayList<Cita>();
        }
        txtUsuario = (TextView) findViewById(R.id.txtvUsuario);
        txtUsuario.setText(intencion.getExtras().getString("nombre"));
        lvCitas = (ListView) findViewById(R.id.lvCitas);
    }

    public void pedirCita(View v){
        Intent intencion = new Intent(this, Citas.class );
        intencion.putExtra("lista", conversorByte(citas));
        startActivity(intencion);
    }
    public void borrarCita(View v){
        if(lvCitas.isSelected()){

        }
        else{
            Toast1 = Toast.makeText(getApplicationContext(), getString(R.string.msgSinCita), Toast.LENGTH_SHORT);
            Toast1.setGravity(0,0,0);
            Toast1.show();
        }
    }
    public void deconexion(View v){
        Intent intencion = new Intent(this, Principal.class );
        startActivity(intencion);
    }
    public static byte[] conversorByte(ArrayList<Cita> lista){
        byte[] objeto= null;
        try{
            ByteArrayOutputStream array = new ByteArrayOutputStream();
            ObjectOutput salida = new ObjectOutputStream(array);
            salida.writeObject(lista);
            objeto = array.toByteArray();
            array.close();
            salida.close();
        }
        catch(IOException e){
            //Nada
        }
        return objeto;
    }
    public static ArrayList<Cita> conversorLista(byte[] array){
        ArrayList<Cita> lista= null;
        try{
            ByteArrayInputStream entrada = new ByteArrayInputStream(array);
            ObjectInputStream objeto = new ObjectInputStream(entrada);
            lista = (ArrayList<Cita>) objeto.readObject();
            entrada.close();
            objeto.close();
        }
        catch (IOException e){
            //Nada
        }
        catch (ClassNotFoundException cnfe){
            //Nada
        }
        return lista;
    }
}
