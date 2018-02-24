package controlador;

import Model.Nodo;
import java.util.ArrayList;

/**
 *
 * @author Yuliana Amaya
 */
public class CTRLNodo {

    private ArrayList<Nodo> nodos;

    public ArrayList<Nodo> getNodos() {
        return nodos;
    }

    public void setNodos(ArrayList<Nodo> nodos) {
        this.nodos = nodos;
    }
    
    public CTRLNodo() {
        this.nodos = new ArrayList();
    }
    
    public void insertarNodo(Nodo nd){
        this.nodos.add(nd); 
    }

    public String recorrerPadres(Nodo ap){
        String cadena = ""; 
        while (ap.getPadre() !=null){
            cadena = " " + ap.getInfoNodo()+ " " + cadena; 
            ap = ap.getPadre(); 
        }
        if(ap.getPadre() == null){
            cadena= " " + ap.getInfoNodo()+ " " + cadena; 
        }
        System.out.println(cadena);
        return cadena; 
    }
}
