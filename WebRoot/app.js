angular.module("wooyun",["ngRoute","lui","chieffancypants.loadingBar","ngAnimate"]).config(["$routeProvider","$locationProvider","$httpProvider",function($routeProvider,$locationProvider,$httpProvider){
	$routeProvider.when("/list",{templateUrl:"template/list.html",controller:"listCtl"});
	$routeProvider.when("/detail/:uid",{templateUrl:"template/detail.html",controller:"detailCtl"});
	$routeProvider.otherwise({redirectTo:"/list"});
}]).config(function(cfpLoadingBarProvider) {
    cfpLoadingBarProvider.includeSpinner = false;
  })