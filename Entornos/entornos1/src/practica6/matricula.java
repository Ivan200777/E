package practica6;
import java.util.Date;

public class matricula {
    private Date fecha;
    private double notaFinal;

    private estudiante estudiante;
    private curso curso;

    public matricula() {}

    public matricula(Date fecha, double notaFinal, estudiante estudiante, curso curso) {
        this.fecha = fecha;
        this.notaFinal = notaFinal;
        this.estudiante = estudiante;
        this.curso = curso;
    }

    public double calcularNotaFinal() {
        return 0.0;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(double notaFinal) {
        this.notaFinal = notaFinal;
    }

    public estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public curso getCurso() {
        return curso;
    }

    public void setCurso(curso curso) {
        this.curso = curso;
    }
}
