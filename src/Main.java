import java.time.Month;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Estudiante estudiante = new Estudiante("E001","Jorge","González",new Date(91, Calendar.AUGUST,3),"Matriculado");
        Estudiante estudiante2 = new Estudiante("E002","Jackelyn","Urías",new Date(97, Calendar.FEBRUARY,10),"Matriculado");
        Curso curso = new Curso("C001","Introducción a Java","Curso de introducción a JAVA",10,"1.0");
        Curso curso2 = new Curso("C002","Introducción a C#","Curso de introducción a C#",12,"1.1.0");

        GestorAcademico gestorAcademico = new GestorAcademico();
        gestorAcademico.matricularEstudiante(estudiante);
        gestorAcademico.matricularEstudiante(estudiante2);
        gestorAcademico.agregarCurso(curso);
        gestorAcademico.agregarCurso(curso2);

        gestorAcademico.inscribirEstudianteCurso(estudiante,"C001");
        gestorAcademico.inscribirEstudianteCurso(estudiante2,"C002");
        gestorAcademico.EstudianteCurso();
        gestorAcademico.desinscribirEstudianteCurso("E001","C002");

        gestorAcademico.EstudianteCurso();

    }
}