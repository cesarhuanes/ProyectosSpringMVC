
package com.proyecto.service;

import com.proyecto.dto.Rol;
import java.util.List;


public interface RolService {
  List<Rol> lstRol();
  
  void saveRol(Rol rol);
  
  Rol getRol(int idRol);
  
  void deleteRol(int idRol);  
}
