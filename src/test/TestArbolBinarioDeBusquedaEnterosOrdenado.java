package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import es.uah.matcomp.ed.e1.ejerciciosclases.Arboles.ArbolBinarioDeBusquedaEnteros;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.ArrayList;

public class TestArbolBinarioDeBusquedaEnterosOrdenado {

    @Test
    void testOperacionesArbol() {
        // 1. Crear el árbol e insertar los números del 0 al 128 (inclusive) en orden ascendente
        ArbolBinarioDeBusquedaEnteros arbol = new ArbolBinarioDeBusquedaEnteros();
        for (int i = 0; i <= 128; i++) {
            arbol.insertar(i);
        }

        // 2. Calcular la suma total de los nodos con getSuma()
        int sumaTotal = arbol.getSuma();

        // 3. Verificar que la suma obtenida es igual a la suma de los elementos
        //    en los recorridos Preorden, Inorden (orden central) y Postorden.
        List<Integer> preOrden = arbol.getListaPreOrden();
        List<Integer> inOrden  = arbol.getListaOrdenCentral();
        List<Integer> postOrden = arbol.getListaPostOrden();
        // Sumar los elementos de cada lista de recorrido
        int sumaPre  = preOrden.stream().mapToInt(Integer::intValue).sum();
        int sumaIn   = inOrden.stream().mapToInt(Integer::intValue).sum();
        int sumaPost = postOrden.stream().mapToInt(Integer::intValue).sum();
        // Comparar cada suma de recorrido con la suma total
        assertEquals(sumaTotal, sumaPre,  "La suma en Preorden debe coincidir con la suma total");
        assertEquals(sumaTotal, sumaIn,   "La suma en Inorden debe coincidir con la suma total");
        assertEquals(sumaTotal, sumaPost, "La suma en Postorden debe coincidir con la suma total");

        // 5. Verificar la altura del árbol resultante
        int altura = arbol.getAltura();
        // En un árbol degenerado con 129 nodos, la altura esperada es 129 (nodos en el camino más largo)
        assertEquals(129, altura, "La altura del árbol debería ser 129");

        // 6. Obtener el camino hasta el valor 110 y verificar su contenido
        List<Integer> camino110 = arbol.getCamino(110);
        // Construir la lista esperada de valores desde 0 hasta 110
        List<Integer> caminoEsperado = new ArrayList<>();
        for (int v = 0; v <= 110; v++) {
            caminoEsperado.add(v);
        }
        // Comparar listas (contenido del camino)
        assertEquals(caminoEsperado, camino110,
                "El camino desde la raíz hasta 110 debería contener [0, 1, 2, ..., 110]");

        // 7. Verificar que la longitud del camino hasta 110 corresponde al número de saltos
        // (número de nodos en el camino menos uno)
        int numeroSaltos = camino110.size() - 1;
        assertEquals(110, numeroSaltos,
                "El número de saltos hasta 110 debería ser 110 (camino de longitud 111)");
    }
}
