package repos;

import com.google.common.base.Objects;
import domain.Tripulante;
import org.apache.commons.collections15.Predicate;
import org.uqbar.commons.model.CollectionBasedHome;

@SuppressWarnings("all")
public class RepoTripulantes extends CollectionBasedHome<Tripulante> {
  private static RepoTripulantes repoTripulantes;
  
  public static RepoTripulantes getInstance() {
    RepoTripulantes _xblockexpression = null;
    {
      boolean _equals = Objects.equal(RepoTripulantes.repoTripulantes, null);
      if (_equals) {
        RepoTripulantes _repoTripulantes = new RepoTripulantes();
        RepoTripulantes.repoTripulantes = _repoTripulantes;
      }
      _xblockexpression = RepoTripulantes.repoTripulantes;
    }
    return _xblockexpression;
  }
  
  protected Predicate<Tripulante> getCriterio(final Tripulante example) {
    return new Predicate<Tripulante>() {
      public boolean evaluate(final Tripulante tripulante) {
        String _nombre = example.getNombre();
        String _nombre_1 = tripulante.getNombre();
        return _nombre.contains(_nombre_1);
      }
    };
  }
  
  public Tripulante createExample() {
    return new Tripulante();
  }
  
  public Class<Tripulante> getEntityType() {
    return Tripulante.class;
  }
  
  public RepoTripulantes() {
    Tripulante _tripulante = new Tripulante("Raul", "Pena", "piloto");
    this.create(_tripulante);
    Tripulante _tripulante_1 = new Tripulante("Sergio", "Fernandez", "piloto");
    this.create(_tripulante_1);
    Tripulante _tripulante_2 = new Tripulante("Fernando", "Alvarez", "copiloto");
    this.create(_tripulante_2);
    Tripulante _tripulante_3 = new Tripulante("Julian", "Mercado", "copiloto");
    this.create(_tripulante_3);
    Tripulante _tripulante_4 = new Tripulante("Florencia", "Suarez", "azafata");
    this.create(_tripulante_4);
    Tripulante _tripulante_5 = new Tripulante("Maria", "Mella", "azafata");
    this.create(_tripulante_5);
    Tripulante _tripulante_6 = new Tripulante("Micaela", "Fazio", "azafata");
    this.create(_tripulante_6);
  }
}
