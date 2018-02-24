package Model;

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
