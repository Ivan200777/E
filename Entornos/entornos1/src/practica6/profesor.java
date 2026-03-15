package practica6;
import java.util.ArrayList;
import java.util.Date;

public class profesor extends persona {
    private double salario;

    private ArrayList<curso> cursosDictados;

    public profesor() {
        cursosDictados = new ArrayList<>();
    }

    public profesor(String dni, String nombre, Date fechaNacimiento, double salario) {
        super(dni, nombre, fechaNacimiento);
        this.salario = salario;
        this.cursosDictados = new ArrayList<>();
    }

    public void asignarCurso(curso c) {}

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public ArrayList<curso> getCursosDictados() {
        return cursosDictados;
    }

    public void setCursosDictados(ArrayList<curso> cursosDictados) {
        this.cursosDictados = cursosDictados;
    }
}
