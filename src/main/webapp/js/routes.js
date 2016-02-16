'use strict';

app.config(function ($stateProvider, $urlRouterProvider) {

  $urlRouterProvider.otherwise("/vuelos");

  $stateProvider
    .state('vuelos', {
      url: '/vuelos',
      templateUrl: 'templates/vuelos.html',
      controller: 'VuelosController as vuelosCtrl',
      data: {},
      resolve: {}
    })
});
