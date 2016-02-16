'use strict';

app.config(function($stateProvider, $urlRouterProvider) {

	$urlRouterProvider.otherwise("/vuelos");

	$stateProvider.state('vuelos', {
		url : '/vuelos',
		templateUrl : 'templates/vuelos.html',
		controller : 'VuelosController as vuelosCtrl',
		data : {},
		resolve : {}
	})

	.state('tripulacionVuelo', {
		url : '/vuelos/:id',
		templateUrl : 'templates/tripulacionVuelo.html',
		controller : 'tripulacionVueloController as tripulacionCtrl',
		data : {},
		resolve : {
		 vueloData : ['vueloSeleccionadoService', '$stateParams',
		 function(vueloSeleccionadoService, $stateParams) {
		 return vueloSeleccionadoService.find($stateParams.id);
		 }],
		}
	})
});
