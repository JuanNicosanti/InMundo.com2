package domain;

import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;
import org.uqbar.commons.model.Entity;

@Accessors
@SuppressWarnings("all")
public class Tripulante extends Entity {
  private String nombre;
  
  private String apellido;
  
  private String tipoPuesto;
  
  public Tripulante(final String nombreNuevo) {
    this.nombre = nombreNuevo;
  }
  
  public Tripulante() {
    this.nombre = "";
    this.apellido = "";
    this.tipoPuesto = "";
  }
  
  public Tripulante(final String nombreNuevo, final String apellidoNuevo, final String puestoNuevo) {
    this.nombre = nombreNuevo;
    this.apellido = apellidoNuevo;
    this.tipoPuesto = puestoNuevo;
  }
  
  @Pure
  public String getNombre() {
    return this.nombre;
  }
  
  public void setNombre(final String nombre) {
    this.nombre = nombre;
  }
  
  @Pure
  public String getApellido() {
    return this.apellido;
  }
  
  public void setApellido(final String apellido) {
    this.apellido = apellido;
  }
  
  @Pure
  public String getTipoPuesto() {
    return this.tipoPuesto;
  }
  
  public void setTipoPuesto(final String tipoPuesto) {
    this.tipoPuesto = tipoPuesto;
  }
}
