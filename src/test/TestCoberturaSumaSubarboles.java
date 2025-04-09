package test;

import es.uah.matcomp.ed.e1.ejerciciosclases.Arboles.ArbolBinarioDeBusquedaEnteros;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCoberturaSumaSubarboles {

    @Test
    void testTodosLosCasosDeSubarboles() {
        // Caso 1: subIzq == null, subDer == null
        ArbolBinarioDeBusquedaEnteros arbol1 = new ArbolBinarioDeBusquedaEnteros();
        arbol1.insertar(10);
        int sumaIzq1 = (arbol1.getSubarbolIzquierdo() != null ? arbol1.getSubarbolIzquierdo().getSuma() : 0);
        int sumaDer1 = (arbol1.getSubarbolDerecho() != null ? arbol1.getSubarbolDerecho().getSuma() : 0);
        assertEquals(10, 10 + sumaIzq1 + sumaDer1);

        // Caso 2: subIzq == null, subDer != null
        ArbolBinarioDeBusquedaEnteros arbol2 = new ArbolBinarioDeBusquedaEnteros();
        arbol2.insertar(10);
        arbol2.insertar(15);
        int sumaIzq2 = (arbol2.getSubarbolIzquierdo() != null ? arbol2.getSubarbolIzquierdo().getSuma() : 0);
        int sumaDer2 = (arbol2.getSubarbolDerecho() != null ? arbol2.getSubarbolDerecho().getSuma() : 0);
        assertEquals(25, 10 + sumaIzq2 + sumaDer2);

        // Caso 3: subIzq != null, subDer == null
        ArbolBinarioDeBusquedaEnteros arbol3 = new ArbolBinarioDeBusquedaEnteros();
        arbol3.insertar(10);
        arbol3.insertar(5);
        int sumaIzq3 = (arbol3.getSubarbolIzquierdo() != null ? arbol3.getSubarbolIzquierdo().getSuma() : 0);
        int sumaDer3 = (arbol3.getSubarbolDerecho() != null ? arbol3.getSubarbolDerecho().getSuma() : 0);
        assertEquals(15, 10 + sumaIzq3 + sumaDer3);

        // Caso 4: subIzq != null, subDer != null
        ArbolBinarioDeBusquedaEnteros arbol4 = new ArbolBinarioDeBusquedaEnteros();
        arbol4.insertar(10);
        arbol4.insertar(5);
        arbol4.insertar(15);
        int sumaIzq4 = (arbol4.getSubarbolIzquierdo() != null ? arbol4.getSubarbolIzquierdo().getSuma() : 0);
        int sumaDer4 = (arbol4.getSubarbolDerecho() != null ? arbol4.getSubarbolDerecho().getSuma() : 0);
        assertEquals(30, 10 + sumaIzq4 + sumaDer4);
    }
}
