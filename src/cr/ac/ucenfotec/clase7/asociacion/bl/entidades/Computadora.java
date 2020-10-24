package cr.ac.ucenfotec.clase7.asociacion.bl.entidades;

import java.util.Objects;

public class Computadora {

    private String nombre;
    private String marca;
    private Empleado responsable;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Empleado getResponsable() {
        return responsable;
    }

    public void setResponsable(Empleado responsable) {
        this.responsable = responsable;
    }

    public Computadora(){}
    public Computadora(String nombre, String marca) {
        this.nombre = nombre;
        this.marca = marca;
        this.responsable = new Empleado("Default", "1-1234-5678");
    }
    public Computadora(String nombre, String marca, Empleado responsable) {
        this.nombre = nombre;
        this.marca = marca;
        this.responsable = responsable;
    }

    @Override
    public String toString() {
        return "Computadora{" +
                ", nombre='" + nombre + '\'' +
                ", marca='" + marca + '\'' +
                ", responsable=" + responsable +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Computadora that = (Computadora) o;
        return Objects.equals(nombre, that.nombre) &&
                Objects.equals(marca, that.marca) &&
                Objects.equals(responsable, that.responsable);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, marca, responsable);
    }
}
