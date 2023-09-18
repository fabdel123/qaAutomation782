Feature: Automatizacion de Api Rest
  Yo como aprendiz
  Necesito automatizar la ejecucion de una api
  Para aprender a interactuar con los servicios

  Scenario Outline: Modificar un usuario con Metodo Patch
    Given "Fabian" Estable la base url "https://gorest.co.in/" del Api
    When Se Ingresa la informacion a modificar del usuario en el endpoint "public-api/users/4275"
    # Los nombres a la derecha, corresponden a la tabla de EXAMPLES
    # y a la izquierda sirve como la llave
      | name   | <name>   |
      | status | <status> |
      | id     | <id>     |
    Then valida que la respuesta tenga el nombre "<name>" y el codigo de status sea 200

    Examples:
      | id   | name                     | status   |
      | 4275 | Fabian Andres De La Rosa | Inactive |