package Entornos.entornos1;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Esta clase creada es totalmente necesaria para mi proyecto, aquí vamos a realizar los casos de pruebas
 * así que veámoslos poco a poco
 */
class PedidoTest {


    /**
     * CP-P01 | REQ-01
     * Verifica que ProductoDigital aplica IVA 21% y descuento 10%.
     * Fórmula: precio * 1.21 * 0.90
     */
    @Test
    @DisplayName("CP-P01: ProductoDigital aplica IVA 21% y descuento 10%")
    void testProductoDigitalIVAyDescuento() {
        ProductoDigital pd = new ProductoDigital("eBook", 100.0, 50);
        double esperado = 100.0 * 1.21 * 0.90; // 108.9
        assertEquals(esperado, pd.calcularPrecioFinal(), 0.01,
                "El precio final debe aplicar IVA 21% y descuento 10%");
    }

    /**
     * CP-P02 | REQ-02
     * Verifica que ProductoFisico suma el coste de envío al precio base.
     * Fórmula: precio + costeEnvio
     */
    @Test
    @DisplayName("CP-P02: ProductoFisico suma el coste de envío al precio base")
    void testProductoFisicoCosteEnvio() {
        ProductoFisico pf = new ProductoFisico("Teclado", 50.0, 5.0);
        assertEquals(55.0, pf.calcularPrecioFinal(), 0.01,
                "El precio final debe ser precio + costeEnvio");
    }

    /**
     * CP-P03 | REQ-03
     * Verifica que calcularTotal() suma correctamente productos mixtos
     * (un ProductoFisico y un ProductoDigital en el mismo pedido).
     */
    @Test
    @DisplayName("CP-P03: calcularTotal() suma productos físicos y digitales correctamente")
    void testPedidoCalculaTotalConProductosMixtos() {
        Cliente c = new Cliente("Test", "test@test.com", "Calle Test");
        Pedido pedido = new Pedido(c);
        pedido.agregarProductos(new ProductoFisico("Ratón", 20.0, 2.0));    // 22.0
        pedido.agregarProductos(new ProductoDigital("Software", 100.0, 1)); // 108.9
        double esperado = 22.0 + (100.0 * 1.21 * 0.90);
        assertEquals(esperado, pedido.calcularTotal(), 0.01);
    }

    /**
     * CP-P04 | REQ-03
     * CASO ADICIONAL: pedido con un solo producto devuelve exactamente su precio final.
     * Cubre el caso límite de lista con un único elemento.
     */
    @Test
    @DisplayName("CP-P04: Pedido con un único producto devuelve su precio final")
    void testPedidoUnSoloProducto() {
        Cliente c = new Cliente("Ana", "ana@test.com", "Calle Mayor");
        Pedido pedido = new Pedido(c);
        pedido.agregarProductos(new ProductoFisico("Monitor", 150.0, 10.0)); // 160.0
        assertEquals(160.0, pedido.calcularTotal(), 0.01);
    }

    /**
     * CP-P05 | REQ-01
     * CASO ADICIONAL: ProductoDigital con precio base 0 devuelve 0.
     * Verifica el comportamiento en el límite inferior del precio.
     */
    @Test
    @DisplayName("CP-P05: ProductoDigital con precio 0 devuelve precio final 0")
    void testProductoDigitalPrecioCero() {
        ProductoDigital pd = new ProductoDigital("Gratis", 0.0, 10);
        assertEquals(0.0, pd.calcularPrecioFinal(), 0.001);
    }

    /**
     * CP-N01 | REQ-01
     * El precio final de ProductoDigital NO es igual al precio base.
     */
    @Test
    @DisplayName("CP-N01: Precio final de ProductoDigital != precio base")
    void testProductoDigitalPrecioFinalDistintoDePrecioBase() {
        ProductoDigital pd = new ProductoDigital("Antivirus", 40.0, 4);
        assertNotEquals(40.0, pd.calcularPrecioFinal(),
                "El IVA y descuento deben modificar el precio base");
    }

    /**
     * CP-N02 | REQ-02
     * El precio final de ProductoFisico con envío NO es igual al precio base.
     */
    @Test
    @DisplayName("CP-N02: Precio final de ProductoFisico != precio base cuando hay envío")
    void testProductoFisicoPrecioFinalDistintoConEnvio() {
        ProductoFisico pf = new ProductoFisico("Monitor", 150.0, 10.0);
        assertNotEquals(150.0, pf.calcularPrecioFinal(),
                "El coste de envío debe incrementar el precio base");
    }

    /**
     * CP-N03 | REQ-03
     * CASO ADICIONAL: el total de un pedido con productos nunca es 0.
     */
    @Test
    @DisplayName("CP-N03: Pedido con productos tiene total mayor que cero")
    void testPedidoTotalNoEsCero() {
        Cliente c = new Cliente("Luis", "luis@test.com", "Av. Central");
        Pedido pedido = new Pedido(c);
        pedido.agregarProductos(new ProductoFisico("Ratón", 30.0, 3.0));
        assertFalse(pedido.calcularTotal() == 0.0,
                "El total no puede ser 0 si hay productos");
    }


    /**
     * CP-N04 | REQ-04
     * Crear un producto con precio negativo lanza IllegalArgumentException.
     * NOTA: Requiere validación en el constructor de Productos.java:
     *   if (precio < 0) throw new IllegalArgumentException(...)
     */
    @Test
    @DisplayName("CP-N04: Producto con precio negativo lanza IllegalArgumentException")
    void testProductoPrecioNegativoLanzaExcepcion() {
        assertThrows(IllegalArgumentException.class,
                () -> new ProductoFisico("Inválido", -10.0, 5.0),
                "Debe lanzar IllegalArgumentException si el precio es negativo");
    }

    /**
     * CP-N05 | REQ-04
     * Calcular el total de un pedido sin productos lanza IllegalStateException.
     * NOTA: Requiere validación en calcularTotal() de Pedido.java:
     *   if (productos.isEmpty()) throw new IllegalStateException(...)
     */
    @Test
    @DisplayName("CP-N05: Pedido vacío lanza IllegalStateException al calcular total")
    void testPedidoVacioLanzaExcepcion() {
        Cliente c = new Cliente("Pedro", "pedro@test.com", "Calle Sur");
        Pedido pedido = new Pedido(c);
        assertThrows(IllegalStateException.class,
                pedido::calcularTotal,
                "Debe lanzar IllegalStateException si el pedido no tiene productos");
    }


 
    /**
     * CP-PAR01 | REQ-01
     * Verifica calcularPrecioFinal() de ProductoDigital con 5 precios base distintos.
     * Fórmula verificada: precioBase * 1.21 * 0.90
     */
    @ParameterizedTest(name = "[CP-PAR01] Precio base {0} -> esperado {1}")
    @DisplayName("CP-PAR01: ProductoDigital con distintos precios base")
    @CsvSource({
        "0.0,   0.0",
        "10.0,  10.89",
        "50.0,  54.45",
        "100.0, 108.90",
        "200.0, 217.80"
    })
    void testProductoDigitalParametrizado(double precioBase, double esperado) {
        ProductoDigital pd = new ProductoDigital("Producto", precioBase, 1);
        assertEquals(esperado, pd.calcularPrecioFinal(), 0.01);
    }

    /**
     * CP-PAR02 | REQ-02
     * Verifica calcularPrecioFinal() de ProductoFisico con distintas combinaciones
     * de precio y coste de envío, incluyendo el caso de envío 0.
     */
    @ParameterizedTest(name = "[CP-PAR02] Precio {0} + Envio {1} -> total {2}")
    @DisplayName("CP-PAR02: ProductoFisico con distintos precios y costes de envío")
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

    /**
     * CP-PAR03 | REQ-03
     * CASO ADICIONAL PARAMETRIZADO:
     * Verifica calcularTotal() con distintas combinaciones de dos productos físicos.
     * Cubre el requisito: "calcularTotal() funciona con diferentes listas de productos".
     */
    @ParameterizedTest(name = "[CP-PAR03] Prod1({0}+{1}) + Prod2({2}+{3}) -> total {4}")
    @DisplayName("CP-PAR03: calcularTotal() con distintas combinaciones de dos productos")
    @CsvSource({
        "10.0, 2.0, 20.0, 3.0, 35.0",
        "50.0, 5.0, 50.0, 5.0, 110.0",
        "100.0, 0.0, 100.0, 0.0, 200.0"
    })
    void testCalcularTotalParametrizado(double p1, double e1,
                                        double p2, double e2,
                                        double esperado) {
        Cliente c = new Cliente("Test", "t@t.com", "Dir");
        Pedido pedido = new Pedido(c);
        pedido.agregarProductos(new ProductoFisico("A", p1, e1));
        pedido.agregarProductos(new ProductoFisico("B", p2, e2));
        assertEquals(esperado, pedido.calcularTotal(), 0.01);
    }
}
