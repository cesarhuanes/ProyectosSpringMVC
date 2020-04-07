
package com.proyecto.dao;

import com.proyecto.dto.Rol;
import java.util.List;


public interface RolDao {
    List<Rol> listaRol();
  
  void saveRol(Rol rol);
  
  Rol getRol(int idRol);
  
  void deleteRol(int idRol);   
}
