package Entornos.entornos1.Proyecto;

public class Main {

    public static void main(String[] args) {

        // Creamos los clientes
        Cliente cliente1 = new Cliente("Iván Sarmiento", "ivi@gmail.com", "Av. Porfa ponme un 10 :) ");
        Cliente cliente2 = new Cliente("Miguel González", "migui@gmail.com", "Calle Jerez 12");

        //  Creamos productos físicos
        ProductoFisico teclado = new ProductoFisico("Teclado", 50, 5);
        ProductoFisico monitor = new ProductoFisico("Monitor", 150, 10);
        ProductoFisico raton = new ProductoFisico("Ratón", 300, 3);

        //  Creamos productos digitales
        ProductoDigital ebook = new ProductoDigital("eBook ", 15, 100);
        ProductoDigital antivirus = new ProductoDigital("Antivirus", 40, 4);
        ProductoDigital software = new ProductoDigital("Software de diseño", 100, 500);

        //  Creamos pedido para cliente1
        Pedido pedido1 = new Pedido(cliente1);
        pedido1.agregarProductos(teclado);
        pedido1.agregarProductos(monitor);
        pedido1.agregarProductos(ebook);

        // Añadimos el pedido al cliente 
        cliente1.agregarPedido(pedido1);

        //  Creamos el pedido para cliente2
        Pedido pedido2 = new Pedido(cliente2);
        pedido2.agregarProductos(raton);
        pedido2.agregarProductos(antivirus);
        pedido2.agregarProductos(software);

        // Añadimos el pedido al cliente
        cliente2.agregarPedido(pedido2);

        //  Mostramos el resumen de pedidos
        System.out.println(" Resumen Pedidos Cliente 1 ");
        pedido1.mostrarResumen();

        System.out.println(" Resumen Pedidos Cliente 2 ");
        pedido2.mostrarResumen();
    }
}


