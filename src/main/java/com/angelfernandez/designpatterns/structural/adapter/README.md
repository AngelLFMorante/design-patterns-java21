# Adapter

## ¿Qué problema resuelve?

Adapter se utiliza cuando tenemos dos clases o interfaces que deberían colaborar, pero sus métodos no son compatibles.

En nuestro ejemplo, el juego espera trabajar siempre con:

```text
Enemy
```

y ese contrato define una acción:

```text
attack()
```

Pero tenemos una clase antigua o externa:

```text
LegacyOrc
```

que no implementa `Enemy` y utiliza otro método:

```text
strikeWithClub()
```

Ambos representan una acción parecida, pero sus interfaces no encajan.

---

## Problema inicial

Nuestro juego quiere trabajar así:

```text
Enemy
  ↓
attack()
```

Mientras que la clase externa ofrece:

```text
LegacyOrc
  ↓
strikeWithClub()
```

Por tanto:

```text
Enemy                LegacyOrc
attack()              strikeWithClub()

       ❌ incompatibles
```

No podemos tratar directamente `LegacyOrc` como un `Enemy`.

---

## Solución

Creamos una clase intermedia:

```text
OrcAdapter
```

El Adapter conoce ambos mundos.

```text
Enemy
  ↑
OrcAdapter
  ↓
LegacyOrc
```

Por un lado, `OrcAdapter` cumple el contrato que espera nuestro juego.

Por otro lado, internamente utiliza `LegacyOrc`.

---

## Flujo

Cuando nuestro juego ejecuta:

```text
attack()
```

el Adapter traduce esa llamada:

```text
Enemy.attack()
     ↓
OrcAdapter.attack()
     ↓
LegacyOrc.strikeWithClub()
```

El cliente no necesita conocer cómo funciona `LegacyOrc`.

---

## Idea principal

Adapter no modifica:

```text
Enemy
```

ni tampoco:

```text
LegacyOrc
```

Simplemente crea una pieza intermedia capaz de hacerlos compatibles.

Podemos verlo como:

```text
MI SISTEMA
    ↓
ADAPTER
    ↓
SISTEMA EXTERNO
```

---

## Componentes del patrón

### Target

Es la interfaz que nuestro sistema entiende.

En nuestro ejemplo:

```text
Enemy
```

---

### Adaptee

Es la clase incompatible que queremos utilizar.

En nuestro ejemplo:

```text
LegacyOrc
```

---

### Adapter

Es la clase que conecta ambos contratos.

En nuestro ejemplo:

```text
OrcAdapter
```

---

### Client

Es el código que utiliza el contrato esperado.

El cliente trabaja contra:

```text
Enemy
```

y no necesita conocer los detalles del objeto adaptado.

---

## Ejemplo conceptual

Sin Adapter:

```text
Juego
 ↓
Enemy.attack()

LegacyOrc
 ↓
strikeWithClub()

❌ No encajan
```

Con Adapter:

```text
Juego
 ↓
Enemy.attack()
 ↓
OrcAdapter
 ↓
LegacyOrc.strikeWithClub()

✅ Compatible
```

---

## Test

El test comprueba que el adaptador puede utilizarse como parte del sistema que espera un `Enemy`.

Esto demuestra que:

```text
LegacyOrc
```

puede incorporarse al juego mediante:

```text
OrcAdapter
```

sin modificar la clase externa.

---

## ¿Cuándo utilizar Adapter?

Puede ser útil cuando:

- integramos una librería externa;
- trabajamos con código antiguo;
- una API tiene métodos distintos a los que espera nuestra aplicación;
- queremos reutilizar una clase existente sin modificarla;
- dos sistemas representan la misma operación de maneras diferentes.

---

## Ejemplos reales

Adapter podría aparecer al integrar:

```text
motor gráfico externo
sistema antiguo de enemigos
API de sonido
librería de controles
sistema de guardado
servicio externo
```

Nuestro código puede mantener su contrato mientras el Adapter traduce hacia la API externa.

---

## ¿Cuándo evitarlo?

No aporta demasiado cuando:

- ambas clases ya tienen interfaces compatibles;
- podemos modificar fácilmente ambos lados;
- estamos creando una capa que no realiza ninguna traducción real.

> [!WARNING]
> Crear adapters innecesarios puede añadir clases y complejidad sin aportar valor.

---

## Ventajas

- permite reutilizar código existente;
- evita modificar librerías externas;
- reduce el acoplamiento;
- mantiene estable la interfaz de nuestra aplicación;
- encapsula la lógica de traducción.

---

## Inconvenientes

- añade una clase adicional;
- demasiados adapters pueden hacer más difícil seguir el flujo;
- una adaptación compleja puede esconder diferencias importantes entre ambos sistemas.

---

## Regla mental

Puedes recordar Adapter como un **traductor**.

```text
Mi aplicación habla:
attack()

La librería habla:
strikeWithClub()

Adapter traduce:
attack() → strikeWithClub()
```

La pregunta mental sería:

> Tengo algo que quiero utilizar, pero su interfaz no encaja con la que espera mi aplicación. ¿Puedo adaptarlo sin modificarlo?

Si la respuesta es sí, Adapter puede ser una buena opción.

---

## Palabra clave

```text
TRADUCIR
```

Adapter convierte una interfaz en otra que nuestro sistema sabe utilizar.