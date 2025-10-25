
package cr.ac.ufidelitas.proyecto.busnovatech;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.JOptionPane;
/**
 *
 * @author Geral
 */
//Viene de la ColaPrioridad
public class PersistenciaCola {

    //Guardamos la cola en JSON
    public void serializarCola(ColaPrioridad cola, String archivo) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(archivo)) {
            gson.toJson(cola, writer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Cargamos la cola desde JSON
    public ColaPrioridad deserializarCola(String archivo) {
        Gson gson = new GsonBuilder().create();
        try (FileReader reader = new FileReader(archivo)) {
            return gson.fromJson(reader, ColaPrioridad.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Gestión de tiquetes con interfaz de usuario - Andrew
    public void gestionarTiquetes(ColaPrioridad cola) {
        int opcion;
        do {
            String menu = "=== GESTIÓN DE TIQUETES ===\n" +
                         "1. Crear nuevo tiquete\n" +
                         "2. Ver cola de tiquetes\n" +
                         "3. Guardar tiquetes\n" +
                         "4. Volver al menú principal";

            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
            } catch (NumberFormatException e) {
                opcion = 0;
            }

            switch(opcion) {
                case 1:
                    cola.crearTiquete();
                    break;
                case 2:
                    cola.mostrarCola();
                    break;
                case 3:
                    this.serializarCola(cola, "tiquetes.json");
                    JOptionPane.showMessageDialog(null, "Tiquetes guardados exitosamente");
                    break;
                case 4:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida");
                    break;
            }
        } while(opcion != 4);
    }
}
