package Model;

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
            case "AscensoColina":
                obj = new AscensoColina();
                break;
            case "A*":
                obj = new AAsterisco();
                break;
            case "RamificacionSin":
                obj = new RamifyAcota();
                break;
            case "RamificacionCon":
                obj = new RamifyAcota_Sub();
                break;
            default:
                break;
        }
        return obj;
    }

}
