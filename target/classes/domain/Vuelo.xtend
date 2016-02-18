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
	Boolean finalizado

	def agregarTripulante(Tripulante tripulante) {

		tripulantes.add(tripulante)
	}

	def eliminarTripulante(String nombre) {
		var tripulanteABorrar = tripulantes.findFirst[it.nombre==nombre]
		tripulantes.remove(tripulanteABorrar)
	}

	new(String numeroDeVuelo, Set<Tripulante> tripulacion, String origenNuevo, String destinoNuevo, String fechaNueva, Boolean finalizadoNuevo) {

		numero = numeroDeVuelo
		tripulantes = tripulacion
		origen = origenNuevo
		destino = destinoNuevo
		fecha = fechaNueva
		finalizado = finalizadoNuevo
	}

	new() {
		numero = ""
		tripulantes = newHashSet()
	}
}
