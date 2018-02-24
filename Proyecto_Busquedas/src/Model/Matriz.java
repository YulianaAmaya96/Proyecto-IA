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

    public String grafoAleatorio(int n) throws IOException {
        String direccion = "E:\\BusquedaExhaustiva\\BusquedaExhaustiva\\src\\texto\\Matriz_A.txt";
        File numeros = new File(direccion);
        try (BufferedWriter bwNumeros = new BufferedWriter(new FileWriter(numeros))) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    bwNumeros.write(this.generarBit() + " ");
                }
                bwNumeros.newLine();
            }
        }
        return this.cargarGrafo(direccion);
    }

    private int generarBit() {
        Random rnd = new Random();
        int temp = (int) (rnd.nextDouble() * 10 + 1);
        if (temp < 5) {
            return 0;
        } else {
            return 1;
        }
    }

    public String cargarGrafo(String direccion) {
        File matrizFile = new File(direccion);
        try {
            String text;
            try (FileReader fr = new FileReader(matrizFile)) {
                BufferedReader br = new BufferedReader(fr);
                String aux;
                text = "";
                while ((aux = br.readLine()) != null) {
                    text += aux + "\n";
                }
            }
            return text;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Matriz.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (IOException ex) {
            Logger.getLogger(Matriz.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public void llenarDatos(int[][] A, String ubicacion) {
        File archivo = new File(ubicacion);
        try {
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            String linea = br.readLine();
            for (int i = 0; i < A.length; i++) {
                StringTokenizer numero = new StringTokenizer(linea, " ");
                for (int j = 0; j < A.length; j++) {
                    if (numero.hasMoreTokens()) {
                        int k = Integer.parseInt(numero.nextToken());
                        A[i][j] = k;
                    } else {
                        A[i][j] = 0;
                    }
                }
                linea = br.readLine();
            }
            fr.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Matriz.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Matriz.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    public int[][] cargarMatriz(String cadena) {
//        this.matriz = new int[7][7]; 
//        int i = 0, j = 0;
//        StringTokenizer linea = new StringTokenizer(cadena, "\n");
//        while (linea.hasMoreTokens()) {
//            StringTokenizer caracter = new StringTokenizer(linea.nextToken(), " ");
//            while (caracter.hasMoreTokens()) {
//                this.matriz[i][j] = Integer.parseInt(caracter.nextToken());
//                j++;
//            }
//            i++;
//        }
//        return this.matriz;
//    }
    public int[][] cargarMatriz(String direccion) {
        File matrizFile = new File(direccion);
        this.matriz = new int[20][20];
        int i = 0, j = 0;
        try {
            String text;
            try (FileReader fr = new FileReader(matrizFile)) {
                BufferedReader br = new BufferedReader(fr);
                text = "";
                while ((text = br.readLine()) != null) {
                    StringTokenizer tokens = new StringTokenizer(text, " ");
                    while (tokens.hasMoreTokens()) {
                        this.matriz[i][j] = Integer.parseInt(tokens.nextToken());
                        j++;
                    }
                    i++;
                }
            }
            return this.matriz;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Matriz.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (IOException ex) {
            Logger.getLogger(Matriz.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

//    public boolean cargarTextoAMatriz(String CadenaTexto, Grafo objGrafo) throws IOException {
//
//        try {
//            int[][] arrTemporal;
//            ArrayList<int[]> ArrFilas = new ArrayList<>();
//            String[] Filas = CadenaTexto.split("\n");
//            int CantidadCol = -1;
//            for (String Fila : Filas) {
//                String[] Columnas = Fila.split(" ");
//                CantidadCol = CantidadCol == -1 ? Columnas.length : CantidadCol;
//                if (CantidadCol != Columnas.length) {
//                    throw new IOException("Los datos ingresados no son correctos.");
//                }
//                int[] itemFila = new int[Columnas.length];
//                for (int j = 0; j < Columnas.length; j++) {
//                    itemFila[j] = Integer.parseInt(Columnas[j].trim());
//                }
//                ArrFilas.add(itemFila);
//            }
//
//            //CIPIAR MATRIZ
//            arrTemporal = new int[ArrFilas.size()][CantidadCol];
//            for (int i = 0; i < ArrFilas.size(); i++) {
//                System.arraycopy(ArrFilas.get(i), 0, arrTemporal[i], 0, CantidadCol);
//            }
//
//            //CARGAR A VECTOR
//            objGrafo.setVector(arrTemporal);
//            return true;
//        } catch (IOException ex) {
//            Logger.getLogger(Matriz.class.getName()).log(Level.SEVERE, null, ex);
//            return false;
//        }
//    }
}
