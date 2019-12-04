package com.example.a1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a1.models.CallResult;
import com.example.a1.utilis.Globals;
import com.example.a1.utilis.ReporteService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReporteActivity extends AppCompatActivity {
    private SharedPreferences reporteDatos;
    String rNombre, rEmail, rTelefono;
    EditText nombre, email, telefono, reporte;
    private ReporteService service;

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

        service = Globals.getApi().create(ReporteService.class);

        Button enviaRepo = findViewById(R.id.btnEnviar);
        enviaRepo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarDatos();
            }
        });
    }

    private void guardarDatos (){
        Call<CallResult> llamadaGuardar = service.agregarReporte(
                nombre.getText().toString(),
                email.getText().toString(),
                telefono.getText().toString(),
                reporte.getText().toString()
        );

        llamadaGuardar.enqueue(new Callback<CallResult>() {
            @Override
            public void onResponse(Call<CallResult> call, Response<CallResult> response) {
                if (response.isSuccessful()){
                    CallResult resultado = response.body();
                    if(!resultado.isError()){
                        Toast.makeText(getApplicationContext(), "Se agrego el reporte número: "+resultado.getId(), Toast.LENGTH_LONG ).show();
                        finish();
                    }
                }
            }

            @Override
            public void onFailure(Call<CallResult> call, Throwable t) {

            }
        });
    }

}
