package com.example.hpuser.productos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hpuser.productos.API.APIEnv;
import com.example.hpuser.productos.API.ProductoService;
import com.example.hpuser.productos.Modelo.Producto;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductoActivity extends AppCompatActivity {

    /*componentes*/
    EditText nombreEdit;
    EditText descripcionEdit;
    Button guardarBtn;

    /*servicio*/
    ProductoService productoService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producto);
        setTitle("CREAR PRODUCTO");

        nombreEdit = (EditText) findViewById(R.id.nombreEdit);
        descripcionEdit = (EditText) findViewById(R.id.descripcionEdit);
        guardarBtn = (Button) findViewById(R.id.guardarBtn);

        productoService = APIEnv.getProductoService();

        Bundle extras = getIntent().getExtras();

        final String id = extras.getString("id");
        String nombre = extras.getString("nombre");
        String descripcion = extras.getString("descripcion");

        nombreEdit.setText(nombre);
        descripcionEdit.setText(descripcion);

        nombreEdit.setFocusable(true);

        guardarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Producto producto = new Producto();
                producto.setNombre(nombreEdit.getText().toString());
                producto.setDescripcion(descripcionEdit.getText().toString());
                if (id != null && id.trim().length() > 0) {
                    update(Integer.parseInt(id), producto);
                } else {
                    store(producto);
                }
            }
        });

    }

    public void store(Producto producto) {
        Call <Producto> call = productoService.store(producto);
        call.enqueue(new Callback<Producto>() {
            @Override
            public void onResponse(Call<Producto> call, Response<Producto> response) {
                if(response.isSuccessful()) {
                    Toast.makeText(ProductoActivity.this, "Producto guardado exitosamente", Toast.LENGTH_SHORT)
                            .show();
                }
            }

            @Override
            public void onFailure(Call<Producto> call, Throwable t) {
                Log.e("Error: ", t.getMessage());
            }
        });
    }

    public void update(int id, final Producto producto) {
        Call <Producto> call = productoService.update(id, producto);
        call.enqueue(new Callback<Producto>() {
            @Override
            public void onResponse(Call<Producto> call, Response<Producto> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(ProductoActivity.this, "El producto " + producto.getNombre() + " fue actualizado ", Toast.LENGTH_SHORT)
                            .show();
                }
            }

            @Override
            public void onFailure(Call<Producto> call, Throwable t) {
                Log.e("Error: ", t.getMessage());
            }
        });


    }






}
