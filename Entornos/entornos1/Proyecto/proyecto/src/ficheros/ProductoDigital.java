package Entornos.entornos1.Proyecto;

public class ProductoDigital extends Productos {
    
    private double tamañoDescarga;

    public ProductoDigital (String nombre, double precio, double tamañoDescarga){
     super(nombre, precio); // llama al constructor de la clase Productos
        this.tamañoDescarga = tamañoDescarga;

    }

    public double getTamañoDescarga() {
        return tamañoDescarga;
    }

    public void setTamañoDescarga(double tamañoDescarga) {
        this.tamañoDescarga = tamañoDescarga;
    }
        //calcular precio final con IVA Y descuento
        @Override
        public double calcularPrecioFinal(){
            double iva = 0.21;
            double descuento = 0.10; //el descuento será de un 10%
            double precioconIVA = getPrecio() * (1+iva);
            return precioconIVA * (1-descuento);
        }
        
        @Override
        public String toString(){
            return getID() + "- " +  getNombre() + " Digital. Precio Final: " + calcularPrecioFinal();
        } 

}
