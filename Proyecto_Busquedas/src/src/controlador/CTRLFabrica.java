package controlador;

import Model.Busqueda;
import Model.FactoriaBusqueda;
import Model.FactoriaMetodoBusqueda;

/**
 *
 * @author Yuliana Amaya
 */

public class CTRLFabrica {

    private FactoriaMetodoBusqueda factoria;

    public CTRLFabrica() {
        this.factoria = new FactoriaBusqueda();
    }

    public Busqueda crearBusqueda(String bs) {
        Busqueda b = this.factoria.crearBusqueda(bs);
        return b;
    }
}
