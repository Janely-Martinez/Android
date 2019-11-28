package com.example.a1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a1.models.Empleado;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {
    private Gson gson;
    private TextView txtRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gson = new Gson();
        final Empleado empleadoObjeto = new Empleado(1, "Joselyn", "DDS");
        final String jsonObjeto = "{id: 4, nombre: \"Joselyn\", empresa: \"Pato\" }";

        txtRes = findViewById(R.id.textResult);


        Button toJsonBtn = findViewById(R.id.btn2Json);
        toJsonBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                claseAJson(empleadoObjeto);
            }
        });

        Button fromJsonBtn = findViewById(R.id.btnFromJson);
        fromJsonBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jsonAClase(jsonObjeto);
            }
        });


    }

    private void claseAJson(Empleado empleado){
        String resultado = gson.toJson(empleado);
        txtRes.setText(resultado);
}
    private void jsonAClase(String json){
        Empleado empResult =gson.fromJson(json, Empleado.class);
        String resultado = "id: "+empResult.getId();
        resultado += "\nnombre: "+empResult.getNombre();
        resultado += "\nempresa: "+empResult.getEmpresa();
        txtRes.setText(resultado);
    }
    public void mostarMensaje(View view){
        Toast.makeText(this, "Hola mundo", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(MainActivity.this, DatosActivity.class);
        startActivity(intent);
    }

}
