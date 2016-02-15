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
import org.uqbar.commons.model.CollectionBasedHome;
import repos.RepoTripulantes;

@SuppressWarnings("all")
public class RepoVuelos extends CollectionBasedHome<Vuelo> {
  private RepoTripulantes repoTripulantes;
  
  private Set<Tripulante> tripulacionEnCurso = CollectionLiterals.<Tripulante>newHashSet();
  
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
    final HashSet<String> tripulacion = CollectionLiterals.<String>newHashSet("Fernando", "Florencia", "Raul");
    final HashSet<String> tripulacion2 = CollectionLiterals.<String>newHashSet("Fernando", "Florencia", "Sergio");
    this.crearVuelo("Y2MW", tripulacion);
    this.crearVuelo("Y3MW", tripulacion2);
  }
  
  public void crearVuelo(final String numeroDeVuelo, final Set<String> tripulacionEnString) {
    RepoTripulantes _instance = RepoTripulantes.getInstance();
    this.repoTripulantes = _instance;
    final Consumer<String> _function = new Consumer<String>() {
      public void accept(final String it) {
        Tripulante _tripulante = new Tripulante(it);
        List<Tripulante> _searchByExample = RepoVuelos.this.repoTripulantes.searchByExample(_tripulante);
        Tripulante _get = _searchByExample.get(0);
        RepoVuelos.this.tripulacionEnCurso.add(_get);
      }
    };
    tripulacionEnString.forEach(_function);
    Vuelo _vuelo = new Vuelo(numeroDeVuelo, this.tripulacionEnCurso);
    this.create(_vuelo);
  }
}
