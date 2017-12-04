package com.grupo5.practica_android_1_evaluacion_grupo_5;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.grupo5.practica_android_1_evaluacion_grupo_5.cuentas.Usuario;

import java.io.File;
import java.util.ArrayList;

public class Principal extends AppCompatActivity{
    /*private EditText txtUser;
    private EditText txtPass;
    private Button btnLogin;
    private Button btnRegister;
    private static ArrayList<String> keylist = new ArrayList<String>();

    private String usuariovalido = "user"; //este usuario vendra del registro
    private String passvalido = "user"; //esto igual

    Context context;
    CharSequence text = "Todo correcto!";
    CharSequence text2 = "todo mal!";
    int duration = Toast.LENGTH_SHORT;*/

    /*public Principal() {
        context = getApplicationContext();
    }*/

    EditText txtUserName;
    Button conectar, registro;
    CheckBox recordar;
    File fichero;
    Usuario cuenta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        txtUserName = (EditText) findViewById(R.id.txtUserName);
        conectar = (Button) findViewById(R.id.btnLogin);
        registro = (Button) findViewById(R.id.btnRegister);
        recordar = (CheckBox) findViewById(R.id.cbRecordar);
        fichero = new File(getApplicationContext().getFilesDir().getPath() + "/user.dat");
        cuenta = Usuario.cargarCuenta(fichero);
        if(cuenta != null){
            txtUserName.setText(cuenta.obtenerNombre());
        }


        /*Intent intent = getIntent();
        String nombreUsuario = intent.getStringExtra(Registro.nombrePorDefecto);

        TextView textView = (TextView) findViewById(R.id.txtUsuario);
        textView.setText(nombreUsuario);


        txtUser =  findViewById(R.id.txtUsuario);
        txtPass =  findViewById(R.id.txtPass);
        btnLogin =  findViewById(R.id.btnLogin);
        btnRegister =  findViewById(R.id.btnRegister);

        //btnRegister.setOnClickListener(this);


        btnLogin.setOnClickListener(new View.OnClickListener() {

            public void onClick(View login) {
                String username = txtUser.getText().toString();
                String password = txtPass.getText().toString();

                if (login.getId() == R.id.btnLogin) {

                    txtUser.setText("asdasdasd");
                    keylist.add(username);
                    keylist.add(password);
                    lanzar();


                } else if (login.getId() == R.id.btnRegister) {
                    txtPass.setText("asdaoiquweoiqwueoqiwe");

                }
        }
        });*/
    }

    public void conexion(View v){

    }

    public void registrarse(View v){
        Intent intencion = new Intent(this, Registro.class);
        startActivity(intencion);
    }

    /*public void lanzar() {
        Intent intent = new Intent(this, Registro.class );
        startActivity(intent);
    }

    public void verificar(ArrayList keylist){

        String verificarUsuario = (String) keylist.get(0);
        String vericarPassword = (String) keylist.get(1);

        if(usuariovalido.equals(verificarUsuario)&& passvalido.equals(vericarPassword)){

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }else {
            Toast toast = Toast.makeText(context, text2, duration);
            toast.show();
        }
    }
    public void onClick(View v) {
        String username = txtUser.getText().toString();
        String password = txtPass.getText().toString();

        if (v.getId() == R.id.btnLogin) {

            txtUser.setText("asdasdasd");
            keylist.add(username);
            keylist.add(password);
            lanzar();


        } else if (v.getId() == R.id.btnRegister) {
            txtPass.setText("asdaoiquweoiqwueoqiwe");

        }

    }*/
}
