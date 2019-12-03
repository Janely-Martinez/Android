package com.example.a1.utilis;

import com.example.a1.models.Empleado;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ReporteService {
    @GET("getEmpleado.php")
    Call<Empleado> getEmpleadoUnico(@Query("id") int idEmpleado);

    @GET ("getAll.php")
    Call<List<Empleado>> getAll();
    @POST("addReporte.php")
    Call<String> agregarReporte(@Field("nombre") String nombre,
                                @Field("email")String email,
                                @Field("telefono")String telefono,
                                @Field("reporte") String reporte);
}
