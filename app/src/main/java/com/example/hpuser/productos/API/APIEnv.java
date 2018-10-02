package com.example.hpuser.productos.API;

public class APIEnv {
    public APIEnv() {}

    public static final String BASE = "http://192.168.22.30:8000/api/";
    /*Acceso a servicios de la API*/
    public static ProductoService getProductoService() {
        return RetrofitClient.getClient(BASE)
                             .create(ProductoService.class);
    }
}
