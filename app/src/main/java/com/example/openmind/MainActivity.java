package com.example.openmind;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MainActivity extends AppCompatActivity {

    Connection connect;
    String ConnectionResult = "";
    CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkBox = findViewById(R.id.checkBox);


        Button cerrar = findViewById(R.id.btnsalir);
        cerrar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });

    }

    //metodo para validar el usuario de inicio de sesion
    public void cargarDatos(View view) {
        TextView txtusuario = findViewById(R.id.txtusuario);
        TextView txtpass = findViewById(R.id.txtpass);
        String usuario = txtusuario.getText().toString();
        String pass = txtpass.getText().toString();

        try {

            Conexion conexion = new Conexion();
            connect = conexion.getConnection();

            //Obligatorio aceptar los terminos y condiciones
           if(checkBox.isChecked()){
               if (connect != null) {
                   String sql = "select usuario, contraseña from empleado where contraseña = ? and usuario = ?";
                   PreparedStatement pst = connect.prepareStatement(sql);
                   pst.setString(1, pass);
                   pst.setString(2, usuario);

                   ResultSet rs = pst.executeQuery();

                   if (rs.next()) {
                       Intent frm2 = new Intent(this, PaginaPrincipal.class);
                       startActivity(frm2);
                       Toast.makeText(getApplicationContext(), "Conexion Exitosa!", Toast.LENGTH_SHORT).show();

                   } else {
                       Toast.makeText(getApplicationContext(), "Usuario y/o Contraseña incorrecta!", Toast.LENGTH_SHORT).show();
                   }

               } else {
                   ConnectionResult = "Revise la conexion a internet!";
                   Toast.makeText(getApplicationContext(), ConnectionResult, Toast.LENGTH_SHORT).show();
               }
           }else{
               Toast.makeText(getApplicationContext(),"Debes aceptar los terminos y condiciones",Toast.LENGTH_LONG).show();
           }

        } catch (Exception e) {

            Context context = getApplicationContext();
            CharSequence text = "Hay un error en la consulta, comuniquese con GGsystems! " + e;
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }

}