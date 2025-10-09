package com.mycompany.main.Dominio;

import java.sql.Date;

public class Pago {
    private int id_pago;
    private int id_alquiler;
    private Date fecha_pago;
    private double monto;
    private String metodo_pago;

    public Pago(int id_pago, int id_alquiler, Date fecha_pago, double monto, String metodo_pago) {
        this.id_pago = id_pago;
        this.id_alquiler = id_alquiler;
        this.fecha_pago = fecha_pago;
        this.monto = monto;
        this.metodo_pago = metodo_pago;
    }

    public int getId_pago() {
        return id_pago;
    }

    public void setId_pago(int id_pago) {
        this.id_pago = id_pago;
    }

    public int getId_alquiler() {
        return id_alquiler;
    }

    public void setId_alquiler(int id_alquiler) {
        this.id_alquiler = id_alquiler;
    }

    public Date getFecha_pago() {
        return fecha_pago;
    }

    public void setFecha_pago(Date fecha_pago) {
        this.fecha_pago = fecha_pago;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getMetodo_pago() {
        return metodo_pago;
    }

    public void setMetodo_pago(String metodo_pago) {
        this.metodo_pago = metodo_pago;
    }
    
    
}
