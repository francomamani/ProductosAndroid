package com.example.hpuser.productos.Modelo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Producto {
    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("nombre")
    @Expose
    private String nombre;

    @SerializedName("descripcion")
    @Expose
    private String descripcion;

    public Producto(){}
    public Producto(int id, String nombre, String descripcion){
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
