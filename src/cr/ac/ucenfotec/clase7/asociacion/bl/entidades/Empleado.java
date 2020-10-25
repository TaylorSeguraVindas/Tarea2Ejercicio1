package cr.ac.ucenfotec.clase7.asociacion.bl.entidades;

import java.util.Objects;

public class Empleado {

    private String nombre;
    private String cedula;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public Empleado() {}

    /**
     * metodo constructor para la clase Empleado
     * @param nombre String que contiene el nombre del empleado
     * @param cedula String que contiene la cedula del empleado
     */
    public Empleado(String nombre, String cedula) {
        this.nombre = nombre;
        this.cedula = cedula;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", cedula='" + cedula + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empleado empleado = (Empleado) o;
        return Objects.equals(nombre, empleado.nombre) &&
                Objects.equals(cedula, empleado.cedula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, cedula);
    }
}
