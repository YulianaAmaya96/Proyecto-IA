package Model;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Yuliana Amaya
 */
public class AscensoColina extends Busqueda {

    private ArrayList<Nodo> abierto;

    public AscensoColina() {
        super();
        this.actual = null;
    }

    public AscensoColina(int[][] estadoInicial, int[][] estadoFinal) {
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
                //expandir sucesores
                //calcular distancia heuristica
                this.cerrado.add(aux);
                if (this.existeSucesor()) {
                    //ordenar sucesores
                    //agregarlos al inicio de abierto
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
        Collections.sort(this.sucesores);
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

    @Override
    public int calcularInfo(Nodo ap) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
