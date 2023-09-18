Feature: Automatizacion de Api Rest
  Yo como aprendiz
  Necesito automatizar la ejecucion de una api
  Para aprender a interactuar con los servicios

  Scenario Outline: Crear un usuario con el metodo Get
    Given "Fabian" Estable la base url "https://gorest.co.in/" del Api
    When Se ingresa la informacion del usuario en el endpoint "public-api/users/4275"
    # Los nombres a la derecha, corresponden a la tabla de EXAMPLES
    # y a la izquierda sirve como la llave
      | name   | <name>   |
      | status | <status> |
      | id     | <id>     |
    Then Valida que la respuesta tenga el código de status 200


    Examples:
      |id |name | email | gender | status