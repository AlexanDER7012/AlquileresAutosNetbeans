package com.mycompany.main.Dominio;


public class Vehiculo {
    private int id_vehiculo;
    private String marca;
    private String modelo;
    private int anio;
    private String placa;
    private String estado;
    private double costo_diario;

    public Vehiculo() {
    }

    public Vehiculo(int id_vehiculo, String marca, String modelo, int anio, String placa, String estado, double costo_diario) {
        this.id_vehiculo = id_vehiculo;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.placa = placa;
        this.estado = estado;
        this.costo_diario = costo_diario;
    }

    public int getId_vehiculo() {
        return id_vehiculo;
    }

    public void setId_vehiculo(int id_vehiculo) {
        this.id_vehiculo = id_vehiculo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getCosto_diario() {
        return costo_diario;
    }

    public void setCosto_diario(double costo_diario) {
        this.costo_diario = costo_diario;
    }
    
}
