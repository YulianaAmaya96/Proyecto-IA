package Model;

import java.util.ArrayList;

/**
 *
 * @author Yuliana Amaya
 */
public class BusquedaAmplitud extends Busqueda {

    private ArrayList<Nodo> abierto;

    public BusquedaAmplitud() {
        super();
        this.actual = null;
    }

    public BusquedaAmplitud(int[][] estadoInicial, int[][] estadoFinal) {
        super(estadoInicial, estadoFinal);
        this.actual = null;
    }

    @Override
    public Nodo metodoBusqueda() {
        this.abierto = new ArrayList();
        this.cerrado = new ArrayList();
        Nodo inicial = this.addNodo(this.estadoInicial);
        inicial.encontrarXYVacion();
        Nodo meta = new Nodo(this.estadoFinal, null);
        this.abierto.add(inicial);
        while (!this.abierto.isEmpty() && !estaEnAbierto(meta)) {
            Nodo aux = this.abierto.remove(0);
            this.actual = aux;
            if (!this.cerrado.contains(aux)) {
                this.cerrado.add(aux);
                ArrayList<Nodo> NodosSucesores = this.ObtenerSucesores(aux, this.cerrado, this.abierto);
                if (!NodosSucesores.isEmpty() && !soNodoMeta(NodosSucesores, meta)) {
                    NodosSucesores.stream().forEach((NodosSucesore) -> {
                        this.abierto.add(NodosSucesore);
                    });
                }
            }
        }
        System.out.println(this.actual.getIdUnicoNodo());
        if (!meta.equals(this.actual)) {
            return null;
        } else {
            return this.actual;
        }
    }

    /**
     * Calculo heuristico
     *
     * @param sucesores
     */
    private boolean soNodoMeta(ArrayList<Nodo> sucesores, Nodo objMeta) {
        for (Nodo sucesore : sucesores) {
            if (sucesore.equals(objMeta)) {
                this.abierto.add(0, sucesore);
                this.actual = sucesore;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean estaEnAbierto(Nodo nodo) {
        boolean ban = false;
        for (Nodo k : this.abierto) {
            if (k.equals(nodo)) {
                ban = true;
            }
        }
        return ban;
    }

}
