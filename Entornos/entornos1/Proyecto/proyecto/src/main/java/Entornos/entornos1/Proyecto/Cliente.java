package Entornos.entornos1.Proyecto;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private static int contadorClientes=1;

    private String ID;
    private String nombre;
    private String correo;
    private String direccion;
    private List<Pedido> pedidos;

    // creamos nuestro constructor cliente
    public Cliente(String nombre, String correo, String direccion) {
        this.ID = "C " + contadorClientes++;
        this.nombre = nombre;
        this.correo = correo;
        this.direccion = direccion;
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

    //introducimos el pedido
    public void agregarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    @Override
    public String toString() {
        return ID + "- " + nombre + "  (" + correo + ") -" + direccion;
    }
}