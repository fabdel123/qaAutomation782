Feature: Automatizacion de Api Rest
  Yo como aprendiz
  Necesito automatizar la ejecucion de una api
  Para aprender a interactuar con los servicios

  Scenario Outline: Crear un usuario con el metodo Post
    Given Usuario Estable la base url "https://gorest.co.in/" del Api
    When Se ingresa la informacion del usuario en el endpoint "/public/v2/users"
    # Los nombres a la derecha, corresponden a la tabla de EXAMPLES
    # y a la izquierda sirve como la llave

      | name   | <name>   |
      | email  | <email>  |
      | gender | <gender> |
      | status | <status> |

    Then Valida que la respuesta tenga el código de status 200


    Examples:
    | name | email | gender | status |
    |      |       |        |        |