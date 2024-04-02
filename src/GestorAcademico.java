import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GestorAcademico {
    private List<Estudiante> estudiantes;
    private List<Curso> cursos;

    private Map<String,List<Estudiante>> estudiantesInscritos;
    public GestorAcademico() {
        this.estudiantes = new ArrayList<>();
        this.cursos = new ArrayList<>();
        this.estudiantesInscritos = new HashMap<>();
    }
}
