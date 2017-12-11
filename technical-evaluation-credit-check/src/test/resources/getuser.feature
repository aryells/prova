Feature: Buscar dados do cliente
  Scenario: busca atraves do id
 	Given o cliente "Ariel" e id 14
    When ao executar GET "/users/-{id}" com id igual 14
    Then o servidor retorna status code igual a 200
   	And e o retorno contem user name "Ariel"
  Scenario: busca atraves do cpf
 	Given o cliente "Maria" e cpf "16898710168"
    When ao executar GET "/users/{cpf}" com cpf igual "16898710168"
    Then o servidor retorna status code igual a 200
   	And e o retorno contem user name "Maria"