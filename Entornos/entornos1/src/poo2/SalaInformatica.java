package poo2;

public class SalaInformatica extends Sala {

    private int numEquipos;

    public SalaInformatica(String nombre, int capacidad, boolean pizarra, String tipo, boolean disponible,
                            int aforoMaximo, int numPersonasActuales, int numEquipos) {
        super(nombre, capacidad, pizarra, tipo, disponible);
        this.numEquipos = numEquipos;
    }

    public int getNumEquipos() {
        return numEquipos;
    }

    public void setNumEquipos(int numEquipos) {
        this.numEquipos = numEquipos;
    }
}
