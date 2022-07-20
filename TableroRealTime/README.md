TALLER TABLERO INTERACTIVO TIEMPO REAL. SPRING.IO, WEBSOCKETS, REACTJS, P5, HEROKU : BUENAS PRÁCTICAS DE DISEÑO
Seguir el taller con sus instrucciones y entregar el link en github. En el readme agregar el link al proyecto en Heroku.

AYUDA: Al subirlo a Heroku recuerde que Heroku requiere una conexión segura para el web socket, por lo tanto debería utilizar "wss" en el protoclo, es decir una dirección de este estilo:

'wss://' + (host) + '/bbService'

## Autor

Natalia Orjuela
Estudiante de ingeniería de sistemas

## Pre-Requisitos

* Maven
* Git
* Java

## Compilar Proyecto
~~~
mvn package
~~~

## Ejecutar Proyecto

![img.png](img.png)

## Ejecutar pruebas

~~~
mvn test
~~~

## Documentación

~~~
mvn javadoc:javadoc
~~~
acceso a la carpeta [JAVADOC](https://github.com/Nataorjuela/LABS-ARSW/tree/master/Concurrent%20Server/apidocs)


## Licencia
Este proyecto está bajo la Licencia Pública General GNU - consulte el archivo de [LICENSE.txt](http://www.gnu.org/licenses/gpl-3.0.html) para obtener más detalles
