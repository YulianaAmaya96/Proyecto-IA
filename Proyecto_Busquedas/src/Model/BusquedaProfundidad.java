package Model;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author Yuliana Amaya
 */
public class BusquedaProfundidad extends Busqueda {

    private int profundidad;
    protected Stack<Nodo> abierto;

    public BusquedaProfundidad() {
        super();
        this.actual = null;
    }

    public BusquedaProfundidad(int profundidad, int[][] estadoInicial, int[][] estadoFinal) {
        super(estadoInicial, estadoFinal);
        this.actual = null;
        this.profundidad = profundidad;
    }

    public void setProfundidad(int profundidad) {
        this.profundidad = profundidad;
    }

    @Override
    public Nodo metodoBusqueda() {
        this.abierto = new Stack();
        this.cerrado = new ArrayList();
        Nodo inicial = this.addNodo(this.estadoInicial);
        inicial.setInfoNodo(0);
        Nodo meta = new Nodo(this.estadoFinal, this.actual);
        this.abierto.push(inicial);
        while (!this.abierto.isEmpty() && !estaEnAbierto(meta)) {
            Nodo aux = this.abierto.pop();
            this.actual = aux;
            if (!this.cerrado.contains(aux) && aux.getInfoNodo() <= this.profundidad) {
                this.cerrado.add(aux);
                ArrayList<Nodo> expandido = expandirNodos(aux);
                if (!expandido.isEmpty()) {
                    expandido.stream().forEach((objNodo) -> {
                        this.abierto.add(objNodo);
                    });
                }
            }
        }
        if (actual.getEstado() == meta.getEstado()) {
            return actual;
        } else {
            return null;
        }
    }

    @Override
    public int calcularInfo(Nodo aux) {
        int n = 0;
        while (aux != null) {
            n++;
            aux = aux.getPadre();
        }
        return n;
    }

    @Override
    public boolean estaEnAbierto(Nodo nodo) {
        boolean ban = false;
        for (Nodo k : this.abierto) {
            if (k.getInfoNodo() == nodo.getInfoNodo()) {
                ban = true;
            }
        }
        return ban;
    }

    //--------------------------------------------------------------------------
    public boolean existePadreNodo(Nodo objActual, char dato) {
        boolean ban = false;
//        Nodo objTemporal = objActual;
//        while (objTemporal != null && ban == false) {
//            ban = objTemporal.getDatos() == dato;
//            objTemporal = objTemporal.getPadre();
//        }
        return ban;
    }

    public void addSucesores(Nodo objActual, Nodo Meta) {
//        int p = this.getP(objActual);
//        if (p >= 0) {
//            Nodo objTemporal = objActual;
//            int n = this.matriz[p].length;
//            int columna = p;
//            while (columna != -1) {
//
//                char d = (char) ((char) 'A' + (char) columna);
//
//                boolean existe = false;
//                for (int i = columna + 1; i < n && existe == false; i++) {
//
//                    char c = (char) ((char) 'A' + (char) i);
//                    if (this.matriz[columna][i] == 1 && !existePadreNodo(objTemporal, c)) {
//                        columna = i;
//                        objTemporal = new Nodo(c, objTemporal, objTemporal.getNivelNodo() + 1);
//                        this.abierto.push(objTemporal);
//                        existe = true;
//                    }
//
//                }
//                if (existe == false) {
//                    columna = -1;
//                }
//
//            }
//            if (objTemporal != objActual) {
//                if (objTemporal.getEstado()== Meta.getEstado()) {
//                    this.cerrado.add(objTemporal);
//                }
//            }
//        }
    }

    public int getNivel(Nodo ap) {
//        int n = this.estado.length, k = -1;
//        for (int i = 0; i < n; i++) {
//            char c = (char) ((char) 'A' + (char) i);
//            if (ap.dato == c) {
//                k = i;
//            }
//        }
//        return k;
        return 0;
    }

    public ArrayList<Nodo> expandirNodos(Nodo objNodo) {
        //calcular nivel del nodo nuevo
        ArrayList<Nodo> nodosExpandidos = new ArrayList<>();
//        int p = this.getP(objNodo);
//        for (int i = 0; i < this.matriz[p].length; i++) {
//            char c = (char) ((char) 'A' + (char) i);
//            if (this.matriz[p][i] == 1 && !existePadreNodo(objNodo, c)) {
//                nodosExpandidos.add(new Nodo(c, objNodo, objNodo.getprofundidad() + 1));
//            }
//        }
        return nodosExpandidos;
    }

    public boolean conNodoMeta(ArrayList<Nodo> NodoExpandidos, Nodo Meta) {
        return NodoExpandidos.stream().anyMatch((objNodo) -> (objNodo.getEstado() == Meta.getEstado()));
    }

}
