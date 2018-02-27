package controlador;

import Model.Busqueda;
import Model.Nodo;
import java.util.ArrayList;

/**
 *
 * @author Yuliana Amaya
 */
public class CTRLBusqueda {


    private Busqueda objBusqueda;

    /**
     * Constructor
     * @param objBusqueda 
     */
    public CTRLBusqueda(Busqueda objBusqueda){
        this.objBusqueda = objBusqueda;
    }

    /**
     * Metodo encargado de inicial la busqueda
     * @return 
     */
    public Nodo iniciarBusqueda(){
        Nodo objNodoSalida =  new Nodo();
        objNodoSalida = this.objBusqueda.metodoBusqueda();
        return objNodoSalida;
    }
   
    /**
     * Metodo encargado de generar pasos del puzzle
     * @param objNodoFinal Nodo final
     * @param txtSalidaDatos JTextArea en from usuario
     * @return 
     */
    public boolean generarPasosDelPuzzle(Nodo objNodoFinal, javax.swing.JTextArea txtSalidaDatos){
        Nodo Padre = objNodoFinal;
        int contadorPasos = 1;
        String cadenaSalida = "";
        while(Padre != null){
            cadenaSalida = "Paso " + Integer.toString(contadorPasos) + ": \n\t\t" +  Padre.getIdUnicoNodo().replace("-:", "\n\t\t") + "\n" + cadenaSalida;
            Padre = Padre.getPadre();
            contadorPasos ++;
        }
        txtSalidaDatos.setText(cadenaSalida);
        return true;
    } 

}
