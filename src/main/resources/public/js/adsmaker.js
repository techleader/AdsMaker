var app = angular.module('AdsMaker',[]);

app.controller('home', function($scope) {
     $scope.greeting = "Jawahar greeting here";


});

app.controller('AdsOptionsController', ['$scope','$http',function($scope, $http) {
    this.headLines = "Invoking request";
    this.subheadLines = "";
    this.buttons = "";
    $http.get("http://localhost:8080//adelement/ads/listHeadlines")
        .success(function (response) {
            $scope.headLines = response;
        });
    $http.get("http://localhost:8080//adelement/ads/listSubHeadlines")
        .success(function (response) {
            $scope.subheadLines = response;
        });
    $http.get("http://localhost:8080//adelement/ads/listButtons")
        .success(function (response) {
            $scope.buttons = response;
        });
}]);


