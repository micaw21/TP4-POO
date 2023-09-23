/** Permite crear y manipular objetos de tipo CuentaBancaria
 * @author Wolkowyski, Micaela
 * @version 03/09/2023
 */

public class CuentaBancaria{
    //Atributos
    private int nroCuenta;
    private double saldo;
    private Persona titular;

    //Metodos Constructores
    /** Permite instanciar objetos de tipo CuentaBancaria
     * @exception No dispara ninguna excepcion
     * @param p_nroCuenta de tipo int, utilizado para asignar el valor de nroCuenta
     * @param p_titular de tipo Persona, utilizado para asignar el valor de titular
     * @return No devuelve ningun valor
     */
    public CuentaBancaria(int p_nroCuenta, Persona p_titular) {
        this.setNroCuenta(p_nroCuenta);
        this.setSaldo(0.0);
        this.setTitular(p_titular);
    }

    /** Permite instanciar objetos de tipo CuentaBancaria
     * @exception No dispara ninguna excepcion
     * @param p_nroCuenta de tipo int, utilizado para asignar el valor de nroCuenta
     * @param p_titular de tipo Persona, utilizado para asignar el valor de titular
     * @param p_saldo de tipo double, utilizado para asignar el valor del saldo
     * @return No devuelve ningun valor
     */
    public CuentaBancaria(int p_nroCuenta, Persona p_titular, double p_saldo) {
        this.setNroCuenta(p_nroCuenta);
        this.setSaldo(p_saldo);
        this.setTitular(p_titular);
    }

    //Getters y Setters
    private void setNroCuenta(int p_nroCuenta) {
        this.nroCuenta = p_nroCuenta;
    }

    private void setSaldo(double p_saldo) {
        this.saldo = p_saldo;
    }

    private void setTitular(Persona p_titular) {
        this.titular = p_titular;
    }

    /** Permite obtener el numero de cuenta
     * @param No utiliza parametros
     * @return Devuelve un int
     * @exception No dispara ninguna excepcion
     */
    public int getNroCuenta() {
        return this.nroCuenta;
    }

    /** Permite obtener el saldo
     * @param No utiliza parametros
     * @return Devuelve un double
     * @exception No dispara ninguna excepcion
     */
    public double getSaldo() {
        return this.saldo;
    }

    /** Permite obtener el titular
     * @param No utiliza parametros
     * @return Devuelve un objeto de tipo Persona
     * @exception No dispara ninguna excepcion
     */
    public Persona getTitular() {
        return this.titular;
    }

    //Metodos
    /** Incrementa el saldo actual con el importe pasado por parametro
     * @param p_importe de tipo double, utilizado para incrementar el saldo
     * @return Devuelve un double
     * @exception No dispara ninguna excepcion
     */
    public double depositar(double p_importe) {
        this.setSaldo(this.getSaldo() + p_importe);
        return this.getSaldo();
    }

    /** Decrementa el saldo actual con el importe pasado por parametro
     * @param p_importe de tipo double, utilizado para decrementar el saldo
     * @return Devuelve un double
     * @exception No dispara ninguna excepcion
     */
    public double extraer(double p_importe) {
        this.setSaldo(this.getSaldo() - p_importe);
        return this.getSaldo();
    }

    /** Imprime por pantalla los datos de la cuenta bancaria, tales como el titular y su saldo
     * @param No utiliza parametros
     * @return No devuelve ningun valor
     * @exception No dispara ninguna excepcion
     */
    public void mostrar() {
        System.out.println("\t" + "- Cuenta Bancaria -");
        System.out.println("Titular: " + this.getTitular().nomYApe() + " " + "(" + this.getTitular().edad() + "años" + ")");
        System.out.println("Saldo: " + this.getSaldo());
    }

    /** Concatena el numero de cuenta, el titular y su saldo
     *  @param No utiliza parametros.
     *  @return Devuelve un String.
     *  @exception No dispara ninguna excepcion.
     */
    public String toString() {
        return ("\t" + this.getNroCuenta() + " " + this.getTitular().nomYApe() + " " + this.getSaldo());
    }


}