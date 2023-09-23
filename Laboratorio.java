/** Permite crear y manipular objetos de tipo Laboratorio
 *  @author Wolkowyski, Micaela
 *  @version 16/08/2023
 */

public class Laboratorio {
    //Atributos
    private String nombre = "";
    private String domicilio = "";
    private String telefono = "";
    private int compraMinima = 0;
    private int diaEntrega = 0;

    //Metodo Constructor
    /** Sirve para instanciar objetos de clase Laboratorio.
     * @return No retorna ningun valor.
     * @param p_nombre de tipo String, se utiliza para asignar el nuevo valor de nombre.
     * @param p_domicilio de tipo String, se utiliza para asignar el nuevo valor de domicilio.
     * @param p_telefono de tipo String, se utiliza para asignar el nuevo valor de telefono.
     * @param p_compraMin de tipo int, se utiliza para asiganr el nuevo valor de compraMinima.
     * @param p_diaEnt de tipo int, se utiliza para asignar el nuevo valor de diaEntrega.
     * @exception No dispara ninguna excepcion.
     */
    public Laboratorio(String p_nombre, String p_domicilio, String p_telefono, int p_compraMin, int p_diaEnt) {
        this.setNombre(p_nombre);
        this.setDomicilio(p_domicilio);
        this.setTelefono(p_telefono);
        this.setCompraMin(p_compraMin);
        this.setDiaEnt(p_diaEnt);
    }

    /** Sirve para instanciar objetos de clase Laboratorio.
     * @return No retorna ningun valor.
     * @param p_nombre de tipo String, se utiliza para asignar el nuevo valor de nombre.
     * @param p_domicilio de tipo String, se utiliza para asignar el nuevo valor de domicilio.
     * @param p_telefono de tipo String se utiliza para asignar el nuevo valor de telefono.
     * @exception No dispara ninguna excepcion.
     */
    public Laboratorio(String p_nombre, String p_domicilio, String p_telefono){
        this.setNombre(p_nombre);
        this.setDomicilio(p_domicilio);
        this.setTelefono(p_telefono);
        this.setCompraMin(0);
        this.setDiaEnt(0);
    }

    //Setter
    private void setNombre(String p_nombre) {
        this.nombre = p_nombre;
    }

    private void setDomicilio(String p_domicilio) {
        this.domicilio = p_domicilio;
    }

    private void setTelefono(String p_telefono) {
        this.telefono = p_telefono;
    }

    private void setCompraMin(int p_compraMin) {
        this.compraMinima = p_compraMin;
    }

    private void setDiaEnt(int p_diaEnt) {
        this.diaEntrega = p_diaEnt;
    }

    //Getter
    /** Retorna el nombre 
     * @param No utiliza parametros.
     * @return Devuelve un String.
     * @exception No dispara ninguna excepcion.
     */
    public String getNombre() {
        return this.nombre;
    }
    
    /** Retorna el domicilio 
     * @param No utiliza parametros.
     * @return Devuelve un String.
     * @exception No dispara ninguna excepcion.
     */
    public String getDomicilio() {
        return this.domicilio;
    }

    /** Retorna el telefono 
     * @param No utiliza parametros.
     * @return Devuelve un String.
     * @exception No dispara ninguna excepcion.
     */
    public String getTelefono() {
        return this.telefono;
    }

    /** Retorna el valor de compra minima 
     * @param No utiliza parametros.
     * @return Devuelve un entero.
     * @exception No dispara ninguna excepcion.
     */
    public int getCompraMin() {
        return this.compraMinima;
    }

    /** Retorna el dia de entrega 
     * @param No utiliza parametros.
     * @return Devuelve un entero.
     * @exception No dispara ninguna excepcion.
     */
    public int getDiaEnt() {
        return this.diaEntrega;
    }

    //metodos
    /** Asigna a compraMinima un nuevo valor
     * @param p_compraMin de tipo int, se utiliza para asignar un nuevo valor al atributo compraMinima.
     * @return No devuelve un valor.
     * @exception No dispara ninguna excepcion.
     */
    public void nuevaCompraMinima(int p_compraMin) {
        this.setCompraMin(p_compraMin);
    }
    /** Asigna a diaEntrega un nuevo valor.
     * @param p_diaEnt de tipo int, se utiliza para asignar el nuevo valor al atributo diaEntrega.
     * @return No retorna ningun valor.
     * @exception No dispara ninguna excepcion.
     */
    public void nuevoDiaEntrega(int p_diaEnt) {
        this.setDiaEnt(p_diaEnt);
    }

    /** Muestra por pantalla el nombre del laboratorio, su domicilio y su telefono
     * @param No posee parametros.
     * @return Devuelve un String.
     * @exception No dispara ninguna excepcion.
     */
    public String mostrar(){
        return ("\t" + "Laboratorio: " + this.getNombre() + "\n" + "\t" + "Domicilio: " + this.getDomicilio() + " " + "-" + " " + "Telefono: " + this.getTelefono());
    }
}
