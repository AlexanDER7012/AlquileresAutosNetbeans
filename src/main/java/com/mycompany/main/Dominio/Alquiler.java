package com.mycompany.main.Dominio;

import java.sql.Date;

public class Alquiler {
    private int id_alquiler;
    private int id_cliente;
    private int id_vehiculo;
    private Date fecha_inicio;
    private Date fecha_fin;
    private int dias_rentados;
    private double total;
    private String estado_renta;
    public Alquiler(){}
    public Alquiler(int id_alquiler, int id_cliente, int id_vehiculo, Date fecha_inicio, Date fecha_fin, int dias_rentados, double total, String estado_renta) {
        this.id_alquiler = id_alquiler;
        this.id_cliente = id_cliente;
        this.id_vehiculo = id_vehiculo;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.dias_rentados = dias_rentados;
        this.total = total;
        this.estado_renta = estado_renta;
    }

    public int getId_alquiler() {
        return id_alquiler;
    }

    public void setId_alquiler(int id_alquiler) {
        this.id_alquiler = id_alquiler;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_vehiculo() {
        return id_vehiculo;
    }

    public void setId_vehiculo(int id_vehiculo) {
        this.id_vehiculo = id_vehiculo;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public int getDias_rentados() {
        return dias_rentados;
    }

    public void setDias_rentados(int dias_rentados) {
        this.dias_rentados = dias_rentados;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getEstado_renta() {
        return estado_renta;
    }

    public void setEstado_renta(String estado_renta) {
        this.estado_renta = estado_renta;
    }
    
    
}
