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
- velascogculebras.personalizedfitworkouts.Entities.Rutina: velascogculebras.personalizedfitworkouts.Entities.Rutina de entrenamiento que se clasifica en; rutinas generales y rutinas específicas para un usuario.
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
##Fase 2
En esta fase explicamos cómo va a funcionar nuestra aplicación. En el diagrama de navegación podemos observar cómo movernos en las diferentes pantallas de la aplicacaión.

##Diagrama navegación

A continuación en el diagrama UML podemos ver las diferentes entidades con sus atributos y las relaciones entre ellas.

##Diagrama E/R

##Diagrama UML

##Páginas principales

#Indice

Página principal o índice desde el cual se accede a los diferenntes servicios de entrenedors y rutinas así como al login.

![índice](https://github.com/sculebras1/PersonalizedFitWorkouts/blob/master/screenshot/images/index.PNG?raw=true)

# Entrenadores

![entrenadores](https://github.com/sculebras1/PersonalizedFitWorkouts/blob/master/screenshot/images/entrenadores.PNG?raw=true)

# Rutinas

![rutinas](https://github.com/sculebras1/PersonalizedFitWorkouts/blob/master/screenshot/images/rutinas.PNG?raw=true)

# Ver entrenador

![entrenador_ver](https://github.com/sculebras1/PersonalizedFitWorkouts/blob/master/screenshot/images/entrenador_ver.PNG?raw=true)

# Ver rutina

![rutina_ver](https://github.com/sculebras1/PersonalizedFitWorkouts/blob/master/screenshot/images/rutina_ver.PNG?raw=true)

# Login

![login](https://github.com/sculebras1/PersonalizedFitWorkouts/blob/master/screenshot/images/login.PNG?raw=true)

# Registro

![registro](https://github.com/sculebras1/PersonalizedFitWorkouts/blob/master/screenshot/images/registro.PNG?raw=true)

# Perfil del entrenador

![perfil_entrenador](https://github.com/sculebras1/PersonalizedFitWorkouts/blob/master/screenshot/images/perfil_entrenador.PNG?raw=true)

# Perfil del usuario

![perfil_usuario](https://github.com/sculebras1/PersonalizedFitWorkouts/blob/master/screenshot/images/perfil_usuario.PNG?raw=true)
