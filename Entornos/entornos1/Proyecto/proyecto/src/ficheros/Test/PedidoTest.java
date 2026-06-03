package Entornos.entornos1.Proyecto;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class PedidoTest {

    // CP-P01: ProductoDigital aplica IVA 21% y descuento 10%
    @Test
    @DisplayName("CP-P01: ProductoDigital aplica IVA 21% y descuento 10%")
    void testProductoDigitalIVAyDescuento() {
        ProductoDigital pd = new ProductoDigital("eBook", 100.0, 50.0);
        double esperado = 100.0 * 1.21 * 0.90;
        assertEquals(esperado, pd.calcularPrecioFinal(), 0.01,
                "El precio final debe aplicar IVA 21% y descuento 10%");
    }

    // CP-P02: ProductoFisico suma el coste de envío
    @Test
    @DisplayName("CP-P02: ProductoFisico suma el coste de envío al precio base")
    void testProductoFisicoCosteEnvio() {
        ProductoFisico pf = new ProductoFisico("Teclado", 50.0, 5.0);
        assertEquals(55.0, pf.calcularPrecioFinal(), 0.01,
                "El precio final debe ser precio + costeEnvio");
    }

    // CP-P03: calcularTotal() con productos mixtos
    @Test
    @DisplayName("CP-P03: calcularTotal() suma productos físicos y digitales correctamente")
    void testPedidoCalculaTotalConProductosMixtos() {
        Cliente c = new Cliente("Test", "test@test.com", "Calle Test");
        Pedido pedido = new Pedido(c);
        pedido.agregarProductos(new ProductoFisico("Ratón", 20.0, 2.0));
        pedido.agregarProductos(new ProductoDigital("Software", 100.0, 1.0));
        double esperado = 22.0 + (100.0 * 1.21 * 0.90);
        assertEquals(esperado, pedido.calcularTotal(), 0.01);
    }

    // CP-P04: Pedido con un único producto
    @Test
    @DisplayName("CP-P04: Pedido con un único producto devuelve su precio final")
    void testPedidoUnSoloProducto() {
        Cliente c = new Cliente("Ana", "ana@test.com", "Calle Mayor");
        Pedido pedido = new Pedido(c);
        pedido.agregarProductos(new ProductoFisico("Monitor", 150.0, 10.0));
        assertEquals(160.0, pedido.calcularTotal(), 0.01);
    }

    // CP-P05: ProductoDigital con precio 0 devuelve 0
    @Test
    @DisplayName("CP-P05: ProductoDigital con precio 0 devuelve precio final 0")
    void testProductoDigitalPrecioCero() {
        ProductoDigital pd = new ProductoDigital("Gratis", 0.0, 0.0);
        assertEquals(0.0, pd.calcularPrecioFinal(), 0.001);
    }

    // CP-N01: Precio final de ProductoDigital != precio base
    @Test
    @DisplayName("CP-N01: Precio final de ProductoDigital es distinto al precio base")
    void testProductoDigitalPrecioFinalDistinto() {
        ProductoDigital pd = new ProductoDigital("Antivirus", 40.0, 4.0);
        assertNotEquals(40.0, pd.calcularPrecioFinal());
    }

    // CP-N02: Precio final de ProductoFisico con envío != precio base
    @Test
    @DisplayName("CP-N02: Precio final de ProductoFisico con envío es distinto al precio base")
    void testProductoFisicoPrecioFinalDistinto() {
        ProductoFisico pf = new ProductoFisico("Monitor", 150.0, 10.0);
        assertNotEquals(150.0, pf.calcularPrecioFinal());
    }

    // CP-N03: Total pedido con productos nunca es 0
    @Test
    @DisplayName("CP-N03: Total de un pedido con productos es mayor que cero")
    void testPedidoTotalNoEsCero() {
        Cliente c = new Cliente("Luis", "luis@test.com", "Av. Central");
        Pedido pedido = new Pedido(c);
        pedido.agregarProductos(new ProductoFisico("Ratón", 30.0, 3.0));
        assertFalse(pedido.calcularTotal() == 0.0);
    }

    // CP-N04: Precio negativo lanza IllegalArgumentException
    @Test
    @DisplayName("CP-N04: Producto con precio negativo lanza IllegalArgumentException")
    void testProductoPrecioNegativo() {
        assertThrows(IllegalArgumentException.class,
                () -> new ProductoFisico("Inválido", -10.0, 5.0));
    }

    // CP-N05: Pedido vacío lanza IllegalStateException
    @Test
    @DisplayName("CP-N05: Pedido vacío lanza IllegalStateException al calcular total")
    void testPedidoVacioLanzaExcepcion() {
        Cliente c = new Cliente("Pedro", "pedro@test.com", "Calle Sur");
        Pedido pedido = new Pedido(c);
        assertThrows(IllegalStateException.class, pedido::calcularTotal);
    }

    // CP-PAR01: ProductoDigital con distintos precios base
    @ParameterizedTest(name = "Precio base {0} -> esperado {1}")
    @DisplayName("CP-PAR01: ProductoDigital calcula precio final con distintos precios")
    @CsvSource({
        "0.0,   0.0",
        "10.0,  10.89",
        "50.0,  54.45",
        "100.0, 108.90",
        "200.0, 217.80"
    })
    void testProductoDigitalParametrizado(double precioBase, double esperado) {
        ProductoDigital pd = new ProductoDigital("Producto", precioBase, 1.0);
        assertEquals(esperado, pd.calcularPrecioFinal(), 0.01);
    }

    // CP-PAR02: ProductoFisico con distintos precios y costes de envío
    @ParameterizedTest(name = "Precio {0} + Envío {1} -> total {2}")
    @DisplayName("CP-PAR02: ProductoFisico calcula precio final con distintos envíos")
    @CsvSource({
        "50.0,  5.0,  55.0",
        "100.0, 10.0, 110.0",
        "200.0, 0.0,  200.0",
        "30.0,  3.0,  33.0"
    })
    void testProductoFisicoParametrizado(double precio, double envio, double esperado) {
        ProductoFisico pf = new ProductoFisico("Producto", precio, envio);
        assertEquals(esperado, pf.calcularPrecioFinal(), 0.01);
    }

    // CP-PAR03: calcularTotal() con distintas combinaciones de dos productos
    @ParameterizedTest(name = "Prod1({0}+{1}) + Prod2({2}+{3}) -> total {4}")
    @DisplayName("CP-PAR03: calcularTotal() con distintas combinaciones de productos")
    @CsvSource({
        "10.0, 2.0, 20.0, 3.0, 35.0",
        "50.0, 5.0, 50.0, 5.0, 110.0",
        "100.0, 0.0, 100.0, 0.0, 200.0"
    })
    void testCalcularTotalParametrizado(double p1, double e1, double p2, double e2, double esperado) {
        Cliente c = new Cliente("Test", "t@t.com", "Dir");
        Pedido pedido = new Pedido(c);
        pedido.agregarProductos(new ProductoFisico("A", p1, e1));
        pedido.agregarProductos(new ProductoFisico("B", p2, e2));
        assertEquals(esperado, pedido.calcularTotal(), 0.01);
    }
}
