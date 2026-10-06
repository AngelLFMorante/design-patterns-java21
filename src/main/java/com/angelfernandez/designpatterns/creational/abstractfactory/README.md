# Abstract Factory

## ¿Qué problema resuelve?

Abstract Factory se utiliza cuando necesitamos crear **familias de objetos relacionados** sin acoplar el código cliente a clases concretas.

En este ejemplo tenemos dos familias visuales:

```text
LIGHT
├── LightButton
├── LightCheckbox
└── LightWindow

DARK
├── DarkButton
├── DarkCheckbox
└── DarkWindow
```

La aplicación debe poder trabajar con cualquiera de las dos familias sin conocer directamente sus implementaciones concretas.

---

## Productos abstractos

Definimos contratos comunes para los componentes:

```text
Button
Checkbox
Window
```

Cada uno define el comportamiento que deben implementar sus versiones concretas.

Por ejemplo:

```java
public interface Button {
    void render();
}
```

---

## Productos concretos

Cada producto abstracto tiene una implementación para cada familia.

```text
Button
├── LightButton
└── DarkButton

Checkbox
├── LightCheckbox
└── DarkCheckbox

Window
├── LightWindow
└── DarkWindow
```

---

## Abstract Factory

La interfaz:

```java
UIFactory
```

define qué productos debe poder crear una familia:

```java
Button createButton();
Checkbox createCheckbox();
Window createWindow();
```

La interfaz no decide si los productos serán light o dark.

---

## Fábricas concretas

Tenemos dos implementaciones:

```text
LightUIFactory
DarkUIFactory
```

`LightUIFactory` crea:

```text
LightButton
LightCheckbox
LightWindow
```

`DarkUIFactory` crea:

```text
DarkButton
DarkCheckbox
DarkWindow
```

---

## Cliente

`ApplicationUI` trabaja únicamente con abstracciones:

```text
UIFactory
Button
Checkbox
Window
```

No necesita conocer directamente:

```text
LightButton
DarkButton
LightCheckbox
DarkCheckbox
...
```

La familia se decide desde fuera:

```java
UIFactory factory = new LightUIFactory();
ApplicationUI application = new ApplicationUI(factory);
```

o:

```java
UIFactory factory = new DarkUIFactory();
ApplicationUI application = new ApplicationUI(factory);
```

---

## Flujo

Con tema claro:

```text
LightUIFactory
      ↓
ApplicationUI
      ↓
LightButton
LightCheckbox
LightWindow
```

Con tema oscuro:

```text
DarkUIFactory
      ↓
ApplicationUI
      ↓
DarkButton
DarkCheckbox
DarkWindow
```

---

## ¿Dónde está la idea principal?

Abstract Factory no crea simplemente un objeto.

Crea una **familia de objetos que deben ser compatibles entre sí**.

```text
Factory Method
→ crea un producto

Abstract Factory
→ crea una familia de productos relacionados
```

---

## Tests

Los tests comprueban que cada fábrica crea su familia correcta.

Por ejemplo:

```java
UIFactory factory = new LightUIFactory();

Button button = factory.createButton();
Checkbox checkbox = factory.createCheckbox();
Window window = factory.createWindow();

assertInstanceOf(LightButton.class, button);
assertInstanceOf(LightCheckbox.class, checkbox);
assertInstanceOf(LightWindow.class, window);
```

Y existe una prueba equivalente para la familia dark.

---

## Cuándo utilizarlo

Tiene sentido cuando:

- existen varias familias de productos relacionados;
- los objetos de una misma familia deben utilizarse juntos;
- queremos poder cambiar una familia completa fácilmente;
- el cliente no debería conocer las implementaciones concretas.

Ejemplos habituales:

```text
tema claro / oscuro
Windows / macOS
Oracle / PostgreSQL
AWS / Azure
```

---

## Cuándo evitarlo

Puede añadir demasiada estructura cuando:

- solo existe una familia;
- los productos no tienen relación entre sí;
- el sistema es muy pequeño;
- no necesitamos intercambiar familias completas.

> [!WARNING]
> Añadir un nuevo tipo de producto afecta a todas las fábricas.

Por ejemplo, si añadimos:

```text
Menu
```

tendremos que modificar:

```text
UIFactory
LightUIFactory
DarkUIFactory
```

Ese es uno de los principales costes del patrón.

---

## Ventajas

- mantiene familias coherentes;
- reduce el acoplamiento con clases concretas;
- facilita cambiar una familia completa;
- favorece trabajar contra interfaces.

---

## Inconvenientes

- aumenta el número de clases;
- puede resultar excesivo para sistemas simples;
- añadir nuevos tipos de producto puede requerir modificar todas las fábricas.

---

## Regla mental

Piensa:

> ¿Necesito crear varios objetos relacionados que siempre deberían pertenecer a la misma familia?

Si la respuesta es sí, Abstract Factory puede encajar.

Ejemplo:

```text
No quiero:
LightButton + DarkCheckbox + LightWindow

Quiero:
LightButton + LightCheckbox + LightWindow
```

La fábrica garantiza esa coherencia.