package com.grupo5.practica_android_1_evaluacion_grupo_5;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class Principal extends AppCompatActivity {
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

       /* txtUser =  findViewById(R.id.txtUsuario);
        txtPass =  findViewById(R.id.txtPass);
        btnLogin =  findViewById(R.id.btnLogin);
        btnRegister =  findViewById(R.id.btnRegister);*/

        // btnLogin.setOnClickListener(this);
        // btnRegister.setOnClickListener(this);


//        btnLogin.setOnClickListener(new View.OnClickListener() {
//
//            public void onClick(View login) {
//                String username = txtUser.getText().toString();
//                String password = txtPass.getText().toString();
//
//                if (login.getId() == R.id.btnLogin) {
//
//                    txtUser.setText("asdasdasd");
//                    keylist.add(username);
//                    keylist.add(password);
//                    lanzar();
//
//
//                } else if (login.getId() == R.id.btnRegister) {
//                    txtPass.setText("asdaoiquweoiqwueoqiwe");
//
//                }
        //}
        // });
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
    @Override
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