/**
 * Ejercicios de recursividad aplicados a un CRUD sobre un arreglo.
 *
 * Contiene tres retos del taller:
 *  a) CRUD completo (agregar, leer, actualizar, buscar) sobre un arreglo fijo.
 *  b) sumaRecursiva(int n): suma los numeros desde 1 hasta n de forma recursiva.
 *  c) multiplicacionBaseExponente(int base, int potencia): calcula la potencia
 *     por multiplicaciones sucesivas, sin usar librerias como Math.pow.
 */
public class CrudRecursividad {

    private static final int CAPACIDAD = 8;

    private final int[] arreglo;
    private int contadorEspaciosOcupados;

    public CrudRecursividad() {
        this.arreglo = new int[CAPACIDAD];
        this.contadorEspaciosOcupados = 0;
    }

    // ---------------------------------------------------------------- CRUD

    /**
     * Agrega un elemento al final de los ya registrados.
     *
     * @param elemento valor a agregar
     * @return true si se agrego, false si el arreglo esta lleno
     */
    public boolean agregarElemento(int elemento) {
        if (contadorEspaciosOcupados >= arreglo.length) {
            System.out.println("El arreglo esta lleno!");
            return false;
        }
        for (int i = 0; i < arreglo.length; i++) {
            if (i == contadorEspaciosOcupados) {
                arreglo[i] = elemento;
                contadorEspaciosOcupados++;
                return true;
            }
        }
        return false;
    }

    /**
     * Imprime en consola los elementos registrados.
     */
    public void leerArreglo() {
        if (contadorEspaciosOcupados == 0) {
            System.out.println("El arreglo esta vacio.");
            return;
        }
        System.out.println("Contenido del arreglo:");
        for (int i = 0; i < contadorEspaciosOcupados; i++) {
            System.out.println("  [" + i + "] = " + arreglo[i]);
        }
    }

    /**
     * Reemplaza el valor de una posicion existente.
     *
     * @param indice        posicion a actualizar
     * @param elementoNuevo nuevo valor
     * @return true si se actualizo, false si la posicion no es valida
     */
    public boolean actualizarElemento(int indice, int elementoNuevo) {
        if (indice >= 0 && indice < contadorEspaciosOcupados) {
            arreglo[indice] = elementoNuevo;
            System.out.println("Elemento actualizado en [" + indice + "]: " + elementoNuevo);
            return true;
        }
        System.out.println("Intentando actualizar elemento no encontrado");
        return false;
    }

    /**
     * Busca el indice de un valor dentro del arreglo.
     *
     * @param elemento valor buscado
     * @return indice encontrado o -1 si no existe
     */
    public int buscarIndiceElemento(int elemento) {
        if (contadorEspaciosOcupados == 0) {
            System.out.println("El arreglo esta vacio!");
        }
        for (int i = 0; i < contadorEspaciosOcupados; i++) {
            if (arreglo[i] == elemento) {
                return i;
            }
        }
        return -1;
    }

    public int getContadorEspaciosOcupados() {
        return contadorEspaciosOcupados;
    }

    // ------------------------------------------------------ Retos recursivos

    /**
     * Suma todos los numeros desde 1 hasta n.
     * Caso base: n == 1 devuelve 1. En cada llamada se resuelve n - 1 y se
     * suma n al resultado.
     *
     * @param n entero positivo
     * @return suma de 1 hasta n
     */
    public static int sumaRecursiva(int n) {
        if (n <= 1) {
            return Math.max(n, 1);
        }
        return sumaRecursiva(n - 1) + n;
    }

    /**
     * Calcula base elevada a potencia usando solo multiplicaciones recursivas.
     *
     * Caso base: potencia == 0 devuelve 1 (todo numero elevado a 0 es 1).
     * En cada llamada se resuelve base elevado a (potencia - 1) y se
     * multiplica por base.
     *
     * <pre>
     * Traza con base = 2, potencia = 3:
     *   multiplicacionBaseExponente(2, 3) -&gt; 2 * multiplicacionBaseExponente(2, 2)
     *   multiplicacionBaseExponente(2, 2) -&gt; 2 * multiplicacionBaseExponente(2, 1)
     *   multiplicacionBaseExponente(2, 1) -&gt; 2 * multiplicacionBaseExponente(2, 0) = 2 * 1 = 2
     *   =&gt; 2 * 2 = 4 -&gt; 2 * 4 = 8
     * Resultado: 8
     * </pre>
     *
     * @param base     base de la potencia
     * @param potencia exponente entero no negativo
     * @return base elevada a potencia
     */
    public static int multiplicacionBaseExponente(int base, int potencia) {
        if (potencia < 0) {
            throw new IllegalArgumentException("El exponente no puede ser negativo");
        }
        if (potencia == 0) {
            return 1;
        }
        return base * multiplicacionBaseExponente(base, potencia - 1);
    }

    // --------------------------------------------------------- Demostracion

    public static void main(String[] args) {
        System.out.println("=== Reto 1: CRUD sobre un arreglo ===");
        CrudRecursividad crud = new CrudRecursividad();
        crud.agregarElemento(10);
        crud.agregarElemento(20);
        crud.agregarElemento(30);
        crud.leerArreglo();
        System.out.println("Indice del valor 20: " + crud.buscarIndiceElemento(20));
        crud.actualizarElemento(1, 25);
        crud.leerArreglo();

        System.out.println();
        System.out.println("=== Reto 2: suma recursiva ===");
        System.out.println("sumaRecursiva(5) = " + sumaRecursiva(5));

        System.out.println();
        System.out.println("=== Reto 3: potencia por multiplicacion recursiva ===");
        System.out.println("multiplicacionBaseExponente(2, 3) = " + multiplicacionBaseExponente(2, 3));
    }
}