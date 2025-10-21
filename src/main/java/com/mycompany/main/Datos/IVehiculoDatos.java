package com.mycompany.main.Datos;

import com.mycompany.main.Dominio.Vehiculo;
import java.util.List;

public interface IVehiculoDatos {
   public List<Vehiculo> getVehiculos();
    public boolean eliminarVehiculo(Vehiculo vehiculo);
    public boolean modificarVehiculo(Vehiculo vehiculo,int id);
    public boolean agregarVehiculo(Vehiculo vehiculo);
    public int ObtenerUltimoIdVehiculo();
    public List<String> getPlacas();
    public int obtenerIdPorPlaca(String placa);
    public double obtenerPrecioPorId(int id);
}
