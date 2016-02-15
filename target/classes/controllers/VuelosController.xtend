package controllers

import org.uqbar.xtrest.api.annotation.Controller
import org.uqbar.xtrest.json.JSONUtils
import org.uqbar.xtrest.api.XTRest
import org.uqbar.xtrest.api.annotation.Get
import org.uqbar.xtrest.api.Result
import repos.RepoVuelos

@Controller
class VuelosController {

	extension JSONUtils = new JSONUtils

	def static void main(String[] args) {
		XTRest.start(VuelosController, 9876)
	}
	
	@Get("/vuelos")
	def Result vuelos(){
		val vuelos = RepoVuelos.instance
	}
	}
