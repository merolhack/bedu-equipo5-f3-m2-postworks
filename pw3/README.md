# Sesión 3: JUnit & TestNG

PostWork Equipo 5: Por Lenin Meza

## Proyecto

Actualización al proyecto con Gradle para la pruebas de jUnit paralelizadas

## Objetivos

> - Analizar el funcionamiento de la ejecución en paralelo en JUnit 5.

## Desarrollo

- Agregar la configuración al archivo build.gradle:

```
systemProperty 'junit.jupiter.execution.parallel.enabled', 'true'
```

Ejecutar las pruebas con el parámetro `--profile`:

```bash
gradle test --profile
```

## Instrucciones

- [Postwork](https://github.com/beduExpert/Java-Testing-Santander-2022/tree/main/Sesion-03/Postwork)
