angular.module('app')
    .controller('UserController', function ($scope, $location, $http) {

        $scope.user = {
            gender:  'M',
            status: 'solteiro' 
        };
        $scope.config = {
            status: [
                { name: 'Solteiro', value: 'solteiro' },
                { name: 'Casado', value: 'casado' },
                { name: 'Viúva', value: 'viuva' },
                { name: 'Divorciado', value: 'divorciado' }
            ],
            gender: [
                { name: 'Masculino', value: 'M' },
                { name: 'Feminino', value: 'F' }
            ]
        };

        $scope.submit = function () {
            if($scope.user.id) {
                $http.put('http://localhost:8080/users', $scope.user)
                .then(function(response) {
                    console.log(response.data);
                    $location.path('/users'); 
                }, function(response) {
                    console.log(response.data);
                });
            } else {
                $http.post('http://localhost:8080/users', $scope.user)
                    .then(function(response) {
                        console.log(response.data);
                        $location.path('/users'); 
                    }, function(response) {
                        console.log(response.data);
                    });
                }
        };

    });