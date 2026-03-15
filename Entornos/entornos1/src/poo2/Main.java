package poo2;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca("Biblioteca Central", "Calle Mayor 123");
        biblioteca.mostrarInformacion();
        biblioteca.estaAbierta(10);
        biblioteca.estaAbierta(23);

<<<<<<< HEAD
        Libro libro1 = new Libro("El Quijote", "978-84-376-0494-7", "Anaya", "español", 863, 1605, true);
        Libro libro2 = new Libro("La pulga", "978-0156013987", "Balon de oro", "español", 134, 2019, false);
        Libro libro3 = new Libro("Hello", "978-0132350884", "Bye bye", "inglés", 464, 2008, true);
=======
        LibroFisico libro1 = new LibroFisico("El Quijote", "español", 863, "A1");
        LibroDigital libro2 = new LibroDigital("Balón de oro", "argentino", "PDF", 5.2);
        LibroFisico libro3 = new LibroFisico("Balón de playa", "brasileño", 464, "B2");
>>>>>>> 3d5796503d23d2b5b3ceefd972f3c4a240ddb50b

        biblioteca.addLibro(libro1);
        biblioteca.addLibro(libro2);
        biblioteca.addLibro(libro3);
        biblioteca.mostrarLibros();

        libro1.mostrarInformacion();
        libro2.mostrarInformacion();
        libro3.mostrarInformacion();

<<<<<<< HEAD
        Sala sala1 = new Sala(" Sala de lectura", 20, true, "lectura", true);
        Sala sala2 = new Sala(" Sala infantil", 15, false, "infantil", false);
        Sala sala3 = new Sala(" Sala de estudio", 30, true, "estudio", true);
=======
        SalaLectura sala1 = new SalaLectura("Sala de lectura", 20, true, "lectura", true);
        SalaEstudio sala2 = new SalaEstudio("Sala infantil", 15, false, "estudio", false, 10);
        SalaInformatica sala3 = new SalaInformatica("Sala de estudio", 30, true, "informatica", true, 12);
>>>>>>> 3d5796503d23d2b5b3ceefd972f3c4a240ddb50b

        biblioteca.addSala(sala1);
        biblioteca.addSala(sala2);
        biblioteca.addSala(sala3);
        biblioteca.mostrarSalas();

        sala1.mostrarInformacion();
        sala2.mostrarInformacion();
        sala3.mostrarInformacion();

        Usuario persona1 = new Usuario("Mbappe", 26, 101);
        Empleado persona2 = new Empleado("Lamine", 18, "Futbolista", 1200);

        persona1.setDireccion("Madrid, 10");
        persona1.mostrarInformacion();
        persona2.mostrarInformacion();
        System.out.println("Para la persona 1 sabemos que tiene " + persona1.getEdad() + " años");

        persona1.estaJubilado();
        persona2.estaJubilado();

        biblioteca.registrarVisita(persona1);
        biblioteca.registrarVisita(persona2);

        biblioteca.asignarResponsable(sala1, persona2);
        biblioteca.asignarResponsable(sala2, persona2);
        biblioteca.asignarResponsable(sala3, persona2);

        persona1.prestarLibro(libro1);

        biblioteca.removeLibro(libro2);
        biblioteca.mostrarLibros();

        biblioteca.removeSala(sala2);
        biblioteca.mostrarSalas();

        biblioteca.mostrarInformacion();
    }
}
