package Model;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Yuliana Amaya
 */
public class BusquedaProfundidad extends Busqueda {

    private int profundidad;
    protected ArrayList<Nodo> abierto;

    public BusquedaProfundidad() {
        super();
        this.actual = null;
        this.profundidad = Integer.parseInt(JOptionPane.showInputDialog("Digite profundidad"));
    }

    public BusquedaProfundidad(int[][] estadoInicial, int[][] estadoFinal) {
        super(estadoInicial, estadoFinal);
        this.actual = null;
        this.profundidad = Integer.parseInt(JOptionPane.showInputDialog("Digite profundidad"));
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
            if (!this.cerrado.contains(aux) &&calcularProfundidad(aux) < this.profundidad) {
                this.cerrado.add(aux);
                ArrayList<Nodo> NodosSucesores = this.ObtenerSucesores(aux,this.cerrado, this.abierto);
                if (!NodosSucesores.isEmpty() && !soNodoMeta(NodosSucesores,meta)) {
                    for(int i=NodosSucesores.size()-1; i >= 0;i--){
                        this.abierto.add(0,NodosSucesores.get(i));
                    }
                }
            }
        }
        System.out.println(this.actual.getIdUnicoNodo());
        if (!meta.equals(this.actual)) {
            return null;
        } else {
            Nodo temp = this.actual; 
            while(temp!=null){
                System.err.println(temp.getIdUnicoNodo());
                temp = temp.getPadre(); 
            }
            return this.actual;
        }
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


    public int calcularProfundidad(Nodo aux) {
        Nodo temp = this.actual;
        int n = 0;
        while (temp != null) {
            System.err.println(temp.getIdUnicoNodo());
            temp = temp.getPadre();
            n++; 
        }
        return n;
    }
}
