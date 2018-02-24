package Model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Yuliana Amaya
 */
public class BusquedaAmplitud extends Busqueda {

    private Queue<Nodo> abierto;

    public BusquedaAmplitud() {
        this.actual = null;
    }

    public BusquedaAmplitud(int[][] estadoInicial, int[][] estadoFinal) {
        super(estadoInicial, estadoFinal);
        this.actual = null;
    }

    @Override
    public Nodo metodoBusqueda() {
        this.abierto = new LinkedList();
        this.cerrado = new ArrayList();
        Nodo inicial;
        inicial = this.addNodo(this.estadoInicial);
        Nodo meta = new Nodo(this.estadoFinal, this.actual);
        this.abierto.add(inicial);
        while (!this.abierto.isEmpty() && !estaEnAbierto(meta)) {
            Nodo aux = this.abierto.poll();
            this.actual = aux;
            if (!this.cerrado.contains(aux)) {
                this.cerrado.add(aux);
                if (this.existeSucesor()) {
                    this.addSucesores();
                }
            }
        }
        if (this.actual.getEstado() == meta.getEstado()) {
            return this.actual;
        } else {
            return null;
        }
    }

    @Override
    public int calcularInfo(Nodo ap) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean estaEnAbierto(Nodo nodo) {
        boolean ban = false;
        for (Nodo k : this.abierto) {
            if(k.getInfoNodo() == nodo.getInfoNodo()){
                ban = true; 
            }
        }
        return ban;
    }

}
