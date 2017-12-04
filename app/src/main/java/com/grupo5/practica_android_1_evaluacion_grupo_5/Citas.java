package com.grupo5.practica_android_1_evaluacion_grupo_5;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.grupo5.practica_android_1_evaluacion_grupo_5.citas.Cita;

import java.util.ArrayList;

public class Citas extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    Spinner spiFecha, spiHora;
    EditText mtxtMotivo;
    ArrayList<Cita> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_citas);

        spiFecha = (Spinner) findViewById(R.id.spiFecha);
        ArrayAdapter<String> fechas = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item,
                getResources().getStringArray(R.array.dias));
        spiFecha.setAdapter(fechas);
        spiFecha.setOnItemSelectedListener(this);
        spiHora = (Spinner) findViewById(R.id.spiHora);
    }


    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        ArrayAdapter<String> horas;
        if(spiFecha.getItemAtPosition(position) == "15/12")
        {
            ArrayAdapter<String> horas = new ArrayAdapter<String>(this,
                    android.R.layout.simple_spinner_dropdown_item,
                    getResources().getStringArray(R.array.dias));

        }
        else if(spiFecha.getItemAtPosition(position) == "16/12")
        {
            iconoIdioma.setImageDrawable(getDrawable(R.drawable.fr));
        }
        else
        {
            iconoIdioma.setImageDrawable(getDrawable(R.drawable.en));
        }
        spiHora.setAdapter(fechas);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
