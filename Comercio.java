
/** Permite instanciar y manipular objetos de tipo Comercio
 * @version 21/09/2023
 * @author Wolkowyski, Micaela
 */

import java.util.HashMap;

public class Comercio {
    //Atributos
    private String nombre;
    private HashMap<Long, Empleado> empleados;

    //Constructores
    /** Permite instanciar objetos de tipo Comercio
     * @return No devuelve ningún valor.
     * @param p_nombre de tipo String, utilizado para asignar el estado de nombre.
     * @exception No dispara ninguna excepción.
     */
    public Comercio(String p_nombre) {
        this.setNombre(p_nombre);
        this.setEmpleados(new HashMap<Long, Empleado>());
    }

    /** Permite instanciar objetos de tipo Comercio
     * @return No devuelve ningún valor
     * @param p_nombre de tipo String, utilizado para asignar el estado de nombre.
     * @param p_empleados de tipo HashMap<Long, Empleado>, utilizado para asignar el estado de empleados.
     * @exception No dispara ninguna excepción.
     */
    public Comercio(String p_nombre, HashMap<Long, Empleado> p_empleados) {
        this.setNombre(p_nombre);
        this.setEmpleados(p_empleados);
    }

    //Setters y Getters
    private void setNombre(String p_nombre) {
        this.nombre = p_nombre;
    }

    private void setEmpleados(HashMap<Long, Empleado> p_empleados) {
        this.empleados = p_empleados;
    }

    /** Retorna el nombre
     * @param No utiliza parámetros
     * @exception No dispara ninguna excepción
     * @return Devuelve un String
     */
    public String getNombre() {
        return this.nombre;
    }

    /** Retorna los empleados
     * @param No utiliza parámetros
     * @exception No dispara ninguna excepción
     * @return Retorna un HashMap<Long, Empleado>
     */
    public HashMap<Long,Empleado> getEmpleados() {
        return this.empleados;
    }

    //Metodos
    
    /** Permite dar de alta un empleado
     * @exception No dispara ninguna excepción
     * @param p_empleado de tipo Empleado, utilizado para darlo de alta.
     * @return No devuelve ningún valor
     */
    public void altaEmpleado(Empleado p_empleado) {
        this.getEmpleados().put(p_empleado.getCuil(), p_empleado);
    }

    /** Permite dar de baja un empleado
     * @exception No dispara ninguna excepción
     * @param p_cuil de tipo long, utilizado para dar de baja al empleado al que pertenece ese CUIL
     * @return Retorna un objeto de tipo Empleado
     */
    public Empleado bajaEmpleado(long p_cuil) {
        return this.getEmpleados().remove(p_cuil);
    }

    /** Retorna la cantidad de empleados
     * @param No utiliza parámetros
     * @return Retorna un int
     * @exception No dispara ninguna excepción
     */
    public int cantidadDeEmpleados() {
        return this.getEmpleados().size();
    }

    /** Verifica según un CUIL dado por parámetro, si el empleado está en el comercio
     * @exception No dispara ninguna excepción
     * @param p_cuil de tipo long, utilizado para verificar
     * @return Retorna un boolean
     */
    public boolean esEmpleado(long p_cuil) {
        return this.getEmpleados().containsKey(p_cuil);
    }

    /** Busca un empleado dado un CUIL
     * @exception No dispara ninguna excepción
     * @param p_cuil de tipo long, utilizado para buscar al empleado
     * @return Retorna un objeto de tipo Empleado
     */
    public Empleado buscarEmpleado(long p_cuil) {
        return this.getEmpleados().get(p_cuil);
    }

    /** Retorna el sueldo neto de un empleado específico
     * @exception No dispara ninguna excepción
     * @param p_cuil de tipo long, utilizado para buscar al empleado y retornar su sueldo neto
     * @return No devuelve ningún valor
     */
    public void sueldoNeto(long p_cuil) {
        System.out.println("Sueldo Neto: " + this.buscarEmpleado(p_cuil).sueldoNeto());
    }

    /** Imprime por pantalla la nómina de empleados
     * @param No utiliza parámetros
     * @exception No dispara ninguna excepción
     * @return No devuelve ningún valor
     */
    public void nomina() {
        System.out.println("\n" + "**** Nómina de Empleados de " + this.getNombre());
        for(HashMap.Entry<Long, Empleado> emplead: this.getEmpleados().entrySet()) {
            System.out.println(emplead.getKey() + " " + emplead.getValue().apeYNombre() + "\t" + " -------- " + "\t" + "$" + emplead.getValue().sueldoNeto());
        }
    }
}
