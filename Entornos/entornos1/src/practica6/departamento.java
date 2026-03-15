package practica6;

import java.util.ArrayList;

public class departamento {
    private String nombre;

    private ArrayList<curso> cursos;
    private universidad universidad;

    public departamento() {
        cursos = new ArrayList<>();
    }

    public departamento(String nombre) {
        this.nombre = nombre;
        this.cursos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<curso> getCursos() {
        return cursos;
    }

    public void setCursos(ArrayList<curso> cursos) {
        this.cursos = cursos;
    }

    public universidad getUniversidad() {
        return universidad;
    }

    public void setUniversidad(universidad universidad) {
        this.universidad = universidad;
    }
}
