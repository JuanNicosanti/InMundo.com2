package domain

import java.util.Set
import org.eclipse.xtend.lib.annotations.Accessors
import org.uqbar.commons.model.Entity

@Accessors
class Vuelo extends Entity {
	String numero
	Set<Tripulante> tripulantes
	String origen
	String destino
	String fecha

	def agregarTripulante(Tripulante tripulante) {

		tripulantes.add(tripulante)
	}

	def eliminarTripulante(Tripulante tripulante) {
		tripulantes.remove(tripulante)
	}

	new(String numeroDeVuelo, Set<Tripulante> tripulacion, String origenNuevo, String destinoNuevo, String fechaNueva) {

		numero = numeroDeVuelo
		tripulantes = tripulacion
		origen = origenNuevo
		destino = destinoNuevo
		fecha = fechaNueva
	}

	new() {
		numero = ""
		tripulantes = newHashSet()
	}
}
