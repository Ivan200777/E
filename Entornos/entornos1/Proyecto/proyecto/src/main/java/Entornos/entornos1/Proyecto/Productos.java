package Entornos.entornos1.Proyecto;



/**
 * Clase abstracta base para todos los productos del sistema.
 * Define los atributos comunes y obliga a las subclases a implementar
 * el cálculo del precio final.
 */
public abstract class Productos {

    private static int contadorProductos = 1;

    private String ID;
    private String nombre;
    private double precio;

    public Productos(String nombre, double precio) {
        if (precio < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo.");
        }
        this.ID = "PROD" + contadorProductos++;
        this.nombre = nombre;
        this.precio = precio;
    }

    // Getters
    public String getID() {
        return ID;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        if (precio < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo.");
        }
        this.precio = precio;
    }

    /**
     * Cada subclase implementa su propia lógica de precio final
     * (IVA, descuento, coste de envío, etc.)
     */
    public abstract double calcularPrecioFinal();

    @Override
    public abstract String toString();
}