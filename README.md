![Duoc UC](https://www.duoc.cl/wp-content/uploads/2022/09/logo-0.png)

# 💻 Integrando interfaces, polimorfismo y estructuras dinámicas – Desarrollo Orientado a Objetos I

---

## 👤 Autor del proyecto
- **Nombre completo:** Jaime Seguel Retamales.
- **Sección:** Desarrollo Orientado a Objetos I, sección 005A.
- **Carrera:** Analista Programador.
- **Sede:** Online.

---

## 📘 Descripción general del sistema
Este proyecto corresponde a la Actividad **Sumativa** de la **Semana 8**, siendo el paso previo a la **Evaluación Final Transversal (EFT)** de la asignatura de *Desarrollo Orientado a Objetos I*.

En esta entrega, se eliminaron las pruebas por consola y toda la lógica residual u obsoleta de las semanas anteriores, para enfocarse de lleno en la funcionalidad real de la aplicación. Se construyeron interfaces gráficas (ventanas visuales) que centralizan la gestión de Clientes, Personal, Recursos y Servicios Turísticos en un entorno amigable. Esto mejora enormemente la experiencia del usuario, asegurando que el ingreso de datos sea intuitivo, estandarizado y seguro mediante validaciones en tiempo real.

A nivel de código, se integró la interfaz **Registrable** como comportamiento común. Esto permite guardar entidades muy distintas (como un **GuiaTuristico** y un **Vehiculo**) en una misma lista dentro de **GestorEntidades**. Al momento de recorrer esa lista, el programa usa la instrucción **instanceof** para identificar qué tipo exacto de objeto es y mostrar sus datos correctamente.

Por último, para modularizar el código y despejar las ventanas de lógica repetida, se crearon clases de apoyo (`ValidadorGeneral` y `CargadorCombobox`). De esta forma, las validaciones y la carga de datos quedan totalmente separadas del diseño visual, manteniendo el proyecto mucho más ordenado y fácil de actualizar.

---

## 🧱 Estructura general del proyecto

```plaintext
📁 src/main/java/com/llanquihuetour/
app/          # Paquete para la clase principal que inicializa el sistema.
└── Main.java                # [MODIFICADO]
data/         # Paquete para clases de gestión de listas y datos.
├── GestorClientes.java      # [NUEVO]
├── GestorEntidades.java     # [NUEVO]
└── GestorServicios.java     # [MODIFICADO]
model/        # Paquete para clases del dominio, herencia e interfaces.
├── Registrable.java         # [NUEVO]
├── Persona.java, Cliente.java, Empleado.java, Asociado.java, GuiaTuristico.java
├── RecursoFisico.java, Vehiculo.java, Alojamiento.java
├── ServicioTuristico.java, RutaGastronomica.java, PaseoLacustre.java, ExcursionCultural.java
└── Direccion.java
ui/           # Paquete para las ventanas visuales de la aplicación.
├── VentanaBienvenida.java   # [NUEVO]
├── VentanaCliente.java      # [NUEVO]
├── VentanaEmpresa.java      # [NUEVO]
└── VentanaServicios.java    # [NUEVO]
util/         # Paquete para utilidades extras y validaciones.
├── ValidadorGeneral.java    # [NUEVO]
├── CargadorCombobox.java    # [NUEVO]
└── RutInvalidoException.java
```

---

## 📅 Historial de Entregas
Este repositorio muestra la evolución incremental del proyecto semana a semana. Para ver el estado del código de una entrega específica, navega por el historial de **commits** de GitHub:

* **Semana 3:** `Commit 1: LlanquihueTourApp.JaimeSeguel.Semana3` ("Registro de personal y clientes")
* **Semana 4:** `Commit 2: LlanquihueTourApp.JaimeSeguel.Semana4` ("Construyendo una lista de objetos desde archivo")
* **Semana 5:** `Commit 3: LlanquihueTourApp.JaimeSeguel.Semana5` ("Organización modular y creación de una librería personalizada")
* **Semana 6:** `Commit 4: LlanquihueTourApp.JaimeSeguel.Semana6` ("Creando jerarquías de clases con herencia simple")
* **Semana 7:** `Commit 5: LlanquihueTourApp.JaimeSeguel.Semana7` ("Aplicando polimorfismo y colecciones genéricas")
* **Semana 8:** `Commit 6: LlanquihueTourApp.JaimeSeguel.Semana8` ("Integrando interfaces, polimorfismo y estructuras dinámicas")

*(Puedes ver el código de cada semana haciendo clic en el botón "<>" al lado del commit correspondiente).*

---

## ⚙️ Instrucciones para clonar y ejecutar el proyecto

**1.** **Clona el repositorio desde GitHub:**
[https://github.com/jamesAnimal/LlanquihueTourApp.git](https://github.com/jamesAnimal/LlanquihueTourApp.git)

**2.** **Abre el proyecto en IntelliJ IDEA.**

**3.** **Ejecuta el archivo Main.java desde el paquete app.** La ventana de Bienvenida se abrirá automáticamente.

---

**Repositorio GitHub:** [https://github.com/jamesAnimal/LlanquihueTourApp](https://github.com/jamesAnimal/LlanquihueTourApp)
**Fecha de entrega límite (Semana 8):** 13/07/2026.

---

© Duoc UC | Escuela de Informática y Telecomunicaciones | Desarrollo Orientado a Objetos I | Avance Semana 8.