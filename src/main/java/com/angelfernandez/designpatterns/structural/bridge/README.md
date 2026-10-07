# Bridge

## ¿Qué problema resuelve?

Bridge se utiliza cuando tenemos **dos dimensiones que pueden variar de forma independiente** y queremos evitar crear una clase para cada combinación posible.

En este ejemplo tenemos dos grupos:

```text
Personajes
├── Warrior
├── Archer
└── Mage
```

y:

```text
Estilos de ataque
├── SwordAttack
├── BowAttack
└── MagicAttack
```

Sin Bridge podríamos acabar creando clases como:

```text
WarriorWithSword
WarriorWithMagic
ArcherWithBow
ArcherWithSword
MageWithMagic
MageWithBow
...
```

A medida que aumentan personajes y ataques, el número de combinaciones crece rápidamente.

---

## Solución

Bridge separa ambas jerarquías.

```text
Character
├── Warrior
├── Archer
└── Mage

AttackStyle
├── SwordAttack
├── BowAttack
└── MagicAttack
```

Un `Character` **tiene un** `AttackStyle`.

Esto utiliza composición:

```text
Character
    ↓
AttackStyle
```

en lugar de crear una subclase para cada combinación.

---

## Abstracción

La clase:

```text
Character
```

representa la abstracción principal.

Guarda una referencia a:

```text
AttackStyle
```

y las clases concretas heredan de ella:

```text
Character
├── Warrior
├── Archer
└── Mage
```

---

## Implementación

`AttackStyle` representa la otra dimensión del patrón.

```text
AttackStyle
├── SwordAttack
├── BowAttack
└── MagicAttack
```

Cada implementación decide cómo realizar el ataque.

---

## El puente

El Bridge aparece en la relación:

```text
Character
    |
    └── AttackStyle
```

Gracias a esa composición podemos crear combinaciones libremente.

Por ejemplo:

```text
Warrior + SwordAttack
Warrior + MagicAttack

Archer + BowAttack
Archer + SwordAttack

Mage + MagicAttack
Mage + BowAttack
```

sin crear nuevas clases de personaje.

---

## Flujo

Por ejemplo:

```text
Warrior
   ↓
performAttack()
   ↓
AttackStyle
   ↓
SwordAttack
   ↓
attack()
```

Si cambiamos la implementación:

```text
Warrior
   ↓
performAttack()
   ↓
AttackStyle
   ↓
MagicAttack
   ↓
attack()
```

`Warrior` sigue siendo exactamente la misma clase.

Solo cambia el objeto encargado del ataque.

---

## Ejemplo ejecutable

Nuestro ejemplo permite crear:

```text
Warrior + SwordAttack
Archer + BowAttack
Mage + MagicAttack
```

y ejecutar:

```text
performAttack()
```

Cada personaje delega el comportamiento en su `AttackStyle`.

---

## Tests

Los tests comprueban que el mismo personaje puede trabajar con distintos estilos de ataque.

Por ejemplo:

```text
Warrior + SwordAttack ✅
Warrior + MagicAttack ✅
```

Esto demuestra que personaje y ataque pueden variar independientemente.

---

## Bridge vs Adapter

Aunque ambos patrones conectan elementos, resuelven problemas distintos.

### Adapter

Se utiliza cuando dos interfaces ya existentes son incompatibles.

```text
Sistema A
   ↓
Adapter
   ↓
Sistema B
```

Palabra mental:

```text
TRADUCIR
```

### Bridge

Se diseña desde el principio para separar dos dimensiones que pueden evolucionar independientemente.

```text
Abstracción
    ↓
Implementación
```

Palabra mental:

```text
SEPARAR
```

---

## ¿Cuándo utilizar Bridge?

Puede tener sentido cuando:

- existen dos jerarquías independientes;
- las combinaciones pueden crecer mucho;
- queremos cambiar una implementación en tiempo de ejecución;
- queremos evitar una explosión de subclases;
- composición resulta más flexible que herencia.

---

## ¿Cuándo evitarlo?

Puede ser innecesario cuando:

- solo existe una implementación;
- no existen realmente dos dimensiones independientes;
- separar las jerarquías añade más complejidad que valor.

> [!WARNING]
> No conviene utilizar Bridge solo para evitar unas pocas clases. Debe existir una separación real entre dos conceptos que pueden cambiar por separado.

---

## Ventajas

- reduce el número de subclases;
- separa responsabilidades;
- permite combinar implementaciones;
- facilita extender ambas jerarquías;
- favorece composición sobre herencia.

---

## Inconvenientes

- añade más clases e interfaces;
- puede resultar menos intuitivo al principio;
- introduce otra capa de indirección.

---

## Regla mental

Pregúntate:

> ¿Tengo dos cosas que pueden variar por separado y estoy creando clases para cada combinación?

Si la respuesta es sí, Bridge puede encajar.

Ejemplo:

```text
PERSONAJE
    +
ATAQUE
```

en lugar de:

```text
WarriorWithSword
WarriorWithMagic
ArcherWithBow
...
```

---

## Palabra clave

```text
SEPARAR
```

Bridge separa dos dimensiones para que puedan evolucionar independientemente.