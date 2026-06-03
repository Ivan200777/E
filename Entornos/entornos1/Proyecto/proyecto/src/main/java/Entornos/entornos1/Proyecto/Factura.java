package Entornos.entornos1.Proyecto;

import java.time.LocalDate;

/**
 * Clase que representa una factura generada tras una venta.
 */
public class Factura {

    private static int contadorFacturas = 1;

    private String codigoFactura;
    private LocalDate fechaEmision;
    private double totalNeto;
    private double totalIva;
    private double totalEnvio;
    private double totalDescuento;
    private double totalFinal;

    /**
     * Constructor de Factura. Aplico lo que he aprendido en el último tema con javadoc
     * @param totalNeto Base imponible sin IVA ni envío.
     * @param totalIva Total de IVA aplicado.
     * @param totalEnvio Total de gastos de envío.
     * @param totalDescuento Descuento de fidelidad aplicado.
     */
    public Factura(double totalNeto, double totalIva, double totalEnvio, double totalDescuento) {
        this.codigoFactura = "FAC" + contadorFacturas++;
        this.fechaEmision = LocalDate.now();
        this.totalNeto = totalNeto;
        this.totalIva = totalIva;
        this.totalEnvio = totalEnvio;
        this.totalDescuento = totalDescuento;
        this.totalFinal = totalNeto + totalIva + totalEnvio - totalDescuento;
    }

   

    public static int getContadorFacturas() {
        return contadorFacturas;
    }



    public String getCodigoFactura() {
        return codigoFactura;
    }



    public LocalDate getFechaEmision() {
        return fechaEmision;
    }



    public double getTotalNeto() {
        return totalNeto;
    }



    public double getTotalIva() {
        return totalIva;
    }



    public double getTotalEnvio() {
        return totalEnvio;
    }



    public double getTotalDescuento() {
        return totalDescuento;
    }



    public double getTotalFinal() {
        return totalFinal;
    }



    /**
     * Muestra la factura
     */
    @Override
    public String toString() {
        return " FACTURA " + codigoFactura  +
            "\nFecha: " + fechaEmision +
            "\nBase imponible: " + totalNeto + "€" +
            "\nIVA: " + totalIva + "€" +
            "\nGastos de envío: " + totalEnvio + "€" +
            "\nDescuento fidelidad: -" + totalDescuento + "€" +
            "\nTOTAL: " + totalFinal + "€";
}
}
