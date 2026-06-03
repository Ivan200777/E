package Entornos.entornos1.Proyecto;

public class ProductoDigital extends Productos {
    
    private double tamañoDescarga;
    private String tipoIva;

    public ProductoDigital (String nombre, double precio, double tamañoDescarga){
     super(nombre, precio); // llama al constructor de la clase Productos
        this.tamañoDescarga = tamañoDescarga;
        this.tipoIva = "GENERAL";

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
        return getPrecio() * getMultiplicadorIva() * (1 - 0.10);
    }
        public String getTipoIva() { return tipoIva; }

    public void aplicarIVA(String tipoIva) {
        if (!tipoIva.equals("GENERAL") && !tipoIva.equals("REDUCIDO") && !tipoIva.equals("SUPER")) {
            throw new IllegalArgumentException("Tipo de IVA no válido: " + tipoIva);
        }
        this.tipoIva = tipoIva;
    }

    public double getMultiplicadorIva() {
        switch (tipoIva) {
            case "REDUCIDO": return 1.10;
            case "SUPER":    return 1.04;
            default:         return 1.21;
        }
    }
        
        @Override
        public String toString(){
            return getID() + "- " +  getNombre() + " Digital. Precio Final: " + calcularPrecioFinal();
        } 

}
