package Model;

import com.sun.org.apache.xpath.internal.operations.Equals;

/**
 *
 * @author Yuliana Amaya
 */
public class Nodo implements Comparable<Nodo> {

    private int[][] estado;
    private Nodo padre;
    private int infoNodo;
    private String IdUnicoNodo;
    private int nodoVacioX;
    private int nodoVacioY;
    private int Valor;

    public Nodo() {
    }

    public Nodo(int[][] estado, Nodo padre) {
        this.estado = estado;
        this.padre = padre;
        this.infoNodo = 0;
        this.Valor = 0;
        this.IdUnicoNodo = generarIdUnicoNodo();
    }
    
    /**
     * Busca y encuentra la posicion del valor vacio
     */
    public void encontrarXYVacion(){
        for(int i = 0; i < this.estado.length;i++ )   {
            for(int j = 0; j < this.estado[i].length;j++ )   {
               if(this.estado[i][j]==0){
                   this.nodoVacioX=j;
                   this.nodoVacioY=i;
               }
            }
        }
    }

    public int[][] getEstado() {
        return estado;
    }

    public int getNodoVacionY(){
        return this.nodoVacioY;
    }
    
    public int getNodoVacionX(){
        return this.nodoVacioX;
    }
    
    public void setNodoVacionY(int NodoVacionx){
        this.nodoVacioX = NodoVacionx;
    }
    
    public void setNodoVacionX(int NodoVaciony){
        this.nodoVacioY = NodoVaciony;
    }
    
    public void setEstado(int[][] estado) {
        this.estado = estado;
        this.IdUnicoNodo = generarIdUnicoNodo();
    }

    public Nodo getPadre() {
        return padre;
    }

    public void setPadre(Nodo padre) {
        this.padre = padre;
    }

    public String getIdUnicoNodo(){
        return this.IdUnicoNodo;
    }
    
    /**
     * Copara dos nodos
     * @param objNodo
     * @return 
     */
    public boolean equals(Nodo objNodo){
        return this.IdUnicoNodo.equals(objNodo.getIdUnicoNodo());
    }
    
    /**
     * Generar ID unico nodo
     * @return 
     */
    private String generarIdUnicoNodo(){
        String cadena = "";
        for(int i = 0; i < this.estado.length;i++ )   {
            for(int j = 0; j < this.estado[i].length;j++ )   {
               cadena += Integer.toString(this.estado[i][j]) + "-";
            }
            cadena += ":";
        }
        return cadena;
    }
    
    public int getInfoNodo() {
        return infoNodo;
    }

    public void setInfoNodo(int infoNodo) {
        this.infoNodo = infoNodo;
    }
    
    public int getValor() {
        return this.Valor;
    }

    public void setValor(int Valor) {
        this.Valor = Valor;
    }

    @Override
    public int compareTo(Nodo o) {
        if (infoNodo < o.getInfoNodo()) {
            return -1;
        }
        if (infoNodo > o.getInfoNodo()) {
            return 1;
        }
        return 0;
    }

}
