'use strict';

app.controller('VuelosController', function (vuelosService) {

  var self = this;

  self.errors = [];
  

  
  this.getVuelos = function () {
	    vuelosService.findAll(function (data) {
	      self.vuelos = data
	  });
  }
  
  function notificarError(mensaje) {
	    self.errors.push(mensaje);
	    self.getVuelos();
	    $timeout(function () {
	      while (self.errors.length > 0)
	        self.errors.pop();
	    }, 3000);
	  };
	  
	  
	function transformarAVuelo(jsonVuelo){
		  return Vuelo.asVuelo(jsonVuelo);
	  }
	  
	  self.getVuelos();
});
  