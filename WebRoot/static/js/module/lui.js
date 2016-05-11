angular.module("lui",["ui.bootstrap"])

.controller("listCtl",["$routeParams","$scope","$http",function($routeParams,$scope,$http){

	$scope.quickSearch=function(e){
		if(e.keyCode==13){
			$scope.search();
		}
	}
	$http({
		url:'getList.do',
		params:{
			key:$scope.keyWord,
			num:1,
			size:10,
		}
	}).success(function(data){
		var _data = JSON.parse(data);
		$scope.currentPage=_data.num;
		$scope.pageSize=_data.size;
		$scope.total = _data.total;
		$scope.list = JSON.parse(_data.list);
	});

	$scope.maxSize = 5;
  	$scope.bigTotalItems = 175;
  	$scope.bigCurrentPage = 1;
  	$scope.total=1000;
  	$scope.currentPage=1;
  	$scope.pageSize=10;

  	$scope.pageChanged = function(){
  		$http({
		url:'getList.do',
		params:{
			key:$scope.keyWord,
			num:$scope.currentPage,
			size:$scope.pageSize
		}
	}).success(function(data){
		console.log($scope.currentPage,$scope.pageSize);
		var _data = JSON.parse(data);
		$scope.currentPage=_data.num;
		$scope.pageSize=_data.size;
		$scope.total = _data.total;
		$scope.list = JSON.parse(_data.list);
	});
  	}
  	$scope.search=function(){
  		$http({
		url:'getList.do',
		params:{
			key:$scope.keyWord,
			num:1,
			size:10
		}
	}).success(function(data){
		var _data = JSON.parse(data);
		$scope.currentPage=_data.num;
		$scope.pageSize=_data.size;
		$scope.total = _data.total;
		$scope.list = JSON.parse(_data.list);
	});
  	}
}])

.controller("detailCtl",["$routeParams","$scope","$sce","$http",function($routeParams,$scope,$sce,$http){
	$http({
		url:'getOne.do',
		params:{
			id:$routeParams.uid
		}
	}).success(function(data){
		var _data = JSON.parse(data);
		$scope.title=_data.bugtitle;
		$scope.content = $sce.trustAsHtml(_data.content.replace(/\[(img.*?)\/\]/g,"<$1/>"));
		$scope.desciption = _data.description;
		$scope.harmlevel = _data.harmlevel;
		$scope.id = _data.id;
		$scope.timeinfo = _data.timeinfo;
		$scope.whitehat_rank = _data.whitehat_rank;		
	})
}])