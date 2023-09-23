/** Permite crear y manipular objetos de tipo Banco
 * @author Wolkowyski, Micaela
 * @version 18/09/2023
 */

import java.util.*;
public class Banco {
    private String nombre;
    private int nroSucursal;
    private ArrayList empleados;
    private Localidad localidad;
    private ArrayList<CuentaBancaria> cuentasBancarias;

    //Metodos Constructores
    /** Permite instanciar objetos de tipo Banco
     * @exception No dispara ninguna excepcion
     * @param p_nombre de tipo String, utilizado para asignar el estado de nombre.
     * @param p_localidad de tipo Localidad, utilizado para asignar el estado de localidad.
     * @param p_nroSucursal de tipo int, utilizado para asignar el estado de nroSucursal
     * @param p_empleados de tipo ArrayList, utilizado para asignar la lista a empleados.
     */
    public Banco(String p_nombre, Localidad p_localidad, int p_nroSucursal, ArrayList p_empleados) {
        this.setNombre(p_nombre);
        this.setLocalidad(p_localidad);
        this.setNroSucursal(p_nroSucursal);
        this.setEmpleados(p_empleados);
        this.setCuentasBancarias(new ArrayList<CuentaBancaria>());
    }

    /** Permite instanciar objetos de tipo Banco
     * @exception No dispara ninguna excepcion
     * @param p_nombre de tipo String, utilizado para asignar el estado del nombre.
     * @param p_localidad de tipo Localidad, utilizado para asignar el estado de localidad.
     * @param p_nroSucursal de tipo int, utilizado para asginar el estado de nroSucursal.
     * @param p_empleado de tipo Empleado, utilizado para asignar el estado de empleado.
     */
    public Banco(String p_nombre, Localidad p_localidad, int p_nroSucursal, Empleado p_empleado) {
        this.setNombre(p_nombre);
        this.setLocalidad(p_localidad);
        this.setNroSucursal(p_nroSucursal);
        this.setEmpleados(new ArrayList());
        this.agregarEmpleado(p_empleado);
        this.setCuentasBancarias(new ArrayList<CuentaBancaria>());
    }

    /** Permite instanciar objetos de tipo Banco
     * @exception No dispara ninguna excepcion
     * @param p_nombre de tipo String, utilizado para asignar el estado del nombre.
     * @param p_localidad de tipo Localidad, utilizado para asignar el estado de localidad.
     * @param p_nroSucursal de tipo int, utilizado para asginar el estado de nroSucursal.
     * @param p_empleados de tipo ArrayList, utilizado para asignar el estado de empleado.
     * @param p_cuenta de tipo ArrayList<CuentaBancaria>, utilizado para asignar el estado de cuentasBancarias.
     */
    public Banco(String p_nombre, Localidad p_localidad, int p_nroSucursal, ArrayList p_empleados, ArrayList<CuentaBancaria> p_cuenta) {
        this.setNombre(p_nombre);
        this.setLocalidad(p_localidad);
        this.setNroSucursal(p_nroSucursal);
        this.setEmpleados(p_empleados);
        this.setCuentasBancarias(p_cuenta);
    }

    //Setters y Getters
    private void setCuentasBancarias(ArrayList<CuentaBancaria> p_cuenta) {
        this.cuentasBancarias = p_cuenta;
    }

    private void setNombre(String p_nombre) {
        this.nombre = p_nombre;
    }

    private void setLocalidad(Localidad p_localidad) {
        this.localidad = p_localidad;
    }

    private void setNroSucursal(int p_nroSucursal) {
        this.nroSucursal = p_nroSucursal;
    }

    private void setEmpleados(ArrayList p_empleado) {
        this.empleados = p_empleado;
    }

    /** Retorna el nombre
     * @exception No dispara excepcion
     * @return Retorna un String
     * @param No utiliza parametros
     */
    public String getNombre() {
        return this.nombre;
    }

    /** Retorna el numero de sucursal
     * @param No utiliza parametros
     * @return Retorna un int
     * @exception No dispara ninguna excepcion
     */
    public int getNroSucursal() {
        return this.nroSucursal;
    }

    /** Retorna los empleados
     * @param No utiliza parametros
     * @return Devuelve un ArrayList
     * @exception No dispara ninguna excepcion
     */
    public ArrayList getEmpleados() {
        return this.empleados;
    }

    /** Retorna la localidad
     * @param No utiliza parametros
     * @return Retorna un objeto de tipo Localidad
     * @exception No dispara ninguna excepcion
     */
    public Localidad getLocalidad() {
        return this.localidad;
    }

    /** Retorna las cuentas bancarias
     * @param No utiliza parametros
     * @return Retorna un ArrayList
     * @exception No dispara ninguna excepcion
     */
    public ArrayList<CuentaBancaria> getCuentasBancarias() {
        return this.cuentasBancarias;
    }

    //Metodos
    /** Permite agregar cuentas al ArraList
     * @exception No dispara ninguna excepcion
     * @param p_cuenta de tipo CuentaBancaria, utilizado para agregarla al ArrayList
     * @return Retorna un boolean
     */
    public boolean agregarCuentaBancaria(CuentaBancaria p_cuenta) {
        return this.getCuentasBancarias().add(p_cuenta);
    }

    /** Permite remover cuentas del ArraList
     * @exception No dispara ninguna excepcion
     * @param p_cuenta de tipo CuentaBancaria, utilizado para removerla del ArrayList
     * @return Retorna un boolean
     */
    public boolean quitarCuentaBancaria(CuentaBancaria p_cuenta) {
        return this.getCuentasBancarias().remove(p_cuenta);
    }

    /** Permite agregar empleados al ArrayList
     * @exception No dispara ninguna excepcion
     * @param p_empleado de tipo Empleado, utilizado para agregarlo al ArrayList
     * @return Retorna un boolean
     */
    public boolean agregarEmpleado(Empleado p_empleado) {
        return this.getEmpleados().add(p_empleado);
    }

    /** Permite remover empleados del ArrayList
     * @exception No dispara ninguna excepcion
     * @param p_empleado de tipo Empleado, utilizado para removerlo del ArrayList
     * @return Retorna un boolean
     */
    public boolean quitarEmpleado(Empleado p_empleado){
        if (this.getEmpleados().size() > 1) {
            return this.getEmpleados().remove(p_empleado);
        } else {
            return false;
        }
    } 

    /** Imprime por pantalla el CUIL, apellido, nombre y sueldo neto de los empleados
     * @exception No dispara ninguna excecpcion
     * @param No utiliza parametros
     * @return No devuelve ningun valor
     */
    public void listarSueldos() {
        for(Object sueldos: this.getEmpleados())  {
            System.out.println(((Empleado)sueldos).mostrarLinea());
        }
    }

    /** Suma el total de sueldos a pagar
     * @exception No dispara ninguna excepcion
     * @return Retorna un double
     * @param No utiliza parametros
     */
    public double sueldosAPagar() {
        double total = 0;
        for(Object sueldos: this.getEmpleados())  {
            total = total + ((Empleado)sueldos).sueldoNeto();
        }
        return total;
    }

    /** Imprime por pantalla todos los datos de los empleaos mas el total a pagar de sueldos
     * @exception No dispara ninguna excepcion
     * @param No utiliza parametros
     * @return No devuelve ningun valor
     */
    public void mostrar() {
        System.out.println("Banco: " + this.getNombre() + "     " + "Sucursal: " + this.getNroSucursal());
        System.out.println("Localidad: " + this.getLocalidad().getNombre() + "     " + "Provincia: " + this.getLocalidad().getProvincia());
        for(Object empleado: this.getEmpleados()) {
            System.out.println(((Empleado)empleado).mostrarLinea());
        }
        System.out.println("Total a Pagar: " + "........................................ " + "$" + this.sueldosAPagar() + "\n");
    }

    /** Muestra por pantalla los datos de los titulas con cuentas bancarias con saldo cero
     *  @exception No dispara ninguna excepcion
     *  @param No utiliza parametros
     *  @return No devuelve ningun valor
     */
    private void mostrarSaldoCero() {
        System.out.println("-----------------------------------------");
        System.out.println("Titulares con Cuenta en Saldo Cero");
        System.out.println("-----------------------------------------");
        for(CuentaBancaria cuentas: this.getCuentasBancarias()) {
            if(cuentas.getSaldo() == 0) {
                System.out.println(cuentas.getNroCuenta() + "\t" + cuentas.getTitular().apeYNom() + "\n");
            }
        }
    }

    /** Calcula la cantidad de cuentas activas
     * @param No utiliza parametros
     * @exception No dispara ninguna excepcion
     * @return Devuelve un int
     */
    private int cuentasSaldoActivo() {
        int cantCuentasActivas = 0;
        for(CuentaBancaria cuentas: this.getCuentasBancarias()) {
            if(cuentas.getSaldo() > 0) {
                cantCuentasActivas++;
            }
        } 
        return cantCuentasActivas;
    }

    /** Imprime por pantalla los datos del Banco y el Resumen de las Cuentas Bancarias
     * @param No utiliza parametros
     * @exception No dispara ninguna excepcion
     * @return No devuelve ningun valor
     */
    public void mostrarResumen() {
        System.out.println("Banco: " + this.getNombre() + "     " + "Sucursal: " + this.getNroSucursal());
        System.out.println("Localidad: " + this.getLocalidad().getNombre() + "     " + "Provincia: " + this.getLocalidad().getProvincia());
        System.out.println("*************************************************");
        System.out.println("RESUMEN DE CUENTAS BANCARIAS");
        System.out.println("*************************************************");
        System.out.println("Numero Total de Cuentas Bancarias: " + this.getCuentasBancarias().size());
        System.out.println("Cuentas Activas: " + this.cuentasSaldoActivo());
        System.out.println("Cuentas Saldo Cero: " + (this.getCuentasBancarias().size() - this.cuentasSaldoActivo()));
        this.mostrarSaldoCero();
    }
}
