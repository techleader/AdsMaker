var app = angular.module('AdsMaker',[]);

app.controller('home', function($scope) {
     $scope.greeting = "Jawahar greeting here";


});

app.controller('AdsOptionsController', ['$scope','$http',function($scope, $http) {
    this.headLines = "Invoking request";
    $http.get("http://localhost:8080//adelement/ads/listHeadlines")
        .success(function (response) {
            $scope.headLines = response;
        });
}]);


