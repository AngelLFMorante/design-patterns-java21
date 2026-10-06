# Prototype

## ¿Qué problema resuelve?

Prototype se utiliza cuando queremos crear un nuevo objeto **copiando otro objeto existente**.

La idea no es compartir la misma referencia, sino crear una instancia nueva con el mismo estado inicial.

---

## Ejemplo utilizado

En este ejemplo trabajamos con:

```text
Enemy
```

que contiene:

```text
type
health
damage
weapon
```

Por ejemplo:

```text
Enemy
├── type = "goblin"
├── health = 100
├── damage = 35
└── weapon = "Sword"
```

---

## Copiar referencia no es copiar objeto

Si hacemos:

```java
Enemy enemy2 = enemy1;
```

no estamos creando un enemigo nuevo.

Tenemos dos referencias al mismo objeto:

```text
enemy1 ─┐
        ├──> Enemy #1
enemy2 ─┘
```

Si una referencia modifica el objeto, la otra verá el mismo cambio.

---

## Prototype

Con Prototype buscamos:

```text
enemy1 ───> Enemy #1
enemy2 ───> Enemy #2
```

Los dos objetos empiezan con los mismos datos, pero son instancias independientes.

---

## Método copy()

Nuestro prototipo puede copiarse mediante:

```java
public Enemy copy() {
    return new Enemy(
            this.type,
            this.health,
            this.damage,
            this.weapon
    );
}
```

El objeto actual sirve como modelo para construir otro.

---

## Flujo

```text
Enemy original
      ↓
    copy()
      ↓
new Enemy(...)
      ↓
Enemy copia
```

El resultado es:

```text
mismos datos
+
distinta instancia
```

---

## Ejemplo

```java
Enemy enemy = new Enemy(
        "goblin",
        100,
        35,
        "Sword"
);

Enemy copy = enemy.copy();
```

La salida puede ser:

```text
Enemy = Enemy{type='goblin', health=100, damage=35, weapon='Sword'}
Copy = Enemy{type='goblin', health=100, damage=35, weapon='Sword'}
¿Es la misma instancia? false
```

---

## ¿Por qué `==` devuelve false?

Porque:

```java
enemy == copy
```

comprueba si ambas variables apuntan al mismo objeto.

En Prototype queremos precisamente que sean objetos diferentes.

Por eso esperamos:

```text
false
```

---

## ¿Y equals()?

Si una clase no sobrescribe `equals()`, Java utiliza por defecto una comparación basada en identidad.

Por eso:

```java
enemy.equals(copy)
```

también puede devolver:

```text
false
```

aunque ambos objetos tengan los mismos datos.

> [!NOTE]
> Que dos objetos tengan el mismo estado no significa automáticamente que `equals()` vaya a considerarlos iguales. Depende de cómo esté implementado dicho método.

---

## Tests

Comprobamos dos propiedades importantes.

### Distinta instancia

```java
assertNotSame(enemy, copy);
```

Esto confirma que Prototype ha creado otro objeto.

### Mismos datos

En este ejemplo educativo comprobamos:

```java
assertEquals(
        enemy.toString(),
        copy.toString()
);
```

Así verificamos que ambos objetos contienen los mismos valores iniciales.

> [!TIP]
> En un proyecto real sería preferible comparar propiedades concretas o implementar correctamente `equals()` cuando tenga sentido para el dominio.

---

## Cuándo utilizar Prototype

Puede resultar útil cuando:

- crear un objeto desde cero es costoso;
- existe una configuración inicial compleja;
- necesitamos muchas variantes parecidas;
- queremos partir de una plantilla existente;
- queremos evitar repetir procesos de inicialización.

Ejemplos:

```text
enemigos de videojuegos
documentos plantilla
configuraciones complejas
objetos gráficos
escenarios preconfigurados
```

---

## Cuándo evitarlo

Puede no aportar valor cuando:

- el objeto es muy sencillo de construir;
- copiarlo es más complejo que crearlo;
- contiene relaciones internas difíciles de duplicar;
- no necesitamos crear objetos similares.

---

## Shallow copy y Deep copy

Existe una diferencia importante cuando un objeto contiene otros objetos.

### Shallow copy

Copia el objeto principal, pero puede mantener referencias compartidas a objetos internos.

```text
Enemy original ───> Weapon #1
Enemy copia    ───> Weapon #1
```

Ambos comparten el mismo `Weapon`.

### Deep copy

También copia los objetos internos.

```text
Enemy original ───> Weapon #1
Enemy copia    ───> Weapon #2
```

Ahora todo es independiente.

> [!IMPORTANT]
> En nuestro ejemplo actual utilizamos `String`, `int` y otros valores sencillos, por lo que todavía no necesitamos enfrentarnos al problema de copias profundas.

---

## Prototype y Cloneable

Java dispone de:

```java
Cloneable
```

y del método:

```java
clone()
```

pero pueden resultar poco claros y tienen varias particularidades históricas.

En este proyecto utilizamos:

```java
copy()
```

porque hace explícita la intención:

```text
quiero crear una copia de este objeto
```

y nos permite aprender Prototype sin añadir complejidad innecesaria.

---

## Ventajas

- permite reutilizar objetos existentes como plantilla;
- evita repetir inicializaciones complejas;
- facilita crear variantes de un objeto;
- desacopla parcialmente la creación del tipo concreto.

---

## Inconvenientes

- copiar objetos complejos puede ser difícil;
- hay que decidir entre shallow copy y deep copy;
- las relaciones internas pueden complicar la copia;
- mantener la lógica de copia puede requerir trabajo adicional.

---

## Regla mental

Pregunta:

> ¿Ya tengo un objeto parecido al que quiero crear?

Si la respuesta es sí, quizá puedas copiarlo en lugar de reconstruirlo desde cero.

Puedes recordar Prototype como:

```text
TENGO UNO
   ↓
LO COPIO
   ↓
TENGO OTRO
```