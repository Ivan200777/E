package practica6;
import java.util.ArrayList;

public class universidad {
    private String nombre;

    private ArrayList<departamento> departamentos;

    public universidad() {
        departamentos = new ArrayList<>();
    }

    public universidad(String nombre) {
        this.nombre = nombre;
        this.departamentos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<departamento> getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(ArrayList<departamento> departamentos) {
        this.departamentos = departamentos;
    }
}
