function Vuelo() {
	
}

Vuelo.asVuelo = function (jsonVuelo) {
	  return angular.extend(new Vuelo(), jsonVuelo);
};