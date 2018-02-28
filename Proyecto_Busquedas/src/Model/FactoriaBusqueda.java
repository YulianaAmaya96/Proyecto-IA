package Model;

import javax.swing.JOptionPane;

/**
 *
 * @author Yuliana Amaya
 */
public class FactoriaBusqueda implements FactoriaMetodoBusqueda {

    @Override
    public Busqueda crearBusqueda(String nombre) {
        Busqueda obj = null;
        switch (nombre) {
            case "Amplitud":
                obj = new BusquedaAmplitud();
                break;
            case "Profundidad":
                obj = new BusquedaProfundidad();
                break;
            case "Ascensoencolina": 
                obj = new AscensoColina();
                break; 
            case "A*":
                obj = new AAsterisco();
                break;
            case "Ramificaciónyacotamiento":
                obj = new RamifyAcota();
                break;
            case "Ramificaciónyacotamientoconsubestimación":
                obj = new RamifyAcota_Sub();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Item incorrecto");
                break;
        }
        return obj;
    }

}
