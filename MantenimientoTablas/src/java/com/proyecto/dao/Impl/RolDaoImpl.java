
package com.proyecto.dao.Impl;

import com.proyecto.dao.RolDao;
import com.proyecto.dto.Rol;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("mysql")
public class RolDaoImpl implements RolDao {
  private JdbcTemplate jdbcTemplate;
  
  public JdbcTemplate getJdbcTemplate() {
    return this.jdbcTemplate;
  }
  
  @Autowired
  public void setConexion(DataSource dataSource) {
    this.jdbcTemplate = new JdbcTemplate(dataSource);
  }
    @Override
    public List<Rol> listaRol() {
    String sql = "select  idRol,descripcion,ifnull(sueldoEstandar,0.00) from rol";
   
     List<Rol> list = getJdbcTemplate().query(sql, new RowMapper<Rol>(){
        @Override
        public Rol mapRow(ResultSet rs, int i) throws SQLException {
            Rol rol=new Rol();
            rol.setIdRol(rs.getInt(1));
            rol.setDescripcionRol(rs.getString(2));
            rol.setMonto(rs.getDouble(3));
            return rol;
        }
        
    }); 
    return list;
    }

    @Override
    public void saveRol(Rol rol) {
       
        String sql = "";
        if(rol.getIdRol()>0){
         //update
         sql="UPDATE ROL SET DESCRIPCION=?,SUELDOESTANDAR=? WHERE IDROL=?";
         this.jdbcTemplate.update(sql,rol.getDescripcionRol(),rol.getMonto(),rol.getIdRol());
        }else{
            //insert
        sql = "INSERT INTO rol (descripcion, sueldoEstandar) VALUES (?, ?)";
        this.jdbcTemplate.update(sql, new Object[] { rol.getDescripcionRol(), rol.getMonto() });
        }
      }

    @Override
    public Rol getRol(int idRol) {
      String sql = "SELECT  idRol,descripcion,ifnull(sueldoEstandar,0.00) from  ROL WHERE IDROL=" + idRol;
     return jdbcTemplate.query(sql, new ResultSetExtractor<Rol>(){
          @Override
          public Rol extractData(ResultSet rs) throws SQLException, DataAccessException {
            if(rs.next()){
                  Rol rol=new Rol();
            rol.setIdRol(rs.getInt(1));
            rol.setDescripcionRol(rs.getString(2));
            rol.setMonto(rs.getDouble(3));
            return rol;
            }
         
           return null;
          }
      }); 
    }

    @Override
    public void deleteRol(int idRol) {
        String sql = "delete from rol where idRol=?";
        this.jdbcTemplate.update(sql,idRol);
    }
    
}
