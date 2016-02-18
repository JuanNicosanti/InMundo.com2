package repos

import org.uqbar.commons.model.CollectionBasedHome
import domain.Tripulante
import org.apache.commons.collections15.Predicate

class RepoTripulantes extends CollectionBasedHome<Tripulante> {

	static RepoTripulantes repoTripulantes

	def static RepoTripulantes getInstance() {
		if (RepoTripulantes.repoTripulantes == null) {
			RepoTripulantes.repoTripulantes = new RepoTripulantes
		}
		RepoTripulantes.repoTripulantes
	}

	override protected Predicate<Tripulante> getCriterio(Tripulante example) {
		new Predicate<Tripulante> {

			override evaluate(Tripulante tripulante) {
				example.nombre.contains(tripulante.nombre)
			}

		}
	}

	override createExample() {
		new Tripulante
	}

	override getEntityType() {
		typeof(Tripulante)
	}

	new() {
		this.create(new Tripulante("Raul", "Pena", "piloto"))
		this.create(new Tripulante("Sergio", "Fernandez","piloto"))
		this.create(new Tripulante("Fernando", "Alvarez", "copiloto"))
		this.create(new Tripulante("Julian", "Mercado", "copiloto"))
		this.create(new Tripulante("Florencia", "Suarez", "azafata"))
		this.create(new Tripulante("Maria", "Mella", "azafata"))
		this.create(new Tripulante("Micaela", "Fazio", "azafata"))
		
	}
}
