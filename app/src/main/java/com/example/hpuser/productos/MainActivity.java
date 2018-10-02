package com.example.hpuser.productos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.hpuser.productos.API.APIEnv;
import com.example.hpuser.productos.API.ProductoService;
import com.example.hpuser.productos.Modelo.Producto;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Button crearBtn;
    Button listarBtn;
    ListView lista;

    ProductoService productoService;
    List<Producto> productos = new ArrayList<Producto>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        crearBtn = (Button) findViewById(R.id.crearBtn);
        listarBtn = (Button) findViewById(R.id.listarBtn);
        lista = (ListView) findViewById(R.id.lista);

        productoService = APIEnv.getProductoService();

        crearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ProductoActivity.class);
                intent.putExtra("id", "");
                intent.putExtra("nombre", "");
                intent.putExtra("descripcion", "");
                startActivity(intent);
            }
        });

        listarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                index();
            }
        });

    }
    public void index() {
        Call <List<Producto>> call =  productoService.index();
        call.enqueue(new Callback<List<Producto>>() {
            @Override
            public void onResponse(Call<List<Producto>> call, Response<List<Producto>> response) {
                if (response.isSuccessful()) {
                    productos = response.body();
                    lista.setAdapter(new ProductoAdapter(MainActivity.this, R.layout.listado_productos, productos));
                }
            }

            @Override
            public void onFailure(Call<List<Producto>> call, Throwable t) {

            }
        });



    }
}
