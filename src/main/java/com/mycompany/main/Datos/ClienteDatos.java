package com.mycompany.main.Datos;

import com.mycompany.main.Conexion.Conexion;
import com.mycompany.main.Dominio.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteDatos implements IClienteDatos {

    @Override
    public List<Cliente> getClientes() {
       List<Cliente> clientes = new ArrayList<>();
    String sql = "SELECT * FROM clientes";
    try (Connection conn = Conexion.getConexion();
         PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {
        while (rs.next()) {
            Cliente ClienteO = new Cliente(); 
                ClienteO.setId_cliente(rs.getInt("id_cliente"));
                ClienteO.setNombres(rs.getString("nombres"));
                ClienteO.setTelefono(rs.getString("telefono"));
                ClienteO.setCorreo(rs.getString("correo"));
                ClienteO.setLicencia(rs.getString("licencia"));
                ClienteO.setFecha_registro(rs.getDate("fecha_registro"));
               
                clientes.add(ClienteO);
        }
    }   catch(Exception e){
         System.out.println("Error al encontrar los resultados de los clientes "+ e.getMessage());
        }
    return clientes;
    }

    @Override
    public boolean eliminarCliente(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean modificarCliente(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean agregarCliente(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
