### UNIR . Grado en Ingeniería Informática
#### Asignatura: Programación Avanzada.
#### Profesor: Gustavo Millan García
#### Alumno: Carlos Hernández Reyes


## Enunciado

#### Laboratorio Programación Avanzada
En un departamento de IT llegan numerosas incidencias de todo tipo, como, por ejemplo, incidencias relacionadas con equipos de red (switch´s, Reuters), servidores, ordenadores personales, móviles, etc. Los técnicos resuelven estas incidencias y como información de cierre imputa el tiempo empleado en la resolución, posteriormente el coordinador con la  información de estos tiempos obtendrá informes de rendimiento para ver cómo funciona su departamento. Se desea desarrollar un pequeño programa que mediante una interfaz gráfica permita asignar técnicos a incidencias que se han producido. El técnico una vez terminado el trabajo deberá anotar el tiempo de resolución y cerrar la incidencia, la fecha de cierre se establecerá automáticamente cuando se impute el tiempo de resolución. El programa deberá permitir obtener distintos informes de rendimiento.
##### Requisitos:

Una Incidencia se caracteriza por la siguiente información:
- Un identificador alfanumérico: Ej IC0001
- Una descripción breve de la incidencia.
- Una fecha de creación: En formato día/mes/año
- Una fecha de cierre. En formato día/mes/año
- Un estado, que podrá ser: abierta, en progreso, cerrada
- Un Técnico asociado: Si la incidencia no tiene técnico asociado no se puede cambiar de estado. La incidencia solo puede tener un único Técnico asociado
- Tiempo de resolución (horas): Ejemplo 2 horas 

Un Técnico esta caracterizado por:
- Nombre completo
- Nivel ( N1,N2,N3)

## Contenidos a entregar:
- Diagrama del modelo de clases que represente la información de técnicos e incidencias exclusivamente
- Implementación en java del modelo de clases anterior
- Diseño e implementación de la interfaz gráfica siguiendo los prototipos de interfaz planeados
- Se deben controlar las siguientes condiciones de error
    - Asignar una Incidencia cerrada a un Técnico
    - Asignar un Técnico a una Incidencia que ya tiene un Técnico asignada

- Todo el código de implementación se debe entregar en un proyecto java en eclipse




