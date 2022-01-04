package com.example.openmind;

import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    Connection con;
    String usuario, pass, servidor, port, bd;
    @SuppressLint("NewApi")

    public Connection getConnection(){

        usuario = "usuario";
        pass = "PGalliance99";

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection connection = null;
        String ConnectionURL = null;

        try {

            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            ConnectionURL = "jdbc:jtds:sqlserver://10.0.0.185:1433/SistemaFacturacion;encrypt=fasle;user=usuario;password=PGalliance99;";
            connection = DriverManager.getConnection(ConnectionURL,usuario,pass);
            Log.w("Connection","open");

        }catch (Exception exception){
            Log.e("Error en: ", exception.getMessage());
        }
        return connection;
    }

}
