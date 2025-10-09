package com.mycompany.main.Datos;

import com.mycompany.main.Conexion.Conexion;
import com.mycompany.main.Dominio.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
}
