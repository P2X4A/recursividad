# Ejercicios de Recursividad

Ejercicios de recursividad aplicados a un CRUD sobre un arreglo de tamano fijo.

## Detalle

| | |
|---|---|
| Tipo | Ejercicios |
| Archivos Java | 1 |
| Version de Java | 21 |
| Patron | Proyecto renombrado de crudRecursividad a CrudRecursividad siguiendo la convencion de Java |

## Funcionalidades

- CRUD completo sobre arreglo (agregar, leer, actualizar, buscar)
- Suma recursiva de 1 a n
- Potencia por multiplicacion recursiva sin Math.pow

## Estructura del proyecto

```
recursividad/
|-- pom.xml       configuracion de Maven, importable desde cualquier IDE
|-- src/          codigo fuente
`-- README.md
```

## Como ejecutarlo

### Con Maven

```bash
mvn clean compile
mvn exec:java
```

### Con javac directamente

```bash
# Linux / macOS
javac -d bin $(find src -name "*.java")

# Windows (PowerShell)
javac -d bin (Get-ChildItem -Recurse -Filter *.java src).FullName
```

```bash
java -cp bin CrudRecursividad
```

### Desde un IDE

Cualquier IDE con soporte de Java (Eclipse, IntelliJ IDEA, VS Code o NetBeans)
puede importar el proyecto directamente como **proyecto Maven**. Basta con abrir
o importar la carpeta: el IDE detecta el `pom.xml`, resuelve las dependencias y
compila sin configuracion adicional.

## Autor

Desarrollado por [Sergio Parra](https://github.com/P2X4A) como parte de su
formacion en Java.

## Licencia

Ver el archivo [LICENSE](LICENSE).