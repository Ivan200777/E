package poo2;


public class Libro {
    private String titulo;
    private String ISBN;
    private String editorial;
    private String idioma;
    private int N_Paginas;
    private int año;
    private boolean reserva_disponible;

    public Libro(String titulo, String ISBN, String editorial, String idioma, int N_Paginas, int año,
            boolean reserva_disponible) {

        this.titulo = titulo;
        this.ISBN = ISBN;
        this.editorial = editorial;
        this.idioma = idioma;
        this.N_Paginas = N_Paginas;
        this.año = año;
        this.reserva_disponible = reserva_disponible;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getEditorial() {
        return editorial;
    }

    public String getIdioma() {
        return idioma;
    }

    public int getNumPaginas() {
        return N_Paginas;
    }

    public int getAño() {
        return año;
    }

    public boolean reserva_disponible() {
        return reserva_disponible;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setIsbn(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public void setNumPaginas(int N_Paginas) {
        this.N_Paginas = N_Paginas;
    }

    public void setAnio(int año) {
        this.año = año;
    }

    public void setDisponible(boolean reserva_disponible) {
        this.reserva_disponible = reserva_disponible;

    }

    public void estaDisponible() {
        if (reserva_disponible) {
            System.out.println("El libro " + this.titulo + " está disponible para reserva.");
        } else {
            System.out.println("El libro " + this.titulo + " no está disponible para reserva.");
        }
    }

    public void esExtranjero() {
        if (idioma.equalsIgnoreCase("español") ||idioma.equalsIgnoreCase("castellano")) {
            System.out.println("El libro " + titulo + " está escrito en español.");
        } else {
             System.out.println("El libro " + titulo + " está escrito en un idioma extranjero (" + idioma + ").");
           
        }
    }

    public void mostrarInformacion() {
        System.out.println("Título: " + this.titulo + ", ISBN " + this.ISBN + " , editorial: " + this.editorial
                + " , idioma: " + this.idioma + " , Número de páginas: " + this.N_Paginas + " , año: " + this.año
                + " , Reserva disponible: " + this.reserva_disponible);

    }
}