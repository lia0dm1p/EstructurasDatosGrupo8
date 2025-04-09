package es.uah.matcomp.ed.e1.ejerciciosclases.Arboles;

import java.util.ArrayList;
import java.util.List;

public class ArbolBinarioDeBusqueda<T extends Comparable<T>> {
    protected T dato;
    protected ArbolBinarioDeBusqueda<T> izquierda;
    protected ArbolBinarioDeBusqueda<T> derecha;

    public ArbolBinarioDeBusqueda() {
        this.dato = null;
    }

    public ArbolBinarioDeBusqueda(T dato) {
        this.dato = dato;
    }

    // Getter para acceder al valor del nodo actual (lo uso en los tests)
    public T getDato() {
        return dato;
    }

    // Inserta elementos manteniendo el orden del árbol binario de búsqueda
    public void add(T nuevoDato) {
        if (dato == null) {
            dato = nuevoDato;
            return;
        }
        if (nuevoDato.compareTo(dato) < 0) {
            if (izquierda == null) izquierda = new ArbolBinarioDeBusqueda<>();
            izquierda.add(nuevoDato);
        } else {
            if (derecha == null) derecha = new ArbolBinarioDeBusqueda<>();
            derecha.add(nuevoDato);
        }
    }

    public int getGrado() {
        int grado = 0;
        if (izquierda != null && izquierda.dato != null) grado++;
        if (derecha != null && derecha.dato != null) grado++;
        return grado;
    }

    public int getAltura() {
        if (dato == null) return 0;
        int altIzq = (izquierda != null) ? izquierda.getAltura() : 0;
        int altDer = (derecha != null) ? derecha.getAltura() : 0;
        return 1 + Math.max(altIzq, altDer);
    }

    public List<T> getListaDatosNivel(int nivel) {
        List<T> lista = new ArrayList<>();
        recorrerNivel(this, nivel, 0, lista);
        return lista;
    }

    private void recorrerNivel(ArbolBinarioDeBusqueda<T> nodo, int nivelObjetivo, int nivelActual, List<T> lista) {
        if (nodo == null || nodo.dato == null) return;
        if (nivelObjetivo == nivelActual) {
            lista.add(nodo.dato);
        } else {
            recorrerNivel(nodo.izquierda, nivelObjetivo, nivelActual + 1, lista);
            recorrerNivel(nodo.derecha, nivelObjetivo, nivelActual + 1, lista);
        }
    }

    public boolean isArbolHomogeneo() {
        return esHomogeneo(this);
    }

    private boolean esHomogeneo(ArbolBinarioDeBusqueda<T> nodo) {
        if (nodo == null || nodo.dato == null) return true;
        int grado = nodo.getGrado();
        boolean okIzq = (nodo.izquierda == null || nodo.izquierda.getGrado() == grado);
        boolean okDer = (nodo.derecha == null || nodo.derecha.getGrado() == grado);
        return okIzq && okDer && esHomogeneo(nodo.izquierda) && esHomogeneo(nodo.derecha);
    }

    public boolean isArbolCompleto() {
        return esCompleto(this, 0, getAltura());
    }

    private boolean esCompleto(ArbolBinarioDeBusqueda<T> nodo, int nivel, int altura) {
        if (nodo == null || nodo.dato == null) return true;
        if (nodo.izquierda == null && nodo.derecha == null) {
            return nivel == altura - 1;
        }
        if (nodo.izquierda == null || nodo.derecha == null) return false;
        return esCompleto(nodo.izquierda, nivel + 1, altura) &&
                esCompleto(nodo.derecha, nivel + 1, altura);
    }

    public boolean isArbolCasiCompleto() {
        int total = contarNodos(this);
        return esCasiCompleto(this, 0, total);
    }

    private boolean esCasiCompleto(ArbolBinarioDeBusqueda<T> nodo, int index, int total) {
        if (nodo == null || nodo.dato == null) return true;
        if (index >= total) return false;
        return esCasiCompleto(nodo.izquierda, 2 * index + 1, total) &&
                esCasiCompleto(nodo.derecha, 2 * index + 2, total);
    }

    private int contarNodos(ArbolBinarioDeBusqueda<T> nodo) {
        if (nodo == null || nodo.dato == null) return 0;
        return 1 + contarNodos(nodo.izquierda) + contarNodos(nodo.derecha);
    }

    public List<T> getCamino(T destino) {
        List<T> camino = new ArrayList<>();
        buscar(this, destino, camino);
        return camino;
    }

    private boolean buscar(ArbolBinarioDeBusqueda<T> nodo, T destino, List<T> camino) {
        if (nodo == null || nodo.dato == null) return false;
        camino.add(nodo.dato);
        int cmp = destino.compareTo(nodo.dato);
        if (cmp == 0) return true;
        if (cmp < 0 && buscar(nodo.izquierda, destino, camino)) return true;
        if (cmp > 0 && buscar(nodo.derecha, destino, camino)) return true;
        camino.remove(camino.size() - 1);
        return false;
    }

    public ArbolBinarioDeBusqueda<T> getSubArbolIzquierda() {
        return izquierda;
    }

    public ArbolBinarioDeBusqueda<T> getSubArbolDerecha() {
        return derecha;
    }

    public List<T> getListaPreOrden() {
        List<T> lista = new ArrayList<>();
        recorrerPre(this, lista);
        return lista;
    }

    private void recorrerPre(ArbolBinarioDeBusqueda<T> nodo, List<T> lista) {
        if (nodo == null || nodo.dato == null) return;
        lista.add(nodo.dato);
        recorrerPre(nodo.izquierda, lista);
        recorrerPre(nodo.derecha, lista);
    }

    public List<T> getListaPostOrden() {
        List<T> lista = new ArrayList<>();
        recorrerPost(this, lista);
        return lista;
    }

    private void recorrerPost(ArbolBinarioDeBusqueda<T> nodo, List<T> lista) {
        if (nodo == null || nodo.dato == null) return;
        recorrerPost(nodo.izquierda, lista);
        recorrerPost(nodo.derecha, lista);
        lista.add(nodo.dato);
    }

    public List<T> getListaOrdenCentral() {
        List<T> lista = new ArrayList<>();
        recorrerEnOrden(this, lista);
        return lista;
    }

    private void recorrerEnOrden(ArbolBinarioDeBusqueda<T> nodo, List<T> lista) {
        if (nodo == null || nodo.dato == null) return;
        recorrerEnOrden(nodo.izquierda, lista);
        lista.add(nodo.dato);
        recorrerEnOrden(nodo.derecha, lista);
    }
}
