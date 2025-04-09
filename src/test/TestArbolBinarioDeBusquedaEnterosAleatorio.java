package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import es.uah.matcomp.ed.e1.ejerciciosclases.Arboles.ArbolBinarioDeBusquedaEnteros;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class TestArbolBinarioDeBusquedaEnterosAleatorio {

    @Test
    void testInsercionAleatoria() {
        List<Integer> valores = new ArrayList<>();
        for (int i = 0; i <= 128; i++) {
            valores.add(i);
        }
        Collections.shuffle(valores, new Random(42));
        ArbolBinarioDeBusquedaEnteros arbol = new ArbolBinarioDeBusquedaEnteros();
        for (int valor : valores) {
            arbol.add(valor);
        }

        int suma = arbol.getSuma();
        assertEquals(8256, suma);

        List<Integer> preorden = arbol.getListaPreOrden();
        List<Integer> inorden = arbol.getListaOrdenCentral();
        List<Integer> postorden = arbol.getListaPostOrden();

        int sumaPre = preorden.stream().mapToInt(Integer::intValue).sum();
        int sumaIn = inorden.stream().mapToInt(Integer::intValue).sum();
        int sumaPost = postorden.stream().mapToInt(Integer::intValue).sum();

        assertEquals(suma, sumaPre);
        assertEquals(suma, sumaIn);
        assertEquals(suma, sumaPost);

        int altura = arbol.getAltura();
        System.out.println("Altura (aleatorio): " + altura);

        List<Integer> camino110 = arbol.getCamino(110);
        assertEquals(110, (int) camino110.get(camino110.size() - 1));
        System.out.println("Camino a 110: " + camino110);
    }
}
