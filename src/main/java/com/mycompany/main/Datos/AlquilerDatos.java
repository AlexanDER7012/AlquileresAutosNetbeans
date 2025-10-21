package com.mycompany.main.Datos;

import com.mycompany.main.Conexion.Conexion;
import com.mycompany.main.Dominio.Alquiler;
import com.mycompany.main.Dominio.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AlquilerDatos implements IAlquilerDatos{

    @Override
    public List<Alquiler> getAlquileres() {
     List<Alquiler> alquiler = new ArrayList<>();
    String sql = "SELECT * FROM alquileres";
    try (Connection conn = Conexion.getConexion();
         PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {
        while (rs.next()) {
            Alquiler alquilerO = new Alquiler(); 
                alquilerO.setId_alquiler(rs.getInt("id_alquiler"));
                alquilerO.setId_cliente(rs.getInt("id_cliente"));
                alquilerO.setId_vehiculo(rs.getInt("id_vehiculo"));
                alquilerO.setFecha_inicio(rs.getDate("fecha_inicio"));
                alquilerO.setFecha_fin(rs.getDate("fecha_fin"));
                alquilerO.setDias_rentados(rs.getInt("dias_rentados"));
                  alquilerO.setTotal(rs.getDouble("total"));
                   alquilerO.setEstado_renta(rs.getString("estado_renta"));
               
                alquiler.add(alquilerO);
        }
    }   catch(Exception e){
         System.out.println("Error al encontrar los resultados de los clientes "+ e.getMessage());
        }
    return alquiler;  
    }

    @Override
    public boolean eliminarAquiler(Alquiler alquiler) {
            String sql = "DELETE FROM alquileres WHERE id_alquiler = ?";
    try (Connection conn =  Conexion.getConexion();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, alquiler.getId_alquiler());
        int rows = stmt.executeUpdate();
        if (rows > 0) {
            System.out.println("Se eliminó el alquiler");
            return true;
        } else {
            System.out.println("No se encontró el alquiler");
            return false;
        }
    }catch(Exception e){
        System.out.println("Ocurrió un error al eliminar el alquiler "+ e.getMessage());
    }
    return false;
    }

    @Override
    public boolean modificarAlquiler(Alquiler alquiler,int Id) {
     String sql = "UPDATE alquileres SET id_cliente = ?, id_vehiculo = ?, fecha_inicio = ?, fecha_fin = ?, dias_rentados = ?, total = ?, estado_renta = ? WHERE id_alquiler = ?";
    
    try (Connection conn = Conexion.getConexion();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, alquiler.getId_cliente());
        stmt.setInt(2, alquiler.getId_vehiculo());
        stmt.setDate(3, alquiler.getFecha_inicio());
        stmt.setDate(4, alquiler.getFecha_fin());
        stmt.setInt(5, alquiler.getDias_rentados());
        stmt.setDouble(6, alquiler.getTotal());
        stmt.setString(7, alquiler.getEstado_renta());
        stmt.setInt(8, Id);

        int rows = stmt.executeUpdate();
        return rows > 0;

    } catch (Exception e) {
        System.out.println("Ocurrio un error al actualizar el alquiler: " + e.getMessage());
    }
    return false;  
    }

    @Override
    public boolean agregarAlquiler(Alquiler alquiler) {
            String sql = "INSERT INTO alquileres (id_alquiler, id_cliente, id_vehiculo, fecha_inicio, fecha_fin, dias_rentados, total, estado_renta) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    try (Connection conn = Conexion.getConexion();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, alquiler.getId_alquiler());
        stmt.setInt(2,alquiler.getId_cliente());
        stmt.setInt(3, alquiler.getId_vehiculo());
        stmt.setDate(4, alquiler.getFecha_inicio());
        stmt.setDate(5, alquiler.getFecha_fin());        
         stmt.setInt(6, alquiler.getDias_rentados());
         stmt.setDouble(7, alquiler.getTotal());
              stmt.setString(8, alquiler.getEstado_renta()); 
        stmt.executeUpdate();
        return true;

    }   catch(Exception e){
         System.out.println("Error al agregar el Alquiler "+ e.getMessage());
        }
    return false;
    }

    @Override
    public int obtenerUltimoAlquierId() {
        String sql = "SELECT id_alquiler FROM alquileres ORDER BY id_alquiler DESC LIMIT 1";
        try(Connection conn = Conexion.getConexion();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()){
             if(rs.next()){
                 return rs.getInt("id_alquiler");
             }
                }catch(Exception e){
                    System.out.println("Ocurrio un error al conseguir ID " +  e.getMessage());
                }
        return -1;
    }

    @Override
    public boolean cambiarFinalizado(int id) {
       String sql ="UPDATE alquileres SET estado_renta = 'Finalizado' WHERE id_vehiculo = ?";

    try(Connection conn = Conexion.getConexion();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, id);
        int rows=stmt.executeUpdate();
        return rows>0;

    }catch(Exception e) {
        System.out.println("Ocurrio un error al actualizar el estado del Alquiler: " + e.getMessage());
    }
    return false;
    }
    
}
