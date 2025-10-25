
package cr.ac.ufidelitas.proyecto.busnovatech;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileReader;
import java.io.FileWriter;
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
}
