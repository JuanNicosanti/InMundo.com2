package repos

import domain.Vuelo
import org.apache.commons.collections15.Predicate
import org.uqbar.commons.model.CollectionBasedHome
import java.util.Set
import domain.Tripulante

class RepoVuelos extends CollectionBasedHome<Vuelo> {

	RepoTripulantes repoTripulantes
	Set<Tripulante> tripulacionEnCurso = newHashSet()
	
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
		val tripulacion = newHashSet("Fernando","Florencia","Raul")
		val tripulacion2 = newHashSet("Fernando", "Florencia","Sergio")
		this.crearVuelo("Y2MW321NKISS",tripulacion, "Paris", "Barcelona", "02/03/2016", false)
		this.crearVuelo("Y3MW123MXXAS",  tripulacion2, "Ezeiza", "Cordoba", "08/09/2016", false)
	}
	
	def crearVuelo( String numeroDeVuelo,Set<String> tripulacionEnString, String origenNuevo, String destinoNuevo, String fechaNueva, Boolean finalizadoNuevo){
		repoTripulantes = RepoTripulantes.instance
		tripulacionEnString.forEach[tripulacionEnCurso.add(repoTripulantes.searchByExample(new Tripulante(it)).get(0))]
		this.create(new Vuelo(numeroDeVuelo,tripulacionEnCurso, origenNuevo, destinoNuevo,fechaNueva, finalizadoNuevo))
	}
	
	def vuelosNoFinalizados() {
		allInstances.filter [ !it.finalizado ].toList
	}
}
