package com.grupo5.practica_android_1_evaluacion_grupo_5;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
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
    String nombreUsuario;
    ListView lvCitas;
    EditText txtFecha, txtHora, txtConsulta;
    Button btnBorrar;
    ArrayList<Cita> citas;

    private Toast Toast1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Intent intencion = getIntent();
        if(intencion.getExtras() != null){
            if(intencion.getExtras().getByteArray("lista") != null){
                citas = conversorLista(intencion.getExtras().getByteArray("lista"));
            }

        }
        if(citas != null) {
            citas = new ArrayList<Cita>();
        }
        txtUsuario = (TextView) findViewById(R.id.txtNombreUsuario);
        nombreUsuario = intencion.getExtras().getString("nombre");
        txtUsuario.setText(nombreUsuario);
        lvCitas = (ListView) findViewById(R.id.lvCitas);
        if(citas != null){
            ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1, adaptador(citas));
            lvCitas.setAdapter(adaptador);
        }
        lvCitas.setClickable(true);
        txtFecha = (EditText) findViewById(R.id.txtFecha);
        txtHora = (EditText) findViewById(R.id.txtHora);
        lvCitas.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {

                //Object o = listView.getItemAtPosition(position);
                // Realiza lo que deseas, al recibir clic en el elemento de tu listView determinado por su posicion.
                Cita citaSeleccionada = null;
                for(int x = 0; x < citas.size(); x++){
                    if(lvCitas.getAdapter().getItem(x).equals(lvCitas.getSelectedItem())){
                        citaSeleccionada = citas.get(x);
                    }
                }
                txtFecha.setText(citaSeleccionada.obtenerDia());
                txtHora.setText(citaSeleccionada.obtenerHora());
                Log.i("Click", "click en el elemento " + position + " de mi ListView");

            }
        });

        txtConsulta = (EditText) findViewById(R.id.txtConsulta);
        txtConsulta.setText(Cita.CONSULTA);

        Toast1 = Toast.makeText(getApplicationContext(), getString(R.string.msgSinCita), Toast.LENGTH_SHORT);
        Toast1.setGravity(0,0,0);
    }

    public void deconexion(View v){
        Intent intencion = new Intent(this, Principal.class );
        startActivity(intencion);
    }
    public void pedirCita(View v){
        Intent intencion = new Intent(this, Citas.class );
        intencion.putExtra("lista", conversorByteLista(citas));
        intencion.putExtra("nueva", true);
        intencion.putExtra("nombre", nombreUsuario);
        startActivity(intencion);
    }
    public void borrarCita(View v){
        if(lvCitas.getSelectedItem() != null){
            for(int x = 0; x < citas.size(); x++){
                if(lvCitas.getAdapter().getItem(x).equals(lvCitas.getSelectedItem())){
                    citas.remove(x);
                }
            }
        }
        else{
            Toast1.show();
        }
    }
    public void editarCita(View v){
        if(lvCitas.isSelected()){
            Intent intencion = new Intent(this, Citas.class );
            intencion.putExtra("lista", conversorByteLista(citas));
            intencion.putExtra("nueva", false);
            intencion.putExtra("nombre", nombreUsuario);
            //intencion.putExtra("cita", conversorByteCita(citas.get(lvCitas.get)));

            startActivity(intencion);
        }
        else{
            Toast1.show();
        }
    }

    public static byte[] conversorByteLista(ArrayList<Cita> lista){
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
    private String[] adaptador(ArrayList<Cita> lista){
        String[] elementos = new String[lista.size()];
        for(int x = 0; x < lista.size(); x++){
            elementos[x] = lista.get(x).obtenerDia() + " - " + lista.get(x).obtenerHora();
        }
        return elementos;
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
    public static byte[] conversorByteCita(Cita cita){
        byte[] objeto= null;
        try{
            ByteArrayOutputStream array = new ByteArrayOutputStream();
            ObjectOutput salida = new ObjectOutputStream(array);
            salida.writeObject(cita);
            objeto = array.toByteArray();
            array.close();
            salida.close();
        }
        catch(IOException e){
            //Nada
        }
        return objeto;
    }
    public static Cita conversorCita(byte[] array){
        Cita cita= null;
        try{
            ByteArrayInputStream entrada = new ByteArrayInputStream(array);
            ObjectInputStream objeto = new ObjectInputStream(entrada);
            cita = (Cita) objeto.readObject();
            entrada.close();
            objeto.close();
        }
        catch (IOException e){
            //Nada
        }
        catch (ClassNotFoundException cnfe){
            //Nada
        }
        return cita;
    }
}
