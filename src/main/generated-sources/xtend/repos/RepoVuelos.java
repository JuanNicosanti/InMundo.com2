package repos;

import com.google.common.base.Objects;
import domain.Tripulante;
import domain.Vuelo;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import org.apache.commons.collections15.Predicate;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.uqbar.commons.model.CollectionBasedHome;
import repos.RepoTripulantes;

@SuppressWarnings("all")
public class RepoVuelos extends CollectionBasedHome<Vuelo> {
  private RepoTripulantes repoTripulantes = RepoTripulantes.getInstance();
  
  private Set<Tripulante> tripulacion = CollectionLiterals.<Tripulante>newHashSet();
  
  private Set<Tripulante> tripulacion2 = CollectionLiterals.<Tripulante>newHashSet();
  
  private static RepoVuelos repoVuelos;
  
  public static RepoVuelos getInstance() {
    RepoVuelos _xblockexpression = null;
    {
      boolean _equals = Objects.equal(RepoVuelos.repoVuelos, null);
      if (_equals) {
        RepoVuelos _repoVuelos = new RepoVuelos();
        RepoVuelos.repoVuelos = _repoVuelos;
      }
      _xblockexpression = RepoVuelos.repoVuelos;
    }
    return _xblockexpression;
  }
  
  protected Predicate<Vuelo> getCriterio(final Vuelo example) {
    return new Predicate<Vuelo>() {
      public boolean evaluate(final Vuelo vuelo) {
        String _numero = example.getNumero();
        String _numero_1 = vuelo.getNumero();
        return _numero.contains(_numero_1);
      }
    };
  }
  
  public Vuelo createExample() {
    return new Vuelo();
  }
  
  public Class<Vuelo> getEntityType() {
    return Vuelo.class;
  }
  
  public RepoVuelos() {
    HashSet<String> tripulacionString = CollectionLiterals.<String>newHashSet("Fernando", "Florencia", "Raul");
    final Consumer<String> _function = new Consumer<String>() {
      public void accept(final String it) {
        Tripulante _tripulante = new Tripulante(it);
        List<Tripulante> _searchByExample = RepoVuelos.this.repoTripulantes.searchByExample(_tripulante);
        Tripulante _head = IterableExtensions.<Tripulante>head(_searchByExample);
        RepoVuelos.this.tripulacion.add(_head);
      }
    };
    tripulacionString.forEach(_function);
    Vuelo _vuelo = new Vuelo("Y2MW321NKISS", this.tripulacion, "Paris", "Barcelona", "02/03/2016", Boolean.valueOf(false));
    this.create(_vuelo);
    HashSet<String> tripulacionString2 = CollectionLiterals.<String>newHashSet("Fernando", "Sergio");
    final Consumer<String> _function_1 = new Consumer<String>() {
      public void accept(final String it) {
        Tripulante _tripulante = new Tripulante(it);
        List<Tripulante> _searchByExample = RepoVuelos.this.repoTripulantes.searchByExample(_tripulante);
        Tripulante _head = IterableExtensions.<Tripulante>head(_searchByExample);
        RepoVuelos.this.tripulacion2.add(_head);
      }
    };
    tripulacionString2.forEach(_function_1);
    Vuelo _vuelo_1 = new Vuelo("Y3MW123MXXAS", this.tripulacion2, "Ezeiza", "Cordoba", "08/09/2016", Boolean.valueOf(false));
    this.create(_vuelo_1);
  }
  
  public void crearVuelo(final String numeroDeVuelo, final Set<Tripulante> tripulacion, final String origenNuevo, final String destinoNuevo, final String fechaNueva, final Boolean finalizadoNuevo) {
    Vuelo _vuelo = new Vuelo(numeroDeVuelo, tripulacion, origenNuevo, destinoNuevo, fechaNueva, finalizadoNuevo);
    this.create(_vuelo);
  }
  
  public List<Vuelo> vuelosNoFinalizados() {
    List<Vuelo> _allInstances = this.allInstances();
    final Function1<Vuelo, Boolean> _function = new Function1<Vuelo, Boolean>() {
      public Boolean apply(final Vuelo it) {
        Boolean _finalizado = it.getFinalizado();
        return Boolean.valueOf((!(_finalizado).booleanValue()));
      }
    };
    Iterable<Vuelo> _filter = IterableExtensions.<Vuelo>filter(_allInstances, _function);
    return IterableExtensions.<Vuelo>toList(_filter);
  }
}
