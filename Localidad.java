/** Permite crear y manipular objetos de tipo Localidad
 * @author Wolkowyski, Micaela
 * @version 03/09/2023
 */

public class Localidad {
    //Atributos
    private String nombre;
    private String provincia;

    //Metodo Constructor
    /** Permite instanciar objetos de tipo Localidad
     * @return No devuelve ningun valor
     * @param p_nombre de tipo String, utilizado para asignar el valor del nombre
     * @param p_provincia de tipo String, utilizado para asignar el valor de provincia
     * @exception No dispara ninguna excepcion
     */
    public Localidad(String p_nombre, String p_provincia) {
        this.setNombre(p_nombre);
        this.setProvincia(p_provincia);
    }

    //Setters y Getters
    private void setNombre(String p_nombre) {
        this.nombre = p_nombre;
    }

    private void setProvincia(String p_provincia) {
        this.provincia = p_provincia;
    }

    /** Retorna el nombre
     * @param No utiliza parametros
     * @return Devuelve un String
     * @exception No dispara ninguna excepcion
     */
    public String getNombre() {
        return this.nombre;
    }

    /** Retorna la provincia
     * @param No utiliza parametros
     * @return Devuelve un String
     * @exception No dispara ninguna excepcion
     */
    public String getProvincia() {
        return this.provincia;
    }

    //Metodos
    /** Muestra por pantalla los datos de la localidad, tales como su nombre y la provincia
     * @param No utiliza parametros
     * @return Devuelve un String
     * @exception No dispara ninguna excepcion
     */
    public String mostrar() {
        return ("Localidad: " + this.getNombre() + "    " + "Provincia: " + this.getProvincia());
    }
}
