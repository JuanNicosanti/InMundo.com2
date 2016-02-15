'use strict';

app.controller('VuelosController', function (vuelosService, $timeout) {

  var self = this;

  self.errors = [];
  
  function transformarAVuelo(jsonVuelo){
	  return Vuelo.asVuelo(jsonVuelo);
  }
  
  this.getVuelos = function () {
	    vuelosService.findAll(function (response) {
	      self.vuelos = _.map(response.data, transformarAVuelo);
	    }, notificarError);
	  }
  
  function notificarError(mensaje) {
	    self.errors.push(mensaje);
	    self.getVuelos();
	    $timeout(function () {
	      while (self.errors.length > 0)
	        self.errors.pop();
	    }, 3000);
	  };

	  self.getVuelos();
});
  