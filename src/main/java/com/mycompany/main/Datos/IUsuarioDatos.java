package com.mycompany.main.Datos;

import com.mycompany.main.Dominio.Usuario;
import java.util.List;

public interface IUsuarioDatos {
    public List<Usuario> getUsuarios();
    public boolean eliminarUsuario(Usuario cliente);
    public boolean modificarUsuario(Usuario cliente);
    public boolean agregarUsuario(Usuario cliente);
}
