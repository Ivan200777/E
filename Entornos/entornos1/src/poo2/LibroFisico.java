package poo2;

public class LibroFisico extends Libro {

    private String ubicacion;

    public LibroFisico(String titulo, String ISBN, String editorial, String idioma,
                       int N_Paginas, int año, boolean reserva_disponible,
                       String ubicacion) {

        super(titulo, ISBN, editorial, idioma, N_Paginas, año, reserva_disponible);
        this.ubicacion = ubicacion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
}
