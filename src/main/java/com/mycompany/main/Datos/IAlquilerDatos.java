package com.mycompany.main.Datos;

import com.mycompany.main.Dominio.Alquiler;
import java.util.List;

public interface IAlquilerDatos {
    public List<Alquiler> getAlquileres();
    public boolean eliminarAquiler(Alquiler alquiler);
    public boolean modificarAlquiler(Alquiler alquiler, int id);
    public boolean agregarAlquiler(Alquiler alquiler);
    public int obtenerUltimoAlquierId();
}
