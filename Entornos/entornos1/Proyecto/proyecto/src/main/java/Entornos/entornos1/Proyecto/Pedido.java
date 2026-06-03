package Entornos.entornos1.Proyecto;

import java.util.ArrayList;
import java.util.List;

import java.time.LocalDate;


public class Pedido {
    
    private static int contadorPedidos = 1;

    private String ID;
    private Cliente cliente; //introducimos Cliente para acceder a toda la información del cliente, lo que viene siendo la asociación.
    private List<Productos> productos = new ArrayList<>();
    private LocalDate fecha;
    //constructor

    public Pedido (Cliente cliente) {
        this.ID  = "PED" + contadorPedidos++;
        this.cliente = cliente;
        this.productos = new ArrayList<>();
        this.fecha = LocalDate.now();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Productos> getProductos() {
        return productos;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setProductos(List<Productos> productos) {
        this.productos = productos;
    }
    //Este es el método para añadir un producto
    public void agregarProductos (Productos producto){
        productos.add(producto);
    }
    //Calculamos
     public double calcularTotal() {
        // TC-N05: lanza excepción si el pedido está vacío
        if (productos.isEmpty()) {
            throw new IllegalStateException("El pedido no tiene productos.");
        }
        double total = 0;
        for (Productos p : productos) {
            total += p.calcularPrecioFinal();
        }
        return total;
    }

    //Resumen
      public void mostrarResumen() {
     
        System.out.println("ID del Pedido " + ID);
        System.out.println("Fecha: " + fecha);
        System.out.println("Cliente: " + cliente);
        System.out.println("Productos:");
        for (Productos p : productos) {
            System.out.println("- " + p); // usa el toString de cada producto
        }
        System.out.println("Importe total: " + calcularTotal());
        System.out.println("La compra ha sido completada con éxito.");
    }


}