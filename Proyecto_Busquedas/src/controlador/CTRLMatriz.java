package controlador;

import Model.Matriz;
import java.io.IOException;
import java.util.ArrayList;
/**
 *
 * @author Yuliana Amaya
 */
public class CTRLMatriz {

    private ArrayList<Matriz> listMatriz;
    private int [][] matrizTemp; 

    public CTRLMatriz() {
        this.listMatriz = new ArrayList(); 
    }

    public ArrayList<Matriz> getListMatriz() {
        return listMatriz;
    }

    public void setListMatriz(ArrayList<Matriz> listMatriz) {
        this.listMatriz = listMatriz;
    }

    public int[][] getMatrizTemp() {
        return matrizTemp;
    }

    public void setMatrizTemp(int[][] matrizTemp) {
        this.matrizTemp = matrizTemp;
    }

    public String crearGrafo(String s, int n) throws IOException {
        Matriz m = new Matriz();
        String cadena = "";
        if (s.equals("Aleatorio")) {
            cadena = m.grafoAleatorio(n);
//            String direccion = "C:\\Users\\yuliana\\Downloads\\BusquedaExhaustiva\\src\\texto\\Matriz_Aleatoria.txt"; 
            //matrizTemp = m.cargarMatriz(direccion);
        } else {
            cadena = m.cargarGrafo(s);
            int number[][] = new int[6][6];
            m.llenarDatos(number,s);
            this.matrizTemp = number; 

        }
        
        this.listMatriz.add(m);
        return cadena;
    }

}
