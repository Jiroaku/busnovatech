# BusNovaTech - Sistema de Gestión de Terminales y Servicios de Buses

## Información del Proyecto

**Curso:** Estructuras de Datos
**Universidad:** Universidad Fidélitas
**Profesor:** Kenneth Artavia A.
**Grupo:** 6
**Versión:** 1.0-SNAPSHOT

## Descripción General Primera Entrega

BusNovaTech es un sistema de gestión inteligente para terminales de buses que implementa estructuras de datos dinámicas para la administración de buses, tiquetes y configuración del sistema. El proyecto desarrolla los módulos 1.0 (Configuración de Estructuras de Datos) y 1.1 (Creación de Tiquetes) utilizando únicamente clases básicas de Java y manejo de archivos JSON.

## Equipo de Desarrollo

| Integrante | Módulo | Responsabilidad |
|------------|--------|-----------------|
| **Jeferson Andrew Fuentes García** | 1.0 | Configuración del sistema y persistencia |
| **Samuel Alonso Mena Garro** | 1.0 | Gestión de buses |
| **Gerald Obed Herra Fonseca** | 1.1 | Gestión de tiquetes |
| **Luna Delgado Durango** | 1.1 | Integración de módulos, login y menú principal |

## Arquitectura del Sistema

### Estructura de Clases

| Clase | Propósito | Autor |
|-------|-----------|-------|
| `BusNovaTech` | Clase principal y controlador del flujo | Luna |
| `ConfiguracionSistema` | Gestión de configuración y persistencia JSON | Andrew |
| `GestionBuses` | Administración de buses y tipos | Samuel |
| `ColaPrioridad` | Implementación de cola de prioridad para tiquetes | Gerald |
| `NodoTiquete` | Estructura de datos para tiquetes | Gerald |
| `Nodo<T>` | Nodo genérico para estructuras enlazadas | Gerald |
| `NodoBus` | Nodo específico para lista de buses | Samuel |
| `Bus` | Entidad de bus con propiedades básicas | Samuel |
| `PersistenciaCola` | Serialización/deserialización de tiquetes | Gerald |

## Módulos Implementados

### Módulo 1.0 - Configuración de Estructuras de Datos

**Objetivo:** Configurar el entorno inicial del sistema y persistir la información en `config.json`.

#### Funcionalidades Implementadas

| Funcionalidad | Descripción | Estado |
|---------------|-------------|--------|
| Detección de configuración | Verifica existencia de `config.json` | ✅ |
| Configuración inicial | Registro de terminal, buses y usuarios | ✅ |
| Validación de buses | 1 preferencial, 1 directo, resto normales | ✅ |
| Gestión de usuarios | Sistema de autenticación básico | ✅ |
| Persistencia JSON | Guardado y carga de configuración | ✅ |

#### Datos Manejados
- Nombre de la terminal
- Cantidad total de buses (dinámico)
- Distribución de tipos de buses
- Usuarios y contraseñas del sistema

### Módulo 1.1 - Creación de Tiquetes

**Objetivo:** Gestionar la creación de tiquetes con colas de prioridad según el tipo de servicio y bus.

#### Funcionalidades Implementadas

| Funcionalidad | Descripción | Estado |
|---------------|-------------|--------|
| Creación de tiquetes | Interfaz para registro de pasajeros | ✅ |
| Cola de prioridad | Organización por tipo de bus | ✅ |
| Validación de datos | Campos obligatorios y formato | ✅ |
| Persistencia JSON | Guardado en `tiquetes.json` | ✅ |
| Gestión de tiquetes | Menú para administrar tiquetes | ✅ |

#### Estructura del Tiquete
- **Nombre:** Identificación del pasajero
- **ID:** Identificador único numérico
- **Edad:** Edad del pasajero
- **Moneda:** Monto a pagar (double)
- **Hora de compra:** Timestamp de compra
- **Hora de abordaje:** Timestamp de abordaje (inicialmente -1)
- **Servicio:** Tipo de servicio (VIP, Regular, Carga, Ejecutivo)
- **Tipo de bus:** Clasificación (P, D, N)

## Sistema de Prioridades

La cola de prioridad implementada organiza los tiquetes según el siguiente criterio:

| Prioridad | Tipo de Bus | Valor |
|-----------|-------------|-------|
| Alta | V.I.P | 3 |
| Media | Normal | 2 |
| Baja | Económico | 1 |

## Flujo del Sistema

1. **Inicialización:** Verificación de configuración existente
2. **Configuración:** Si no existe, ejecuta configuración inicial
3. **Autenticación:** Login con usuarios del sistema
4. **Menú Principal:** Acceso a funcionalidades del sistema
5. **Gestión:** Administración de buses y tiquetes
6. **Persistencia:** Guardado automático de datos

## Tecnologías Utilizadas

- **Java 24:** Lenguaje de programación principal
- **Maven:** Gestión de dependencias y construcción
- **Gson 2.8.9:** Serialización/deserialización JSON
- **Swing (JOptionPane):** Interfaz de usuario
- **Estructuras de Datos:** Listas enlazadas y colas de prioridad

## Estructura de Archivos

```
src/main/java/cr/ac/ufidelitas/proyecto/busnovatech/
├── BusNovaTech.java          # Clase principal
├── ConfiguracionSistema.java # Módulo 1.0 - Configuración
├── GestionBuses.java         # Módulo 1.0 - Gestión de buses
├── ColaPrioridad.java        # Módulo 1.1 - Cola de prioridad
├── NodoTiquete.java          # Módulo 1.1 - Estructura de tiquete
├── Nodo.java                 # Nodo genérico para estructuras
├── NodoBus.java              # Nodo específico para buses
├── Bus.java                  # Entidad de bus
└── PersistenciaCola.java     # Módulo 1.1 - Persistencia
```

## Archivos de Datos

| Archivo | Propósito | Formato |
|---------|-----------|---------|
| `config.json` | Configuración del sistema | JSON |
| `tiquetes.json` | Cola de tiquetes persistente | JSON |


## Características Técnicas

### Estructuras de Datos Implementadas
- **Lista Enlazada:** Para gestión de buses
- **Cola de Prioridad:** Para organización de tiquetes
- **Nodos Genéricos:** Para flexibilidad en estructuras

### Patrones de Diseño
- **Separación de Responsabilidades:** Cada clase tiene un propósito específico
- **Persistencia de Datos:** Serialización JSON para mantener estado
- **Interfaz de Usuario:** Menús interactivos con JOptionPane

### Validaciones Implementadas
- Verificación de configuración existente
- Validación de credenciales de usuario
- Control de tipos de buses según reglas de negocio
- Validación de datos de entrada en tiquetes

## Estado del Proyecto

**Módulo 1.0:** ✅ Completado
**Módulo 1.1:** ✅ Completado
**Integración:** ✅ Completada
**Persistencia:** ✅ Implementada
**Interfaz de Usuario:** ✅ Funcional

## Notas de Desarrollo

- El sistema utiliza únicamente librerías básicas de Java y Gson para JSON
- No se emplean frameworks externos, cumpliendo con los requisitos académicos
- La implementación sigue principios de programación orientada a objetos
- El código está documentado con comentarios explicativos
- Se implementó manejo de errores básico para robustez del sistema

---

**Desarrollado para el curso de Estructuras de Datos - Universidad Fidélitas**
**Semestre 2024 - Grupo 6**
