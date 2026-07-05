![Duoc UC](https://www.duoc.cl/wp-content/uploads/2022/09/logo-0.png)

# 💻 Aplicando polimorfismo y colecciones genéricas – Desarrollo Orientado a Objetos I

---

## 👤 Autor del proyecto
- **Nombre completo:** Jaime Seguel Retamales.
- **Sección:** Desarrollo Orientado a Objetos I, sección 005A.
- **Carrera:** Analista Programador.
- **Sede:** Online.

---

## 📘 Descripción general del sistema
Este proyecto corresponde a la Actividad Formativa de la Semana 7, la cual representa el desarrollo incremental de la aplicación **LlanquihueTourApp** para la asignatura de *Desarrollo Orientado a Objetos I*.

Esta aplicación de consola sirve para administrar los datos del personal y los clientes de la agencia, cargar una lista de tours desde un archivo de texto y realizar búsquedas por etiquetas. También permite la gestión de los diferentes servicios especializados que ofrece la agencia (rutas gastronómicas, paseos por el lago y excursiones culturales). En esta entrega (Semana 7), el sistema agrupa todos estos servicios en una única lista para mostrarlos en pantalla de forma automática, identificando dinámicamente el tipo de actividad con su detalle específico (restricciones alimentarias, tipo de embarcación o lugar histórico) y desplegando la ficha de información completa de cada servicio.

**¡Atención!** En Main.java la lógica de las semanas pasadas está comentada para que solo corra lo de la Semana 7. Para ver todo el funcionamiento anterior, retire los caracteres /* y */.

---

## 🧱 Estructura general del proyecto

```plaintext
📁 src/main/java/com/llanquihuetour/
app/          # Paquete para la clase principal Main (equivalente a ui/).
└── Main.java                # [MODIFICADO]
data/         # Paquete para clases de lectura y persistencia de datos.
├── GestorDatos.java
└── GestorServicios.java     # [MODIFICADO]
model/        # Paquete para las clases de dominio y jerarquía de herencia.
├── Persona.java
├── Direccion.java
├── Cliente.java
├── Empleado.java
├── Asociado.java
├── Tour.java
├── ServicioTuristico.java   # [MODIFICADO]
├── RutaGastronomica.java    # [MODIFICADO]
├── PaseoLacustre.java       # [MODIFICADO]
└── ExcursionCultural.java   # [MODIFICADO]
util/         # Paquete para utilidades, validaciones y excepciones.
├── ValidadorRut.java
├── RutInvalidoException.java
└── BuscadorTours.java

📁 src/main/resources/     # Carpeta para archivos de recursos y datos del programa.
└── tours.txt
```

---

## 📅 Historial de Entregas (Git History)
Este repositorio muestra la evolución incremental del proyecto semana a semana. Para ver el estado del código de una entrega específica, navega por el historial de **commits** de GitHub:

* **Semana 3:** `Commit 1: LlanquihueTourApp.JaimeSeguel.Semana3` ("Registro de personal y clientes")
* **Semana 4:** `Commit 2: LlanquihueTourApp.JaimeSeguel.Semana4` ("Construyendo una lista de objetos desde archivo")
* **Semana 5:** `Commit 3: LlanquihueTourApp.JaimeSeguel.Semana5` ("Organización modular y creación de una librería personalizada")
* **Semana 6:** `Commit 4: LlanquihueTourApp.JaimeSeguel.Semana6` ("Creando jerarquías de clases con herencia simple")
* **Semana 7:** `Commit 5: LlanquihueTourApp.JaimeSeguel.Semana7` ("Aplicando polimorfismo y colecciones genéricas")

*(Puedes ver el código de cada semana haciendo clic en el botón  "<>"  al lado del commit correspondiente).*

---

## ⚙️ Instrucciones para clonar y ejecutar el proyecto

**1.** **Clona el repositorio desde GitHub:**
[https://github.com/jamesAnimal/LlanquihueTourApp.git](https://github.com/jamesAnimal/LlanquihueTourApp.git)

**2.** **Abre el proyecto en IntelliJ IDEA.**

**3.** **Ejecuta el archivo Main.java desde el paquete app.**

---

**Repositorio GitHub:** [https://github.com/jamesAnimal/LlanquihueTourApp](https://github.com/jamesAnimal/LlanquihueTourApp)
**Fecha de entrega límite (Semana 7):** 06/07/2026.

---

© Duoc UC | Escuela de Informática y Telecomunicaciones | Desarrollo Orientado a Objetos I | Avance Semana 7.