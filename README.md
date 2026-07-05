# Sistema de Control de Inventario

## Estudiante

**Dayana Murillo**

## Curso

Programación IV

---

# Descripción

El Sistema de Control de Inventario es una aplicación de escritorio desarrollada en Java Swing que permite administrar un inventario de productos.

El sistema permite registrar, editar, eliminar, buscar, ordenar y visualizar productos, además de generar estadísticas y exportar el inventario a un archivo CSV.

El proyecto fue desarrollado aplicando programación por capas, manejo de excepciones, Collections y control de versiones mediante Git y GitHub.

---

# Tecnologías utilizadas

- Java
- Java Swing
- NetBeans
- Git
- GitHub

---

# Componentes Swing utilizados

- JFrame
- JPanel
- JMenuBar
- JToolBar
- JTabbedPane
- JTable
- JScrollPane
- JTextField
- JTextArea
- JComboBox
- JCheckBox
- JRadioButton
- JButton
- JOptionPane
- JFileChooser

---

# Funcionalidades

- Registrar productos
- Editar productos
- Eliminar productos
- Buscar productos por código y categoría
- Ordenar productos
- Visualizar estadísticas
- Exportar inventario a archivo CSV
- Historial de acciones realizadas

---

# Collections utilizadas

El proyecto utiliza las siguientes estructuras de datos:

- List<Producto>
- Set<String>
- Map<String, Integer>
- Stack<String>

---

# Excepciones personalizadas

- DatoInvalidoException
- ProductoDuplicadoException
- ArchivoException

---

# Organización del proyecto

```
src
│
├── modelo
│     Producto.java
│
├── repositorio
│     ProductoRepositorio.java
│
├── negocio
│     ProductoNegocio.java
│
├── excepciones
│     DatoInvalidoException.java
│     ProductoDuplicadoException.java
│     ArchivoException.java
│
├── presentacion
│     MainFrame.java
│     ProductoPanel.java
│     ListaProductosPanel.java
│     EstadisticaPanel.java
│     HistorialPanel.java
│
└── util
      ArchivoUtil.java
```

---

# Requisitos

- Java JDK 17 o superior
- NetBeans IDE
- Git

---

# Instrucciones de uso

1. Abrir el proyecto en NetBeans.
2. Ejecutar la clase MainFrame.
3. Registrar productos.
4. Consultar la lista de productos.
5. Buscar, editar o eliminar productos.
6. Visualizar las estadísticas.
7. Consultar el historial de acciones.
8. Exportar el inventario mediante la opción correspondiente.

---

# Capturas de la aplicación

Agregar aquí las capturas del sistema:

- Registro de productos
- Lista de productos
- Estadísticas
- Historial
- Exportación del inventario
- Repositorio de GitHub

---

# Autor

Dayana Murillo

Proyecto desarrollado para el curso de Programación IV.
