package cr.ac.ucenfotec.clase7.asociacion.controlador;

import cr.ac.ucenfotec.clase7.asociacion.bl.entidades.Computadora;
import cr.ac.ucenfotec.clase7.asociacion.bl.entidades.Empleado;
import cr.ac.ucenfotec.clase7.asociacion.ui.UI;
import cr.ac.ucenfotec.clase7.asociacion.bl.gestor.Gestor;

import java.util.ArrayList;

/**
 * La clase Controlador se usa para realizar la comunicación entre
 * el UI y el Gestor
 *
 * @author Taylor Segura Vindas
 * @version 1.0
 * @since 2020-10-24
 */
public class Controlador {
    private UI ui = new UI();
    private Gestor gestor = new Gestor();

    /**
     * Este método se usa para iniciar el comportamiento del controlador
     */
    public void iniciarPrograma(){
        int opcion = 0;
       do {
           ui.imprimirLinea("Bienvenido, seleccione una opcion");
           ui.imprimirLinea("1. Registrar empleado");
           ui.imprimirLinea("2. Listar empleados");
           ui.imprimirLinea("3. Registrar computadora");
           ui.imprimirLinea("4. Listar computadoras");
           ui.imprimirLinea("5. Salir");
           ui.imprimir("Su opcion: ");
           opcion = ui.leerEntero();
           procesarOpcion(opcion);
       } while (opcion != 5);
    }

    /**
     * Este método se usa para procesar la opción recibida por el usuario
     * y realizar una acción basada en esta
     * @param  opcion  el entero que el usuario ingresó
     */
    private void procesarOpcion(int opcion){
        switch (opcion){
            case 1:
                registrarEmpleado();
                break;
            case 2:
                listarEmpleados();
                break;
            case 3:
                registrarComputadora();
                break;
            case 4:
                listarComputadoras();
                break;
            case 5:
                ui.imprimirLinea("Adios");
                break;
            default:
                ui.imprimirLinea("Opcion invalida");
                break;
        }
    }

    /**
     * Este método se usa para llevar a cabo el registro de un empleado
     * @return el empleado que se ha creado y registrado, null si ya existe
     * @see Empleado
     */
    private Empleado registrarEmpleado() {
        ui.imprimirLinea("Registro de empleado");
        ui.imprimir("Nombre: ");
        String nombre = ui.leerLinea();
        ui.imprimir("Cedula: ");
        String cedula = ui.leerLinea();

        boolean resultado = gestor.registrarEmpleado(nombre, cedula);

        if(resultado){
            ui.imprimirLinea("Registro realizado correctamente");
            return gestor.buscarEmpleado(cedula);
        } else {
            ui.imprimirLinea("El empleado ya existe :(");
        }

        return null;
    }
    /**
     * Este método se usa mostrar en el UI todos los empleados que se han registrado
     */
    private void listarEmpleados() {
        ui.imprimirLinea("Lista de emplados");
        ArrayList<Empleado> empleados = gestor.listarEmpleados();

        for (Empleado objEmpleado: empleados) {
            ui.imprimirLinea(objEmpleado.toString());
        }
    }

    /**
     * Este método se usa para llevar a cabo el registro de una computadora
     * @return la computadora que se ha creado y registrado, null si ya existe
     * @see Computadora
     */
    private Computadora registrarComputadora(){
        ui.imprimirLinea("Registro de computadora");
        ui.imprimir("Nombre: ");
        String nombre = ui.leerLinea();
        ui.imprimir("Marca: ");
        String marca = ui.leerLinea();

        ui.imprimir("Ingrese la cedula del empleado responsable: ");
        String cedula = ui.leerLinea();

        Empleado empleado = gestor.buscarEmpleado(cedula);

        if(empleado == null){
            ui.imprimirLinea("No se ha encontrado ningun empleado con esa cedula.");
            empleado = registrarEmpleado();
        }

        boolean resultado = gestor.registrarComputadora(nombre, marca, empleado);

        if(resultado){
            ui.imprimirLinea("Registro realizado correctamente");
            return gestor.buscarComputadora(nombre);
        } else {
            ui.imprimirLinea("El empleado ya existe :(");
        }

        return null;
    }
    /**
     * Este método se usa mostrar en el UI todos los empleados que se han registrado
     */
    private void listarComputadoras(){
        ui.imprimirLinea("Lista de computadoras");
        ArrayList<Computadora> computadoras = gestor.listarComputadoras();

        for (Computadora objComputadora: computadoras) {
            ui.imprimirLinea(objComputadora.toString());
        }
    }
}
