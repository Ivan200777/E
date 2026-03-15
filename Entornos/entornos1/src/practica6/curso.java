package practica6;

import java.util.ArrayList;

public class curso {
    private String codigo;
    private String nombre;
    private int cupoMaximo;

    private profesor profesor;
    private ArrayList<estudiante> inscripciones;
    private ArrayList<horario> horarios;

    public curso() {
        inscripciones = new ArrayList<>();
        horarios = new ArrayList<>();
    }

    public curso(String codigo, String nombre, int cupoMaximo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cupoMaximo = cupoMaximo;
        this.inscripciones = new ArrayList<>();
        this.horarios = new ArrayList<>();
    }

    public matricula inscribir(estudiante e) {
        return null;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCupoMaximo() {
        return cupoMaximo;
    }

    public void setCupoMaximo(int cupoMaximo) {
        this.cupoMaximo = cupoMaximo;
    }

    public profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(profesor profesor) {
        this.profesor = profesor;
    }

    public ArrayList<estudiante> getInscripciones() {
        return inscripciones;
    }

    public void setInscripciones(ArrayList<estudiante> inscripciones) {
        this.inscripciones = inscripciones;
    }

    public ArrayList<horario> getHorarios() {
        return horarios;
    }

    public void setHorarios(ArrayList<horario> horarios) {
        this.horarios = horarios;
    }
}
