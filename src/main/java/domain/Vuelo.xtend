package domain

import java.util.Set
import org.eclipse.xtend.lib.annotations.Accessors
import org.uqbar.commons.model.Entity

@Accessors
class Vuelo extends Entity {
	String numero
	Set<Tripulante> tripulantes

	def agregarTripulante(Tripulante tripulante) {

		tripulantes.add(tripulante)
	}

	def eliminarTripulante(Tripulante tripulante) {
		tripulantes.remove(tripulante)
	}

	new(String numeroDeVuelo, Set<Tripulante> tripulacion) {

		numero = numeroDeVuelo
		tripulantes = tripulacion
	}

	new() {
		numero = ""
		tripulantes = newHashSet()
	}
}
