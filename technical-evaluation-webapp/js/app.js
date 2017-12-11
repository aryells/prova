angular.module('app', ['ngAnimate', 'ngRoute', 'ngResource', 'ngDialog'])
    .config(function ($routeProvider) {

        $routeProvider.when('/users', {
            templateUrl: 'partials/principal.html',
            controller: 'UsersController'
        });

        $routeProvider.when('/users/new', {
            templateUrl: 'partials/user.html',
            controller: 'UserController'
        });

        $routeProvider.when('/users/edit/:userId', {
            templateUrl: 'partials/user.html',
            controller: 'UserController'
        });

        $routeProvider.otherwise({ redirectTo: '/users' });

    });