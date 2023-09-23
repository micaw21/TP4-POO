import java.util.*;

/** Permite craer y manipular un objeto de tipo Persona
 *  @author Wolkowyski, Micaela
 *  @version 16/08/2023
 */

public class Persona {

    //atributos
    private int nroDni;
    private String nombre;
    private String apellido;
    //private int anioNacimiento;
    private Calendar fechaNacimiento;

    //metodo constructor
    /** Permite instanciar objetos de la clase Persona
     * @return No devuelve valor.
     * @exception No dispara ninguna excepcion.
     * @param p_dni tipo int, se utiliza para asignar el nuevo valor de DNI.
     * @param p_nombre tipo String, se utiliza para asignar el nuevo nombre.
     * @param p_apellido tipo String, se utiliza para asignar el nuevo apellido. 
     * @param p_anio tipo int, se utiliza para asignar el nuevo valor de anio.
     */

    public Persona(int p_dni, String p_nombre, String p_apellido, int p_anio) {
        this.setDni(p_dni);
        this.setNombre(p_nombre);
        this.setApellido(p_apellido);
        this.setAnioNacimiento(p_anio);
    }

    /** Permite instanciar objetos de tipo Persona
     * @return No devuelve ningun valor
     * @exception No dispara ninguna excepción
     * @param p_dni tipo int, se utiliza para asignar el nuevo valor de DNI.
     * @param p_nombre tipo String, se utiliza para asignar el nuevo nombre.
     * @param p_apellido tipo String, se utiliza para asignar el nuevo apellido. 
     * @param p_fecha de tipo Calenar, utilizado para asignar el estado de fecha
     */
    public Persona(int p_dni, String p_nombre, String p_apellido, Calendar p_fecha) {
        this.setDni(p_dni);
        this.setNombre(p_nombre);
        this.setApellido(p_apellido);
        this.setFechaNacimiento(p_fecha);
    }

    //setters
    private void setDni(int p_dni) {
        this.nroDni = p_dni;
    }

    private void setNombre(String p_nombre){
        this.nombre = p_nombre;
    }

    private void setApellido(String p_apellido){
        this.apellido = p_apellido;
    }

    private void setAnioNacimiento(int p_anio) {
        this.fechaNacimiento.set(Calendar.YEAR, p_anio);
    }

    private void setFechaNacimiento(Calendar p_fecha) {
        this.fechaNacimiento = p_fecha;
    }

    //getters
    /** Retorna el DNI 
     * @return Devuelve un entero.
     * @param No utiliza ningun parametro.
     * @exception No dispara ninguna excepcion.
     */
    public int getDni() {
        return this.nroDni;
    }
    /** Retorna el nombre
     * @return Devuelve un String.
     * @param No utiliza ningun parametro.
     * @exception No dispara ninguna excepcion.
     */
    public String getNombre() {
        return this.nombre;
    }

    /** Retorna el apellido 
     * @return Devuelve un String.
     * @param No utiliza ningun parametro.
     * @exception No dispara ninguna excepcion.
     */
    public String getApellido() {
        return this.apellido;
    }

    /** Retorna el anio de nacimiento 
     * @return Devuelve un entero.
     * @param No utiliza ningun parametro.
     * @exception No dispara ninguna excepcion.
     */
    public int getAnioNacimiento() {
        return this.fechaNacimiento.get(Calendar.YEAR);
    }

    /** Retorna la fecha de nacimiento
     * @param No utiliza parametros
     * @return Retorna un objeto de tipo Calendar
     * @exception No dispara ninguna excepcion
     */
    public Calendar getFechaNacimiento() {
        return this.fechaNacimiento;
    }

    //metodos
    /** Calcula la edad de una persona a partir de la diferencia entre el anio actual (anioHoy) y su anio de nacimiento (getAnioNacimiento).
     *  @param No utiliza parametros.
     *  @return Devuelve un valor de tipo entero.
     *  @exception No dispara ninguna excepcion.
     */
    public int edad(){
        Calendar fechaHoy = new GregorianCalendar();
        int anioHoy = fechaHoy.get(Calendar.YEAR);
        return (anioHoy - this.getAnioNacimiento());
    }
    
    /** Concatena dos strings, en este caso el nombre y apellido.
     *  @param No utiliza parametros.
     *  @return Devuelve un String.
     *  @exception No dispara ninguna excepcion.
     */
    public String nomYApe() {
        return (this.getNombre() + " " + this.getApellido());
    }
    
    /** Concatena dos strings, en este caso el apellido y el nombre.
     *  @param No utiliza parametros.
     *  @return Devuelve un String.
     *  @exception No dispara ninguna excepcion.
     */
    public String apeYNom() {
        return (this.getApellido() + " "  + this.getNombre());
    }
    
    /** Imprime por pantalla el nombre y apellido, el DNI y la edad.
     *  @param No utiliza parametros.
     *  @return No devuelve ningun valor.
     *  @exception No dispara ninguna excepcion.
     */
    public void mostrar() {
        System.out.println("\t" + "Nombre y Apellido: " + this.nomYApe());
        System.out.println("\t" + "DNI: " + this.getDni() + "\t" + "Edad: " + this.edad());
    }

    /** Si el dia de la fecha el empleado ingreso a la empresa, devuelve true
     * @param No utiliza parametros
     * @return Retorna un boolean
     * @exception No dispara ninguna excepcion
     */
    public boolean esCumpleaños() {
        Calendar fechaHoy = new GregorianCalendar();
        return ((fechaHoy.get(Calendar.DAY_OF_MONTH) == fechaNacimiento.get(Calendar.DAY_OF_MONTH)) && (fechaHoy.get(Calendar.MONTH) == fechaNacimiento.get(Calendar.MONTH)));
    }


}

