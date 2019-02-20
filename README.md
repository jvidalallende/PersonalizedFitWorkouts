# PersonalizedFitWorkouts en Kubernetes

Esta práctica forma parte de la asignatura _Computación en la Nube_
del curso _Experto en Sistemas Software Distribuidos_, en el curso 2018-2019.

# Autor

Juan Vidal Allende

# Objetivos

El objetivo principal de esta práctica consiste en _kubernetizar_ una aplicación
ya desarrollada, que además tenga cierta complejidad. Para ello, se ha tomado
como punto de partida el proyecto
[Personalized Fit Workouts](https://github.com/sculebras1/PersonalizedFitWorkouts),
que consta de una aplicación web principal desarrollada con
[Spring Boot](https://spring.io/projects/spring-boot), un servicio web auxiliar
que también usa _Spring Boot_, y una base de datos [MySQL](https://www.mysql.com/)
como componentes principales. Para consultar los detalles de la aplicación base,
se ha movido la documentación original a la carpeta
[old_doc](https://github.com/jvidalallende/PersonalizedFitWorkouts/tree/master/old_doc).

# Desarrollo de la migración

## _Dockerización_ de los componentes

El primer paso para que la aplicación se pueda desplegar en [Kubernetes](https://kubernetes.io/)
consiste en desplegar cada uno de sus servicios en contenedores.

### Base de datos
En primer lugar, para la base de datos se ha elegido el contenedor oficial de
[MariaDB](https://hub.docker.com/_/mariadb), en su versión 10.0.

En la base de datos es necesario crear una base de datos y un usuario (con su
respectiva contraseña) que después serán inyectados a la aplicación principal
como propiedades. Para hacer esto, al lanzar el contenedor de la base de datos
basta con montar un volumen con los scripts SQL de inicialización en la ruta
`/docker-entrypoint-initdb.d`, y estos se ejecutarán al arrancar el contenedor.

#### Kubernetización

La base de datos se arranca en su propio POD, con un contenedor en el que se montan
dos volúmenes: uno para el PV, y otro para el INITDB. Puesto que el volumen de INITDB
utiliza un fichero que está en el repositorio (y tiene que hacerse accesible desde
minikube), lo más sencillo es clonar el repositorio en el directorio HOME de minikube
(`/home/docker`). El spec está preparado para usar esa ruta como base.

Para exponer la BBDD al resto del cluster se utiliza un servicio que expone el puerto
3306, el que usa MariaDB por defecto.

Para verificar la conexión, puede utilizarse un contenedor de mariaDB, usando los comandos:

  $ kubectl run -it --rm --restart=Never mariadb-exec --image=mariadb:10.0 bash

### PDF app

### PFW app

#### Kubernetización

Es necesario pasar todas las variables de entorno, o la app no funciona correctamente.
Las variables de entorno de construcción no sirven para nada... ¿habría que eliminarlas?

De momento probado con una única réplica. ¿cómo gestionar Hazelcast? ¿Un nuevo servicio?

# Referencias

* [Installing and using MariaDB via Docker](https://mariadb.com/kb/en/library/installing-and-using-mariadb-via-docker/)
