
/** Permite crear y manipular un objeto de tipo Cliente
 *  @author Wolkowyski, Micaela
 *  @version 23/08/2023
 */

public class Cliente {
    //Atributos; variables de instancias 
    private int nroDni = 0;
    private String apellido = "";
    private String nombre = "";
    private double saldo = 0;

    //Metodo Constructor
    /** Sirve para instanciar objetos de la clase Cliente
     * @return No devuelve ningun valor.
     * @exception No dispara ninguna excepcion.
     * @param p_dni tipo int, se utiliza para asignar el nuevo valor de dni.
     * @param p_apellido tipo String, se utiliza para asignar el nuevo valor de apellido.
     * @param p_nombre tipo String, se utiliza para asignar el nuevo valor de nombre.
     * @param p_importe tipo double, se utiliza para asignar el nuevo valor del saldo.
     */
    public Cliente(int p_dni, String p_apellido, String p_nombre, double p_importe) {
        this.setNroDni(p_dni);
        this.setApellido(p_apellido);
        this.setNombre(p_nombre);
        this.setSaldo(p_importe); 
    }

    //Setters
    private void setNroDni(int p_dni) {
        this.nroDni = p_dni;
    }

    private void setApellido(String p_apellido) {
        this.apellido = p_apellido;
    }

    private void setNombre(String p_nombre) {
        this.nombre = p_nombre;
    }

    private void setSaldo(double p_importe) {
        this.saldo = p_importe;
    }

    //Getters
    /** Retorna el DNI
     * @param No utiliza parametros.
     * @return Devuelve un int.
     * @exception No dispara ninguna excepcion.
     */
    public int getDni() {
        return this.nroDni;
    }

    /** Retorna el apellido.
     * @param No utiliza parametros.
     * @return Devuelve un String.
     * @exception No dispara ninguna excepcion.
     */
    public String getApellido() {
        return this.apellido;
    }

    /** Retorna el nombre.
     * @param No utiliza parametros.
     * @return Devuelve un String.
     * @exception No dispara ninguna excepcion.
     */
    public String getNombre() {
        return this.nombre;
    }

    /** Retorna el saldo.
     * @param No utiliza parametros.
     * @return Devuelve un double.
     * @exception No dispara ninguna excepcion.
     */
    public double getSaldo() {
        return this.saldo;
    }

    //Metodos
    /** Muestra por pantalla los datos del Cliente (nombre y apellido, DNI, y saldo)
     * @param No utiliza parametros.
     * @return No devuelve ningun valor.
     * @exception No dispara ninguna excepcion.
     */
    public void mostrar() {
        System.out.println(" - Cliente - ");
        System.out.println("Nombre y Apellido: " + this.nomYape() + "(" + this.getDni() + ")");
        System.out.println("Saldo: " + "$" + this.getSaldo());
    }

    /** Asigna un nuevo importe de saldo.
     * @param p_importe de tipo double, se utiliza para asignar el nuevo importe del saldo.
     * @return Devuelve un double.
     * @exception No dispara ninguna excepcion.
     */
    public double nuevoSaldo(double p_importe) {
        this.setSaldo(p_importe);
        return this.saldo;
    }

    /** Calcula el nuevo saldo al agregarle otra suma de importe.
     * @param p_importe de tipo double, se utiliza para agregarle el importe al saldo.
     * @return Devuelve un double.
     * @exception No dispara ninguna excepcion.
     */
    public double agregaSaldo(double p_importe) {
        double importe = this.getSaldo();
        this.setSaldo(importe + p_importe);
        return this.getSaldo();
    }

    /** Retorna el apellido y el nombre
     * @param No utiliza parametros.
     * @return Devuelve un String.
     * @exception No dispara ninguna excepcion.
     */
    public String apeYNom(){
        return (this.getApellido() + " " + this.getNombre());
    }

    /** Retorna el nombre y apellido.
     * @param No utiliza parametros.
     * @return Devuelve un String.
     * @exception No dispara ninguna excepcion.
     */
    public String nomYape() {
        return (this.getNombre() + " " + this.getApellido());
    }
}
