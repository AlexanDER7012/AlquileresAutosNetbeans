package com.mycompany.main.Datos;

import com.mycompany.main.Dominio.Cliente;
import java.util.List;

public interface IClienteDatos {
    public List<Cliente> getClientes();
    public boolean eliminarCliente(Cliente cliente);
    public boolean modificarCliente(Cliente cliente);
    public boolean agregarCliente(Cliente cliente);
    public int obtenerUltimoIdCliente();
}
