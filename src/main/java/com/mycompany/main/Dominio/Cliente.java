package com.mycompany.main.Dominio;

import java.sql.Date;

public class Cliente {
    private int id_cliente;
    private String nombres;
    private String telefono;
    private String correo;
    private String licencia;
    private Date fecha_registro;
    
    public Cliente(){}
    
    public Cliente(int id_cliente){
        this.id_cliente = id_cliente;
    }
    
    public Cliente(int id_cliente, String nombres, String telefono, String correo, String licencia, Date fecha_registro) {
        this.id_cliente = id_cliente;
        this.nombres = nombres;
        this.telefono = telefono;
        this.correo = correo;
        this.licencia = licencia;
        this.fecha_registro = fecha_registro;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getLicencia() {
        return licencia;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }
    
    
}

