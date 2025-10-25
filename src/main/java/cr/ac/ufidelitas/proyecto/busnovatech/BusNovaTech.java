package cr.ac.ufidelitas.proyecto.busnovatech;

import javax.swing.JOptionPane;

/**
 *
 * @author jiroaku
 */

//PUSE LA VERSION 2.8.9 DE GSON COMO EL PROFE
public class BusNovaTech {

    public static void main(String[] args) {

        // Configuración inicial del sistema
        ConfiguracionSistema gestorConfig = new ConfiguracionSistema();
        ConfiguracionSistema config = null;

        if (gestorConfig.existeConfiguracion()) {
            config = gestorConfig.cargarConfiguracion();
            if (config == null) {
                config = gestorConfig.ejecutarConfiguracionInicial();
            }
        } else {
            config = gestorConfig.ejecutarConfiguracionInicial();
        }

        if (config != null) {
            gestorConfig.guardarConfiguracion(config);
        }

        // Persona 4: Parte LUNA - Integrar módulos de buses y tiquetes
        // Persona 4: Parte LUNA - Implementar login y menú principal

        /*
        PASOS A IMPLEMENTAR:

        1. CREAR INSTANCIAS DE MÓDULOS:
           - GestionBuses gestorBuses = new GestionBuses();
           - PersistenciaCola persistencia = new PersistenciaCola();
           - ColaPrioridad cola = persistencia.deserializarCola("tiquetes.json");
           - Si cola es null, crear nueva: cola = new ColaPrioridad();

        2. IMPLEMENTAR LOGIN:
           - Pedir usuario y contraseña con JOptionPane
           - Usar config.validarLogin(usuario, contrasena)
           - Si es incorrecto, mostrar mensaje y salir

        3. CREAR MENÚ PRINCIPAL:
           - Menú con 4 opciones: Ver configuración, Gestionar buses, Gestionar tiquetes, Salir
           - Usar do-while para repetir menú
           - Para opción 3, revisar método gestionarTiquetes() en PersistenciaCola

        MÉTODOS DISPONIBLES:
        - config.validarLogin(usuario, contrasena)
        - config.getInformacionCompleta()
        - gestorBuses.mostrarBuses()
        - persistencia.gestionarTiquetes(cola)
        - persistencia.serializarCola(cola, "tiquetes.json")
        */
    }
}