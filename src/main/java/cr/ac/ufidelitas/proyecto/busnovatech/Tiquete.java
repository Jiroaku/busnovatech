
package cr.ac.ufidelitas.proyecto.busnovatech;

/**
 *
 * @author samim
 */

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Tiquete {
    private String nombre;
    private String id;
    private int edad;
    private String moneda; // ₡ o $
    private String horaCompra;
    private String horaAbordaje; // "-1" hasta que aborde
    private String servicio; // VIP, Regular, Carga, Ejecutivo
    private String tipoBus; // P, D o N

    public Tiquete(String nombre, String id, int edad, String moneda, String servicio, String tipoBus) {
        this.nombre = nombre;
        this.id = id;
        this.edad = edad;
        this.moneda = moneda;
        this.servicio = servicio;
        this.tipoBus = tipoBus;
        this.horaCompra = obtenerHoraActual();
        this.horaAbordaje = "-1";
    }

    private String obtenerHoraActual() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.now().format(dtf);
    }

    public int obtenerPrioridad() {
        switch (servicio.toUpperCase()) {
            case "VIP": return 1;
            case "EJECUTIVO": return 2;
            case "REGULAR": return 3;
            case "CARGA": return 4;
            default: return 5;
        }
    }

    @Override
    public String toString() {
        return "{ \"nombre\": \"" + nombre + "\", \"id\": \"" + id + "\", \"edad\": " + edad +
                ", \"moneda\": \"" + moneda + "\", \"horaCompra\": \"" + horaCompra +
                "\", \"horaAbordaje\": \"" + horaAbordaje + "\", \"servicio\": \"" + servicio +
                "\", \"tipoBus\": \"" + tipoBus + "\" }";
    }

    // Getters
    public String getNombre() { return nombre; }
    public String getId() { return id; }
    public int getEdad() { return edad; }
    public String getMoneda() { return moneda; }
    public String getHoraCompra() { return horaCompra; }
    public String getHoraAbordaje() { return horaAbordaje; }
    public String getServicio() { return servicio; }
    public String getTipoBus() { return tipoBus; }
}
