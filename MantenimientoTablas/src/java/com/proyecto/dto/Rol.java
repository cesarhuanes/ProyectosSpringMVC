
package com.proyecto.dto;

import java.io.Serializable;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;


public class Rol implements Serializable{
  private int idRol;
  
  @NotEmpty(message = "Ingrese descripcion")
  @Size(min = 5, max = 30, message = "Ingrese descripc[5-30] caracteres")
  private String descripcionRol;
  
  @Min(value=1 ,message="Ingrese Monto")
  private double monto;
  
  public int getIdRol() {
    return this.idRol;
  }
  
  public void setIdRol(int idRol) {
    this.idRol = idRol;
  }
  
  public String getDescripcionRol() {
    return this.descripcionRol;
  }
  
  public void setDescripcionRol(String descripcionRol) {
    this.descripcionRol = descripcionRol;
  }
  
  public double getMonto() {
    return this.monto;
  }
  
  public void setMonto(double monto) {
    this.monto = monto;
  }
}
