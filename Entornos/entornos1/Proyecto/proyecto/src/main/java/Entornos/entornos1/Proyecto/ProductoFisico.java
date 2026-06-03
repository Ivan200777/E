package Entornos.entornos1.Proyecto;

public class ProductoFisico extends Productos {
    //Introducimos extends para hacer la herencia
    private double costeEnvio;
    private double peso;
    private String zonaDestino;
    //heredamos en el constructor los atributos de los productos.
    public ProductoFisico (String nombre, double precio, double peso, String zonaDestino){
        super(nombre, precio); // llama al constructor de la clase Productos
        this.peso=peso;
        this.zonaDestino=zonaDestino;
    }

    

    public void setCosteEnvio(double costeEnvio) {
        this.costeEnvio = costeEnvio;
    }

    public double getPeso() {
        return peso;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getZonaDestino() {
        return zonaDestino;
    }

    public void setZonaDestino(String zonaDestino) {
        this.zonaDestino = zonaDestino;
    }

    public double calcularCosteEnvio() {
    if (zonaDestino.equalsIgnoreCase("España")) return 0;
    if (zonaDestino.equalsIgnoreCase("Francia") ||
        zonaDestino.equalsIgnoreCase("Italia") ||
        zonaDestino.equalsIgnoreCase("Portugal")) return 5;
    return 10;
}
    @Override
    public double calcularPrecioFinal() {
        return getPrecio() + calcularCosteEnvio();
    }

    @Override 
    public String toString(){
        return getID() + "- " + getNombre() + " Físico. Precio Final: " + calcularPrecioFinal() + "(Coste de envío: " + costeEnvio + ")";
    }

}
