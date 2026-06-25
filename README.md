###Realizando validación, excepciones y relaciones entre clases – Desarrollo Orientado a Objetos I###

-----Autor del proyecto-----

Nombre completo: Jaime Seguel Retamales.

Sección: Desarrollo Orientado a Objetos I, sección 005A.

Carrera: Analista Programador.

Sede: Online.

-----Descripción general del sistema-----

Este proyecto corresponde a la Evaluación Sumativa de la Semana 3 para la asignatura de Desarrollo Orientado a Objetos I. 

Esta aplicación de consola en Java gestiona los registros de la agencia de turismo "Llanquihue Tour" usando herencia para 
clasificar a los usuarios (Clientes, Empleados y Asociados) a partir de una clase padre común (Persona), y usa composición 
para integrar sus direcciones. Además, implementa un sistema de validación con una excepción personalizada y bloques try-catch 
para asegurar que el RUT se ingrese en el formato correcto sin que el programa se caiga.

-----Estructura general del proyecto-----

📁 src/

├── app/         # Clase principal con el método main (Main.java).

├── model/       # Clases de dominio (Persona, Cliente, Empleado, Asociado, Direccion).

└── util/        # Utilidades y manejo de excepciones (ValidadorRut, RutInvalidoException).

-----Instrucciones para clonar y ejecutar el proyecto-----

1. Clona el repositorio desde GitHub: git clone [https://github.com/jamesAnimal/Evaluacion_Semana_3_POO1_005A_Jaime_Seguel].
2. Abre el proyecto en Apache NetBeans (o el IDE de tu preferencia).
3. Navega hasta el paquete app y ejecuta el archivo Main.java.
4. Sigue las instrucciones en la consola para el ingreso y validación de datos de los clientes.

Link del video explicativo: https://youtu.be/VjF1R-UL9vE?si=h3xLlVlHXilPnx1H 
