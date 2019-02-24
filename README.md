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

# Despliegue

## Preparación del entorno

En primer lugar, deberá empezarse por clonar el repositorio a un directorio de
trabajo en la máquina de desarrollo:

    user@dev:~$ git clone https://github.com/jvidalallende/PersonalizedFitWorkouts.git
    user@dev:~$ cd PersonalizedFitWorkouts

Posteriormente, se arrancará minikube, y se habilitará el plugin para Ingress:

    user@dev:~/PersonalizedFitWorkouts$ minikube start
    user@dev:~/PersonalizedFitWorkouts$ minikube addons enable ingress

Para que hazelcast-minikube funcione correctamente, es necesario otorgarle
algunos permisos, descritos en el fichero `k8s/rbac.yaml` del repositorio.
Pueden aplicarse a Minikube con el siguiente comando:

    user@dev:~/PersonalizedFitWorkouts$ kubectl apply -f k8s/rbac.yaml

## Creación de las imágenes de los contenedores

Para simplificar la creación de las imágenes dentro del propio cluster de
Minikube, se proporciona un script: `build-pfw-images.bash`. Puede lanzarse desde
la carpeta raiz del proyecto con el siguiente comando:

    user@dev:~/PersonalizedFitWorkouts$ ./scripts/build-pfw-images.bash

## Preparación de la base de datos

La base de datos espera que existan dos carpetas dentro de la máquina virtual de
Minikube, una con un fichero SQL para la inicialización de la misma, y otra donde
montar el volumen persistente. En el repositorio existe un fichero de inicialización
de la BBDD ya preconfigurado con los mismos valores del fichero `values.yaml`.
Si se opta por modificar estos valores, tenga en cuenta que la inicialización de
la BBDD y la configuración del Chart deben estar sincronizadas.

Para crear los directorios adecuados, ejecute los siguientes comandos:

    user@dev:~/PersonalizedFitWorkouts$ minikube ssh "sudo mkdir /mnt/sda1/pfw_pv"
    user@dev:~/PersonalizedFitWorkouts$ minikube ssh "git clone https://github.com/jvidalallende/PersonalizedFitWorkouts.git"

## Configuración de DNS en el host

Puesto que el despliegue usa un nombre de dominio para el Ingress, es necesario
configurar la máquina de desarrollo para redireccione el tráfico de ese nombre de
dominio hacia el cluster de Minikube. Para conocer la IP del cluster, puede utilizarse
este comando:

    user@dev:~/PersonalizedFitWorkouts$ minikube ip
    192.168.99.106

Una vez conocida la IP del cluster, habría que modificar el fichero `/etc/hosts`
de la máquina de desarrollo para que tenga una entrada a esa IP con el nombre de
dominio apropiado (por defecto *juanvidal.pfw.example.com*).

## Configuración de Helm y despliegue

Aunque se asume que la instalación de Helm es correcta, se añaden a continuación
los comandos para realizarla, así como para configurar Tiller en caso de que no
se haya hecho previamente. Se asume que el cliente de Helm está disponible en la
máquina de desarrollo.

    user@dev:~/PersonalizedFitWorkouts$ helm init
    user@dev:~/PersonalizedFitWorkouts$ kubectl -n kube-system patch deployment tiller-deploy -p'{"spec": {"template": {"spec":  {"automountServiceAccountToken":true}}}}'
    user@dev:~/PersonalizedFitWorkouts$ kubectl create clusterrolebinding add-on-cluster-admin --clusterrole=cluster-admin --serviceaccount=kube-system:default

Finalmente, llegó el momento de desplegar la aplicación. Para ello, basta con utilizar un comando de helm:

    user@dev:~/PersonalizedFitWorkouts$ helm install --name juanvidal-pfw helm/pfw/
