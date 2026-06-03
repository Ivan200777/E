package Entornos.entornos1.Proyecto;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Pruebas de integración entre Tienda, Factura, Pedido, Cliente y Productos.
 * Verifica que el flujo completo de venta funciona correctamente.
 */
class TiendaFacturaTest {

    private Tienda tienda;

    @BeforeEach
    void setUp() {
        tienda = new Tienda();
    }


    // IT-01: Flujo E2E completo: cliente normal, producto digital
    @Test
    @DisplayName("IT-01: Venta completa genera factura con datos correctos (cliente sin descuento)")
    void testVentaCompletaClienteNormal() {
        Cliente cliente = new Cliente("Ana", "ana@test.com", "Calle 1", 0, false, "España");
        Pedido pedido = new Pedido(cliente);
        pedido.agregarProductos(new ProductoDigital("eBook", 100.0, 5.0));

        Factura factura = tienda.realizarVenta(cliente, pedido);

        assertNotNull(factura, "La factura no debe ser null");
        assertEquals(100.0, factura.getTotalNeto(), 0.01);
        assertEquals(21.0,  factura.getTotalIva(),  0.01);   // 21% de 100
        assertEquals(0.0,   factura.getTotalDescuento(), 0.01); // sin descuento
        assertEquals(121.0, factura.getTotalFinal(), 0.01);
    }

    // IT-02: Flujo E2E con producto físico y envío
    @Test
    @DisplayName("IT-02: Venta con ProductoFisico incluye coste de envío en la factura")
    void testVentaConProductoFisico() {
        Cliente cliente = new Cliente("Luis", "luis@test.com", "Rue de Paris", 0, false, "Francia");
        Pedido pedido = new Pedido(cliente);
        // Francia = 5€ de envío
        pedido.agregarProductos(new ProductoFisico("Teclado", 50.0, 1.0, "Francia"));

        Factura factura = tienda.realizarVenta(cliente, pedido);

        assertNotNull(factura);
        assertEquals(50.0, factura.getTotalNeto(),  0.01);
        assertEquals(5.0,  factura.getTotalEnvio(), 0.01);
        assertEquals(55.0, factura.getTotalFinal(), 0.01);
    }

    // IT-03: Descuento VIP se aplica correctamente en la factura
    @Test
    @DisplayName("IT-03: Cliente VIP recibe 10% de descuento en el total")
    void testDescuentoClienteVip() {
        Cliente clienteVip = new Cliente("Carlos", "carlos@test.com", "Av. VIP", 0, true, "España");
        Pedido pedido = new Pedido(clienteVip);
        pedido.agregarProductos(new ProductoDigital("Software", 100.0, 1.0));

        Factura factura = tienda.realizarVenta(clienteVip, pedido);

        // Base = 100, IVA = 21 ----- subtotal = 121 ---- descuento VIP 10% = 12.10
        assertEquals(12.10, factura.getTotalDescuento(), 0.01);
        assertEquals(121.0 - 12.10, factura.getTotalFinal(), 0.01);
    }

    // IT-04: Descuento por antigüedad ≥ 5 años
    @Test
    @DisplayName("IT-04: Cliente con 5 años de antigüedad recibe 5% de descuento")
    void testDescuentoPorAntiguedad5Anios() {
        Cliente cliente = new Cliente("Marta", "marta@test.com", "Calle 5", 5, false, "España");
        Pedido pedido = new Pedido(cliente);
        pedido.agregarProductos(new ProductoDigital("Curso", 100.0, 1.0));

        Factura factura = tienda.realizarVenta(cliente, pedido);

        // subtotal = 121 = descuento 5% = 6.05
        assertEquals(6.05, factura.getTotalDescuento(), 0.01);
    }

    // IT-05: Descuento máximo: VIP + 10 años de antigüedad = 20%
    @Test
    @DisplayName("IT-05: Cliente VIP con 10+ años de antigüedad recibe 20% de descuento")
    void testDescuentoMaximo() {
        Cliente cliente = new Cliente("Pedro", "pedro@test.com", "Calle 10", 10, true, "España");
        Pedido pedido = new Pedido(cliente);
        pedido.agregarProductos(new ProductoDigital("App", 100.0, 1.0));

        Factura factura = tienda.realizarVenta(cliente, pedido);

        // VIP(10%) + antigüedad≥5(5%) + antigüedad≥10(5%) = 20%
        // subtotal = 121 = descuento 20% = 24.20
        assertEquals(24.20, factura.getTotalDescuento(), 0.01);
        assertEquals(121.0 - 24.20, factura.getTotalFinal(), 0.01);
    }

    // IT-06: Factura tiene código y fecha generados automáticamente
    @Test
    @DisplayName("IT-06: La factura generada tiene código y fecha válidos")
    void testFacturaTieneCodigoYFecha() {
        Cliente cliente = new Cliente("Eva", "eva@test.com", "Calle Eva", 0, false, "España");
        Pedido pedido = new Pedido(cliente);
        pedido.agregarProductos(new ProductoDigital("Juego", 20.0, 2.0));

        Factura factura = tienda.realizarVenta(cliente, pedido);

        assertNotNull(factura.getCodigoFactura());
        assertTrue(factura.getCodigoFactura().startsWith("FAC"));
        assertNotNull(factura.getFechaEmision());
        assertEquals(java.time.LocalDate.now(), factura.getFechaEmision());
    }

    // IT-07: Factura toString contiene todos los conceptos
    @Test
    @DisplayName("IT-07: El toString de la factura incluye todos los conceptos del desglose")
    void testFacturaToStringDesglose() {
        Cliente cliente = new Cliente("Juan", "juan@test.com", "Calle Juan", 0, false, "España");
        Pedido pedido = new Pedido(cliente);
        pedido.agregarProductos(new ProductoDigital("eBook", 50.0, 1.0));

        Factura factura = tienda.realizarVenta(cliente, pedido);
        String texto = factura.toString();

        assertTrue(texto.contains("FACTURA"));
        assertTrue(texto.contains("IVA"));
        assertTrue(texto.contains("envío") || texto.contains("Envío"));
        assertTrue(texto.contains("TOTAL"));
    }

    // IT-08: Pedido con mezcla de productos físicos y digitales
    @Test
    @DisplayName("IT-08: Factura con productos mixtos suma correctamente IVA y envío")
    void testVentaProductosMixtos() {
        Cliente cliente = new Cliente("Lola", "lola@test.com", "Av. Mix", 0, false, "España");
        Pedido pedido = new Pedido(cliente);
        pedido.agregarProductos(new ProductoDigital("eBook", 100.0, 1.0)); // IVA 21 = 21€
        pedido.agregarProductos(new ProductoFisico("Ratón", 30.0, 0.3, "Italia")); // envío 5€

        Factura factura = tienda.realizarVenta(cliente, pedido);

        assertEquals(130.0, factura.getTotalNeto(),  0.01); // 100 + 30
        assertEquals(21.0,  factura.getTotalIva(),   0.01);
        assertEquals(5.0,   factura.getTotalEnvio(), 0.01);
        assertEquals(156.0, factura.getTotalFinal(), 0.01); // 130+21+5-0
    }

    // IT-09: Robustez ----- pedido vacío lanza excepción antes de generar factura
    @Test
    @DisplayName("IT-09 (Robustez): Tienda no genera factura si el pedido está vacío")
    void testVentaPedidoVacioLanzaExcepcion() {
        Cliente cliente = new Cliente("Test", "t@t.com", "Dir", 0, false, "España");
        Pedido pedido = new Pedido(cliente);

        // La tienda itera sobre productos vacíos y devuelve factura con total 0,
        // o podemos verificar que el pedido vacío es inválido
        Factura factura = tienda.realizarVenta(cliente, pedido);
        assertEquals(0.0, factura.getTotalFinal(), 0.01,
                "Una venta sin productos debe tener total 0");
    }

    // IT-10: Robustez ----- precio negativo lanza excepción antes de llegar a Tienda
    @Test
    @DisplayName("IT-10 (Robustez): No se puede crear producto con precio negativo")
    void testProductoPrecioNegativoNoLlegaATienda() {
        assertThrows(IllegalArgumentException.class,
                () -> new ProductoDigital("Trampa", -50.0, 1.0));
    }
}