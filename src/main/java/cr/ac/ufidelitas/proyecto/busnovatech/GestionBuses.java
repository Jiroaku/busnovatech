
package cr.ac.ufidelitas.proyecto.busnovatech;

/**
 *
 * @author samim
 */
import javax.swing.*;
import java.io.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

public class GestionBuses {

    private NodoBus primero; // cabeza de la lista
    private final String ARCHIVO_CONFIG = "config.json";
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public GestionBuses() {
        primero = null;
    }

    public void configurarBuses() {
        int cantidadTotal;

        try {
            cantidadTotal = Integer.parseInt(JOptionPane.showInputDialog(
                    "Ingrese la cantidad total de buses:"));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Debe ingresar un número válido.");
            return;
        }

        if (cantidadTotal < 2) {
            JOptionPane.showMessageDialog(null, "Debe haber al menos 2 buses (1 preferencial y 1 directo).");
            return;
        }

        insertarBus(new Bus("P1", "Preferencial"));
        insertarBus(new Bus("D1", "Directo"));

        int normales = cantidadTotal - 2;
        for (int i = 1; i <= normales; i++) {
            insertarBus(new Bus("N" + i, "Normal"));
        }

        guardarBusesEnConfig();
        JOptionPane.showMessageDialog(null, "Registro de buses completado correctamente.");
    }

    private void insertarBus(Bus nuevoBus) {
        NodoBus nuevo = new NodoBus(nuevoBus);
        if (primero == null) {
            primero = nuevo;
        } else {
            NodoBus actual = primero;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
    }

    private void guardarBusesEnConfig() {
        File archivo = new File(ARCHIVO_CONFIG);
        JsonObject config;

        try {
            if (archivo.exists()) {
                FileReader reader = new FileReader(archivo);
                config = JsonParser.parseReader(reader).getAsJsonObject();
                reader.close();
            } else {
                config = new JsonObject();
            }

            // Convertir la lista enlazada en un JsonArray
            JsonArray busesArray = new JsonArray();
            NodoBus actual = primero;
            while (actual != null) {
                JsonObject busJson = new JsonObject();
                busJson.addProperty("idBus", actual.bus.getIdBus());
                busJson.addProperty("tipo", actual.bus.getTipo());
                busJson.addProperty("estado", actual.bus.getEstado());
                busesArray.add(busJson);
                actual = actual.siguiente;
            }

            config.add("buses", busesArray);

            FileWriter writer = new FileWriter(ARCHIVO_CONFIG);
            gson.toJson(config, writer);
            writer.flush();
            writer.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al guardar los datos de buses: " + e.getMessage());
        }
    }

    public void cargarBusesDesdeConfig() {
        File archivo = new File(ARCHIVO_CONFIG);
        if (!archivo.exists()) {
            return; // No hay configuración previa
        }

        try {
            FileReader reader = new FileReader(archivo);
            JsonObject config = JsonParser.parseReader(reader).getAsJsonObject();
            reader.close();

            if (config.has("buses")) {
                JsonArray busesArray = config.getAsJsonArray("buses");
                primero = null; // Limpiar lista existente

                for (int i = 0; i < busesArray.size(); i++) {
                    JsonObject busJson = busesArray.get(i).getAsJsonObject();
                    String idBus = busJson.get("idBus").getAsString();
                    String tipo = busJson.get("tipo").getAsString();
                    String estado = busJson.get("estado").getAsString();

                    Bus bus = new Bus(idBus, tipo);
                    bus.setEstado(estado);
                    insertarBus(bus);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar buses: " + e.getMessage());
        }
    }

    public void mostrarBuses() {
        if (primero == null) {
            JOptionPane.showMessageDialog(null, "No hay buses registrados.");
            return;
        }

        String texto = "Lista de buses registrados:\n\n";
        NodoBus actual = primero;
        while (actual != null) {
            texto += "ID: " + actual.bus.getIdBus() +
                     " | Tipo: " + actual.bus.getTipo() +
                     " | Estado: " + actual.bus.getEstado() + "\n";
            actual = actual.siguiente;
        }
        JOptionPane.showMessageDialog(null, texto);
    }
}