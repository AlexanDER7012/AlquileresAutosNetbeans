package com.mycompany.main.Datos;

import com.mycompany.main.Dominio.Vehiculo;
import java.util.List;

public interface IVehiculoDatos {
   public List<Vehiculo> getVehiculos();
    public boolean eliminarVehiculo(Vehiculo vehiculo);
    public boolean modificarVehiculo(Vehiculo vehiculo);
    public boolean agregarVehiculo(Vehiculo vehiculo); 
}
