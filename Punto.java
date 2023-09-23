/** Permite crear e instanciar objetos de clase Punto
 *  @author Wolkowyski, Micaela
 *  @version 31/08/2023
 */
public class Punto {
    //Atriutos
    private double x = 0.0;
    private double y = 0.0;

    //Metodo Constructor
    /** Permite instanciar objetos de tipo Punto
     *  @param No recibe parametros
     *  @exception No dispara excepciones
     *  @return No devuelve ningun valor
     */
    public Punto() {
        this.setX(0.0);
        this.setY(0.0);
    }

    /** Permite instanciar objetos de tipo Punto
    *  @param p_x de tipo double, utilizado para asignar el nuevo valor de x
    *  @param p_y de tipo double, utilizado para asignar el nuevo valor de y   
    *  @exception No dispara excepciones
    *  @return No devuelve ningun valor
    */
    public Punto(double p_x, double p_y) {
        this.setX(p_x);
        this.setY(p_y);
    }

    //Getters y Setters
    private void setX(double p_x) {
        this.x = p_x;
    }

    private void setY(double p_y) {
        this.y = p_y;
    }

    /** Permite obtener el valor de x
     * @param No utiliza parametros
     * @exception No dispara ninguna excepcion
     * @return Retorna un double.
     */

    public double getX(){
        return this.x;
    }

    /** Permite obtener el valor y
     * @param No utiliza parametros
     * @exception No dispara ninguna excepcion
     * @return Retorna un double 
     */

    public double getY() {
        return this.y;
    }
    
    /** Calcula la distancia desde un punto hasta otro dado por parametro
     * @param p_ptoDistante de tipo Punto, se utiliza para calcular la distancia al punto distante
     * @exception No dispara ninguna excepcion
     * @return Devuelve un double
     */
    public double distanciaA(Punto p_ptoDistante) {
        return Math.sqrt(Math.pow((p_ptoDistante.x - this.getX()), 2) + (Math.pow((p_ptoDistante.y - this.getY()), 2)));
    }

    /** Desplaza un punto a otro pasado como parametro
    *  @param p_dx de tipo Double, se utiliza para calcular el desplazamiento de x
    *  @param p_dy de tipo Double, se utiliza para calcular el desplazamiento de y
    *  @exception No dispara ninguna excepcion.
    *  @return No devuelve ningun valor.
    */

    public void desplazar(double p_dx, double p_dy) {
        this.setX(this.getX() + p_dx);
        this.setY(this.getY() + p_dy);
    }

    /** Muestra por pantalla los valores de x e y
     * @param No utiliza parametros
     * @exception No dispara excepciones
     * @return No devuelve ningun valor
     */

    public void mostrar() {
        System.out.println("Punto. X: " + getX() + " " + "Y: " + getY()); 
    }

    /** Muestra por pantalla las coordenadas x e y
     * @param No utiliza parametros
     * @exception No dispara ninguna excepcion
     * @return Devuelve un String
     */

    public String coordenadas() {
        return ("(" + getX() + "," + " " + getY() + ")");
    }
}
