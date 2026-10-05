# Design Patterns con Java 21

Proyecto educativo para aprender, practicar y comprender los **23 patrones de diseño GoF** utilizando **Java 21**, Maven y JUnit.

El objetivo de este repositorio no es únicamente mostrar implementaciones, sino entender:

- qué problema resuelve cada patrón;
- cuándo tiene sentido utilizarlo;
- cuándo conviene evitarlo;
- cómo reconocerlo en un proyecto real;
- cómo probarlo;
- y cómo se relaciona con Java moderno y frameworks habituales.

> [!NOTE]
> Los ejemplos están diseñados para ejecutarse de forma independiente desde IntelliJ IDEA.

---

## Tecnologías

- Java 21
- Maven
- JUnit
- Maven Compiler Plugin
- Maven Surefire Plugin
- IntelliJ IDEA

---

## Estructura del proyecto

```text
src/main/java/com/angelfernandez/designpatterns
│
├── creational
│   ├── abstractfactory
│   ├── builder
│   ├── factorymethod
│   ├── prototype
│   └── singleton
│
├── structural
│
└── behavioral
```

Los patrones se dividen en tres grandes grupos.

### Creacionales

Se centran en cómo se crean los objetos.

- Abstract Factory
- Builder
- Factory Method
- Prototype
- Singleton

### Estructurales

Se centran en cómo se relacionan y organizan clases y objetos.

- Adapter
- Bridge
- Composite
- Decorator
- Facade
- Flyweight
- Proxy

### Comportamiento

Se centran en cómo colaboran los objetos y cómo se reparten responsabilidades.

- Chain of Responsibility
- Command
- Interpreter
- Iterator
- Mediator
- Memento
- Observer
- State
- Strategy
- Template Method
- Visitor

---

## Cómo ejecutar el proyecto

### Requisitos

Necesitas tener instalado:

```text
Java 21
Maven
```

Puedes comprobarlo con:

```bash
java -version
mvn -version
```

---

## Compilar

Desde la raíz del proyecto:

```bash
mvn clean compile
```

---

## Ejecutar los tests

```bash
mvn test
```

---

## Ejecutar un patrón

Cada patrón tendrá una clase de ejemplo con un método `main()`.

Por ejemplo:

```text
SingletonExample
```

Desde IntelliJ puedes ejecutar directamente:

```text
Run 'SingletonExample.main()'
```

Esto permite estudiar cada patrón de forma independiente.

---

# Patrones implementados

| Categoría | Patrón | Estado |
|---|---|---|
| Creacional | Abstract Factory | ⬜ Pendiente |
| Creacional | Builder | ⬜ Pendiente |
| Creacional | Factory Method | ⬜ Pendiente |
| Creacional | Prototype | ⬜ Pendiente |
| Creacional | Singleton | ✅ Implementado |
| Estructural | Adapter | ⬜ Pendiente |
| Estructural | Bridge | ⬜ Pendiente |
| Estructural | Composite | ⬜ Pendiente |
| Estructural | Decorator | ⬜ Pendiente |
| Estructural | Facade | ⬜ Pendiente |
| Estructural | Flyweight | ⬜ Pendiente |
| Estructural | Proxy | ⬜ Pendiente |
| Comportamiento | Chain of Responsibility | ⬜ Pendiente |
| Comportamiento | Command | ⬜ Pendiente |
| Comportamiento | Interpreter | ⬜ Pendiente |
| Comportamiento | Iterator | ⬜ Pendiente |
| Comportamiento | Mediator | ⬜ Pendiente |
| Comportamiento | Memento | ⬜ Pendiente |
| Comportamiento | Observer | ⬜ Pendiente |
| Comportamiento | State | ⬜ Pendiente |
| Comportamiento | Strategy | ⬜ Pendiente |
| Comportamiento | Template Method | ⬜ Pendiente |
| Comportamiento | Visitor | ⬜ Pendiente |

---

## Forma de aprendizaje

Cada patrón sigue aproximadamente este proceso:

```text
Problema
   ↓
Idea
   ↓
Diseño
   ↓
Implementación
   ↓
Ejecución
   ↓
Tests
   ↓
Casos de uso
```

> [!TIP]
> El objetivo no es memorizar código, sino aprender a reconocer el problema que resuelve cada patrón.

---

## Organización de cada patrón

Cada patrón tendrá aproximadamente:

```text
nombre-del-patron/
├── clases del patrón
├── Example.java
└── README.md
```

El README específico explicará:

- problema que resuelve;
- estructura;
- funcionamiento;
- ejemplo utilizado;
- cómo ejecutarlo;
- tests;
- cuándo utilizarlo;
- cuándo evitarlo;
- ventajas;
- inconvenientes;
- variantes;
- relación con Java moderno.

---

## Convenciones del proyecto

El código intenta seguir estas reglas:

- nombres expresivos;
- clases pequeñas;
- responsabilidad clara;
- ejemplos fáciles de ejecutar;
- comentarios orientados al aprendizaje;
- tests que demuestran el comportamiento;
- uso razonable de características modernas de Java 21.

> [!IMPORTANT]
> Los comentarios explicarán principalmente decisiones y comportamiento. Se evitarán comentarios innecesarios que simplemente repitan lo que ya dice el código.

---

## Objetivo

Este repositorio forma parte de un proceso práctico de aprendizaje de arquitectura y diseño orientado a objetos.

La intención es poder llegar a identificar situaciones como:

```text
"Tengo este problema"
        ↓
"Este patrón podría ayudarme"
```

en lugar de limitarse a memorizar definiciones.

---

## Licencia

Este proyecto tiene finalidad educativa.
