package controlador;

import Model.Busqueda;
import Model.Nodo;
import java.util.ArrayList;

/**
 *
 * @author Yuliana Amaya
 */
public class CTRLBusqueda {

    private CTRLFabrica cTRLFabrica;
    private CTRLNodo cTRLNodo;
    private ArrayList<Busqueda> busquedas;

    public CTRLBusqueda() {
        this.busquedas = new ArrayList();
        this.cTRLFabrica = new CTRLFabrica();
        this.cTRLNodo = new CTRLNodo();
    }

    public Busqueda nuevaBusqueda(String bs) {
        return this.cTRLFabrica.crearBusqueda(bs);
    }

    /*
    public String procesarBusquda(String bs, int[][] matriz, int[][] matriz2, int np) {
        Busqueda busqueda = this.nuevaBusqueda(bs);
        //busqueda.setProfundidad(np); 
        busqueda.setEstadoInicial(matriz);
        busqueda.setEstadoFinal(matriz2);
        Nodo nd = busqueda.metodoBusqueda();

        this.cTRLNodo.insertarNodo(nd);
        this.insertarBusqueda(busqueda);
        return nd == null ? "" : this.cTRLNodo.recorrerPadres(nd);
    }

    public void insertarBusqueda(Busqueda busqueda) {
        this.busquedas.add(busqueda);
    }
    */

}
