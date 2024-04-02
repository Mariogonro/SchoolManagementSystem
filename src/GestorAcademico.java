import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class GestorAcademico implements ServiciosAcademicosI {
    private List<Estudiante> estudiantes;
    private List<Curso> cursos;
    private HashMap<String, Estudiante> estudiantesInscritos;


    public GestorAcademico() {
        this.estudiantes = new ArrayList<>();
        this.cursos = new ArrayList<>();
        this.estudiantesInscritos = new HashMap<>();
    }

    @Override
    public void matricularEstudiante(Estudiante estudiante) {
        ;
        if (estudiantes.contains(estudiante)) {
            System.out.println("\nEl código del estudiante ya existe");
        } else {
            estudiantes.add(estudiante);
            String formato = "dd/MM/yyyy";
            SimpleDateFormat fecha = new SimpleDateFormat(formato);
            System.out.println("\nSe agrego correctamente al estudiante " + '\n' + "Datos del Estudiante" + '\n' + "--------------------------");
            System.out.println("\rCódigo: " + estudiante.getId() + "\nNombre: " + estudiante.getNombre() + "\nApellido: " + estudiante.getApellido() + "\nFecha Nacimiento: " + fecha.format(estudiante.getFechaDeNacimiento()));
        }
    }

    public void EstudianteCurso() {
        if (!estudiantesInscritos.isEmpty()) {
            for (String i : estudiantesInscritos.keySet()) {
                System.out.println("Codigo Curso: " + i + " - Estudiante: " + estudiantesInscritos.get(i).getNombre() + " " + estudiantesInscritos.get(i).getApellido() +  "\r");
            }
        } else {
            System.out.println("No hay registros");
        }
    }

    @Override
    public void agregarCurso(Curso curso) {
        if (cursos.contains(curso)) {
            System.out.println("\nEl código del curso ya existe");
        } else {
            cursos.add(curso);
            System.out.println("\n" + "Se agrego correctamente el curso " + '\n' + "Datos del Curso" + '\n' + "--------------------------");
            System.out.println("\rCódigo: " + curso.getId() + "\nNombre: " + curso.getNombre() + "\nCréditos: " + curso.getNumeroCreditos());
        }
    }

    @Override
    public void inscribirEstudianteCurso(Estudiante estudiante, String idCurso) {
        try {
            InscribirEstudianteCurso(estudiante, idCurso);
        } catch (EstudianteYaInscritoException e) {
            System.out.println(e.getMessage());
        }
    }

    private void InscribirEstudianteCurso(Estudiante estudiante, String idCurso) throws EstudianteYaInscritoException {
        boolean existe = false;
        for (Curso curso : cursos) {
            if (Objects.equals(curso.getId(), idCurso)) {
                existe = true;
                break;
            }
        }
        if (existe) {
            if (!estudiantesInscritos.containsKey(idCurso + "." + estudiante.getId())) {
                estudiantesInscritos.put(idCurso + "." + estudiante.getId(), estudiante);
                System.out.println("\nSe asigna el curso: " + idCurso + " al estudiante: " + estudiante.getNombre() + " " + estudiante.getApellido());
            } else {
                throw new EstudianteYaInscritoException("El estudiante ya tiene asignado el curso");
            }
        } else {
            System.out.println("No existe el curso ingresado");
        }
    }

    @Override
    public void desinscribirEstudianteCurso(String idEstudiante, String idCurso) {
        try {
            DesinscribirEstudianteCurso(idEstudiante, idCurso);
        } catch (EstudianteNoInscritoEnCursoException e) {
            System.out.println(e.getMessage());
        }
    }

    private void DesinscribirEstudianteCurso(String idEstudiante, String idCurso) throws EstudianteNoInscritoEnCursoException {
        if (!estudiantesInscritos.containsKey(idCurso + "." + idEstudiante)) {
            throw new EstudianteNoInscritoEnCursoException("El estudiante no esta inscrito");
        } else {
            estudiantesInscritos.remove(idCurso + "." + idEstudiante);
            System.out.println("Se ha eliminado al estudiante: " + idEstudiante + " del curso: " + idCurso);
        }
    }

    static class EstudianteYaInscritoException extends Exception {
        public EstudianteYaInscritoException(String mensaje) {
            super(mensaje);
        }
    }

    static class EstudianteNoInscritoEnCursoException extends Exception {
        public EstudianteNoInscritoEnCursoException(String mensaje) {
            super(mensaje);
        }
    }
}
