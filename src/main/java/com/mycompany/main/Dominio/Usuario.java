package com.mycompany.main.Dominio;

public class Usuario {
    private int id_usuario;
    private String usuario;
    private String contrasenia;

    public Usuario(int id_usuario, String usuario, String contrasenia) {
        this.id_usuario = id_usuario;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    
}
