import java.util.Date;
import java.util.Objects;

public class Estudiante extends Persona {
    private String id;

    private String estado;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Estudiante( String id,String nombre, String apellido, Date fechaDeNacimiento, String estado) {
        super(nombre, apellido, fechaDeNacimiento);
        this.id = id;
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estudiante that = (Estudiante) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
