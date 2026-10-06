# Factory Method

## ¿Qué problema resuelve?

Factory Method se utiliza cuando queremos crear distintos tipos de objetos sin hacer que el código cliente conozca directamente todas sus clases concretas.

Sin este patrón podríamos terminar con código como:

```java
if (type.equals("book")) {
    return new Book();
} else if (type.equals("magazine")) {
    return new Magazine();
} else if (type.equals("audiobook")) {
    return new Audiobook();
}
```

A medida que aparecen nuevos tipos, este código crece y obliga a modificarlo continuamente.

Factory Method delega la creación del objeto a clases especializadas.

---

## Ejemplo utilizado

En este ejemplo tenemos distintos contenidos de una biblioteca:

```text
LibraryContent
├── Book
├── Magazine
└── Audiobook
```

Todos comparten el mismo contrato:

```java
void open();
```

---

## Estructura

```text
LibraryContent
├── Book
├── Magazine
└── Audiobook


ContentFactory
├── BookFactory
├── MagazineFactory
└── AudiobookFactory
```

`LibraryContent` representa el producto.

`ContentFactory` representa el creador.

Las fábricas concretas deciden qué producto crear.

---

## El Factory Method

La clase base declara:

```java
public abstract LibraryContent createContent();
```

Cada fábrica concreta implementa este método.

Conceptualmente:

```text
BookFactory
    ↓
createContent()
    ↓
new Book()
```

```text
MagazineFactory
    ↓
createContent()
    ↓
new Magazine()
```

```text
AudiobookFactory
    ↓
createContent()
    ↓
new Audiobook()
```

---

## Lógica común

`ContentFactory` también contiene:

```java
public void openContent() {
    LibraryContent content = createContent();
    content.open();
}
```

La clase base sabe que quiere:

```text
crear contenido
      ↓
abrir contenido
```

pero no sabe qué tipo concreto debe crear.

Esa decisión pertenece a las subclases.

---

## Flujo de ejecución

Ejemplo:

```java
ContentFactory factory = new BookFactory();
factory.openContent();
```

El flujo es:

```text
BookFactory
    ↓
openContent()
    ↓
createContent()
    ↓
BookFactory.createContent()
    ↓
new Book()
    ↓
Book.open()
```

---

## Añadir un nuevo tipo

Si mañana queremos añadir:

```text
Newspaper
```

crearíamos:

```text
Newspaper implements LibraryContent
NewspaperFactory extends ContentFactory
```

No necesitamos modificar las fábricas existentes.

Esto favorece la idea de:

> abierto a extensión, cerrado a modificación.

---

## Tests

Los tests comprueban que cada fábrica crea el producto correcto.

Ejemplo:

```java
ContentFactory factory = new BookFactory();

LibraryContent content = factory.createContent();

assertInstanceOf(Book.class, content);
```

Tenemos pruebas equivalentes para:

```text
BookFactory      → Book
MagazineFactory  → Magazine
AudiobookFactory → Audiobook
```

---

## ¿Cuándo utilizar Factory Method?

Tiene sentido cuando:

- existen distintos productos que comparten una abstracción;
- no queremos que el cliente conozca todas las clases concretas;
- queremos permitir nuevos tipos sin modificar la lógica existente;
- distintas subclases deben decidir qué objeto crear.

---

## ¿Cuándo evitarlo?

Puede ser excesivo si:

- solo existe un tipo de objeto;
- la creación es extremadamente sencilla;
- no esperamos diferentes implementaciones;
- las fábricas añaden más complejidad que valor.

> [!WARNING]
> Aplicar Factory Method a objetos muy simples puede introducir clases innecesarias.

---

## Ventajas

- reduce el acoplamiento entre cliente y clases concretas;
- facilita añadir nuevos productos;
- centraliza responsabilidades de creación;
- permite trabajar contra abstracciones.

---

## Inconvenientes

El principal coste es aumentar el número de clases.

Por ejemplo:

```text
Book
BookFactory

Magazine
MagazineFactory

Audiobook
AudiobookFactory
```

Por eso debe utilizarse cuando esa separación aporte valor.

---

## Factory Method vs una fábrica con switch

Esto:

```java
switch (type) {
    case "BOOK" -> new Book();
    case "MAGAZINE" -> new Magazine();
}
```

no representa necesariamente Factory Method.

En Factory Method, la creación se delega mediante herencia o especialización:

```text
ContentFactory
       ↑
       |
BookFactory
MagazineFactory
AudiobookFactory
```

Cada fábrica sobrescribe el método:

```java
createContent()
```

y decide qué producto crear.

---

## Regla mental

Puedes recordar Factory Method con esta pregunta:

> Tengo varios objetos relacionados. ¿Quiero que otra clase decida cuál debe crear?

Si la respuesta es sí, Factory Method puede ser una buena opción.

Otra forma de recordarlo:

```text
Cliente
   ↓
pide crear algo
   ↓
Factory Method
   ↓
decide qué clase concreta crear
```