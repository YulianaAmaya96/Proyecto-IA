package controlador;

import Model.Matriz;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Yuliana Amaya
 */
public class CTRLMatriz {

    private ArrayList<Matriz> listMatriz;
    private int[][] matrizTemp;

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
//
//    public String crearGrafo(String s, int n) throws IOException {
//        Matriz m = new Matriz();
//        String cadena = "";
//        if (s.equals("Aleatorio")) {
//            cadena = m.grafoAleatorio(n);
////            String direccion = "C:\\Users\\yuliana\\Downloads\\BusquedaExhaustiva\\src\\texto\\Matriz_Aleatoria.txt"; 
//            //matrizTemp = m.cargarMatriz(direccion);
//        } else {
//            cadena = m.cargarGrafo(s);
//            int number[][] = new int[6][6];
//            m.llenarDatos(number,s);
//            this.matrizTemp = number; 
//
//        }
//        
//        this.listMatriz.add(m);
//        return cadena;
//    }

    /**
     * Carga matriz a partir de un archivo
     *
     * @param direccion Ubicación del archivo
     * @return Matriz entero
     */
    public int[][] cargarMatriz(String direccion) {
        Matriz objMatriz = new Matriz();
        return objMatriz.cargarMatriz(direccion);
    }
    
     /**
     * Metodo encargado de validar la existencia de un archivo
     * @param ubicacionArchivo ubicacion del archivo
     * @return retorna un valor boolean
     */
    public boolean existeArchivoInicial(String ubicacionArchivo){
        File archivo =   new File(ubicacionArchivo);
        return archivo.exists();
    }
    
    public boolean llenarMatrizOrdenada(int[][] matriz) {
        int contador = 1;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                matriz[i][j] = contador;
                contador++;
            }
        }
        matriz[matriz.length - 1][matriz[0].length - 1] = 0;
        return true;
    }

    public void desordenarMatriz(int[][] matrizBoseto) {
        ArrayList<String> listaAux = new ArrayList();
        for (int[] matrizBoseto1 : matrizBoseto) {
            for (int j = 0; j < matrizBoseto.length; j++) {
                listaAux.add(matrizBoseto1[j] + "");
            }
        }
        Collections.shuffle(listaAux);
        for (int[] matrizBoseto1 : matrizBoseto) {
            for (int j = 0; j < matrizBoseto.length; j++) {
                matrizBoseto1[j] = Integer.parseInt(listaAux.remove(0));
            }
        }
    }

}
