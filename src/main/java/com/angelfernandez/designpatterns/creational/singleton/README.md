# Singleton

## ¿Qué problema resuelve?

Singleton se utiliza cuando queremos controlar que exista **una única instancia de una clase dentro de una aplicación Java en ejecución**.

En este ejemplo utilizamos un reproductor de música.

Queremos evitar que diferentes partes de la aplicación creen distintos reproductores mediante:

```java
new MusicPlayer();
```

En su lugar, todas las partes de la aplicación utilizan la misma instancia.

---

## Ejemplo

Nuestra clase principal es:

```text
MusicPlayer
```

El reproductor mantiene información como la canción que está reproduciendo actualmente.

Dos partes diferentes de la aplicación pueden obtener el reproductor:

```java
var player1 = MusicPlayer.getInstance();
var player2 = MusicPlayer.getInstance();
```

Pero ambas referencias apuntan al mismo objeto.

```text
player1 ─┐
         ├──> MusicPlayer
player2 ─┘
```

---

## Funcionamiento

El patrón se apoya en tres ideas principales.

### Constructor privado

El constructor es privado para impedir que otras clases puedan ejecutar:

```java
new MusicPlayer();
```

---

### Instancia estática

La propia clase mantiene una referencia a su instancia.

```text
MusicPlayer
    ↓
instance
    ↓
único MusicPlayer
```

Al ser `static`, esa referencia pertenece a la clase y no a cada objeto.

---

### Método de acceso

La clase ofrece un método para obtener la instancia.

La lógica es:

```text
¿Existe una instancia?
       |
   ┌───┴───┐
   │       │
   NO      SÍ
   │       │
crear      devolver
   │       │
   └───┬───┘
       ↓
 misma instancia
```

---

## Concurrencia

El método utilizado en este ejemplo está sincronizado.

Esto evita que dos hilos entren simultáneamente cuando la instancia todavía no existe.

```text
Hilo A entra
    ↓
Hilo B espera
    ↓
Hilo A termina
    ↓
Hilo B puede entrar
```

Se utiliza:

```java
synchronized
```

para proteger la creación de la instancia.

---

## Prueba del patrón

El test comprueba que dos llamadas devuelven exactamente el mismo objeto.

```java
assertSame(player1, player2);
```

`assertSame` comprueba identidad de objeto.

No comprueba simplemente que tengan los mismos datos.

---

## Estado compartido

También comprobamos que ambas referencias comparten el mismo estado.

Si:

```java
player1.play("Purple Rain - Prince");
```

entonces:

```java
player2.getCurrentSong();
```

devuelve la misma canción.

Esto ocurre porque `player1` y `player2` apuntan al mismo objeto.

---

## Cómo ejecutarlo

Ejecuta:

```text
SingletonExample
```

desde IntelliJ.

La salida será similar a:

```text
¿Es la misma instancia? true
Canción actual: Purple Rain - Prince
```

---

## Cuándo utilizar Singleton

Puede tener sentido cuando realmente queremos controlar un único recurso dentro de una JVM.

Ejemplos:

- gestor de audio;
- cache local;
- gestor de recursos compartidos;
- registro central de eventos;
- coordinador interno de una aplicación.

---

## Cuándo evitarlo

No debería utilizarse simplemente para acceder fácilmente a un objeto.

Normalmente no tendría sentido aplicar Singleton a:

```text
Usuario
Pedido
Libro
Canción
Producto
Carrito
```

porque normalmente necesitamos múltiples instancias.

> [!WARNING]
> Singleton introduce estado global en la aplicación. Su uso excesivo puede dificultar los tests y aumentar el acoplamiento.

---

## Regla mental

Una pregunta útil antes de utilizarlo:

> ¿Tiene sentido que dentro de esta aplicación Java exista solamente una instancia de esta clase?

Si la respuesta es sí, Singleton puede ser una opción.

Si la respuesta es no, probablemente necesites otro diseño.