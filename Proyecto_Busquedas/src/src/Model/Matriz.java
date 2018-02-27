package Model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Matriz {

    private int[][] matriz;

    public int[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(int[][] matriz) {
        this.matriz = matriz;
    }

//    public String grafoAleatorio(int n) throws IOException {
//        String direccion = "";
//        File numeros = new File(direccion);
//        try (BufferedWriter bwNumeros = new BufferedWriter(new FileWriter(numeros))) {
//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < n; j++) {
//                    bwNumeros.write(this.generarNumero() + " ");
//                }
//                bwNumeros.newLine();
//            }
//        }
//        return this.cargarGrafo(direccion);
//    }
//
//    private int generarNumero() {
//        Random rnd = new Random();
//        int temp = (int) (rnd.nextDouble() * 10 + 1);
//        if (temp < 5) {
//            return 0;
//        } else {
//            return 1;
//        }
//    }
//
//    public String cargarGrafo(String direccion) {
//        File matrizFile = new File(direccion);
//        try {
//            String text;
//            try (FileReader fr = new FileReader(matrizFile)) {
//                BufferedReader br = new BufferedReader(fr);
//                String aux;
//                text = "";
//                while ((aux = br.readLine()) != null) {
//                    text += aux + "\n";
//                }
//            }
//            return text;
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(Matriz.class.getName()).log(Level.SEVERE, null, ex);
//            return null;
//        } catch (IOException ex) {
//            Logger.getLogger(Matriz.class.getName()).log(Level.SEVERE, null, ex);
//            return null;
//        }
//    }

    public int[][] cargarMatriz(String direccion) {
        File matrizFile = new File(direccion);
        ArrayList<int[]> lstFilas = new ArrayList();
        int[][] objMatriz1;
        if (matrizFile != null) {
            try {
                FileReader fr = new FileReader(matrizFile);
                BufferedReader br = new BufferedReader(fr);
                String linea; 
                while ((linea = br.readLine()) != null) {
                    int[] filaNumeros = null;
                    String[] partes = linea.split(" ");
                    if (filaNumeros == null) {
                        filaNumeros = new int[partes.length];
                    }
                    for (int j = 0; j < partes.length; j++) {
                        filaNumeros[j] = Integer.parseInt(partes[j]);
                    }
                    lstFilas.add(filaNumeros); 
                }
                fr.close();
                objMatriz1 = new int[lstFilas.size()][lstFilas.get(0).length];
                for (int i = 0; i < lstFilas.size(); i++) {
                    System.arraycopy(lstFilas.get(i), 0, objMatriz1[i], 0, lstFilas.get(i).length);
                }
                return objMatriz1; 
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Matriz.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            } catch (IOException ex) {
                Logger.getLogger(Matriz.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        }else {
            return null; 
        }
    }
}
