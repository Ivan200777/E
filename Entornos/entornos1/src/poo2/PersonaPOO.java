package poo2;

public class PersonaPOO {
    /**
     * Definicioón de atributos de la persona
     */
    private String nombre;
    private int edad;
    private String direccion;
    private String apellidos;
    private String DNI;
    private String email;
    private int telefono;
    private String profesion;
    private int añosDeExperiencia;

    /**
     * Definición del comportmiento de la persona
     */
    public PersonaPOO(String nombre, int edad, String apellidos, String DNI, String email, int telefono,
            String profesion, int añosDeExperiencia) {

        this.nombre = nombre;
        this.edad = edad;
        this.apellidos = apellidos;
        this.DNI = DNI;
        this.email = email;
        this.telefono = telefono;
        this.profesion = profesion;
        this.añosDeExperiencia = añosDeExperiencia;
    }

    public void mostrarInformacion() {
        System.out.println("Nombre: " + this.nombre + ", edad " + this.getEdad() + " , direccion: " + this.direccion
                + " , apellidos: " + this.apellidos + " , DNI: " + this.DNI + " , email: " + this.email
                + " , teléfono: " + this.telefono + " , profesión: " + profesion + " y años de experiencia: "
                + this.añosDeExperiencia);
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getEdad() {
        return this.edad;
    }

    public String getApellidos() {
        return this.apellidos;
    }

    public String getDNI() {
        return this.DNI;
    }

    public String getEmail() {
        return this.email;
    }

    public int getTelefono() {
        return this.telefono;
    }

    public String getProfesion() {
        return this.profesion;
    }

    public int getAñosDeExperiencia() {
        return this.añosDeExperiencia;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public void setAñosDeExperiencia(int añosDeExperiencia) {
        this.añosDeExperiencia = añosDeExperiencia;
    }

    /**
     * A partir de la clase Persona, añade una nueva funcionalidad que sea el método
     * estaJubilado(). Este método nos indicará a través de un mensaje por pantalla
     * de si la persona en cuestión está en edad de trabajar o se encuentra ya en la
     * jubilación
     */
    public boolean estaJubilado() {
        if (this.edad > 65) {
            System.out.println("La persona en cuestion está jubilada.");
            return true;
        } else {
            if (this.edad >= 18) {
                System.out.println("La persona en cuestión está en edad de trabajar.");
            } else {
                System.out.println("La persona es menor y no puede trabajar.");
            }
            return false;
        }
    }
}
