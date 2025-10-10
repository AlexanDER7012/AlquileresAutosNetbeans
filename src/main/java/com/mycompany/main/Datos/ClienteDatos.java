package com.mycompany.main.Datos;

import com.mycompany.main.Conexion.Conexion;
import com.mycompany.main.Dominio.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


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
   String sql = "DELETE FROM clientes WHERE id_cliente = ?";
    try (Connection conn =  Conexion.getConexion();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, cliente.getId_cliente());
        int rows = stmt.executeUpdate();
        if (rows > 0) {
            System.out.println("Se eliminó el cliente");
            return true;
        } else {
            System.out.println("No se encontró el cliente");
            return false;
        }
    }catch(Exception e){
        System.out.println("Ocurrió un error al eliminar el cliente " + e.getMessage());
    }
    return false;
    }

    @Override
    public boolean modificarCliente(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean agregarCliente(Cliente cliente) {
    String sql = "INSERT INTO clientes (id_cliente, nombres, telefono, correo, licencia, fecha_registro) VALUES (?, ?, ?, ?, ?, ?)";
    try (Connection conn = Conexion.getConexion();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, cliente.getId_cliente());
        stmt.setString(2, cliente.getNombres()); 
        stmt.setString(3, cliente.getTelefono());
        stmt.setString(4, cliente.getCorreo());
        stmt.setString(5, cliente.getLicencia());        
         stmt.setDate(6, cliente.getFecha_registro());    
        stmt.executeUpdate();
        return true;

    }   catch(Exception e){
         System.out.println("Error al agregar el cliente "+ e.getMessage());
        }
    return false;
    }    
    
}
    

