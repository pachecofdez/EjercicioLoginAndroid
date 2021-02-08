package com.opacheco.ejercicioteacherdavid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText pt_usuario;
    EditText pt_password;
    Button btn_registrar;
    Button btn_iniciarSesion;
    String nombreUsuario;
    String passwordUsuario;

    SharedPreferences sp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pt_usuario = findViewById(R.id.pt_usuario);
        pt_password = findViewById(R.id.pt_password);
        btn_registrar = findViewById(R.id.btn_registrar);
        btn_iniciarSesion = findViewById(R.id.btn_iniciarSesion);
        sp = getSharedPreferences("Registros", Context.MODE_PRIVATE);

    }


    public void registrar (View view) {
         nombreUsuario = pt_usuario.getText().toString();
         passwordUsuario = pt_password.getText().toString();

        if (nombreUsuario.isEmpty() || passwordUsuario.isEmpty()){
            Toast.makeText(this, "No se puede registrar sin email o password", Toast.LENGTH_SHORT).show();
        } else {

        SharedPreferences.Editor editor = sp.edit();

        editor.putString(nombreUsuario, passwordUsuario);
        editor.commit();
        }

    }

    public void iniciarSesion (View view) {

        nombreUsuario = pt_usuario.getText().toString();
        passwordUsuario = pt_password.getText().toString();

        if (nombreUsuario.isEmpty() || passwordUsuario.isEmpty()){
            Toast.makeText(this, "No se puede iniciar sesion sin email o password", Toast.LENGTH_SHORT).show();
        } else {
            System.out.println(sp.getString(nombreUsuario, "No existe"));
            String passwordCorrecta = sp.getString(nombreUsuario, "No existe");

            if (passwordCorrecta.equals(passwordUsuario)){
                //System.out.println("Funciona y no te peines");

                Intent it = new Intent(this, Bienvenida.class);
                it.putExtra("user", nombreUsuario);
                startActivity(it);


            } else {
                //System.out.println("No funciona, peinate");
                Intent it = new Intent(this, Bienvenida.class);
                it.putExtra("user", "No existe");
                startActivity(it);
            }

        }


        }




}