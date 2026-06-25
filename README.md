# Construyendo una lista de objetos desde archivo – Desarrollo Orientado a Objetos I

## Autor del proyecto
* **Nombre completo:** Jaime Seguel Retamales.
* **Sección:** Desarrollo Orientado a Objetos I, sección 005A.
* **Carrera:** Analista Programador.
* **Sede:** Online.

## Descripción general del sistema
Este proyecto corresponde a la Actividad Formativa de la Semana 4 para la asignatura de Desarrollo Orientado a Objetos I.

Esta aplicación de consola en Java gestiona los registros de la agencia de turismo "Llanquihue Tour". El sistema lee datos de tours desde un archivo externo (tours.txt), convierte cada registro en un objeto de tipo `Tour` y los almacena en una colección dinámica (ArrayList). Finalmente, recorre la lista y aplica filtros de categoría (Naturaleza) y precio (Económicos y Premium), mostrando los resultados organizados en la consola.

## Estructura general del proyecto
```text
📁 src/
├── data/
│   └── GestorDatos.java  # Clase encargada de leer el archivo .txt y agregarlos a una lista dinámica de objetos.
├── model/
│   └── Tour.java         # Clase modelo para crear objetos de tipo Tour.
└── app/
    └── Main.java         # Clase principal que contiene la lógica del programa.

📁 resources/
└── tours.txt             # Archivo de texto con los registros de los tours.
```

## Instrucciones para clonar y ejecutar el proyecto

### 1. Clonar el repositorio
Clona el repositorio desde GitHub ejecutando el siguiente comando en la terminal:
```bash
git clone https://github.com/jamesAnimal/llanquihue-tour.git
```

### 2. Ejecutar en el IDE
1. Abre el proyecto en IntelliJ IDEA (o el IDE de tu preferencia).
2. Navega hasta el paquete app y ejecuta el archivo Main.java.
3. El programa cargará los tours automáticamente del archivo y mostrará los resultados filtrados en la consola.
