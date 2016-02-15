package domain

import org.uqbar.commons.model.Entity
import org.eclipse.xtend.lib.annotations.Accessors

@Accessors
class Tripulante extends Entity {
	String nombre
	String apellido
	String tipoPuesto

	new(String nombreNuevo) {

		nombre = nombreNuevo
	}

	new() {
		nombre = ""
		apellido = ""
		tipoPuesto = ""
	}
	
	new(String nombreNuevo, String apellidoNuevo, String puestoNuevo){
		nombre = nombreNuevo
		apellido = apellidoNuevo
		tipoPuesto = puestoNuevo
	}
}
