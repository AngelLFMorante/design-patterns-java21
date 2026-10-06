# Builder

## ¿Qué problema resuelve?

Builder se utiliza cuando crear un objeto empieza a ser difícil de leer o mantener porque tiene muchos atributos, especialmente si varios son opcionales.

Sin Builder podríamos terminar con constructores como:

```java
new Computer("Ryzen 7", "RTX 4070", 32, 1000, true, true);
```

El problema es que al leerlo cuesta saber qué representa cada valor.

También puede aparecer el problema de tener muchos constructores diferentes para cubrir distintas combinaciones.

---

## Ejemplo utilizado

En este ejemplo construimos objetos:

```text
Computer
```

con los siguientes atributos:

```text
processor
graphicsCard
ram
storage
wifi
bluetooth
```

Algunos pueden ser opcionales y otros deben ser obligatorios.

---

## Objeto final

`Computer` guarda sus atributos como:

```java
private final ...
```

Esto hace que, una vez construido, su estado no pueda cambiar mediante nuevas asignaciones internas.

La construcción se hace únicamente a través del Builder.

---

## Builder interno

Dentro de `Computer` tenemos:

```java
public static class Builder
```

El Builder mantiene temporalmente los valores necesarios para construir el objeto final.

Ejemplo conceptual:

```text
Builder
├── processor
├── graphicsCard
├── ram
├── storage
├── wifi
└── bluetooth
```

Estos atributos no son `final` porque se van configurando paso a paso.

---

## ¿Por qué Builder es static?

El Builder debe poder existir antes de tener un objeto `Computer`.

Gracias a `static` podemos hacer:

```java
new Computer.Builder()
```

sin necesitar previamente una instancia de `Computer`.

---

## Métodos encadenables

Cada método guarda un valor y devuelve el propio Builder:

```java
public Builder ram(int ram) {
    this.ram = ram;
    return this;
}
```

El:

```java
return this;
```

permite encadenar llamadas:

```java
new Computer.Builder()
        .processor("Ryzen 7")
        .ram(32)
        .storage(1000)
```

---

## Construcción final

El método:

```java
build()
```

crea finalmente el objeto:

```text
Builder
   ↓
build()
   ↓
new Computer(this)
   ↓
Computer
```

`Computer` recibe el Builder mediante un constructor privado y copia todos sus valores.

---

## Ejemplo de uso

```java
Computer computer = new Computer.Builder()
        .processor("Ryzen 7")
        .ram(32)
        .storage(1000)
        .graphicsCard("RTX 4070")
        .wifi(true)
        .bluetooth(true)
        .build();
```

Esto es más legible que:

```java
new Computer("Ryzen 7", "RTX 4070", 32, 1000, true, true);
```

---

## Parámetros opcionales

Una ventaja importante es que no estamos obligados a especificar todos los atributos.

Por ejemplo:

```java
Computer computer = new Computer.Builder()
        .processor("Intel Core i5")
        .ram(16)
        .wifi(true)
        .build();
```

Los atributos no configurados mantienen sus valores por defecto.

---

## Valores por defecto en Java

Si no configuramos determinados campos:

```text
String  → null
int     → 0
boolean → false
```

Esto puede ser válido para atributos opcionales, pero no necesariamente para atributos obligatorios.

---

## Validación

El Builder también puede validar los datos antes de construir el objeto.

En este ejemplo comprobamos:

```text
processor no puede estar vacío
ram debe ser mayor que 0
```

El flujo es:

```text
Builder
   ↓
build()
   ↓
validar
   ↓
¿datos correctos?
   ├── no → IllegalStateException
   └── sí → new Computer(...)
```

Esto evita crear objetos inválidos.

---

## Tests

Los tests comprueban tres situaciones principales.

### Construcción correcta

Se verifica que un `Computer` válido puede construirse correctamente.

### Procesador obligatorio

Si falta el procesador:

```java
new Computer.Builder()
        .ram(32)
        .build();
```

se espera:

```text
IllegalStateException
```

### RAM inválida

Si la RAM es `0` o menor:

```java
new Computer.Builder()
        .processor("Ryzen 7")
        .ram(0)
        .build();
```

también se lanza una excepción.

---

## ¿Cuándo utilizar Builder?

Tiene sentido cuando:

- una clase tiene muchos parámetros;
- existen muchos parámetros opcionales;
- queremos evitar constructores enormes;
- queremos construir objetos paso a paso;
- queremos validar antes de crear el objeto;
- queremos crear objetos inmutables de forma cómoda.

---

## ¿Cuándo evitarlo?

Puede ser excesivo para objetos muy simples.

Por ejemplo, para una clase con solo:

```text
name
age
```

probablemente un constructor normal sea suficiente.

> [!WARNING]
> No conviene aplicar Builder automáticamente a todas las clases. Su utilidad aparece cuando simplifica una construcción que realmente empieza a ser compleja.

---

## Ventajas

- mejora mucho la legibilidad;
- evita constructores con demasiados parámetros;
- permite parámetros opcionales;
- facilita validaciones;
- permite construir objetos inmutables;
- hace explícito qué valor corresponde a cada atributo.

---

## Inconvenientes

- añade más código;
- requiere mantener el Builder;
- puede ser innecesario para objetos sencillos.

---

## Builder y Java moderno

En Java moderno también existen:

```text
records
```

que facilitan la creación de objetos de datos inmutables.

Sin embargo, Builder sigue siendo útil cuando:

- hay muchos campos;
- existen muchos campos opcionales;
- hay reglas de validación;
- queremos una API de construcción legible.

Por eso `record` y Builder no son necesariamente alternativas excluyentes.

---

## Regla mental

Piensa en Builder cuando veas algo como:

```java
new Something(a, b, c, d, e, f, g, h);
```

y te preguntes:

> ¿Qué significa cada parámetro?

Builder transforma eso en algo mucho más claro:

```java
Something.builder()
        .name(...)
        .size(...)
        .enabled(...)
        .build();
```

La palabra mental para recordar este patrón es:

```text
CONSTRUIR PASO A PASO
```