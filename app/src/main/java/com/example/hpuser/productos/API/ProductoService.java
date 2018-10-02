package com.example.hpuser.productos.API;

import com.example.hpuser.productos.Modelo.Producto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ProductoService {
    @GET("productos")
    Call<List<Producto>> index();

    @GET("productos/{id}")
    Call <Producto> show(@Path("id") int id);

    @POST("productos")
    Call<Producto> store(@Body Producto producto);

    @PUT("productos/{id}")
    Call<Producto> update(@Path("id") int id, @Body Producto producto);

    @DELETE("productos/{id}")
    Call<Producto> destroy(@Path("id") int id);

}
