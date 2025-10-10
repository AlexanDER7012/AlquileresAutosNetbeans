package com.mycompany.main.Datos;

import com.mycompany.main.Conexion.Conexion;
import com.mycompany.main.Dominio.Vehiculo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class VehiculosDatos implements IVehiculoDatos {

    @Override
    public List<Vehiculo> getVehiculos() {
    List<Vehiculo> vehiculos = new ArrayList<>();
    String sql = "SELECT * FROM vehiculos";
    try (Connection conn = Conexion.getConexion();
         PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            Vehiculo v = new Vehiculo();
            v.setId_vehiculo(rs.getInt("id_vehiculo"));
            v.setMarca(rs.getString("marca"));
            v.setModelo(rs.getString("modelo"));
            v.setAnio(rs.getInt("anio"));
            v.setPlaca(rs.getString("placa"));
            v.setEstado(rs.getString("estado"));
            v.setCosto_diario(rs.getDouble("costo_diario"));
            vehiculos.add(v);
        }
    }catch(Exception e) {
        System.out.println("Error al obtener los vehículos: " + e.getMessage());
    }
    return vehiculos;
}

 

    @Override
    public boolean eliminarVehiculo(Vehiculo vehiculo) {
       String sql = "DELETE FROM vehiculos WHERE id_vehiculo = ?";
    try (Connection conn =  Conexion.getConexion();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, vehiculo.getId_vehiculo());
        int rows = stmt.executeUpdate();
        if (rows > 0) {
            System.out.println("Se eliminó el vehículo");
            return true;
        } else {
            System.out.println("No se encontró el vehículo");
            return false;
        }
    }catch(Exception e){
        System.out.println("Ocurrió un error al eliminar el vehículo " + e.getMessage());
    }
    return false;
    }

    @Override
    public boolean modificarVehiculo(Vehiculo vehiculo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean agregarVehiculo(Vehiculo vehiculo) {
        String sql = "INSERT INTO vehiculos (id_vehiculo, marca, modelo, anio, placa, estado, costo_diario) VALUES (?, ?, ?, ?, ?, ?, ?)";
    try (Connection conn = Conexion.getConexion();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, vehiculo.getId_vehiculo());
        stmt.setString(2,vehiculo.getMarca());
        stmt.setString(3, vehiculo.getModelo());
        stmt.setInt(4, vehiculo.getAnio());
        stmt.setString(5, vehiculo.getPlaca());        
         stmt.setString(6, vehiculo.getEstado());
         stmt.setDouble(7, vehiculo.getCosto_diario());
   
        stmt.executeUpdate();
        return true;

    }   catch(Exception e){
         System.out.println("Error al agregar el Vehiculo "+ e.getMessage());
        }
    return false;
    }
    
}
