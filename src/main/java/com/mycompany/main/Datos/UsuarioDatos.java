package com.mycompany.main.Datos;

import com.mycompany.main.Conexion.Conexion;
import com.mycompany.main.Dominio.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.List;


public class UsuarioDatos implements IUsuarioDatos {

    @Override
    public List<Usuario> getUsuarios() {
       
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminarUsuario(Usuario cliente) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean modificarUsuario(Usuario cliente){
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean agregarUsuario(Usuario cliente)  {
       String sql = "INSERT INTO usuarios (id_usuario, usuario, contrasenia) VALUES (?, ?, ?)";
    try (Connection conn = Conexion.getConexion();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, cliente.getId_usuario());
        stmt.setString(2, cliente.getUsuario()); 
        stmt.setString(3, cliente.getContrasenia());
        stmt.executeUpdate();
        return true;

    }   catch(Exception e){
         System.out.println("Error al agregar el usuario "+ e.getMessage());
        }
    return false;
    }

    @Override
    public boolean compararUsuario(String usuario, String contrasena) {
         String sql = "SELECT * FROM usuarios WHERE usuario = ? AND contrasenia = ?";
    try (Connection conn = Conexion.getConexion();
         PreparedStatement stmt = conn.prepareStatement(sql);) {
             stmt.setString(1, usuario);
             stmt.setString(2, contrasena);
             ResultSet rs=stmt.executeQuery();
             return rs.next();

    }catch(Exception e) {
        System.out.println("Error al obtener los datos de usuario: " + e.getMessage());
    }
         return false;

    }
    
    
    
    
}
