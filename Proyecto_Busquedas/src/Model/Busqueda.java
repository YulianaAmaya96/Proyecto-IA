package Model;

import java.time.Clock;
import java.util.ArrayList;

/**
 *
 * @author Yuliana Amaya
 */
public abstract class Busqueda {

    protected Nodo actual;
    protected int[][] estadoInicial;
    protected int[][] estadoFinal;
    protected ArrayList<Nodo> sucesores;
    protected ArrayList<Nodo> cerrado;

    public Busqueda() {
        this.actual = null;
    }

    public Busqueda(int[][] estadoInicial, int[][] estadoFinal) {
        this.actual = null;
        this.estadoInicial = estadoInicial;
        this.estadoFinal = estadoFinal;
    }

    public void setEstadoInicial(int[][] estadoInicial) {
        this.estadoInicial = estadoInicial;
    }

    public void setEstadoFinal(int[][] estadoFinal) {
        this.estadoFinal = estadoFinal;
    }

    public Nodo addNodo(int[][] estado) {
        Nodo ap = new Nodo(estado, this.actual);
        if (this.actual == null) {
            this.actual = ap;
        }
        return ap;
    }

    /**
     * Calcular el valor del estado actual
     * @param estadoActual Matriz de estado actual
     * @return valor heurisctico
     */
    public int valorNodo(int[][] estadoActual) {
        int valor = 0;
        for (int i = 0; i < estadoActual.length; i++) {
            for (int j = 0; j < estadoActual[i].length; j++) {
                if (estadoActual[i][j] == this.estadoFinal[i][j]) {
                    valor += 1;
                   // System.out.println( "*" + estadoActual[i][j]);
                }
            }
        }
        return (estadoActual.length * estadoActual[0].length) - (valor +1);
    }
    
    /**
     * Calcular el valor heuristico del estado actual
     *
     * @param estadoActual Matriz de estado actual
     * @return valor heurisctico
     */
    public int valorHeuristico(int[][] estadoActual) {
        int valor = 0;
        for (int i = 0; i < estadoActual.length; i++) {
            for (int j = 0; j < estadoActual[i].length; j++) {
                if (estadoActual[i][j] != 0) {
                    valor += valorItemHeurisctico(estadoActual[i][j], i, j);
                }
            }
        }
        return valor;
    }

    /**
     * Busca el item y determina el valor contra la matriz final
     *
     * @param valor
     * @return
     */
    private int valorItemHeurisctico(int valor, int xFila, int xColumna) {
        int valorItem = 0;
        for (int i = 0; i < this.estadoFinal.length; i++) {
            for (int j = 0; j < this.estadoFinal[0].length; j++) {
                if (this.estadoFinal[i][j] == valor) {
                    int numeroFila = Math.abs(xFila - i);
                    int numeroColuma = Math.abs(xColumna - j);
                    return numeroFila + numeroColuma;
                }
            }
        }
        return valorItem;
    }

    /**
     * Valida la existencia de un nodo en un listado
     *
     * @param objNodo
     * @param cerrados
     * @return
     */
    private boolean noEstaCerrado(Nodo objNodo, ArrayList<Nodo> cerrados) {
        return cerrados.stream().anyMatch((objCerrado) -> (objCerrado.equals(objNodo)));
    }

    /**
     * Recorre los padres de un nodo buscando si existe o no
     *
     * @param objNodo
     * @return
     */
    private boolean nodoExisteComoPadre(Nodo objNodo) {
        Nodo Padre = objNodo.getPadre();
        while (Padre != null) {
            if (Padre.equals(objNodo)) {
                return true;
            } else {
                Padre = Padre.getPadre();
            }
        }
        return false;
    }

    /**
     * Metodo encargado de copiar matriz
     *
     * @param matrizACopiar M;atriz a copiar
     * @return Retorna nueva matriz
     */
    private int[][] copiarMatriz(int[][] matrizACopiar) {
        int[][] nuevoValor = new int[matrizACopiar.length][matrizACopiar[0].length];
        for (int i = 0; i < matrizACopiar.length; i++) {
            System.arraycopy(matrizACopiar[i], 0, nuevoValor[i], 0, matrizACopiar[0].length);
        }
        return nuevoValor;
    }

    /**
     * Metodo encargado de generar sucesores
     *
     * @param objNodo
     * @return
     */
    public ArrayList<Nodo> ObtenerSucesores(Nodo objNodo, ArrayList<Nodo> cerrados, ArrayList<Nodo> abiertos) {
        int fila = objNodo.getNodoVacionY();
        int columna = objNodo.getNodoVacionX();
        ArrayList<Nodo> lstNodosSucesores = new ArrayList<>();
        if (fila > 0) {

            boolean filaOrdenada = true;
            int indexfilaOrdenada = -1;
            for (int i = 0; i < objNodo.getEstado().length; i++) {
                for (int j = 0; j < objNodo.getEstado()[i].length; j++) {
                    filaOrdenada = filaOrdenada && objNodo.getEstado()[i][j] == this.estadoFinal[i][j];
                }
                if (filaOrdenada) {
                    indexfilaOrdenada++;
                }
            }

            if (indexfilaOrdenada < fila - 1) {
                int[][] nuevoValor = copiarMatriz(objNodo.getEstado());
                int valor = nuevoValor[fila - 1][columna];
                nuevoValor[fila][columna] = valor;
                nuevoValor[fila - 1][columna] = 0;

                Nodo objNodoIzquierda = new Nodo(nuevoValor, objNodo);
                objNodoIzquierda.setNodoVacionX(fila - 1);
                objNodoIzquierda.setNodoVacionY(columna);
                if (!nodoExisteComoPadre(objNodoIzquierda) && !noEstaCerrado(objNodoIzquierda, cerrados) ) {
                    lstNodosSucesores.add(objNodoIzquierda);
                }
            }
        }

        if (columna < objNodo.getEstado()[0].length - 1) {
            int[][] nuevoValor = copiarMatriz(objNodo.getEstado());
            int valor = nuevoValor[fila][columna + 1];
            nuevoValor[fila][columna] = valor;
            nuevoValor[fila][columna + 1] = 0;
            Nodo objNodoDerecha = new Nodo(nuevoValor, objNodo);
            objNodoDerecha.setNodoVacionX(fila);
            objNodoDerecha.setNodoVacionY(columna + 1);
            if (!nodoExisteComoPadre(objNodoDerecha) && !noEstaCerrado(objNodoDerecha, cerrados)) {
                lstNodosSucesores.add(objNodoDerecha);
            }
        }

        if (fila < objNodo.getEstado().length - 1) {
            int[][] nuevoValor = copiarMatriz(objNodo.getEstado());
            int valor = nuevoValor[fila + 1][columna];
            nuevoValor[fila][columna] = valor;
            nuevoValor[fila + 1][columna] = 0;
            Nodo objNodoDerecha = new Nodo(nuevoValor, objNodo);
            objNodoDerecha.setNodoVacionX(fila + 1);
            objNodoDerecha.setNodoVacionY(columna);
            if (!nodoExisteComoPadre(objNodoDerecha) && !noEstaCerrado(objNodoDerecha, cerrados)) {
                lstNodosSucesores.add(objNodoDerecha);
            }
        }

        if (columna > 0) {
            int[][] nuevoValor = copiarMatriz(objNodo.getEstado());
            int valor = nuevoValor[fila][columna - 1];
            nuevoValor[fila][columna] = valor;
            nuevoValor[fila][columna - 1] = 0;
            Nodo objNodoSuperior = new Nodo(nuevoValor, objNodo);
            objNodoSuperior.setNodoVacionX(fila);
            objNodoSuperior.setNodoVacionY(columna - 1);
            if (!nodoExisteComoPadre(objNodoSuperior)) {
                lstNodosSucesores.add(objNodoSuperior);
            }
        }

        return lstNodosSucesores;
    }

    public int nodosGenerados() {
        return this.cerrado.size() - 1;
    }

    public boolean existeSucesor() {
        return true;
    }

    public void addSucesores() {
        this.sucesores = new ArrayList();
    }

    public boolean obtenerSucesores(Nodo objActual, Nodo objNodoMeta) {
        boolean ban = false;
//        int p = this.getP(objActual);
//        if (p >= 0) {
//            int n = this.matriz[p].length;
//            for (int i = objActual.getprofundidad(); i < n; i++) {
//                char c = (char) ((char) 'A' + (char) i);
//                if (this.matriz[p][i] == 1 && objNodoMeta.getDatos() != c) {
//                    return true;
//                }
//            }
//        }
        return ban;
    }

    public abstract boolean estaEnAbierto(Nodo nodo);

    public abstract Nodo metodoBusqueda();

    public abstract int calcularInfo(Nodo ap);

}
