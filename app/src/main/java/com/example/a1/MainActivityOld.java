package com.example.a1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a1.models.Empleado;
import com.example.a1.utilis.Globals;
import com.example.a1.utilis.ReporteService;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityOld extends AppCompatActivity {
    private Gson gson;
    private TextView txtRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_old);

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

        service = Globals.getApi().create(ReporteService.class);

        Button llamadaUnico = findViewById(R.id.empleadoU);
        llamadaUnico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getEmpleado(1);

            }

        });

        Button llamadaTodos = findViewById(R.id.empleadosT);
        llamadaTodos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getEmpleados();
            }
        });


    }

    private ReporteService service;
    private void getEmpleado(int id){
        Call<Empleado> getEmpleadoCall = service.getEmpleadoUnico(id);
        getEmpleadoCall.enqueue(new Callback<Empleado>() {
            @Override
            public void onResponse(Call<Empleado> call, Response<Empleado> response) {
                Log.i("API_RESULT", response.toString());
                if (response.isSuccessful()) {
                    Empleado empleadoResult = response.body();
                    claseAJson(empleadoResult);
                }
            }

            @Override
            public void onFailure(Call<Empleado> call, Throwable t) {
                Log.i("API_ERROR", t.getMessage());
            }
        });
    }
    private void getEmpleados(){
        Call<List<Empleado>> getTodosCall = service.getAll();
        getTodosCall.enqueue(new Callback<List<Empleado>>() {
            @Override
            public void onResponse(Call<List<Empleado>> call, Response<List<Empleado>> response) {
                if(response.isSuccessful()){
                    List<Empleado> todos = response.body();
                    Toast.makeText(getApplicationContext(), todos.size()+" Empleados encontrados", Toast.LENGTH_LONG).show();
                    claseAJson(todos.get(2));
                }

            }

            @Override
            public void onFailure(Call<List<Empleado>> call, Throwable t) {

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
        Intent intent = new Intent(MainActivityOld.this, DatosActivity.class);
        startActivity(intent);
    }


}
