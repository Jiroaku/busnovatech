
package cr.ac.ufidelitas.proyecto.busnovatech;

import javax.swing.JOptionPane;

/**
 *
 * @author Geral
 */
public class ColaPrioridad {

    private Nodo<NodoTiquete> frente;
    private Nodo<NodoTiquete> fin;

    public ColaPrioridad() {
        this.frente = null;
        this.fin = null;
    }

    //Encolar con la prioridad
    public void encolar(NodoTiquete tiquete) {
        Nodo<NodoTiquete> nuevo = new Nodo<>(tiquete);

        if (frente == null) { //Cola vacia
            frente = fin = nuevo;
            return;
        }

        //Si el nuevo tiene mayor prioridad que el de alfrente
        if (compararPrioridad(nuevo.getDato(), frente.getDato()) > 0) {
            nuevo.setSiguiente(frente);
            frente = nuevo;
            return;
        }

        Nodo<NodoTiquete> actual = frente;
        while (actual.getSiguiente() != null &&
               compararPrioridad(actual.getSiguiente().getDato(), nuevo.getDato()) >= 0) {
            actual = actual.getSiguiente();
        }

        nuevo.setSiguiente(actual.getSiguiente());
        actual.setSiguiente(nuevo);

        if (nuevo.getSiguiente() == null) {
            fin = nuevo;
        }
    }

    private int compararPrioridad(NodoTiquete a, NodoTiquete b) {
        return getPrioridad(a.getTipoBus()) - getPrioridad(b.getTipoBus());
    }

    private int getPrioridad(String tipoBus) {
        switch (tipoBus.toUpperCase()) {
            case "V.I.P": return 3;
            case "NORMAL": return 2;
            case "ECONOMICO": return 1;
            default: return 0;
        }
    }

    //Desencolar
    public NodoTiquete desencolar() {
        if (frente == null) {
            System.err.println("La cola está vacía");
            return null;
        }
        NodoTiquete tiquete = frente.getDato();
        frente = frente.getSiguiente();
        if (frente == null) {
            fin = null;
        }
        return tiquete;
    }

    public boolean estaVacia() {
        return frente == null;
    }

    //Mostrar
    public void mostrarCola() {
        if (frente == null) {
            System.out.println("Cola vacía");
            return;
        }
        Nodo<NodoTiquete> actual = frente;
        while (actual != null) {
            System.out.println(actual.getDato());
            actual = actual.getSiguiente();
        }
    }

    @Override
    public String toString() {
        if (frente == null) return "Cola vacía";
        StringBuilder sb = new StringBuilder();
        Nodo<NodoTiquete> actual = frente;
        while (actual != null) {
            sb.append(actual.getDato());
            actual = actual.getSiguiente();
            if (actual != null) sb.append(" -> ");
        }
        return sb.toString();
    }

    // Creación de tiquetes con interfaz de usuario - Andrew
    public void crearTiquete() {
        try {
            String nombre = JOptionPane.showInputDialog("Nombre del pasajero:");
            if (nombre == null || nombre.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nombre es requerido");
                return;
            }

            int id = Integer.parseInt(JOptionPane.showInputDialog("ID del pasajero:"));
            int edad = Integer.parseInt(JOptionPane.showInputDialog("Edad del pasajero:"));
            double moneda = Double.parseDouble(JOptionPane.showInputDialog("Monto a pagar:"));
            String horaCompra = JOptionPane.showInputDialog("Hora de compra (HH:MM):");
            String horaAbordaje = JOptionPane.showInputDialog("Hora de abordaje (HH:MM):");
            String servicio = JOptionPane.showInputDialog("Tipo de servicio (VIP/Regular/Carga/Ejecutivo):");
            String tipoBus = JOptionPane.showInputDialog("Tipo de bus (P/D/N):");

            NodoTiquete nuevoTiquete = new NodoTiquete(nombre, id, edad, moneda,
                                                      horaCompra, horaAbordaje, servicio, tipoBus);
            this.encolar(nuevoTiquete);

            JOptionPane.showMessageDialog(null, "Tiquete creado exitosamente");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error en los datos ingresados");
        }
    }
}
