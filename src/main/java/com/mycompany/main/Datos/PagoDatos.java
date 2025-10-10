package com.mycompany.main.Datos;

import com.mycompany.main.Conexion.Conexion;
import com.mycompany.main.Dominio.Pago;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PagoDatos implements IPagoDatos {

    @Override
    public List<Pago> getPago() {
List<Pago> pagos = new ArrayList<>();
    String sql = "SELECT * FROM pagos";
    try (Connection conn = Conexion.getConexion();
         PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            Pago pago = new Pago();
            pago.setId_pago(rs.getInt("id_pago"));
            pago.setId_alquiler(rs.getInt("id_alquiler"));
            pago.setFecha_pago(rs.getDate("fecha_pago"));
            pago.setMonto(rs.getDouble("monto"));
            pago.setMetodo_pago(rs.getString("metodo_pago"));
            pagos.add(pago);
        }
    } catch(Exception e){
        System.out.println("Error al obtener los pagos: " + e.getMessage());
    }
    return pagos;
    }

    @Override
    public boolean eliminarPago(Pago pago) {
      String sql = "DELETE FROM pagos WHERE id_pago = ?";
    try (Connection conn =  Conexion.getConexion();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, pago.getId_pago());
        int rows = stmt.executeUpdate();
        if (rows > 0) {
            System.out.println("Se eliminó el pago");
            return true;
        } else{
            System.out.println("No se encontró el pago");
            return false;
        }
    }catch(Exception e) {
        System.out.println("Ocurrió un error al eliminar el pago " + e.getMessage());
    }
    return false;
    }

    @Override
    public boolean modificarPago(Pago pago) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean agregarPago(Pago pago) {
                String sql = "INSERT INTO pagos (id_pago, id_alquiler, fecha_pago, monto, metodo_pago) VALUES (?, ?, ?, ?, ?)";
    try (Connection conn = Conexion.getConexion();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, pago.getId_pago());
        stmt.setInt(2,pago.getId_alquiler());
        stmt.setDate(3, pago.getFecha_pago());
        stmt.setDouble(4, pago.getMonto());
        stmt.setString(5, pago.getMetodo_pago());        

   
        stmt.executeUpdate();
        return true;

    }   catch(Exception e){
         System.out.println("Error al agregar el Pagos "+ e.getMessage());
        }
    return false;
    }
    
}
