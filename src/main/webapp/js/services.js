app.service('vuelosService', function ($http) {

  this.findAll = function (callback, errorHandler) {
    $http.get('/vuelos').then(callback, errorHandler);
  };
  
});