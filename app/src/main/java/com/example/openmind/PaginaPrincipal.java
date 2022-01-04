package com.example.openmind;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class PaginaPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_principal);
    }

    //Agregar menu de configuracion
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuinfo, menu);
        return true;
    }

    //Metodos del menu de configuracion
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        switch (id){
            case R.id.ItConfiguracion:
                Toast.makeText(this,"Configuración",Toast.LENGTH_SHORT).show();
                break;
            case R.id.ItAyuda:
                Toast.makeText(getApplicationContext(),"Ayuda",Toast.LENGTH_SHORT).show();
                break;
            case R.id.ItSalir:
                this.finish();
                break;
        }
        return false;
    }

    public void ConsultaProductos(View view) {
        Intent intent = new Intent(PaginaPrincipal.this, ConsultaProductos.class);
        startActivity(intent);
    }

    public void ConsultaUsuarios(View view){
        Intent intent = new Intent(this, usuarios.class);
        startActivity(intent);
    }

    public void ConsultaFacturas(View view){
        Intent intent = new Intent(this, facturas.class);
        startActivity(intent);
    }

    public void ConsultaClientes(View view){
        Intent intent = new Intent(this, clientes.class);
        startActivity(intent);
    }

}