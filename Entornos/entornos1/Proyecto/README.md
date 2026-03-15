Este proyecto está diseñado para gestionar pedidos de productos, tanto físicos como digitales, que hacen los clientes. En él vamos a encontrar clases que representarán a los clientes, pedidos y los productos, físicos y digitales, junto a sus relaciones.

Vamos a ver primeramente las clases que ya hemos mencionado, después las relaciones, las funcionalidas, las instrucciones y un ejemplo de uso.

Definamos clase por clase:

## Clases Principales

- Cliente: Representa un cliente con ID, nombre, correo, dirección y lista de pedidos.  
- Pedido: Representa un pedido asociado a un cliente y que contiene múltiples productos. Permite calcular totales y mostrar resúmenes mediante sus métodos.  
- Productos: Es la clase base para todos los productos, con atributos como ID, nombre y precio. 
    De esta clase heredan:  
     - ProductoDigital: Subclase para productos descargables, con tamaño de descarga.  
     - ProductoFisico: Subclase para productos físicos, con costo de envío incluido en el cálculo final del     precio.  


## Relaciones

- Un cliente puede tener muchos pedidos.  
- Un pedido pertenece a un solo cliente.  
- Un pedido puede contener muchos productos.  
- Productos se dividen en digitales y físicos.

## Funcionalidades

- Registrar clientes.  
- Crear pedidos para clientes.  
- Agregar productos físicos o digitales a los pedidos.  
- Calcular el total de cada pedido (considerando costos de envío y con rebajas).  
- Mostrar resúmenes completos de pedidos.


## Instrucciones de Ejecución

1. Abre el proyecto en tu IDE favorito, puedes hacerlo en Eclipse o IntelliJ por ejemplo, aunque VS Code (xon el que trabajamos) es muy cómodo.
2. Creamos los objetos de Cliente, Productos y Pedidos.
3. Utilizamos el método agregarProducto() para añadir productos al pedido.
4. Usamos el método calcularTotal()para calcular todas las compras.
5. Hacemos finalmente un resumen.

### Ejemplo de Uso


// Crear un cliente
Cliente cliente = new Cliente("Iván Sarmiento", "ivi@gmail.com", "Av. Porfa ponme un 10 :)";

// Crear productos
ProductoFisico teclado = new ProductoFisico("Teclado", 50, 5);
ProductoDigital ebook = new ProductoDigital("eBook", 15, 100);

// Crear un pedido y agregar productos
Pedido pedido = new Pedido(cliente);
pedido.agregarProductos(teclado);
pedido.agregarProductos(ebook);
cliente.agregarPedido(pedido);

// Mostrar resumen del pedido
System.out.println("Resumen del Pedido:");
pedido.mostrarResumen();

El ejemplo está sacado de la práctica tal cual.
