# Personalized Fit Workouts
## Descripción de la web
La web a implementar trata de acercar al usuario a planes de entrenamiento a través de rutinas accesibles por los usuarios, categorizando estas rutinas en dos tipos públicas y personalizadas para cada usuario:

- Parte publica: Rutinas públicas/generales, accesibles para todos los usuarios registrados o no registrados , publicadas por entrenadores registrados. 

- parte privada: 
    - Usuario: Rutinas privadas o especializadas  las cuales son creadas por entrenadores a petición de un usuario que demande esta rutina comunicándose con él a través de la web. Los usuarios registrados podrán acceder a estas rutinas privadas.
    - Entrenador:  A diferencia del usuario normal, el entrenador tiene la posibilidad de subir rutinas generales y crear rutinas especializadas para los usuarios que se hayan puesto en contacto con él demandando dicha tabla.

## Entidades


- Usuario: Usuario básico que podrá visualizar , valorar , comentar y añadir a sus favoritos las rutinas , además podría contactar con un entrenador para obtener rutinas personalizadas(privada).
- Entrenador: Usuario con capacidad de creación y compartición de rutinas, además puede comunicarse con los usuarios normales.
- Favorito: Rutinas marcadas como favoritas para cada usuario en particular.
- Rutina: velascogculebras.personalizedfitworkouts.Entities.Rutina de entrenamiento que se clasifica en; rutinas generales y rutinas específicas para un usuario.
- Valoración/Comentario: Valoracion/comentario que se podrá poner a las rutinas o a los entrenadores.

## Servicio Interno
El servicio interno realizará dos funciones, en primer lugar será el encargado de enviar mensajes dentro de la aplicación de un usuario a otro , por otro lado también ofrecerá la posibilidad de crear PDFs para la descarga de las rutinas.
## Integrantes
- Sergio Culebras Mezquita
    - Mail:  s.culebras@alumnos.urjc.es
    - GitHub: s.culebras1

- Ivan Velasco Gonzalez
    - Mail: i.velascog@alumnos.urjc.es
    - GitHub: i.velascog1
## Fase 2
En esta fase explicamos cómo va a funcionar nuestra aplicación. En el diagrama de navegación podemos observar cómo movernos en las diferentes pantallas de la aplicacaión.

![d_navegación](https://github.com/sculebras1/PersonalizedFitWorkouts/blob/master/screenshot/images/Diagrama%20navegacion.jpg?raw=true)

El diagrama E/R muestra las relaciones entre las distintas entidades.

![E/R](https://raw.githubusercontent.com/sculebras1/PersonalizedFitWorkouts/master/screenshot/images/ERd.PNG)

A continuación en el diagrama UML podemos ver las diferentes entidades con sus atributos y las relaciones entre ellas.

![UML](https://github.com/sculebras1/PersonalizedFitWorkouts/blob/master/screenshot/images/Modelo%20UML.PNG?raw=true)

# Páginas principales

## Indice

Página principal o índice desde el cual se accede a los diferentes servicios de entrenedors y rutinas así como al login.

![índice](https://github.com/sculebras1/PersonalizedFitWorkouts/blob/master/screenshot/images/index.PNG?raw=true)

## Entrenadores

Visualización de todos los entrenadores que están registrados.

![entrenadores](https://github.com/sculebras1/PersonalizedFitWorkouts/blob/master/screenshot/images/entrenadores.PNG?raw=true)

## Rutinas

Visualización de todas las rutinas disponibles y subidas por los diferentes entrenadores con sus respectivas categorías.

![rutinas](https://github.com/sculebras1/PersonalizedFitWorkouts/blob/master/screenshot/images/rutinas.PNG?raw=true)

## Ver entrenador

Posibilita acceder al perfil público del entrenador deseado.

![entrenador_ver](https://github.com/sculebras1/PersonalizedFitWorkouts/blob/master/screenshot/images/entrenador_ver.PNG?raw=true)

## Ver rutina

Permite acceder a una rutina en concreto.

![rutina_ver](https://github.com/sculebras1/PersonalizedFitWorkouts/blob/master/screenshot/images/rutina_ver.PNG?raw=true)

## Login

Patalla de inicio de sesión tanto para usuarios como para entrenadores.

![login](https://github.com/sculebras1/PersonalizedFitWorkouts/blob/master/screenshot/images/login.PNG?raw=true)

## Registro

Registro con diferenciación de rol dentro de la aplicación según seamos un usuario o entrenador.

![registro](https://github.com/sculebras1/PersonalizedFitWorkouts/blob/master/screenshot/images/registro.PNG?raw=true)

## Perfil del entrenador

Perfil privado del entrenador al que puede acceder mediante el login.

![perfil_entrenador](https://github.com/sculebras1/PersonalizedFitWorkouts/blob/master/screenshot/images/perfil_entrenador.PNG?raw=true)

## Perfil del usuario

Perfil privado del usuario al que puede acceder mediante el login, a diferencia del entrenador solo contiene sus datos más relevantes..

![perfil_usuario](https://github.com/sculebras1/PersonalizedFitWorkouts/blob/master/screenshot/images/perfil_usuario.PNG?raw=true)

## Fase 3

En primer lugar hemos actualizado el diagrama de navegación:

![diagrama_navegación2](https://github.com/sculebras1/PersonalizedFitWorkouts/blob/master/screenshot/images/Diagrama%20navegacion%202.jpg?raw=true)

Hemos implementado seguridad de tal forma que el formulario de login es capaz de permitir el acceso solo a usuarios y entrenadore registrados.
Por otro lado hay restricción de acceso a diferentes páginas dependiendo de si es un usuario o un entrenador quien accede; de esta forma
el entrenador puedee añadir rutinas y un usuario no dispone de dicha opción siquiera, además la página de perfil de los usuarios y de los entrenadores
son diferentes ya que un entrenador no dispone de biografía por lo que no puede acceder a ese campo.

### Servicio interno

Como servicio interno, nuestra aplicación dispone de un conversor PDF, es capaz de convertir las rutinas en forma de tabla a formato PDF.

**Diagramas de Clases y Templates**:

![diag_templ](https://github.com/sculebras1/PersonalizedFitWorkouts/blob/master/screenshot/images/diagrama%20Clases.jpg?raw=true)

Dado que en el diagrama anterior no se mostraba la relación de repositorios y controladores hemos adjuntado otro diagrama:

![diag_temp2](https://github.com/sculebras1/PersonalizedFitWorkouts/blob/master/screenshot/images/Diagrama%20Repository-Controller.jpg?raw=true)

**Instrucciones para el despliegue de la aplicación**:

En primer lugar compilaremos la apliccacion, para ello es necesario maven y jdk8:
 1. Descargar los sources
     ```sh
     $ git clone https://github.com/sculebras1/PersonalizedFitWorkouts.git
      ```
 2. Compilamos los sources
     ```sh
     $ cd PersonalizedFitWorkouts
     $ mvn package
     $ cd pdfcreatormodule
     $ mvn package
     ```
 A partir de este paso ya hemos generado los ficheros JAR de la aplicacion que se enceuntran en target y pdfcreatormodule/target
 
 
  
Seguidamente procedemos al despliegue en una VM(Máquina Virtual ubuntu server) y los archivos .jar de nuestra aplicación, el despliegue de la aplicación se desarrola de la siguiente forma:
    
   1. Transferencia de archivos .jar a la VM:
        ```
         $ scp archivo_jar usuario@servidor:ruta_servidor_donde_colocar_archivo
         ```
   2. Conexión SSH a la VM:
        ```
        ssh usuario@ip
        ```
   3. Instalación de mySQL en la VM.
   4. Instalación de java8 en la VM.
   5. Inicio del servicio mySQL :
        ```
        $ service mysql start
        ```
    6. Crear un nuevo schema en la base de datos ("test").
        6.1 - A través del workbench configuramos una nueva conexión, añadimos una nueva conexión y cambiamos el método de
        TCP/IP a TCP/IP over ssh
        6.2 - Validar la conexión y aceptar.
        6.3 - Conexión a la base de datos  y creación de un nuevo schema (test).
    7. Ejecución de los -jar, primero PersonalizedFitWorkouts y después el servicio interno PDFcreator.
           ```
           java -jar personalizedfitworkouts-0.0.1-SNAPSHOT.jar
           java -jar pdfcreatormodule-0.0.1-SNAPSHOT.jar
           ```