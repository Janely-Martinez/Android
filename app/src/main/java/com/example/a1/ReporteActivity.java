package com.example.a1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class ReporteActivity extends AppCompatActivity {
    private SharedPreferences reporteDatos;
    String rNombre, rEmail, rTelefono;
    EditText nombre, email, telefono, reporte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporte);
        reporteDatos= getSharedPreferences("misDatos", Context.MODE_PRIVATE);
        rNombre = reporteDatos.getString("nombre", "");
        rEmail = reporteDatos.getString("email", "");
        rTelefono = reporteDatos.getString("telefono", "");

        nombre =findViewById(R.id.rptNombre);
        email =findViewById(R.id.rptEmail);
        telefono =findViewById(R.id.rptTelefono);
        reporte =findViewById(R.id.rptReporte);

        nombre.setText(rNombre);
        email.setText(rEmail);
        telefono.setText(rTelefono);
        reporte.setText("");

    }
}
