Feature: Salvar um novo cliente
  Scenario: Executa metodo POST /users para salvar o usuario
 	Given o dados do novo usuario:
 		| name		| cpf			| yearsOld	| gender| status	| state	| dependent	| income	|
 		| Eduardo	| 98783940855	| 28		| MALE	| UNMARRIED	| SC	| 0			| 2500		|
    When o cliente executa "/users" com os dados fornecidos
    Then o servidor retorna status code 201 Created
  