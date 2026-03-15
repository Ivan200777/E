package poo2;

public class Empleado extends PersonaPOO {

    private String puesto;
    private double sueldo;

    public Empleado(String nombre, int edad, String apellidos, String DNI, String email,
                    int telefono, String profesion, int añosDeExperiencia,
                    String puesto, double sueldo) {

        super(nombre, edad, apellidos, DNI, email, telefono, profesion, añosDeExperiencia);

        this.puesto = puesto;
        this.sueldo = sueldo;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
}
