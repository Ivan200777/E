package poo2;

import java.util.ArrayList;
import java.util.List;

public class Sala {

    // Atributos
    private String nombre;
    private int aforoMaximo;
    private int numPersonasActuales;
    private boolean pizarra;
    private String tipo;          
    private boolean disponible;   
    private PersonaPOO responsable;
    private List<PersonaPOO> personas = new ArrayList<>(); 

    // Constructor
    public Sala(String nombre, int aforoMaximo, boolean pizarra, String tipo, boolean disponible) {
        this.nombre = nombre;
        this.aforoMaximo = aforoMaximo;
        this.pizarra = pizarra;
        this.tipo = tipo;
        this.disponible = disponible;
        this.numPersonasActuales = 0;
    }

    // Métodos get
    public String getNombre() {
        return nombre;
    }

    public int getAforoMaximo() {
        return aforoMaximo;
    }

    public int getNumPersonasActuales() {
        return numPersonasActuales;
    }

    public boolean getPizarra() {
        return pizarra;
    }

    public String getTipo() {
        return tipo;
    }

    public boolean getDisponible() {
        return disponible;
    }

    public List<PersonaPOO> getPersonas() {
        return personas;
    }

    public PersonaPOO getResponsable() {
        return responsable;
    }

    // Métodos set
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAforoMaximo(int aforoMaximo) {
        this.aforoMaximo = aforoMaximo;
    }

    public void setNumPersonasActuales(int numPersonasActuales) {
        this.numPersonasActuales = numPersonasActuales;
    }

    public void setPizarra(boolean pizarra) {
        this.pizarra = pizarra;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public void setResponsable(PersonaPOO responsable) {
        this.responsable = responsable;
    }

    // Métodos simples
    public void estaDisponible() {
        if (disponible) {
            System.out.println("La sala " + nombre + " esta disponible para su reserva");
        } else {
            System.out.println("La sala " + nombre + " no esta disponible para su reserva");
        }
    }

    public void tienePizarra() {
        if (pizarra) {
            System.out.println("La sala " + nombre + " dispone de pizarra");
        } else {
            System.out.println("La sala " + nombre + " no dispone de pizarra");
        }
    }

    public void mostrarInformacion() {
        System.out.println("Sala " + nombre);
        System.out.println("Aforo maximo " + aforoMaximo);
        System.out.println("Personas actualmente " + numPersonasActuales);
        System.out.println("Tipo de sala " + tipo);

        if (pizarra) {
            System.out.println("Tiene pizarra Si");
        } else {
            System.out.println("Tiene pizarra No");
        }

        if (disponible) {
            System.out.println("Disponible Si");
        } else {
            System.out.println("Disponible No");
        }
    }
}
