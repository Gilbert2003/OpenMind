package com.example.openmind;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class clientes extends AppCompatActivity {

    private RecyclerView recyclerViewClientes;
    private RecyclerViewAdaptador adaptadorClientes;
    Connection connect;
    Button btnAgregarCliente = findViewById(R.id.btnagregarcliente);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes);

        recyclerViewClientes = findViewById(R.id.recyclerClientes);
        recyclerViewClientes.setLayoutManager(new LinearLayoutManager(this));

        adaptadorClientes = new RecyclerViewAdaptador(getClientes());
        recyclerViewClientes.setAdapter(adaptadorClientes);

        btnAgregarCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
                builder.setTitle("Agregar Cliente");
                builder.setMessage("Mensaje Agregar Cliente");
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });


    }

    public List<obtenerClientes> getClientes() {
        List<obtenerClientes> cliente = new ArrayList<>();

        try {

            Conexion conexion = new Conexion();
            connect = conexion.getConnection();

            if (connect != null) {

                String sql = "select * from cliente";
                PreparedStatement pst = connect.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();

                while (rs.next()) {
                    cliente.add(new obtenerClientes(rs.getString(3), rs.getString(2), R.drawable.usuario));
                }

            } else {
                Toast.makeText(getApplicationContext(), "ha ocurrido un error al cargar los datos, Fallo de conexion", Toast.LENGTH_LONG);
            }

        } catch (SQLException e) {
            Toast.makeText(getApplicationContext(), "No se pudo devolver un valor, revise la conexion!", Toast.LENGTH_SHORT);
        }
        return cliente;
    }


}
