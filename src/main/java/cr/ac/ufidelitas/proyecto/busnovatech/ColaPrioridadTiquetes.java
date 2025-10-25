
package cr.ac.ufidelitas.proyecto.busnovatech;

/**
 *
 * @author samim
 */
public class ColaPrioridadTiquetes {
    private Nodo primero;

    private class Nodo {
        Tiquete tiquete;
        Nodo siguiente;

        Nodo(Tiquete t) { this.tiquete = t; }
    }

    public void insertar(Tiquete nuevo) {
        Nodo nodo = new Nodo(nuevo);

        if (primero == null || nuevo.obtenerPrioridad() < primero.tiquete.obtenerPrioridad()) {
            nodo.siguiente = primero;
            primero = nodo;
        } else {
            Nodo actual = primero;
            while (actual.siguiente != null && 
                   actual.siguiente.tiquete.obtenerPrioridad() <= nuevo.obtenerPrioridad()) {
                actual = actual.siguiente;
            }
            nodo.siguiente = actual.siguiente;
            actual.siguiente = nodo;
        }
    }

    public Tiquete atender() {
        if (primero == null) return null;
        Tiquete t = primero.tiquete;
        primero = primero.siguiente;
        return t;
    }

    public boolean estaVacia() {
        return primero == null;
    }

    public String aJSON() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Nodo actual = primero;
        while (actual != null) {
            sb.append(actual.tiquete.toString());
            if (actual.siguiente != null) sb.append(",");
            actual = actual.siguiente;
        }
        sb.append("]");
        return sb.toString();
    }
}
