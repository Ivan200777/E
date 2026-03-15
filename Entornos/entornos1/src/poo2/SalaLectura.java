package poo2;

import java.util.ArrayList;
import java.util.List;

public class SalaLectura extends Sala {

    private List<Libro> listaLibros = new ArrayList<>();

    public SalaLectura(String nombre, int capacidad, boolean pizarra, String tipo, boolean disponible,
                       int aforoMaximo, int numPersonasActuales) {
        super(nombre, capacidad, pizarra, tipo, disponible);
    }

    public List<Libro> getListaLibros() {
        return listaLibros;
    }

    public void añadirLibro(Libro libro) {
        listaLibros.add(libro);
    }
}
