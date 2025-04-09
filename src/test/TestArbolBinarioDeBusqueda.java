package test;

import es.uah.matcomp.ed.e1.ejerciciosclases.Arboles.ArbolBinarioDeBusquedaEnteros;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TestArbolBinarioDeBusqueda {

    private ArbolBinarioDeBusquedaEnteros arbol;

    /*
    Utilizamos @BeforeEach para inicializar o resetear objetos que cada test necesita.
    Su uso es especialmente útil para evitar la duplicación de código y asegurar que
    cada prueba comience con un estado limpio y controlado. Esta práctica está incentivada
    por fuentes reconocidas como la JUnit 5 User Guide, el artículo Introduction to JUnit 5
    de Baeldung y numerosas respuestas de expertos en Stack Overflow, donde múltiples hilos
    recomiendan explícitamente el uso de @BeforeEach para garantizar entornos de prueba
    consistentes.
     */
    @BeforeEach
    void setUp() {
        arbol = new ArbolBinarioDeBusquedaEnteros();
        arbol.add(10);
        arbol.add(5);
        arbol.add(15);
        arbol.add(3);
        arbol.add(7);
        arbol.add(12);
        arbol.add(18);
    }

    @Test
    void testAddYGetListaOrdenCentral() {
        assertEquals(List.of(3, 5, 7, 10, 12, 15, 18), arbol.getListaOrdenCentral());
    }

    @Test
    void testGetGrado() {
        assertEquals(2, arbol.getGrado()); // nodo raíz con 2 hijos
    }

    @Test
    void testGetAltura() {
        assertEquals(3, arbol.getAltura());
    }

    @Test
    void testGetListaDatosNivel() {
        assertEquals(List.of(10), arbol.getListaDatosNivel(0));
        assertEquals(List.of(5, 15), arbol.getListaDatosNivel(1));
        assertEquals(List.of(3, 7, 12, 18), arbol.getListaDatosNivel(2));
    }

    @Test
    void testIsArbolHomogeneo() {
        assertFalse(arbol.isArbolHomogeneo()); // no todos los nodos tienen mismo número de hijos
    }

    @Test
    void testIsArbolCompleto() {
        assertTrue(arbol.isArbolCompleto());
    }

    @Test
    void testIsArbolCasiCompleto() {
        assertTrue(arbol.isArbolCasiCompleto());
    }

    @Test
    void testGetCamino() {
        assertEquals(List.of(10, 15, 12), arbol.getCamino(12));
    }

    @Test
    void testGetListaPreOrden() {
        assertEquals(List.of(10, 5, 3, 7, 15, 12, 18), arbol.getListaPreOrden());
    }

    @Test
    void testGetListaPostOrden() {
        assertEquals(List.of(3, 7, 5, 12, 18, 15, 10), arbol.getListaPostOrden());
    }

    @Test
    void testGetSuma() {
        assertEquals(10 + 5 + 15 + 3 + 7 + 12 + 18, arbol.getSuma());
    }
}

