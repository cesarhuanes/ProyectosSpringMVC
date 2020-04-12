package hibernate;
// Generated 12-abr-2020 0:01:43 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Estado generated by hbm2java
 */
public class Estado  implements java.io.Serializable {


     private Integer idEstado;
     private String descripcion;
     private Set clienteses = new HashSet(0);

    public Estado() {
    }

	
    public Estado(String descripcion) {
        this.descripcion = descripcion;
    }
    public Estado(String descripcion, Set clienteses) {
       this.descripcion = descripcion;
       this.clienteses = clienteses;
    }
   
    public Integer getIdEstado() {
        return this.idEstado;
    }
    
    public void setIdEstado(Integer idEstado) {
        this.idEstado = idEstado;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Set getClienteses() {
        return this.clienteses;
    }
    
    public void setClienteses(Set clienteses) {
        this.clienteses = clienteses;
    }




}


