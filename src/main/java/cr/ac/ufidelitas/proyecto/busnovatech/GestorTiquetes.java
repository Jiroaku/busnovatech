
package cr.ac.ufidelitas.proyecto.busnovatech;

/**
 *
 * @author samim
 */

import java.io.*;

public class GestorTiquetes {
    private ColaPrioridadTiquetes cola = new ColaPrioridadTiquetes();

    public void agregarTiquete(Tiquete t) {
        cola.insertar(t);
        guardarEnArchivo();
    }

    public void guardarEnArchivo() {
        try (FileWriter fw = new FileWriter("tiquetes.json")) {
            fw.write(cola.aJSON());
            fw.flush();
            System.out.println("Tiquetes guardados en tiquetes.json");
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }

    public void mostrarCola() {
        System.out.println("=== Cola de Tiquetes ===");
        if (cola.estaVacia()) {
            System.out.println("No hay tiquetes registrados.");
        } else {
            System.out.println(cola.aJSON());
        }
    }
}
