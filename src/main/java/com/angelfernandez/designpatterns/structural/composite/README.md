# Composite

## ¿Qué problema resuelve?

Composite permite tratar de la misma manera:

- un objeto individual;
- un grupo de objetos;
- grupos que contienen otros grupos.

En nuestro videojuego queremos poder ejecutar:

```text
attack()
```

tanto sobre un enemigo individual como sobre un grupo completo.

---

## Ejemplo utilizado

Tenemos distintos enemigos:

```text
Goblin
Orc
```

y también podemos crear:

```text
EnemyGroup
```

Todos implementan el mismo contrato:

```text
EnemyComponent
```

---

## Estructura

```text
EnemyComponent
├── Goblin
├── Orc
└── EnemyGroup
```

La diferencia es que `EnemyGroup` puede contener otros `EnemyComponent`.

Por ejemplo:

```text
EnemyGroup
├── Goblin
├── Orc
└── EnemyGroup
    ├── Goblin
    └── Orc
```

Esto forma una estructura similar a un árbol.

---

## Componente común

Todos los elementos implementan:

```text
EnemyComponent
```

que define:

```text
attack()
```

Gracias a esto, el código cliente puede utilizar cualquier componente de la misma manera.

---

## Leaf

Los objetos individuales son las hojas del árbol.

En nuestro ejemplo:

```text
Goblin
Orc
```

Estos elementos realizan directamente la operación `attack()`.

---

## Composite

`EnemyGroup` representa el objeto compuesto.

Internamente mantiene una colección de:

```text
EnemyComponent
```

Por eso puede contener:

```text
Goblin
Orc
EnemyGroup
```

Cuando se ejecuta:

```text
EnemyGroup.attack()
```

el grupo recorre todos sus componentes y ejecuta:

```text
component.attack()
```

---

## Flujo

Tenemos:

```text
MainGroup
├── Goblin
├── Orc
└── SecondaryGroup
    ├── Goblin
    └── Orc
```

Al ejecutar:

```text
MainGroup.attack()
```

ocurre:

```text
MainGroup.attack()
     ↓
Goblin.attack()
     ↓
Orc.attack()
     ↓
SecondaryGroup.attack()
        ↓
        Goblin.attack()
        ↓
        Orc.attack()
```

---

## Idea principal

El cliente no necesita saber si está trabajando con:

```text
un enemigo
```

o:

```text
un grupo de enemigos
```

Simplemente trabaja contra:

```text
EnemyComponent
```

y llama:

```text
attack()
```

---

## Tests

Los tests comprueban que:

```text
Goblin
Orc
EnemyGroup
```

pueden tratarse como:

```text
EnemyComponent
```

También comprobamos que un `EnemyGroup` puede contener otro `EnemyGroup`.

Esto demuestra la estructura recursiva del patrón.

---

## Cuándo utilizar Composite

Puede ser útil cuando tenemos estructuras jerárquicas como:

```text
carpetas y archivos
menús y submenús
componentes gráficos
organizaciones
escenas de videojuegos
grupos de enemigos
árboles de objetos
```

---

## Cuándo evitarlo

Puede ser innecesario cuando:

- no existe una estructura jerárquica;
- los objetos individuales y los grupos tienen comportamientos totalmente distintos;
- el sistema no necesita tratar ambos de la misma manera.

> [!WARNING]
> Composite puede hacer que el modelo sea demasiado genérico si intentamos obligar a elementos muy diferentes a compartir operaciones que realmente no tienen sentido para todos.

---

## Ventajas

- permite tratar elementos individuales y grupos de la misma manera;
- facilita construir árboles de objetos;
- permite composiciones anidadas;
- reduce lógica especial en el cliente;
- facilita añadir nuevos tipos de componentes.

---

## Inconvenientes

- puede ser difícil restringir qué componentes puede contener un grupo;
- las estructuras pueden crecer bastante;
- puede ocultar diferencias entre objetos individuales y agrupaciones.

---

## Composite vs Bridge

### Bridge

Separa dos dimensiones independientes.

```text
Character
+
AttackStyle
```

### Composite

Permite tratar un elemento individual y una colección de elementos de la misma manera.

```text
Enemy
+
EnemyGroup
```

---

## Regla mental

La pregunta es:

> ¿Quiero tratar igual un elemento individual y un grupo de elementos?

Si la respuesta es sí, Composite puede encajar.

Por ejemplo:

```text
Goblin.attack()

EnemyGroup.attack()
```

Desde el punto de vista del cliente ambos son:

```text
EnemyComponent
```

---

## Palabra clave

```text
ÁRBOL
```

Composite permite construir estructuras jerárquicas donde una rama puede contener otras ramas y hojas.