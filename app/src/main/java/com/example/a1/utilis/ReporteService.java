package com.example.a1.utilis;

import com.example.a1.models.Empleado;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ReporteService {
    @GET("getEmpleado.php")
    Call<Empleado> getEmpleadoUnico(@Query("id") int idEmpleado);
}
