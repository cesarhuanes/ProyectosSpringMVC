
package com.proyecto.service.Impl;


import com.proyecto.dao.RolDao;
import com.proyecto.dto.Rol;
import com.proyecto.service.RolService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class RolServiceImpl implements RolService {
  @Autowired
  @Qualifier("mysql")
  RolDao rolDao;
  
  @Override
  public List<Rol> lstRol() {
    return this.rolDao.listaRol();
  }
   @Override
  public void saveRol(Rol rol) {
    this.rolDao.saveRol(rol);
  }
   @Override
  public Rol getRol(int idRol) {
    return this.rolDao.getRol(idRol);
  }
   @Override
  public void deleteRol(int idRol) {
    this.rolDao.deleteRol(idRol);
  }

 
    
}
