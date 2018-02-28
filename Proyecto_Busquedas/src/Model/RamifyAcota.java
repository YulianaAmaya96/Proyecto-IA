package Model;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Yuliana Amaya
 */
public class RamifyAcota extends Busqueda {

    private ArrayList<Nodo> abierto;

    public RamifyAcota() {
        super();
        this.actual = null;
    }

    public RamifyAcota(int[][] estadoInicial, int[][] estadoFinal) {
        super(estadoInicial, estadoFinal);
        this.actual = null;
    }

    @Override
    public Nodo metodoBusqueda() {
        this.abierto = new ArrayList();
        this.cerrado = new ArrayList();
        Nodo inicial = this.addNodo(this.estadoInicial); inicial.encontrarXYVacion();
        Nodo meta = new Nodo(this.estadoFinal, null);
        this.abierto.add(inicial);
        while (!this.abierto.isEmpty() && !estaEnAbierto(meta)) {
            Nodo aux = this.abierto.remove(0);
            this.actual = aux;
            if (!this.cerrado.contains(aux)) {
                this.cerrado.add(aux);
                ArrayList<Nodo> NodosSucesores = this.ObtenerSucesores(aux,this.cerrado, this.abierto);
                CalcularHeuristica(NodosSucesores);
                if (!NodosSucesores.isEmpty() && !soNodoMeta(NodosSucesores,meta)) {
                    ordenarLista(NodosSucesores);
                    this.abierto.addAll(0, NodosSucesores);
                }
            }
        }
        if (!meta.equals(this.actual)) {
            return null;
        } else {
            return this.actual;
        }
    }
    
    /**
     * Calculo heuristico
     * @param sucesores 
     */
    private void CalcularHeuristica(ArrayList<Nodo> sucesores){
        sucesores.stream().forEach((sucesore) -> {
            sucesore.setInfoNodo(this.valorNodo(sucesore.getEstado()) + sucesore.getPadre().getInfoNodo());
        });
    }
    
    /**
     * Calculo heuristico
     * @param sucesores 
     */
    private boolean soNodoMeta(ArrayList<Nodo> sucesores,Nodo objMeta){
        for (Nodo sucesore : sucesores) {
            if (sucesore.equals(objMeta)) {
                this.abierto.add(0, sucesore);
                this.actual = sucesore;
                return true;
            }
        }
        return false;
    }
    
    public void ordenarLista(ArrayList<Nodo> sucesores) {
        Collections.sort(sucesores);
    }

    /**
     * Metodo encargado de validar que no exista el nodo final en los nodos abiertos
     * @param nodo nodo meta
     * @return retorna valor boolean
     */
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
