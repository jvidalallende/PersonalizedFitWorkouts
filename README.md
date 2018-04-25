# Personalized Fit Workouts

(https://www.youtube.com/watch?v=PZ2Y_kT7U5k&feature=youtu.be)


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
 
 
  
Seguidamente procedemos al despliegue en una VM(Máquina Virtual ubuntu server) y los archivos .jar de nuestra aplicación, el despliegue de la aplicación se desarrolla de la siguiente forma:
    
1. Transferencia de archivos .jar a la VM:
    ```
    $ scp archivo_jar usuario@servidor:ruta_servidor_donde_colocar_archivo
    ```
2. Conexión SSH a la VM:
     ```
     $ ssh usuario@ip
    ```
3. Instalación de mySQL en la VM.
4. Instalación de java8 en la VM.
5. Inicio del servicio mySQL :
    ```
    $ service mysql start
    ```
6. Crear un nuevo schema en la base de datos ("test").
    1. A través del workbench configuramos una nueva conexión, añadimos una nueva conexión y cambiamos el método de
        TCP/IP a TCP/IP over ssh
    2. Validar la conexión y aceptar.
    3. Conexión a la base de datos  y creación de un nuevo schema (test).
7. Ejecución de los -jar, primero PersonalizedFitWorkouts y después el servicio interno PDFcreator.
    ```
    $ java -jar personalizedfitworkouts-0.0.1-SNAPSHOT.jar
    $ java -jar pdfcreatormodule-0.0.1-SNAPSHOT.jar
    ```
   
## Fase 4

La comunicación con el servicio interno se realiza a través de API Rest. Únicamente tenemos un endpoint ubicado en la URL "/getPdf" que atiende peticiones de tipo GET.
Ademas recibe un parametro "rutinaId" el cual indica el id de la rutina que queremos transformar a formato PDF.

En este nuevo diagrama hemos añadido las clases de configuración.

![diag_clas2](https://github.com/sculebras1/PersonalizedFitWorkouts/blob/master/screenshot/images/diagrama%20Clases2.jpg?raw=true)

Teniendo en cuenta que aunque en el diagrama podemos observar los servidores conmo instancias diferentes, ambos acceden a las instancias 
consecuentes por igual.

![diag_arqu](https://github.com/sculebras1/PersonalizedFitWorkouts/blob/master/screenshot/images/Arquitectura.jpg?raw=true)


**Despliegue:**

Para el despliegue es necesario contar en el equipo con Vagrant, una vez instalado:

 Lo primero que debemos hacer es crear un directorio contenedor de las carpetas en las 
 cuales van a estar cada MV.
  
 Las carpetas que debemos crear son las siguientes: **Proxy1**, **Proxy2**, **InternalService1**, **InternalService2**,
 **Web1**, **Web2**, **DataBaseMaster**, **DataBaseSlave**.
 
 Divididas en los siguientes roles:
 
  - **Proxy**: Proxy1, Proxy2.
  - **Servicio Interno**: InternalService1, InternalService2.
  - **Servidores**: Web1, Web2, InternalService1, InternalService2.
  - **Bases de Datos**: DataBaseMaster, DataBaseSlave.
 
 Una vez hemos creado este directorio, creamos las carpetas (una por MV), y en cada una de ellas ejecutamos 
 el siguiente comnado para la creación de dichas MV:
 
    $ vagrant init [name [url]]
 
 En nuestro caso:
 
    $ vagrant init ubuntu/xenial64
 
 Ahora debemos configurar cada MV:
 
 **Proxys**:
 
 Empecemos por el Proxy1; el cual va ser el que va a balancear el trabajo entre los dos servidores 
 web1 y web2 a la vez que la "puerta de entrada".
 
 Primero debemos arrancar la MV con el comando :
 
 *(situados en su carpeta)*
 
    $ vagrant up
    
 Y conectarnos a ella:
    
    $ vagrant ssh
 
 **(Estos dos pasos son iguales en el resto MV)**
 
 Una vez estamos conectados a la MV, instalamos haproxy:
 
    $ sudo apt install haproxy 
    
 A continuación editamos el archivo de configuración (*.cfg) añadiendo el siguiente código al final:
 
    frontend localhost
            bind *:80
            bind *:443 ssl crt /etc/ssl/xip.io/xip.io.pem
            redirect scheme https if !{ ssl_fc }
            mode http
            default_backend nodes
    
    
    backend nodes
            mode http
            balance roundrobin
            option forwardfor
            cookie SRV_ID insert
            server web1 192.168.33.11:8080 check cookie 1
            server web2 192.168.33.12:8080 check cookie 2
    
 Despues de reiniciar el servicio, haproxy estaría en funcionamiento:
 
    $ sudo service haproxy restart
    
 Para el segundo proxy procederíamos de la misma forma; conectándonos e instalando haproxy y editando 
 su archivo de configuración de la siguiente manera, añadiendo el siguiente código al final:
 
    frontend localnodes
        bind *:8080
        mode http
        default_backend nodes
    
    
    backend nodes
        mode http
        balance roundrobin
        option forwardfor
        server pdf1 192.168.33.14:8080 check
        server pdf2 192.168.33.15:8080 check
    
 **Servicio Interno**:
 
  En el servicio interno vamos a configurar los servidores encargados de nuestro servicio de creador de 
  PDFs (InternalService1 y 2), en ambos se actúa de la misma manera:
 
  *Habiendo arrancado y estando conectados a la MV:*
 
 Tanto en estos servidores como en los encargados de la aplicacición (Web1 y Web2) tendremos que instalar la última
 versión de java.
 
    $ sudo apt install java-jre-default
 
 Por último añadimos a las carpetas contenedoras de las MV el .jar correspondiente al servicio interno,
 de esta manera ya tendríamos preparado el servidor para lanzar el servicio interno mas adelante.
 
 **Servidores**:
 
 Los servidores serán los encargados de ejecutar nuestra aplicación y contaremos con dos : Web1 y Web2.
 
  *Habiendo arrancado y estando conectados a la MV:*
  
 Al igual que en el servicio interno instalamos la última versión de java  en ambos servidores (web1 y web2) y 
 situamos los archivos .jar correspondientes a la aplicación en las carpetas de dichos servidores, dejando
 de esta manera ambos servidores preparados para el posterior lanzamiento de la aplicación. 
 
 **Bases de Datos**:
 
 Los servidores de BBDD serán los encargados de almacenar los datos que nuestra aplicación desee guardar y recuperar y 
 siguen una jerarquía de maestro - esclavo.
 
  *Habiendo arrancado y estando conectados a la MV:*
 
 Empecemos con el maestro (DataBaseMaster):
 En primer llugar debemos instalar MySql en la MV:
 
    sudo apt install mysql-server
    
 Una vez instalado editamos el archivo de configuración.
 
    $ sudo nano /etc/mysql/my.cnf
  
  Cambiando el campo bind_address por la ip de la MV.
  
    [mysqld]
    bind-address            = 192.168.33.16
    server-id               = 1
    log_bin                 = /var/log/mysql/mysql-bin.log
    binlog_do_db            = test
    
 Reiniciamos el servicio
 
    $ sudo service mysql restart
   
 Abrimos MySql Shell:
 
    $mysql -u root -p
    
 Creamos la base de datos:
 
    CREATE DATABASE test;
    EXIT;
    
 Damos privilegios al esclavo
 
    mysql> GRANT REPLICATION SLAVE ON *.* TO 'slave_user'@'%' IDENTIFIED BY 'password';
    
    mysql> FLUSH PRIVILEGES;
    
    mysql> USE test;
    
    mysql> FLUSH TABLES WITH READ LOCK;
    
    mysql> SHOW MASTER STATUS;
    
 Cuando recibamos la salida del siguiente comando que será una tabla, deberemos apuntar
 la columna 'File' y la columna 'Position'
 
    mysql> SHOW MASTER STATUS;
    
 En el bash normal realizamos la exportación de la BBDD.
 
    $ mysqldump -u root -p --opt test > test.sql
    
 Volviendo a MySQL shell:
       
    mysql> UNLOCK TABLES;
    mysql> QUIT;
    
 Configuramos ahora el esclavo (DataBaseSlave):
 
 *Habiendo arrancado y estando conectados a la MV:*
 

  Creamos la base de datos:
  
    mysql> CREATE DATABASE test;
    mysql> EXIT;
    
 Movemos la archivo .sql creado anteriormente del master al slave (A traves de las carpetas compartitdas 
 de vagrant /vagrant) y una vez movido lo importamos a la BBDD:
 
    mysql -u root -p test < /vagrant/test.sql
    
 Editamos la configuración al igual que hicimos con el master:
 
    $ sudo nano /etc/mysql/my.cnf
    
 Y añadimos:
 
    [mysqld] 
    bind-address            = 192.168.33.17
    server-id               = 2
    relay-log               = /var/log/mysql/mysql-relay-bin.log
    log_bin                 = /var/log/mysql/mysql-bin.log
    binlog_do_db            = test
    
 Reiniciamos el servicio 
  
    $ sudo service mysql restart
    
 Dentro de MySQL Shell activamos la replicación
  
    mysql> CHANGE MASTER TO MASTER_HOST='12.34.56.789',MASTER_USER='slave_user', MASTER_PASSWORD='password', MASTER_LOG_FILE='mysql-bin.000001', MASTER_LOG_POS=  107;
    
 Siendo MASTER_LOG_FILE Y MASTER_LOG_POS las dos columnas apuntadas anteriormente.
 Activamos el esclavo
 
    mysql> START SLAVE;
    
  De esta manera tendríamos configurada la replicación maestro-esclavo.
  
 Por último añadimos los usuarios a la BBDD para permitir las conexiones de los servidores a estas par 
 ello ejecutamos las siguientes instrucciones para cada ip de servidor en cada una de las bases de datos.
  
    mysql> create user 'server'@'<ip VM>' identified by 'password';
    mysql> grant all privileges on  test.* on 'server'@'<ip VM>';
    
 Una ejecutadas hacemos un flush de los privilegios.
    
    mysql> flush privileges;
    
 De esta manera tendríamos configurada la BBDD.
 
**Funcionamiento Final**
    
  Contando con el proxy y la bases de datos en funcionamiento, lo único que restaría es ejecutar la aplicación en 
  los servidores y el servicio interno:
  
  (Estando conectados a los servidores)
  
  Primero ejecutamos la aplicación en el servidor web1 y web2:
  
    $java -jar [NombreDeFichero].jar
    
  A continuación ejecutamos el servicio interno en sus correspondientes servers:
  
    $java -jar [NombreFicheroServicioInterno].jar
    
  De esta manera terndrríamos nuestra aplicación en funcionamiento.
    
  
  