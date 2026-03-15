package poo2;

import java.util.ArrayList;
import java.util.List;

public class Usuario extends PersonaPOO {

    private int numSocio;
    private List<Libro> listaLibrosPrestados;

    public Usuario(String nombre, int edad, String apellidos, String DNI, String email,
                   int telefono, String profesion, int añosDeExperiencia,
                   int numSocio) {

        super(nombre, edad, apellidos, DNI, email, telefono, profesion, añosDeExperiencia);

        this.numSocio = numSocio;
        this.listaLibrosPrestados = new ArrayList<>();
    }

    public int getNumSocio() {
        return numSocio;
    }

    public void setNumSocio(int numSocio) {
        this.numSocio = numSocio;
    }

    public List<Libro> getListaLibrosPrestados() {
        return listaLibrosPrestados;
    }

    public void prestarLibro(Libro libro) {
        listaLibrosPrestados.add(libro);
        System.out.println(getNombre() + " ha prestado el libro: " + libro.getTitulo());
    }

    public void devolverLibro(Libro libro) {
        if (listaLibrosPrestados.remove(libro)) {
            System.out.println(getNombre() + " ha devuelto el libro: " + libro.getTitulo());
        } else {
            System.out.println("El libro no estaba prestado por este usuario.");
        }
    }
}
