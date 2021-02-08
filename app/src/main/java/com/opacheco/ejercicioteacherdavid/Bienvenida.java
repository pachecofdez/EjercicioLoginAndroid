package com.opacheco.ejercicioteacherdavid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Bienvenida extends AppCompatActivity {

    TextView tv_datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenida);

        tv_datos = findViewById(R.id.tv_datos);
        tv_datos.setText("Hola tt");

        Bundle bundle = getIntent().getExtras();
        if (bundle.getString("user").equals("No existe")){
            tv_datos.setText("Inicio de sesion incorrecto");
        } else {
            String usuarioTemporal = (String) bundle.get("user");
            tv_datos.setText("Inicio de sesion correcto " + usuarioTemporal);
        }

    }



}