package com.example.openmind;

public class obtenerClientes {

    private String nombres, cedula;
    private int imgClientes;

    public obtenerClientes (){}

    public obtenerClientes (String nombres, String cedula, int imgClientes){
        this.nombres = nombres;
        this.cedula = cedula;
        this.imgClientes = imgClientes;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public int getImgClientes() {
        return imgClientes;
    }

    public void setImgClientes(int imgClientes) {
        this.imgClientes = imgClientes;
    }
}
