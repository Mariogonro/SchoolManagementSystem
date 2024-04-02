import java.util.List;

public interface ServiciosAcademicosI {
    void matricularEstudiante (Estudiante estudiante);
    void agregarCurso(Curso curso);
    void inscribirEstudianteCurso(Estudiante estudiante, String idCurso);
    void desinscribirEstudianteCurso(String idEstudiante, String idCurso);
}
