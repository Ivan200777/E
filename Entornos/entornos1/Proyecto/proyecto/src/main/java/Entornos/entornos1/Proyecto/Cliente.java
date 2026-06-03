package Entornos.entornos1.Proyecto;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private static int contadorClientes=1;

    private String ID;
    private String nombre;
    private String correo;
    private String direccion;
    private int aniosAntiguedad;
    private boolean esVip;
    private String pais;
    private List<Pedido> pedidos;

    // creamos nuestro constructor cliente
    public Cliente(String nombre, String correo, String direccion, int aniosAntiguedad, boolean esVip, String pais) {
        this.ID = "C " + contadorClientes++;
        this.nombre = nombre;
        this.correo = correo;
        this.direccion = direccion;
        this.aniosAntiguedad=aniosAntiguedad;
        this.esVip=esVip;
        this.pais=pais;
        this.pedidos = new ArrayList<>();

    }

    // getters
    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public int getAniosAntiguedad() {
        return aniosAntiguedad;
    }
     public boolean esVip() {
        return esVip;
    }

    public String getPais() {
        return pais;
    }

    // setters

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public void setAniosAntiguedad(int aniosAntiguedad) {
        this.aniosAntiguedad = aniosAntiguedad;
    }

    public void setEsVip(boolean esVip) {
        this.esVip = esVip;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    //introducimos el pedido
    public void agregarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    @Override
    public String toString() {
        return ID + "- " + nombre + "  (" + correo + ") -" + direccion;
    }
}