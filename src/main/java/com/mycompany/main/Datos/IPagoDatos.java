package com.mycompany.main.Datos;

import com.mycompany.main.Dominio.Pago;
import java.util.List;

public interface IPagoDatos {
    public List<Pago> getPago();
    public boolean eliminarPago(Pago pago);
    public boolean modificarPago(Pago pago);
    public boolean agregarPago(Pago pago);
}
