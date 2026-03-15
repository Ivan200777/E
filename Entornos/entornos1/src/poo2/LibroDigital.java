package poo2;

public class LibroDigital extends Libro {

    private String formato;
    private double tamañoMB;

    public LibroDigital(String titulo, String ISBN, String editorial, String idioma,
                        int N_Paginas, int año, boolean reserva_disponible,
                        String formato, double tamañoMB) {

        super(titulo, ISBN, editorial, idioma, N_Paginas, año, reserva_disponible);
        this.formato = formato;
        this.tamañoMB = tamañoMB;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public double getTamañoMB() {
        return tamañoMB;
    }

    public void setTamañoMB(double tamañoMB) {
        this.tamañoMB = tamañoMB;
    }
}