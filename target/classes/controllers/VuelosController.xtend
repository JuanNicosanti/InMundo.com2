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
import org.uqbar.xtrest.api.annotation.Put
import org.uqbar.xtrest.api.annotation.Body
import domain.Tripulante
import domain.TripulanteVuelo
import org.uqbar.xtrest.api.annotation.Post

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
	
	@Put("/eliminarTripu")
	def Result eliminarTripu(@Body String body){
		println(body)
		var TripulanteVuelo tripuVuelo=body.fromJson(TripulanteVuelo)
		var vuelo = RepoVuelos.instance.searchById(tripuVuelo.vuelo)
		println(tripuVuelo.vuelo)
		vuelo.eliminarTripulante(tripuVuelo.nombre)
		println(vuelo.tripulantes.size())
		response.contentType = ContentType.APPLICATION_JSON
		ok(vuelo.toJson)
	}
	
	@Post("/nuevoTripu")	
	def Result nuevoTripu(@Body String body){
		var TripulanteVuelo tripuVuelo = body.fromJson(TripulanteVuelo)
		var vuelo = RepoVuelos.instance.searchById(tripuVuelo.vuelo)
		vuelo.agregarTripulante(new Tripulante(tripuVuelo.nombre,tripuVuelo.apellido, tripuVuelo.tipoPuesto))
		response.contentType = ContentType.APPLICATION_JSON
		ok(vuelo.toJson)
	}
	
	@Get("/tripulantes")
	def Result tripulantes() {
		val tripulantes = RepoTripulantes.instance.allInstances
		response.contentType = ContentType.APPLICATION_JSON
		ok(tripulantes.toJson)
	}
}
