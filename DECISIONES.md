## ADR-002: Equipo como clase abstracta + interfaz Mantenible (CP2)
**Fecha:** 2026-10-19

**Contexto:** Todo equipo necesita mantenimiento periódico, pero el intervalo
depende del tipo (eléctrico: 90 días; mecánico: 30). Además, en el dominio no
existe un "equipo genérico": siempre es de un tipo concreto.

**Decisión:**
- `Equipo` es una **clase abstracta**: define la **identidad y el estado
  compartido** (codigo, fechaInstalacion) y no puede **instanciarse**.
- `Mantenible` es una **interfaz**: define una **capacidad** (tener mantenimiento
  programado) mediante el **contrato** `diasEntreMantenimientos()` y un
  **método default** `proximoMantenimiento()` con la lógica común.
- Cada subclase **implementa** su propio intervalo; el cálculo se resuelve por
  **polimorfismo** (**dynamic dispatch**).

**Alternativas descartadas:**
- `Mantenible` como clase abstracta: Java solo permite **herencia simple**;
  otros tipos (vehículos, instalaciones) no podrían ser mantenibles sin
  heredar de `Equipo`.
- `Equipo` como **clase sellada** (`sealed`, Java 17+): Hibernate genera
  **proxies** que extienden las entidades para la **carga lazy**; una clase
  sellada lo impide.

**Consecuencias:**
- El intervalo hoy es un valor fijo por tipo. Evolucionará a un **dato
  configurable** (por equipo o por tipo) sin cambiar la **firma** del método,
  gracias al **encapsulamiento**.