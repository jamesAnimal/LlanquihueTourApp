![Duoc UC](https://www.duoc.cl/wp-content/uploads/2022/09/logo-0.png)

# 💻 Organización modular y creación de una librería personalizada – Desarrollo Orientado a Objetos I

---

## 👤 Autor del proyecto
- **Nombre completo:** Jaime Seguel Retamales.
- **Sección:** Desarrollo Orientado a Objetos I, sección 005A.
- **Carrera:** Analista Programador.
- **Sede:** Online.

---

## 📘 Descripción general del sistema
Este proyecto corresponde a la Evaluación Sumativa de la Semana 5 para la asignatura de *Desarrollo Orientado a Objetos I*.

Esta aplicación de consola en Java modela y gestiona la información de las personas vinculadas a la agencia de turismo "Llanquihue Tour" (Clientes, Empleados y Asociados) aplicando principios de herencia y composición. Además, carga de forma dinámica una lista de tours desde un archivo externo (tours.txt) a una colección ArrayList, aplicando filtros de categoría y precio en consola, todo organizado modularmente en paquetes.

---

## 🧱 Estructura general del proyecto

```plaintext
📁 src/main/java/
└── com/llanquihuetour/
    ├── app/          # Paquete para la clase principal main.
    │   └── Main.java
    ├── data/         # Paquete para clases de lectura, procesamiento y persistencia de datos externos.
    │   └── GestorDatos.java
    ├── model/        # Paquete para las clases de dominio que definen la estructura y comportamiento de los objetos.
    │   ├── Persona.java
    │   ├── Direccion.java
    │   ├── Cliente.java
    │   ├── Empleado.java
    │   ├── Asociado.java
    │   └── Tour.java
    └── util/         # Paquete para utilidades, validaciones y excepciones personalizadas.
        ├── ValidadorRut.java
        ├── RutInvalidoException.java
        └── BuscadorTours.java

📁 src/main/resources/     # Carpeta para archivos de configuración, recursos y datos del programa.
└── tours.txt
```

---

## ⚙️ Instrucciones para clonar y ejecutar el proyecto

**1.** **Clona el repositorio desde GitHub**
```bash
git clone https://github.com/jamesAnimal/llanquihue-tour-2.0.git
```

**2.** **Abre el proyecto en IntelliJ IDEA.**

**3.** **Verifica que los archivos .txt estén correctamente ubicados.**

**4.** **Ejecuta el archivo Main.java desde el paquete app.**

**5.** **Sigue las instrucciones en consola o en la interfaz gráfica (si corresponde).**

---

**Repositorio GitHub:** [https://github.com/jamesAnimal/llanquihue-tour-2.0](https://github.com/jamesAnimal/llanquihue-tour-2.0)
**Fecha de entrega:** 22/06/2026

---

© Duoc UC | Escuela de Informática y Telecomunicaciones | Desarrollo Orientado a Objetos I | Evaluación Sumativa Semana 5