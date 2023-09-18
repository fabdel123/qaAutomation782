Feature: Automatizacion de Api Rest
  Yo como aprendiz
  Necesito automatizar la ejecucion de una api
  Para aprender a interactuar con los servicios

  Scenario Outline: Eliminar un usuario con Metodo Delete
    Given "Fabian" Establece la base url "https://gorest.co.in/"
    When El usuario a eliminar en el api "public-api/users/4275"
      | id | <id> |
    Then valido el id "<id>" con estado "<status>"

    Examples:
      | id   | status |
      | 4275 | 204    |