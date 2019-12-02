package com.example.a1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DatosActivity extends AppCompatActivity {
    private SharedPreferences infoDatos;
    String mNombre, mEmail, mTelefono;
    EditText nombre, email, telefono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);
        infoDatos = getSharedPreferences("misDatos", Context.MODE_PRIVATE);
        mNombre = infoDatos.getString("nombre", "");
        mEmail = infoDatos.getString("email", "");
        mTelefono = infoDatos.getString("telefono", "");


        nombre =findViewById(R.id.nombre);
        email =findViewById(R.id.email);
        telefono =findViewById(R.id.telefono);

        nombre.setText(mNombre);
        email.setText(mEmail);
        telefono.setText(mTelefono);
    }

    public void guardarDatos (View view){
        if (view.getId()==R.id.datosGuardados){
            SharedPreferences.Editor editor = infoDatos.edit();
            editor.putString("nombre",nombre.getText().toString());
            editor.putString("email",email.getText().toString());
            editor.putString("telefono",telefono.getText().toString());

            editor.commit();
            Toast.makeText(this, "Se guardaron los datos", Toast.LENGTH_LONG).show();
        }


    }
}
