package controllers

import domain.Vuelo
import org.uqbar.commons.model.UserException
import org.uqbar.xtrest.api.Result
import org.uqbar.xtrest.api.XTRest
import org.uqbar.xtrest.api.annotation.Controller
import org.uqbar.xtrest.api.annotation.Get
import org.uqbar.xtrest.http.ContentType
import org.uqbar.xtrest.json.JSONUtils
import repos.RepoTripulantes
import repos.RepoVuelos

@Controller
class VuelosController {

	extension JSONUtils = new JSONUtils

	def static void main(String[] args) {
		XTRest.start(VuelosController, 9995)
	}

	@Get("/vuelos")
	def Result vuelos() {
		val vuelos = (RepoVuelos.instance.allInstances)
		response.contentType = ContentType.APPLICATION_JSON
		ok(vuelos.toJson)
	}

	@Get('/vuelos/:id')
	def Result vuelo() {
		response.contentType = "application/json"
		val iId = Integer.valueOf(id)
		try {
			ok(RepoVuelos.instance.searchById(iId).toJson)
		} catch (UserException e) {
			notFound("No existe el vuelo con id " + id + "");
		}
	}

	@Get('/vuelos/:numero')
	def Result buscar() {
		val vueloBuscado = new Vuelo
		vueloBuscado.numero = numero
		ok(RepoVuelos.instance.searchByExample(vueloBuscado).toJson)
	}

	/**
	@Put('/tareas/:id')
	def Result actualizar(@Body String body) {
		try {
			val actualizado = body.fromJson(Vuelo)

			val asignadoA = body.getPropertyValue("asignadoA")
			val asignatario = RepoUsuarios.instance.allInstances.findFirst[it.nombre.equalsIgnoreCase(asignadoA)]
			actualizado.asignarA(asignatario)

			if (Integer.parseInt(id) != actualizado.id) {
				return badRequest('{ "error" : "Id en URL distinto del cuerpo" }')
			}

			RepoTareas.instance.update(actualizado)
			ok('{ "status" : "OK" }');
		} catch (Exception e) {
			badRequest(e.message)
		}
	}
	*/

	@Get("/tripulantes")
	def Result tripulantes() {
		val tripulantes = RepoTripulantes.instance.allInstances
		response.contentType = ContentType.APPLICATION_JSON
		ok(tripulantes.toJson)
	}
}
