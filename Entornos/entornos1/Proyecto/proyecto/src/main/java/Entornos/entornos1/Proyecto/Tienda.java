package Entornos.entornos1.Proyecto;

/**
 * Clase que dirige el sistema de ventas.
 */
public class Tienda {

    /**
     * Calcula el porcentaje de descuento según el cliente.
     * @param cliente Cliente al que aplicar el descuento.
     * @return Porcentaje de descuento entre 0 y 1.
     */
    private double calcularDescuento(Cliente cliente) {
        double descuento = 0;
        if (cliente.getAniosAntiguedad() >= 5) descuento += 0.05;
        if (cliente.getAniosAntiguedad() >= 10) descuento += 0.05;
        if (cliente.esVip()) descuento += 0.10;
        return descuento;
    }

    /**
     * Realiza una venta completa y genera una factura.
     * @param cliente Cliente que realiza la compra.
     * @param pedido Pedido con los productos.
     * @return Factura generada con el toString de la clase factura.
     */
    public Factura realizarVenta(Cliente cliente, Pedido pedido) {
        double totalNeto = 0;
        double totalIva = 0;
        double totalEnvio = 0;

        for (Productos p : pedido.getProductos()) {
            double precioBase = p.getPrecio();
            totalNeto += precioBase;

            if (p instanceof ProductoDigital) {
                ProductoDigital pd = (ProductoDigital) p;
                totalIva += precioBase * (pd.getMultiplicadorIva() - 1);
            }

            if (p instanceof ProductoFisico) {
                ProductoFisico pf = (ProductoFisico) p;
                totalEnvio += pf.calcularCosteEnvio();
            }
        }

        double totalDescuento = (totalNeto + totalIva + totalEnvio) * calcularDescuento(cliente);
        return new Factura(totalNeto, totalIva, totalEnvio, totalDescuento);
    }
}