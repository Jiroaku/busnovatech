package cr.ac.ufidelitas.proyecto.busnovatech;

import javax.swing.JOptionPane;

/**
 *
 * @author jiroaku
 */

//PUSE LA VERSION 2.8.9 DE GSON COMO EL PROFE
public class BusNovaTech {

    public static void main(String[] args) {
        // ========================================
        // PERSONA 1 (Andrew): Configuración del sistema
        // ========================================
        ConfiguracionSistema gestorConfig = new ConfiguracionSistema();
        ConfiguracionSistema config = null;

        // Verificar si existe configuración
        if (gestorConfig.existeConfiguracion()) {
            config = gestorConfig.cargarConfiguracion();
            if (config == null) {
                config = gestorConfig.ejecutarConfiguracionInicial();
            }
        } else {
            config = gestorConfig.ejecutarConfiguracionInicial();
        }

        // Guardar configuración
        if (config != null) {
            gestorConfig.guardarConfiguracion(config);
        }

        // ========================================
        // PERSONA 2 (Samuel): Configuración de buses
        // ========================================
        // TODO: Samuel integrará aquí su módulo de buses:
        // - Expandir config.json con detalles de buses específicos
        // - Agregar clases para gestionar buses (preferencial, directo, normales)
        // - Integrar con la configuración base existente
        // - Usar: config.getCantidadBuses(), config.getBusesPreferenciales(), etc.

        // ========================================
        // PERSONA 4 (Luna): Integración e interfaz
        // ========================================
        // TODO: Luna integrará aquí:
        // 1. Login con usuarios de config.json
        //    - Usar: config.validarLogin(usuario, contrasena)
        //    - Usuarios disponibles: config.getUsuario1(), config.getUsuario2()
        // 2. Menú principal con JOptionPane
        //    - Opción 1: Ver configuración del sistema
        //    - Opción 2: Gestionar buses (módulo de Samuel)
        //    - Opción 3: Gestionar tiquetes (módulo de Geral)
        //    - Opción 4: Salir
        // 3. Integración con módulo de tiquetes (Geral)
        //    - Usar: PersistenciaCola para cargar/guardar tiquetes
        //    - Usar: ColaPrioridad para gestionar cola de tiquetes
        //    - Usar: NodoTiquete para crear nuevos tiquetes

        // ========================================
        // PERSONA 3 (Geral): Módulo de tiquetes
        // ========================================
        // NOTA: El código de Geral está comentado para respetar su trabajo
        // Luna puede descomentarlo y usarlo en su integración
        /**
        // Código de prueba del módulo de tiquetes (Geral - Persona 3)
        PersistenciaCola persistencia = new PersistenciaCola();

        //Cargamos la cola si existe
        ColaPrioridad cola = persistencia.deserializarCola("Tiquetes.Json");

        //Agregamos nuevos tiquetes
        cola.encolar(new NodoTiquete("Gerald", 1, 25, 1500, "8:00","2:00","Express","V.I.P" ));
        cola.encolar(new NodoTiquete("Ge", 1, 25, 20.5, "09:00", "10:00", "Standar", "Economico"));
        cola.encolar(new NodoTiquete("Ana", 1, 25, 20.5, "09:00", "10:00", "Normal", "Normal"));

        //Mostramos cola
        System.out.println("Cola de prioridad");
        cola.mostrarCola();

        //Garudamos en Json
        persistencia.serializarCola(cola, "tiquetes.json");
        System.out.println("Tiquetes guardados en json");
        */
    }
}