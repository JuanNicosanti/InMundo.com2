package domain;

import com.google.common.base.Objects;
import domain.Tripulante;
import java.util.HashSet;
import java.util.Set;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;
import org.uqbar.commons.model.Entity;

@Accessors
@SuppressWarnings("all")
public class Vuelo extends Entity {
  private String numero;
  
  private Set<Tripulante> tripulantes;
  
  private String origen;
  
  private String destino;
  
  private String fecha;
  
  private Boolean finalizado;
  
  public boolean agregarTripulante(final Tripulante tripulante) {
    return this.tripulantes.add(tripulante);
  }
  
  public boolean eliminarTripulante(final String nombre) {
    boolean _xblockexpression = false;
    {
      final Function1<Tripulante, Boolean> _function = new Function1<Tripulante, Boolean>() {
        public Boolean apply(final Tripulante it) {
          String _nombre = it.getNombre();
          return Boolean.valueOf(Objects.equal(_nombre, nombre));
        }
      };
      Tripulante tripulanteABorrar = IterableExtensions.<Tripulante>findFirst(this.tripulantes, _function);
      _xblockexpression = this.tripulantes.remove(tripulanteABorrar);
    }
    return _xblockexpression;
  }
  
  public Vuelo(final String numeroDeVuelo, final Set<Tripulante> tripulacion, final String origenNuevo, final String destinoNuevo, final String fechaNueva, final Boolean finalizadoNuevo) {
    this.numero = numeroDeVuelo;
    this.tripulantes = tripulacion;
    this.origen = origenNuevo;
    this.destino = destinoNuevo;
    this.fecha = fechaNueva;
    this.finalizado = finalizadoNuevo;
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
  
  @Pure
  public String getOrigen() {
    return this.origen;
  }
  
  public void setOrigen(final String origen) {
    this.origen = origen;
  }
  
  @Pure
  public String getDestino() {
    return this.destino;
  }
  
  public void setDestino(final String destino) {
    this.destino = destino;
  }
  
  @Pure
  public String getFecha() {
    return this.fecha;
  }
  
  public void setFecha(final String fecha) {
    this.fecha = fecha;
  }
  
  @Pure
  public Boolean getFinalizado() {
    return this.finalizado;
  }
  
  public void setFinalizado(final Boolean finalizado) {
    this.finalizado = finalizado;
  }
}
