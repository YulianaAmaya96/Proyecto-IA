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
        for(int i=0; i < sucesores.size();i++){
            sucesores.get(i).setValor(this.valorNodo(sucesores.get(i).getEstado()) + sucesores.get(i).getPadre().getValor());
            sucesores.get(i).setInfoNodo(this.valorHeuristico(sucesores.get(i).getEstado()) + sucesores.get(i).getValor());
        }
    }
    
    /**
     * Calculo heuristico
     * @param sucesores 
     */
    private boolean soNodoMeta(ArrayList<Nodo> sucesores,Nodo objMeta){
        for(int i=0; i < sucesores.size();i++){
            if(sucesores.get(i).equals(objMeta)){
                this.abierto.add(0, sucesores.get(i));
                this.actual = sucesores.get(i);
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

    @Override
    public int calcularInfo(Nodo ap) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
