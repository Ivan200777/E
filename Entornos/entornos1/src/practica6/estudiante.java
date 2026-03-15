package practica6;
import java.util.ArrayList;
import java.util.Date;

public class estudiante extends persona {
    private boolean repetidor;

 
    private ArrayList<matricula> matriculas;

    public estudiante() {
        matriculas = new ArrayList<>();
    }

    public estudiante(String dni, String nombre, Date fechaNacimiento, boolean repetidor) {
        super(dni, nombre, fechaNacimiento);
        this.repetidor = repetidor;
        this.matriculas = new ArrayList<>();
    }

    public matricula inscribirse(curso c) {
        return null;
    }

    public boolean isRepetidor() {
        return repetidor;
    }

    public void setRepetidor(boolean repetidor) {
        this.repetidor = repetidor;
    }

    public ArrayList<matricula> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(ArrayList<matricula> matriculas) {
        this.matriculas = matriculas;
    }
}
