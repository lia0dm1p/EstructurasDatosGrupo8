package es.uah.matcomp.ed.e1.ejerciciosclases.Arboles;

public class ArbolBinarioDeBusquedaEnteros extends ArbolBinarioDeBusqueda<Integer> {

    public ArbolBinarioDeBusquedaEnteros() {
        super();
    }

    public ArbolBinarioDeBusquedaEnteros(Integer dato) {
        super(dato);
    }

    // Insertar un número entero en el árbol (alias de add)
    public void insertar(int valor) {
        add(valor);
    }

    // Devuelve el valor almacenado en la raíz
    public int getRaiz() {
        return (this.getDato() != null) ? this.getDato() : 0;
    }

    // Suma recursiva de todos los elementos del árbol
    public int getSuma() {
        return sumar(this);
    }

    private int sumar(ArbolBinarioDeBusqueda<Integer> nodo) {
        if (nodo == null || nodo.getDato() == null) return 0;
        int valor = nodo.getDato();
        return valor + sumar(nodo.getSubArbolIzquierda()) + sumar(nodo.getSubArbolDerecha());
    }

    // Devuelve una copia del subárbol izquierdo
    public ArbolBinarioDeBusquedaEnteros getSubarbolIzquierdo() {
        ArbolBinarioDeBusqueda<Integer> sub = getSubArbolIzquierda();
        if (sub == null || sub.getDato() == null) return null;
        ArbolBinarioDeBusquedaEnteros copia = new ArbolBinarioDeBusquedaEnteros(sub.getDato());
        copiarSubarbol(sub, copia);
        return copia;
    }

    // Devuelve una copia del subárbol derecho
    public ArbolBinarioDeBusquedaEnteros getSubarbolDerecho() {
        ArbolBinarioDeBusqueda<Integer> sub = getSubArbolDerecha();
        if (sub == null || sub.getDato() == null) return null;
        ArbolBinarioDeBusquedaEnteros copia = new ArbolBinarioDeBusquedaEnteros(sub.getDato());
        copiarSubarbol(sub, copia);
        return copia;
    }

    // Copia recursivamente los valores del subárbol origen al destino
    private void copiarSubarbol(ArbolBinarioDeBusqueda<Integer> origen, ArbolBinarioDeBusquedaEnteros destino) {
        if (origen.getSubArbolIzquierda() != null && origen.getSubArbolIzquierda().getDato() != null) {
            destino.add(origen.getSubArbolIzquierda().getDato());
            copiarSubarbol(origen.getSubArbolIzquierda(), destino);
        }
        if (origen.getSubArbolDerecha() != null && origen.getSubArbolDerecha().getDato() != null) {
            destino.add(origen.getSubArbolDerecha().getDato());
            copiarSubarbol(origen.getSubArbolDerecha(), destino);
        }
    }
}

