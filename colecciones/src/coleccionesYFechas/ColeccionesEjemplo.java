package coleccionesYFechas;

import java.util.*;

public class ColeccionesEjemplo {
    public static void main(String[] args) {
        // Crear un TreeMap
        TreeMap<String, Integer> treeMap = new TreeMap<>();

        // Agregar elementos al TreeMap
        treeMap.put("Manzanas", 10);
        treeMap.put("Naranjas", 15);
        treeMap.put("Plátanos", 8);
        treeMap.put("Uvas", 20);

        // Acceder a los elementos del TreeMap
        System.out.println("Cantidad de Manzanas: " + treeMap.get("Manzanas"));

        // Iterar sobre los elementos del TreeMap
        System.out.println("Elementos del TreeMap:");
        for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
