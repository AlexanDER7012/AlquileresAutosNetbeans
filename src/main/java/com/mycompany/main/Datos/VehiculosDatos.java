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
            return true;
        } else {
            return false;
        }
    }catch(Exception e){
        System.out.println("Ocurrio un error al eliminar el vehiculo " + e.getMessage());
    }
    return false;
    }

    @Override
    public boolean modificarVehiculo(Vehiculo vehiculo, int id) {
        String sql = "UPDATE vehiculos SET marca = ?, modelo = ?, anio = ?, placa = ?, estado = ?, costo_diario = ? WHERE id_vehiculo = ?";
    try (Connection conn = Conexion.getConexion();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1,vehiculo.getMarca());
        stmt.setString(2,vehiculo.getModelo());
        stmt.setInt(3,vehiculo.getAnio());
        stmt.setString(4,vehiculo.getPlaca());
        stmt.setString(5,vehiculo.getEstado());
        stmt.setDouble(6,vehiculo.getCosto_diario());
        stmt.setInt(7,id);

        int rows = stmt.executeUpdate();
        if(rows > 0){
            return true;
        } else {
            return false;
        }
    } catch(Exception e){
        System.out.println("Ocurrio un error al actualizar el vehiculo " + e.getMessage());
    }
    return false;
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

    @Override
    public int ObtenerUltimoIdVehiculo() {
     String sql = "SELECT id_vehiculo FROM vehiculos ORDER BY id_vehiculo DESC LIMIT 1";
    try(Connection conn = Conexion.getConexion();
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery()){
         if(rs.next()){
             return rs.getInt("id_vehiculo");
         }
    }catch(Exception e){
        System.out.println("Ocurrio un error al conseguir ID " +  e.getMessage());
    }
    return -1;
    }

    @Override
    public List<String> getPlacas() {
         List<String> placas = new ArrayList<>();
    String sql="SELECT placa FROM vehiculos WHERE estado = 'Disponible'";
    
    try (Connection conn = Conexion.getConexion();
         PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            placas.add(rs.getString("placa"));
        }

    } catch (Exception e) {
        System.out.println("Error al obtener las placas: " + e.getMessage());
    }

    return placas;
    }

    @Override
    public int obtenerIdPorPlaca(String placa) {
       String sql = "SELECT id_vehiculo FROM vehiculos WHERE placa = ?";
    
    try (Connection conn = Conexion.getConexion();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, placa);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return rs.getInt("id_vehiculo");
        }

    }catch(Exception e) {
        System.out.println("Ocurrio un error al conseguir ID: " + e.getMessage());
    }
    
    return -1;
    }

    @Override
    public double obtenerPrecioPorId(int id) {
       String sql = "SELECT costo_diario FROM vehiculos WHERE id_vehiculo = ?";
    
    try (Connection conn = Conexion.getConexion();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return rs.getDouble("costo_diario");
        }

    }catch(Exception e) {
        System.out.println("Ocurrio un error al conseguir precio: " + e.getMessage());
    }
    
    return 0;
    }

    @Override
    public boolean deDisponibleAlquilado(int id) {
        String sql ="UPDATE vehiculos SET estado = 'Alquilado' WHERE id_vehiculo = ?";

    try(Connection conn = Conexion.getConexion();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, id);
        int rows=stmt.executeUpdate();
        return rows>0;

    }catch(Exception e) {
        System.out.println("Ocurrio un error al actualizar el estado del vehículo: " + e.getMessage());
    }
    return false;
    }
    
    
    
}
