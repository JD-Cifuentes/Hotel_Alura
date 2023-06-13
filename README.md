<h1 align = "center">

![Logo conversor alura](Hotel_Alura/src/main/resources/imagenes/aH-150px.png)

</h1>
<h2>Oracle Next Education - Alura Challenge #2</h2>

<p>
<img src="https://img.shields.io/badge/jackson-2.14.2-blue">
<img src="https://img.shields.io/badge/java-11-blue">
<img src="https://img.shields.io/badge/maven-3.8-blue">
<img src="https://img.shields.io/badge/hibernate-5.6.15.Final-blue">
<img src="https://img.shields.io/badge/h2database-2.1.214-blue"> 
<img src="https://img.shields.io/badge/toedter-1.4-blue"> 
<img src="https://img.shields.io/badge/version-1.0-brightgreen">
<img src="https://img.shields.io/badge/license-free-brightgreen">
<img src="https://img.shields.io/badge/status-stable-green">
</p>

<br>

<h3>Introducción</h3>
<p>La app Hotel Alura permite gestionar reservas facíl e intuitivamente, logrando tener un control del flujo de huéspedes en cuanto a las fechas escogidas para el check in y el check out</p>

<h3>Estado del proyecto</h3>
<p>Se encuentra en su versión 1 estable.</p>

<h3>Sobre la funcionalidad de la app</h3>
<p>
  La aplicación inicialmente solicita que se ingrese al apartado login, donde se solicitara un nombre de usuario, el cual es por defecto Pepe, y una contraseña, 123aBc; con lo anterior se logrará ingresar al menú de usuario, en el cual se tienen 3 opciones, registro reserva, registro huéspedes y busqueda. 
</p>
<p>
  Para registrar reservas y huéspedes solo se necesita llenar todos lo campos, teniendo en cuenta que cada uno de estos posee una limitación según su tipo, es decir, para los apartados de documento y telefóno solo se podrán ingresar números, para campos como nombre y apellido, solo se pueden ingresar letras, y para fecha de nacimiento, ingreso y salida, solo se admite el formato por defecto.
</p>
<p>
  Lo anterior con la finalidad de minimizar errores de tipado, sin embargo, si por alguna razón se comete un error al ingresar un dato a pesar de que se encuentre dentro del formato contemplado para el campo, se pueden editar algunos campos de huéspedes y reservas en la opción busqueda, así como también eliminarlos, 
  o simplemente consultarlos; es de aclarar que hay campos que no se pueden modificar por efectos de mitigación de errores en la base de datos, tales son números de documento, id de reservas y fecha de ingreso.
</p>

<p>
  Cada ventada que parte del menú de usuario, Busqueda, y registros, poseen botones que no permiten regresar a dicho menú, así como de cerrar la aplicación. A su vez, una ventana emergente notificará al usuario cuando un registro se complete exitosamente .
</p>


<h3>Tecnologías implementadas</h3>
<ul>
  <li>Java 11</li>
  <li>Maven 3.8</li>
  <li>Jackson 2.14.2</li>
  <li>hibernate-5.6.15.Final</li>
  <li>h2database-2.1.214</li>
  <li>toedter-1.4</li>
</ul>

<h3>Acceso al proyecto</h3>
<p> pendiente actualizar!  </p>


<h3>Créditos</h3>
<p>La interfáz gráfica fue facilitada por los tutores de la plataforma Alura, mil gracias por facilitar esta parte del proceso, ya que por motivos personales y de trabajo no logré implementar dede cero el aplicativo. imensamente agradecido por este gesto de comprensión y ayuda :D </p>

<h3>Autor</h3>
<img src="https://avatars.githubusercontent.com/u/53058604?v=4" width=115>
<sub><a href ="https://github.com/JD-Cifuentes">Juan David Cifuentes</a></sub>
