package Model;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Yuliana Amaya
 */
public class RamifyAcota_Sub extends Busqueda {

    private ArrayList<Nodo> abierto;

    public RamifyAcota_Sub() {
        super();
        this.actual = null;
    }

    public RamifyAcota_Sub(int[][] estadoInicial, int[][] estadoFinal) {
        super(estadoInicial, estadoFinal);
        this.actual = null;
    }

    @Override
    public Nodo metodoBusqueda() {
        this.abierto = new ArrayList();
        this.cerrado = new ArrayList();
        Nodo inicial = this.addNodo(this.estadoInicial);
        Nodo meta = new Nodo(this.estadoFinal, this.actual);
        this.abierto.add(inicial);
        while (!this.abierto.isEmpty() && !estaEnAbierto(meta)) {
            Nodo aux = this.abierto.remove(0);
            this.actual = aux;

            if (!this.cerrado.contains(aux)) {
                this.cerrado.add(aux);
                //expandir sucesores
                //Acumular distancia informacion + heuristicas

                if (this.existeSucesor()) {
                    //agregarlos a abierto
                    //ordenar lista de abiertos ascententemente
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

    public void ordenarLista() {
        Collections.sort(this.abierto);
    }

    @Override
    public int calcularInfo(Nodo ap) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
}
