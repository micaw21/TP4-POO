import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

/** Permite crear y manipular objetos de tipo Curso
 * @version 20/09/2023
 * @author Wolkowyski, Micaela
 */

public class Curso {
    private String nombre;
    private HashMap alumnos; 

    //Constructores
    /** Permite instanciar objetos de tipo Curso
     * @exception No dispara ninguna excepción
     * @param p_nombre de tipo String, utilizado para asignar el valor del nombre
     */
    public Curso(String p_nombre) {
        this.setNombre(p_nombre);
        this.setAlumnos(new HashMap());
    }

    /** Permite instanciar objetos de tipo Curso
     * @exception No dispara ninguna excepcion
     * @param p_nombre de tipo String, utilizado para asignar el estado de nombre
     * @param p_alumnos de tipo HashMap, utilizado para asignar el estado de alumnos
     */
    public Curso(String p_nombre, HashMap p_alumnos) {
        this.setNombre(p_nombre);
        this.setAlumnos(p_alumnos);
    }

    //Setters y Getters
    private void setNombre(String p_nombre) {
        this.nombre = p_nombre;
    }

    private void setAlumnos(HashMap p_alumnos){
        this.alumnos = p_alumnos;
    }

    /** Devuelve el nombre
     * @exception No dispara ninguna excepcion
     * @return Retorna un String
     * @param No utiliza parametros
     */
    public String getNombre() {
        return this.nombre;
    }

    /** Devuelve el HashMap de alumnos
     * @param No utiliza parametros
     * @return Devuelve un HashMap
     * @exception No dispara ninguna excepcion
     */
    public HashMap getAlumnos(){
        return this.alumnos;
    }

    /** Permite inscribir un alumno al curso
     * @exception No dispara ninguna excepcion
     * @param p_alumno de tipo Alumno, es el alumno a inscribir
     * @return No devuelve ningun valor
     */
    public void inscribirAlumno(Alumno p_alumno) {
        this.getAlumnos().put(p_alumno.getLu(), p_alumno);
    }
    
    /** Permite quitar alumnos
     * @exception No dispara ninguna excepcion
     * @param p_lu de tipo int, utilizado para buscar el alumno a eliminar
     * @return Retorna un Alumno
     */
    public Alumno quitarAlumno(int p_lu) {
        return (Alumno)this.getAlumnos().remove(p_lu);
    }

    /** Permite saber cuantos alumnos tiene el curso
     * @param No utiliza parametros
     * @return Retorna un int
     * @exception No dispara ninguna excepcion
     */
    public int cantidadDeAlumnos() {
        return this.getAlumnos().size();
    }

    /** Verifica, segun la LU, si el alumno esta inscripto en el curso
     *  @exception No dispara ninguna excepción
     * @param p_lu de tipo int, utilizado para buscar al alumno
     * @return Retorna un boolean
     */
    public boolean estaInscripto(int p_lu) {
        return this.getAlumnos().containsKey(p_lu);
    }

    /** Verifica, segun los datos del Alumno, si el mismo está inscripto en el curso
     * @exception No dispara ninguna excepción
     * @param p_alumno de tipo Alummno, utilizado para buscar al alumno
     * @return Retorna un boolean
     */
    public boolean estaInscripto(Alumno p_alumno) {
        return this.getAlumnos().containsValue(p_alumno);
    }

    /** Permite buscar un alumno a través de su LU
     * @exception No dispara ninguna excepción
     * @param p_lu de tipo int, utilizado para buscar al alumno
     * @return Retorna un objeto de tipo Alumno
     */
    public Alumno buscarAlumno(int p_lu) {
        return (Alumno)this.getAlumnos().get(p_lu);
    }

    /** Imprime por pantalla el promedio del alumno dado su LU
     * @exception No dispara ninguna excepción
     * @param p_lu de tipo int, utilizado para buscar al alumno a imprimir promedio
     * @return No devuelve ningun valor
     */
    public void imprimirPromedio(int p_lu) {
        Alumno alum = this.buscarAlumno(p_lu);
        System.out.println("Promedio de Alumno: " + alum.promedio());
    }

    /** Imprime la lista de alumnos incriptos al curso
     * @exception No dispara ninguna excepción
     * @param No utiliza parametros
     * @return No retorna ningún valor
     */
    public void mostrarInscriptos() {
        Iterator<Map.Entry<Integer, Alumno>> it = this.getAlumnos().entrySet().iterator();
        while(it.hasNext()) {
            Map.Entry<Integer, Alumno> alum = it.next();
            System.out.println(alum.getKey() + " " + ((Alumno)alum.getValue()).apeYNom());
        }
    }

}
