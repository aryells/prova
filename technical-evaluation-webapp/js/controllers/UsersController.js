angular.module('app')
    .controller('UsersController', function ($scope, ngDialog, $http) {

        $scope.users = [];
        
        var loadUsers = function() {
            $http.get('http://localhost:8080/users').then(function (res) {
                $scope.users = res.data;
            });
        }();

        $scope.creditCheck = function (cpf) {
            $http.get('http://localhost:8081/credit/' + cpf).then(function (res) {
                $scope.cd = res.data;
                ngDialog.open({
                    height: '150px',
                    className: 'ngdialog-theme-default',
                    controller: 'CreditController',
                    template: 'partials/credit.html',
                    resolve: {
                        credit: function () {
                            return $scope.cd;
                        }
                    }
                });
            });
        };
        
    });