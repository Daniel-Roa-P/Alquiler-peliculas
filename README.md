# Alquiler Peliculas - Java

En el actual repositorio se encuentra un programa elaborado en java en el cual se muestra una pantalla en la que un usuario puede elegir las distintas películas que una tienda tiene para ofrecer con los respectivos atributos de cada película ( imagen, descripción, precio, disponibilidad ), el usuario puede elegir la película que desea comprar según la categoría que este prefiera, ya seleccionadas las películas que el usuario desea llevar pasa a una pantalla en donde puede se muestran las películas elegidas previamente y este debe ingresar o crear un usuario con el que poder alquilar lo que desea llevar de modo que se registrada la deuda en su cuenta, también es posible hacer un seguimiento de las diferentes transacciones realizadas en la aplicación como el estado de las películas y clientes.

<p align="center">
  <img width="460" height="500" src="https://raw.githubusercontent.com/DanielAlejandroRoaPalacios/Alquiler-peliculas/main/imagenes/1.PNG">
  <img width="300" height="500" src="https://raw.githubusercontent.com/DanielAlejandroRoaPalacios/Alquiler-peliculas/main/imagenes/2.PNG">
  <img width="460" height="500" src="https://raw.githubusercontent.com/DanielAlejandroRoaPalacios/Alquiler-peliculas/main/imagenes/3.PNG">
</p>

Para la realización de este programa se empleo como motor de base de datos MySQL por lo que es necesario incluir dentro de las librerías del proyecto el archivo [mysql-connector-java-5.1.47.jar](https://github.com/DanielAlejandroRoaPalacios/Alquiler-peliculas/blob/main/mysql-connector-java-5.1.47.jar) el cual se puede encontrar en la misma carpeta en la que está ubicado este mismo README , también se recomienda correr este programa en el IDE Netbeans 8.2 y para poder acceder a los datos ubicados en la base de datos es necesario cambiar el valor del password utilizado en el archivo DBconexion.java al Password correspondiente de la maquina donde este se ejecute.


<p align="center">
  <img width="350" height="150" src="https://raw.githubusercontent.com/DanielAlejandroRoaPalacios/Alquiler-peliculas/main/imagenes/4.PNG">
</p>

Para poder tener la información a la mano como son los datos del cliente, peliculas y transacciones es necesario correr el script [MySQL_script.sql](https://github.com/DanielAlejandroRoaPalacios/Alquiler-peliculas/blob/main/MySQL%20script.sql) que se ubicado este mismo README pues este creará la base de datos con sus respectivas tablas y datos consignados en estas (Preferiblemente en MySQL Workbench 8.0 CE), tambien al momento de realizar una compra estos son los usuarios predeterminados con los que cuenta la base de datos (El nombre es el PRYMARYKEY)

<p align="center">
  <img width="450" height="200" src="https://raw.githubusercontent.com/DanielAlejandroRoaPalacios/Alquiler-peliculas/main/imagenes/5.PNG">
</p>

Respecto a las dificultades que se presentaron al momento de realizar el proyecto hubo una en particular que pudo arruinar la experiencia de usuario y esta se presentó al momento de desplegar las fichas de películas pues la pantalla se quedaba congelada mientra se cargaban las imagenes en la aplicación, está duraba así durante unos segundos y mientras se espera puede dar la impresión de que se rompió el programa mientras que en realidad este está cargando, así que para dar solución a esto se hizo uso de un hilo en el cual se iba a desplegar las fichas de las películas una por una haciendolo lucir mucho más natural. 
