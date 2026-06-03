package Entornos.entornos1.Proyecto;

public class ProductoFisico extends Productos {
    //Introducimos extends para hacer la herencia
    private double costeEnvio;
    //heredamos en el constructor los atributos de los productos.
    public ProductoFisico (String nombre, double precio, double costeEnvio){
        super(nombre, precio); // llama al constructor de la clase Productos
        this.costeEnvio = costeEnvio;
    }

    public double getCosteEnvio() {
        return costeEnvio;
    }

    public void setCosteEnvio(double costeEnvio) {
        this.costeEnvio = costeEnvio;
    }

    @Override 
    public double calcularPrecioFinal(){
        return getPrecio()+ costeEnvio;
    }

    @Override 
    public String toString(){
        return getID() + "- " + getNombre() + " Físico. Precio Final: " + calcularPrecioFinal() + "(Coste de envío: " + costeEnvio + ")";
    }

}
