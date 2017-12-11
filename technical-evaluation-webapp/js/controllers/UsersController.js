angular.module('app')
    .controller('UsersController', function ($scope, ngDialog, $http) {

        $scope.users = [{
            "id": 1,
            "name": "Lucas",
            "cpf": "64793808190",
            "yearsOld": 28,
            "gender": "M",
            "status": "solteiro",
            "state": "SC",
            "dependent": 0,
            "income": 2500.00
        }, {
            "id": 2,
            "name": "Ana",
            "cpf": "75229844400",
            "yearsOld": 17,
            "gender": "F",
            "status": "solteiro",
            "state": "SP",
            "dependent": 0,
            "income": 1000.00
        }, {
            "id": 3,
            "name": "Pedro",
            "cpf": "62672408785",
            "yearsOld": 68,
            "gender": "M",
            "status": "casado",
            "state": "SC",
            "dependent": 3,
            "income": 8000.00
        }, {
            "id": 4,
            "name": "Paula",
            "cpf": "92019226634",
            "yearsOld": 61,
            "gender": "F",
            "status": "casado",
            "state": "RJ",
            "dependent": 3,
            "income": 5000.00
        }, {
            "id": 5,
            "name": "João",
            "cpf": "68913646390",
            "yearsOld": 56,
            "gender": "M",
            "status": "divorciado",
            "state": "RJ",
            "dependent": 2,
            "income": 2000.00
        }, {
            "id": 6,
            "name": "Maria",
            "cpf": "16898710168",
            "yearsOld": 45,
            "gender": "F",
            "status": "divorciado",
            "state": "SP",
            "dependent": 1,
            "income": 2000.00
        }, {
            "id": 7,
            "name": "José",
            "cpf": "04036455907",
            "yearsOld": 30,
            "gender": "M",
            "status": "casado",
            "state": "MA",
            "dependent": 2,
            "income": 8000.00
        }, {
            "id": 8,
            "name": "Dinae",
            "cpf": "73826137124",
            "yearsOld": 33,
            "gender": "F",
            "status": "casado",
            "state": "SP",
            "dependent": 1,
            "income": 10000.00
        }, {
            "id": 9,
            "name": "Marcos",
            "cpf": "16883200835",
            "yearsOld": 19,
            "gender": "M",
            "status": "solteiro",
            "state": "SC",
            "dependent": 1,
            "income": 400.00
        }, {
            "id": 10,
            "name": "Suzan",
            "cpf": "12258054222",
            "yearsOld": 63,
            "gender": "F",
            "status": "viuva",
            "state": "MA",
            "dependent": 3,
            "income": 1500.00
        }, {
            "id": 11,
            "name": "Luci",
            "cpf": "97171164071",
            "yearsOld": 28,
            "gender": "F",
            "status": "solteiro",
            "state": "SC",
            "dependent": 2,
            "income": 2500.00
        }, {
            "id": 12,
            "name": "Roberto",
            "cpf": "68551266420",
            "yearsOld": 16,
            "gender": "M",
            "status": "solteiro",
            "state": "SP",
            "dependent": 0,
            "income": 500.00
        }, {
            "id": 13,
            "name": "Bruno",
            "cpf": "44641283605",
            "yearsOld": 30,
            "gender": "M",
            "status": "casado",
            "state": "MA",
            "dependent": 5,
            "income": 8000.00
        }, {
            "id": 14,
            "name": "Ariel",
            "cpf": "80858822059",
            "yearsOld": 33,
            "gender": "F",
            "status": "viuva",
            "state": "SP",
            "dependent": 0,
            "income": 10000.00
        }];

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