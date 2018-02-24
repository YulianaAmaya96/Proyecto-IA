package Model;

/**
 *
 * @author Yuliana Amaya
 */
public class Nodo implements Comparable<Nodo> {

    private int[][] estado;
    private Nodo padre;
    private int infoNodo;

    public Nodo() {
    }

    public Nodo(int[][] estado, Nodo padre) {
        this.estado = estado;
        this.padre = padre;
        this.infoNodo = 0;
    }

    public int[][] getEstado() {
        return estado;
    }

    public void setEstado(int[][] estado) {
        this.estado = estado;
    }

    public Nodo getPadre() {
        return padre;
    }

    public void setPadre(Nodo padre) {
        this.padre = padre;
    }

    public int getInfoNodo() {
        return infoNodo;
    }

    public void setInfoNodo(int infoNodo) {
        this.infoNodo = infoNodo;
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
