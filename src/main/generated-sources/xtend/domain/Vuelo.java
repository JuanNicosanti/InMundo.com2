package domain;

import domain.Tripulante;
import java.util.HashSet;
import java.util.Set;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;
import org.uqbar.commons.model.Entity;

@Accessors
@SuppressWarnings("all")
public class Vuelo extends Entity {
  private String numero;
  
  private Set<Tripulante> tripulantes;
  
  public boolean agregarTripulante(final Tripulante tripulante) {
    return this.tripulantes.add(tripulante);
  }
  
  public boolean eliminarTripulante(final Tripulante tripulante) {
    return this.tripulantes.remove(tripulante);
  }
  
  public Vuelo(final String numeroDeVuelo, final Set<Tripulante> tripulacion) {
    this.numero = numeroDeVuelo;
    this.tripulantes = tripulacion;
  }
  
  public Vuelo() {
    this.numero = "";
    HashSet<Tripulante> _newHashSet = CollectionLiterals.<Tripulante>newHashSet();
    this.tripulantes = _newHashSet;
  }
  
  @Pure
  public String getNumero() {
    return this.numero;
  }
  
  public void setNumero(final String numero) {
    this.numero = numero;
  }
  
  @Pure
  public Set<Tripulante> getTripulantes() {
    return this.tripulantes;
  }
  
  public void setTripulantes(final Set<Tripulante> tripulantes) {
    this.tripulantes = tripulantes;
  }
}
