/** Permite crear y manipular un objeto de tipo Alumno.
 *  @author  Wolkowyski, Micaela
 *  @version 16/08/2023
 */

public class Alumno {

    //Atributos
    private int lu = 0;
    private String nombre = "";
    private String apellido = "";
    private double nota1 = 0;
    private double nota2 = 0;

    //Metodo Constructor
    /** Permite instanciar objetos de tipo Alumno
     * @exception No dispara ninguna excepción
     * @param p_lu de tipo int, utilizado para asignar el estado de LU
     * @param p_nombre de tipo String, utilizado para asignar el estado de nombre
     * @param p_apellido de tipo String, utilizado para asignar el valor del alumno.
     */
    public Alumno(int p_lu, String p_nombre, String p_apellido) {
        this.setLU(p_lu);
        this.setNombre(p_nombre);
        this.setApellido(p_apellido);
        this.setNota1(0.0);
        this.setNota2(0.0);
    }

    //Setters
    private void setLU(int p_lu) {
        this.lu = p_lu;
    }

    private void setNombre(String p_nombre){
        this.nombre = p_nombre;
    }

    private void setApellido(String p_apellido) {
        this.apellido = p_apellido;
    }

    /** Permite asignar la nota1 del alumno
     * @exception No dispara ninguna excepción
     * @param p_nota1 de tipo double, utilizado para asignar la nota1
     * @return No devuelve ningun valor
     */
    public void setNota1(double p_nota1){
        this.nota1 = p_nota1;
    }

    /** Permite asignar la nota2 del alumnno
     * @exception No dispara ninguna excepción
     * @param p_nota2 de tipo double, utilizado para asignar la nota2
     * @return No devuelve ningun valor
     */
    public void setNota2(double p_nota2) {
        this.nota2 = p_nota2;
    }

    //Getters
    /** Devuelve el LU 
     * @param No utiliza parámetros
     * @exception No dispara ninguna excepción
     * @return Retorna un int
     */
    public int getLu() {
        return this.lu;
    }

    /** Devuelve el nombre
     * @exception No dispara ninguna excepción
     * @return Retorna un String
     * @param No utiliza parámetros
     */
    public String getNombre() {
        return this.nombre;
    }

    /** Devuelve el apellido
     * @param No utiliza parámetros
     * @return Retorna un String
     * @excepcion No dispara ninguna excepción
     */
    public String getApellido() {
        return this.apellido;
    }

    /** Retorna la nota1
     * @param No utiliza parametros
     * @return Retorna un double.
     * @exception No dispara ninguna excepción
     */
    public double getNota1() {
        return this.nota1;
    }

    /** Retorna la nota2
     * @param No utiliza parámetross
     * @exception No dispara ninguna excepción
     * @return Retorna un double
     */
    public double getNota2() {
        return this.nota2;
    }

    //Metodos

    /** Retorna true si las notas del alumno coinciden con las necesarias o false en caso contrario.
     *  @return Devuelve un booleano
     *  @param No utiliza parametros.
     *  @exception No dispara ninguna excepcion. 
     */

    private boolean aprueba() {
        if(this.promedio() >= 7.0 && (this.getNota1() >= 6.0 && this.getNota2() >= 6.0)) {
            return true;
        } else {
            return false;
        }
    }

    /** Retorna una leyenda dependiendo del mensaje aprueba()
     * @param No utiliza parametros.
     * @return Devuelve un String.
     * @exception No dispara excepciones.
     */
    private String leyendaAprueba(){
        if(this.aprueba()){
            return("APROBADO");
        } else {
            return("DESAPROBADO");
        }
    }

    /** Calcula el promedio de dos notas
     * @param No utiliza parametros.
     * @return Retorna un double.
     * @exception No dispara excepciones.
     */
    public double promedio() {
        return((this.getNota1() + this.getNota2()) / 2);
    }

    /** Retorna un String conteniendo nombre y apellido
     * @param No utiliza parametros.
     * @return Devuelve un String.
     * @exception No dispara excepciones.
     */
    public String nomYApe() {
        return (this.getNombre() + " " + this.getApellido());
    }

    /** Retorna un String conteniendo apellido y nombre
     * @param No utiliza parametros.
     * @return Devuelve un String.
     * @exception No dispara excepciones.
     */
    public String apeYNom() {
        return (this.getApellido() + " " + this.getNombre());
    }

    /** Muestra por pantalla nombre y apellido, libreta universitaria, las notas y el promedio
     * @param No utiliza parametros.
     * @return No retorna un valor.
     * @exception No dispara excepciones.
     */
    public void mostrar() {
        System.out.println("Nombre y Apellido: " + nomYApe());
        System.out.println("LU:" + this.getLu() + "\t" + "Notas: " + this.getNota1() + " " + "-" + " " + this.getNota2());
        System.out.println("Promedio: " + this.promedio() + " " + "-" + " " + this.leyendaAprueba());
    }
}
