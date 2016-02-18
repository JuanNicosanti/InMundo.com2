package repos

import domain.Vuelo
import org.apache.commons.collections15.Predicate
import org.uqbar.commons.model.CollectionBasedHome
import java.util.Set
import domain.Tripulante

class RepoVuelos extends CollectionBasedHome<Vuelo> {

	RepoTripulantes repoTripulantes = RepoTripulantes.getInstance()
	var Set<Tripulante> tripulacion = newHashSet()
	var Set<Tripulante> tripulacion2 = newHashSet()
	var Set<Tripulante> tripulacion3 = newHashSet()
	var Set<Tripulante> tripulacion4 = newHashSet()
	
	static RepoVuelos repoVuelos

	def static RepoVuelos getInstance() {
		if (RepoVuelos.repoVuelos == null) {
			RepoVuelos.repoVuelos = new RepoVuelos
		}
		RepoVuelos.repoVuelos
	}

	override protected Predicate<Vuelo> getCriterio(Vuelo example) {
		new Predicate<Vuelo> {

			override evaluate(Vuelo vuelo) {
				example.numero.contains(vuelo.numero)
			}

		}
	}

	override createExample() {
		new Vuelo
	}

	override getEntityType() {
		typeof(Vuelo)
	}

	new() {
		
		var tripulacionString = newHashSet("Fernando","Florencia","Raul")
		tripulacionString.forEach[tripulacion.add(repoTripulantes.searchByExample(new Tripulante(it)).head)]
		this.create(new Vuelo("Y2MW321NKISS", tripulacion, "Paris", "Barcelona", "02/03/2016", false))
		
		var tripulacionString2 = newHashSet("Fernando","Sergio")
		tripulacionString2.forEach[tripulacion2.add(repoTripulantes.searchByExample(new Tripulante(it)).head)]
		this.create(new Vuelo("Y3MW123MXXAS", tripulacion2, "Ezeiza", "Cordoba", "08/09/2016", false))
		
		var tripulacionString3 = newHashSet("Fernando","Julian","Micaela")
		tripulacionString3.forEach[tripulacion3.add(repoTripulantes.searchByExample(new Tripulante(it)).head)]
		this.create(new Vuelo("Y5MH1653MXYAS", tripulacion3, "Madrid", "Milan", "22/12/2016", false))
		
		var tripulacionString4 = newHashSet("Fernando","Maria","Julian")
		tripulacionString4.forEach[tripulacion4.add(repoTripulantes.searchByExample(new Tripulante(it)).head)]
		this.create(new Vuelo("Y8KH1953MXFHN", tripulacion4, "Ezeiza", "El calafate", "29/10/2017", false))
		
	}
	
	def crearVuelo( String numeroDeVuelo,Set<Tripulante> tripulacion, String origenNuevo, String destinoNuevo, String fechaNueva, Boolean finalizadoNuevo){

		this.create(new Vuelo(numeroDeVuelo, tripulacion, origenNuevo, destinoNuevo,fechaNueva, finalizadoNuevo))
	}
	
	def vuelosNoFinalizados() {
		allInstances.filter [ !it.finalizado ].toList
	}
}
