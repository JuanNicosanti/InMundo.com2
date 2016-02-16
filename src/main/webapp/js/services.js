app.service('vuelosService', function ($http) {

  this.findAll = function (callback) {
    $http.get('/vuelos').then(callback);
  }
  
});