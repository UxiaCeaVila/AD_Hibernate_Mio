# Acceso a Datos - TarefaEA3.2

- **El identificador de dicha clase será almacenado en el DBMS como autoincremental ¿Sería lo mismo
  que si pusiésemos estrategia auto?**

No, ya que algunos sistemas gestores como el de Oracle o Postgres utilizan por defecto
una `SEQUENCE`,
en lugar de Identity. Por tanto, en esos sistemas, `auto` usaría `SEQUENCE` en lugar de `IDENTITY`.

- **El identificador de dicha clase será autogenerado con una estrategia de secuencia. ¿En qué
  consiste esta estrategia?**

Si el sistema gestor cuenta con una implementación propia de `SEQUENCE`, este mantiene sus propias
secuencias de números para los ID generados.

Si no existe, Hibernate mantiene una tabla para guardar dichas secuencias, y lee de ahí para generar
el siguiente valor incremental cada vez que se guarda una nueva fila.

- **¿Qué tipos de comportamiento podemos especificar en la relación? Demuestra su uso**

Con la anotación `@JoinTable` se crea una tabla de unión entre las dos entidades. Especificamos en
la anotación el atributo `name=students_courses` para el nombre de la tabla, `joinColumns` para la(
s) columna(s) de unión de nuestra entidad y `inverseJoinColumns` para la(s) columna(s) de unión con
la otra entidad.

