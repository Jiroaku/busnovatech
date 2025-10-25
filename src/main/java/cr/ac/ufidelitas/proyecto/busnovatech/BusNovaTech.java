package cr.ac.ufidelitas.proyecto.busnovatech;

/**
 *
 * @author jiroaku
 */

//PUSE LA VERSION 2.8.9 DE GSON COMO EL PROFE
public class BusNovaTech {

    public static void main(String[] args) {

        //Prueba de que Gestor de tiquetes funciona
        /** GestorTiquetes gestor = new GestorTiquetes();

        Tiquete t1 = new Tiquete("Juan", "001", 25, "₡", "VIP", "P");
        Tiquete t2 = new Tiquete("Ana", "002", 40, "$", "Regular", "N");
        Tiquete t3 = new Tiquete("Luis", "003", 35, "₡", "Ejecutivo", "D");

        gestor.agregarTiquete(t1);
        gestor.agregarTiquete(t2);
        gestor.agregarTiquete(t3);

        gestor.mostrarCola();*/

        


        /**
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
        *persistencia.serializarCola(cola, "tiquetes.json");
        *System.out.println("Tiquetes guardados en json");
        */
                
        

    }
}
