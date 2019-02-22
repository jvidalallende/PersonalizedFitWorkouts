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
como componentes principales.

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

#### Persistent Volume

El PV utiliza la ruta `/mnt/sda1/pfw_pv`. Minikube cuenta con almacenamiento disponible
en `/mnt/sda1`, por lo que basta con crear una carpeta vacía en dicha ruta.

### PDF app

### PFW app

#### Kubernetización

Es necesario pasar todas las variables de entorno, o la app no funciona correctamente.
Las variables de entorno de construcción no sirven para nada... ¿habría que eliminarlas?

De momento probado con una única réplica. ¿cómo gestionar Hazelcast? ¿Un nuevo servicio?

#### Hazelcast

La implementación existente de la aplicación hace uso de *Hazelcast* para tener una
caché distribuida de sesiones. Sin embargo, tiene escrita la IP exacta del nodo
maestro, lo cual no es válido en un despliegue en Kubernetes.

Para utilizar Hazelcast en Kubernetes, se ha desplegado un nuevo servicio que permite
comunicarse a las réplicas a través del puerto 5701, y se ha actualizado el pom.xml
para utilizar *hazelcast-kubernetes* junto con una versión reciente de Hazelcast.

Haciendo uso de la API de Kubernetes (para lo cual hay que dar permisos mediante
el fichero de autorización `rbac.yaml`), es posible hacer que las instancias de
la aplicación se autodescubran. Para mejorar además la configuración, se ha especificado
que únicamente las instancias pertenecientes al servicio `hazelcast` sean las que
se interroguen para unirse al cluster de replicación de sesiones.

## Ingress

El primer paso es habilitar el addon para ingress, que por defecto viene deshabilitado.

  $ minikube addons enable ingress

Una vez hecho, cambiamos el servicio del front-end para que sea `ClusterIP`, y definimos
el ingress para que exponga el puerto 8080, y redireccione todas las peticiones al
dominio definido, `pfw.example.com`, al servicio interno `pfw-front`, también en el
puerto 8080.

Por último, para poder probar correctamente conviene cambiar el fichero `/etc/hosts`
para que redireccione a la IP del cluster de minikube:

  $ echo "$(minikube ip) myminikube.info cheeses.all" | sudo tee -a /etc/hosts

## TODO

* Use Helm for deployment
* Change names and use consistent naming
* Add labels for applications
* Improve documentation, including diagrams

# Referencias

* [Installing and using MariaDB via Docker](https://mariadb.com/kb/en/library/installing-and-using-mariadb-via-docker/)
* [How to use embedded Hazelcast in Kubernetes](https://blog.hazelcast.com/how-to-use-embedded-hazelcast-on-kubernetes/)
* [Setting up Ingress on Minikube](https://medium.com/@Oskarr3/setting-up-ingress-on-minikube-6ae825e98f82)
