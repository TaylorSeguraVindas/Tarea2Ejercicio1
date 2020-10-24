package cr.ac.ucenfotec.clase7.asociacion.bl.gestor;

import cr.ac.ucenfotec.clase7.asociacion.bl.entidades.Computadora;
import cr.ac.ucenfotec.clase7.asociacion.bl.entidades.Empleado;

import java.util.ArrayList;

/**
 * La clase Gestor se encarga de toda la lógica base de la aplicación
 * es donde se interactúa directamente con los objetos que se almacenan
 *
 * @author Taylor Segura Vindas
 * @version 1.0
 * @since 2020-10-24
 */
public class Gestor {
    private ArrayList<Computadora> computadoras = new ArrayList<Computadora>();
    private ArrayList<Empleado> empleados = new ArrayList<Empleado>();

    /**
     * Este método se usa para registrar una nueva computadora
     * @param  nombre  un String que hace referencia al nombre de la computadora
     * @param  marca  un String que hace referencia al nombre de la marca de la computadora
     * @param  responsable  una referencia al Empleado responsable de la computadora
     * @return true si se realiza el registro correctamente, false si la computadora ya existe
     * @see Computadora
     * @see Empleado
     */
    public boolean registrarComputadora(String nombre, String marca, Empleado responsable){
        Computadora nuevaComputadora;
        if(responsable == null){
            nuevaComputadora = new Computadora(nombre, marca);
        } else {
            nuevaComputadora = new Computadora(nombre, marca, responsable);
        }

        if(!computadoras.contains(nuevaComputadora)){
            computadoras.add(nuevaComputadora);
            return true;
        }

        return false;
    }
    /**
     * Este método se usa para obtener la lista de computadoras almacenada
     * @return un arrayList que contiene los vehiculos que se han creado
     * @see Computadora
     * @see ArrayList
     */
    public ArrayList<Computadora> listarComputadoras(){
        return this.computadoras;
    }
    /**
     * Este método se usa para buscar y obtener una computadora basado en su nombre
     * @return un objeto de la clase Computadora que posee el mismo nombre que se envió como parámetro
     * @see Computadora
     */
    public Computadora buscarComputadora(String pNombre){
        for (Computadora objComputadora: computadoras) {
            if(objComputadora.getNombre().equals(pNombre)){
                return objComputadora;
            }
        }

        return null;
    }


    /**
     * Este método se usa para registrar un nuevo empleado
     * @param  nombre  un String que hace referencia al nombre del empleado
     * @param  cedula  un entero que hace referencia a la cedula del empleado
     * @return true si se realiza el registro correctamente, false si el Empleado ya existe
     * @see Empleado
     */
    public boolean registrarEmpleado(String nombre, String cedula){
        Empleado nuevoEmpleado = new Empleado(nombre, cedula);
        if(!empleados.contains(nuevoEmpleado)){
            empleados.add(nuevoEmpleado);
            return true;
        }

        return false;
    }
    /**
     * Este método se usa para obtener la lista de empleados almacenada
     * @return un arrayList que contiene los empleados que se han creado
     * @see Empleado
     * @see ArrayList
     */
    public ArrayList<Empleado> listarEmpleados(){
        return this.empleados;
    }
    /**
     * Este método se usa para buscar y obtener un empleado basado en su cedula
     * @return un objeto de la clase Empleado que posee la misma cedula que se envió como parámetro
     * @see Empleado
     */
    public Empleado buscarEmpleado(String pCedula){
        for (Empleado objEmpleado: empleados) {
            if(objEmpleado.getCedula().equals(pCedula)){
                return objEmpleado;
            }
        }

        return null;
    }
}
