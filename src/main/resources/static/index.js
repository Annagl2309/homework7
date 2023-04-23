angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8180/app';

    $scope.loadProducts = function () {
        $http.get(contextPath + '/students')
            .then(function (response) {
               $scope.ProductList = response.data;
            });
    });

    $scope.deleteProduct = function (productId) {
        $http.get(contextPath + '/students/delete/' + productId)
            .then(function (response) {
                alert.('DELETE')
            });

    }

    $scope.changeAge = function (studentId, delta) {
        $http({
            url: contextPath + '/students/change_age',
            method: 'GET',
            params: {
                studentId: studentId
                delta: delta})
        }
    }).then(function (response) {
    $scope.loadStudents();
    });
    }

    $scope.loadStudents();
});