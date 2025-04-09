# EstructurasDatosGrupo8
Trabajo de Estructuras de Datos por: Marina Sancho Pavón, Loren Ballesteros Álvarez, Brianda García Aguirre y Lía de Miguel Pastor



EXPLICACIÓN DE PREGUNTAS 3.4-3.6:




1. Verificación de la Suma Mediante Raíz y Subárboles


Una propiedad intrínsec de los árboles binarios es que muchas funciones pueden definirse de
forma recursiva sobre la estructura del árbol. Por ejemplo, en el caso de la suma de los valores
almacenados en un ABB, esta propiedad se formaliza como:

S(T) = r + S(T_izquierdo) + S(T_derecho)

Donde S(T) es la suma total del árbol T, r es el valor almacenado en la raíz, y T_izquierdo,
T_derecho son los subárboles izquierdo y derecho, como su nombre indica, respectivamente.
En nuestro test, hemos construido un ABB insertando los valores enteros de 0 a 128 en orden
creciente. Esto produce un árbol hacia la derecha, es decir, una estructura equivalente a una
lista enlazada. En este caso:

- La raíz es 0.
- El subárbol izquierdo es nulo, por lo que su suma es 0.
- El subárbol derecho contiene los valores de 1 a 128.

La suma de los enteros de 1 a 128 es:
(128 × 129)/2 = 8256
Por tanto, el test verifica que:

getSuma() = 0 + 0 + 8256 = 8256

lo cual concuerda con el resultado esperado, validando así tanto
la correcta implementación recursiva como la propiedad estructural del ABB.




2. Verificación de la Altura del Árbol


La altura de un árbol binario se define como el número de nodos en el camino
más largo desde la raíz hasta una hoja. Dado que los elementos se insertaron en orden
ascendente, el árbol generado no está balanceado: cada nuevo nodo se inserta como
hijo derecho del anterior. Este es el caso peor, y genera un árbol de altura máxima,
equivalente a una lista enlazada.

Si insertamos 129 nodos (de 0 a 128), la altura esperada es:

getAltura() = 129

El test compara el resultado del método getAltura() con este valor esperado para garantizar
que el cálculo de la altura se realiza correctamente.




3. Verificación del Camino hacia un Valor Específico


Se comprueba la corrección del método getCamino(valor), el cual retorna la lista de valores de
los nodos que forman el camino desde la raíz hasta el nodo con el valor buscado. En el ejemplo,
buscamos el camino hacia el nodo que contiene el valor 110. Como el árbol lo construimos
insertando slo valores crecientes, cada nodo está a la derecha del anterior, y el camino
hasta 110 debe recorrer exactamente los siguientes nodos:

[0, 1, 2, ..., 110]

Esto da una lista de 111 elementos, y por tanto 110 transiciones entre nodos.
El test verifica que:

- La lista retornada sea exactamente igual a la lista esperada.
- La longitud del camino coincida con el número de saltos esperados.

Por tanto podemos ver que este test permite validar la implementación de búsqueda dentro del
ABB, así como la trazabilidad de recorridos desde la raíz a cualquier nodo interno.




4. Bibliografía:


- Weiss, M. A. (2014). Data Structures and Algorithm Analysis in Java (3rd ed.). Pearson.

  
- Cormen, T. H., Leiserson, C. E., Rivest, R. L., & Stein, C. (2009). Introduction to Algorithms (3rd ed.). MIT Press.


- FING (2023). Estructuras de Datos y Algoritmos I. Facultad de Ingeniería, Universidad de la
  República.

  
- Wikipedia contributors. (2024). Árbol binario de búsqueda. Wikipedia, la enciclopedia libre.




EXPLICACIÓN DE PREGUNTAS 4.4-4.6 y preguntas adicionales:




1. Verifica que la suma es la misma cuando se suman los elementos de los subárboles
izquierdo y derecho. ¿Por qué?


Sí, la suma es la misma. Se cumple la propiedad de los árboles binarios de búsqueda:

suma total = valor en la raíz + suma del subárbol izquierdo + suma del subárbol derecho

Esto ocurre porque cada nodo está en un único lugar del árbol, por lo que no hay duplicados
ni omisiones.




2. ¿Cuál es la altura del árbol? Explica el porque.


La altura del árbol con inserción aleatoria fue aproximadamente 11. Esto se debe a que al
insertar de forma aleatoria, los nodos se distribuyen mejor y no se acumulan todos a un solo
lado, como sí ocurre cuando se insertan en orden.




3. ¿Cuál es el camino para llegar al valor 110? ¿Cuál es su longitud de camino?


El camino hasta el nodo con valor 110 varía dependiendo del orden de inserción.
Por ejemplo:

[88, 113, 39, 77, 105, 91, 110].

La longitud del camino es igual al número de nodos recorridos menos uno.
En este caso, 7 - 1 = 6 saltos.




4. Diferencias (si las ha habido) de los resultados obtenidos entre los dos programas de prueba.

Diferencias clave:
- Inserción ordenada genera un árbol degenerado (como una lista), mientras que la inserción aleatoria
genera un árbol más equilibrado.
- Altura con ordenada: 129. Altura con aleatoria: ~11.
- Camino hasta 110 en ordenada: 111 pasos. En aleatoria: típicamente < 10.
En ambos casos, la suma total es idéntica porque los elementos son los mismos.




5. ¿Qué sucede con los resultados si ejecuta los programas de prueba varias veces?


Con inserción ordenada, el árbol y resultados siempre son los mismos. Con inserción 
aleatoria, los resultados cambian (camino a un nodo, altura), excepto si se fija la 
semilla del generador aleatorio.La suma total siempre será la misma si los valores
insertados no cambian.




6. Bibliografia


- Devroye, L. (1988). Applications of the theory of records in the study of random trees.
  Acta Informatica, 26(1), 123–130.


- Knuth, D. E. (1997). The Art of Computer Programming, Volume 3: Sorting and Searching
  (2nd ed.). Addison-Wesley.


- Baase, S., & Van Gelder, A. (2000). Computer Algorithms: Introduction to Design and
  Analysis (3rd ed.). Addison-Wesley.


- Cormen, T. H., Leiserson, C. E., Rivest, R. L., & Stein, C. (2009). Introduction to
  Algorithms (3rd ed.). MIT Press.


- Goodrich, M. T., & Tamassia, R. (2010). Data Structures and Algorithms in Java (5th ed.).
  Wiley.


- Weiss, M. A. (2011). Data Structures and Algorithm Analysis in Java (3rd ed.). Pearson
  Education.


- Sedgewick, R., & Wayne, K. (2011). Algorithms (4th ed.). Addison-Wesley.


- Wikipedia contributors. (2024). Binary search tree. In Wikipedia, The Free Encyclopedia.


- Referencia general para ABB, altura y recorridos.


