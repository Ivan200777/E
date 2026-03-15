package poo2;

import java.util.List;
import java.util.ArrayList;

public class Biblioteca {

    private String nombre;
    private String direccion;
    private int horaApertura; 
    private int horaCierre; 

    private List<Libro> libros;
    private List<Sala> salas;
    private List<PersonaPOO> personas;

    public Biblioteca(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.horaApertura = 9;
        this.horaCierre = 22;
        this.libros = new ArrayList<>();
        this.salas = new ArrayList<>();
        this.personas = new ArrayList<>();
    }

    public void estaAbierta(int hora) {
        if (hora >= this.horaApertura && hora <= this.horaCierre) {
            System.out.println("La biblioteca está abierta");
        } else {
            System.out.println("La biblioteca está cerrada");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public List<Sala> getSalas() {
        return salas;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public List<PersonaPOO> getPersonas() {
        return personas;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getHoraApertura() {
        return horaApertura;
    }

    public int getHoraCierre() {
        return horaCierre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setHoraApertura(int horaApertura) {
        this.horaApertura = horaApertura;
    }

    public void setHoraCierre(int horaCierre) {
        this.horaCierre = horaCierre;
    }

    public void esExtranjero(Libro libro) {
        if (libro.getIdioma().equalsIgnoreCase("español") ||
            libro.getIdioma().equalsIgnoreCase("castellano")) {
            System.out.println("El libro " + libro.getTitulo() + " está escrito en español.");
        } else {
            System.out.println("El libro " + libro.getTitulo() + 
                    " está escrito en un idioma extranjero (" + libro.getIdioma() + ").");
        }
    }

    public void mostrarInformacion() {
        System.out.println("Biblioteca: " + nombre + " - " + direccion +
                ". Abierto de " + horaApertura + ":00 a " + horaCierre + ":00.");

        System.out.println("Libros:");
        for (Libro l : libros) {
            System.out.println(" - " + l.getTitulo());
        }

        System.out.println("Salas:");
        for (Sala s : salas) {
            System.out.println(" - " + s.getNombre());
            if (s.getResponsable() != null) {
                System.out.println("   Responsable: " + s.getResponsable().getNombre());
            }
        }

        System.out.println("Personas registradas:");
        for (PersonaPOO p : personas) {
            System.out.println(" - " + p.getNombre());
        }
    }

    public void addLibro(Libro libro) {
        libros.add(libro);
        System.out.println("Libro añadido: " + libro.getTitulo());
    }

    public void addSala(Sala sala) {
        salas.add(sala);
        System.out.println("Sala añadida: " + sala.getNombre());
    }

    public void removeLibro(Libro libro) {
        if (libros.remove(libro)) {
            System.out.println("Libro eliminado: " + libro.getTitulo());
        } else {
            System.out.println("El libro no se encontró en la biblioteca");
        }
    }

    public void mostrarLibros() {
        System.out.println("Libros disponibles:");
        if (libros.isEmpty()) {
            System.out.println("No hay libros registrados.");
        } else {
            for (Libro libro : libros) {
                System.out.println(" - " + libro.getTitulo());
            }
        }
    }

    public void removeSala(Sala sala) {
        if (salas.remove(sala)) {
            System.out.println("Sala eliminada: " + sala.getNombre());
        } else {
            System.out.println("La sala no se encontró en la biblioteca");
        }
    }

    public void registrarVisita(PersonaPOO p) {
        personas.add(p);
        System.out.println("Ha entrado la persona: " + p.getNombre());
    }

    public void asignarResponsable(Sala sala, PersonaPOO p) {
        sala.setResponsable(p);
    }

    public void mostrarSalas() {
        System.out.println("Salas de la biblioteca:");
        if (salas.isEmpty()) {
            System.out.println("No hay salas registradas.");
        } else {
            for (Sala sala : salas) {
                System.out.println(sala.getNombre() + 
                    " tiene " + sala.getPersonas().size() + " personas.");
            }
        }
    }

    public void mostrarSalasDisponibles() {
        System.out.println("Salas disponibles (0 personas):");
        boolean alguna = false;

        for (Sala sala : salas) {
            if (sala.getPersonas().isEmpty()) {
                System.out.println(" - " + sala.getNombre());
                alguna = true;
            }
        }

        if (!alguna) System.out.println("No hay salas disponibles.");
    }

    public void mostrarBiblioteca() {
        mostrarInformacion();
        mostrarLibros();
        mostrarSalas();
    }

    public Libro mostrarLibroPorTitulo(String titulo) {
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                System.out.println("Libro encontrado: " + libro.getTitulo());
                return libro;
            }
        }
        System.out.println("No se encontró ningún libro con el título: " + titulo + ".");
        return null;
    }

    public void mostrarTotalPersonas() {
        int total = 0;
        for (Sala sala : salas) {
            total += sala.getPersonas().size();
        }
        System.out.println("Total de personas en todas las salas: " + total);
    }
}
