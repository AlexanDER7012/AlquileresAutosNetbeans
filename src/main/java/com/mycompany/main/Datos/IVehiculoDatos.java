package com.mycompany.main.Datos;

import com.mycompany.main.Dominio.Vehiculo;
import java.util.List;

public interface IVehiculoDatos {
   public List<Vehiculo> getVehiculos();
    public boolean eliminarVehiculo(Vehiculo cliente);
    public boolean modificarVehiculo(Vehiculo cliente);
    public boolean agregarVehiculo(Vehiculo cliente); 
}
