package com.example.hpuser.productos;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.hpuser.productos.Modelo.Producto;

import java.util.List;

public class ProductoAdapter extends ArrayAdapter<Producto> {
    private Context context;
    private List<Producto> productos;


    public ProductoAdapter(@NonNull Context context, int resource, @NonNull List<Producto> objects) {
        super(context, resource, objects);
        this.context = context;
        this.productos = objects;
    }

    @Override
    public View getView(final int pos, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.listado_productos, parent, false);
        TextView nombre = (TextView) rowView.findViewById(R.id.nombre);
        TextView descripcion = (TextView) rowView.findViewById(R.id.descripcion);

        nombre.setText(productos.get(pos).getNombre());
        descripcion.setText(productos.get(pos).getDescripcion());

        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ProductoActivity.class);
                intent.putExtra("id", String.valueOf(productos.get(pos).getId()));
                intent.putExtra("nombre", String.valueOf(productos.get(pos).getNombre()));
                intent.putExtra("descripcion", String.valueOf(productos.get(pos).getDescripcion()));
                context.startActivity(intent);
            }
        });

        return rowView;
    }


}
