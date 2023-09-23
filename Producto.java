import java.util.Scanner;

/** Permite crear y manipular objetos de la clase Producto
 *  @author Wolkowyski, Micaela
 *  @version 24/08/2023
 */

public class Producto {
    //atributos - variables de instancia
    private int codigo;
    private String rubro;
    private double costo;
    private String descripcion;
    private int stock;
    private double porcPtoRepo;
    private int existMinima;
    private Laboratorio laboratorio;

    //Metodo Constructor
    /** Sirve para instanciar objetos de clase Producto
     * @return No retorna ningun valor.
     * @param p_codigo de tipo int, se utiliza para asignar el nuevo valor de codigo.
     * @param p_rubro de tipo String, se utiliza para asignar el nuevo valor de rubro.
     * @param p_desc de tipo String, se utiliza para asignar el nuevo valor de descripcion.
     * @param p_costo de tipo double, se utiliza para asignar el nuevo valor de costo.
     * @param p_porcPtoRepo de tipo double, se utiliza para asignar el nuevo valor de porcPtoRepo.
     * @param p_existMinima de tipo entero, se utiliza para asignar el nuevo valor de existMinima.
     * @param p_lab de tipo Laboratorio, se utiliza para asignar el nuevo valor de laboratorio.
     * @exception No dispara ninguna excepcion.
     */
    public Producto(int p_codigo, String p_rubro, String p_desc, double p_costo, double p_porcPtoRepo, int p_existMinima, Laboratorio p_lab) {
        this.setCodigo(p_codigo);
        this.setRubro(p_rubro);
        this.setCosto(p_costo);
        this.setDescripcion(p_desc);
        this.setStock(0);
        this.setPorcPtoRepo(p_porcPtoRepo);
        this.setExistMinima(p_existMinima);
        this.setLaboratorio(p_lab);
    }

    //Metodo Constructor
    /** Sirve para instanciar objetos de clase Laboratorio
     * @return No retorna ningun valor.
     * @param p_codigo de tipo int, se utiliza para asignar el nuevo valor de codigo.
     * @param p_rubro de tipo String, se utiliza para asignar el nuevo valor de rubro.
     * @param p_desc de tipo String, se utiliza para asignar el nuevo valor de descripcion.
     * @param p_costo de tipo double, se utiliza para asignar el nuevo valor de costo.
     * @param p_lab de tipo Laboratorio, se utiliza para asignar el nuevo valor de laboratorio.
     * @exception No dispara ninguna excepcion.
     */
    public Producto(int p_codigo, String p_rubro, String p_desc, double p_costo, Laboratorio p_lab) {
        this.setCodigo(p_codigo);
        this.setRubro(p_rubro);
        this.setDescripcion(p_desc);
        this.setCosto(p_costo);
        this.setStock(0);
        this.setPorcPtoRepo(0);
        this.setExistMinima(0);
        this.setLaboratorio(p_lab);
    }

    //Setters
    private void setCodigo (int p_codigo) {
        this.codigo = p_codigo;
    }

    private void setRubro(String p_rubro) {
        this.rubro = p_rubro;
    }

    private void setCosto (double p_costo) {
        this.costo = p_costo;
    }

    private void setDescripcion(String p_desc) {
        this.descripcion = p_desc;
    }

    private void setStock(int p_stock) {
        this.stock = p_stock;
    }

    private void setPorcPtoRepo(double p_porcPtoRepo) {
        this.porcPtoRepo = p_porcPtoRepo;
    }

    private void setExistMinima(int p_existMinima) {
        this.existMinima = p_existMinima;
    }

    private void setLaboratorio(Laboratorio p_Laboratorio) {
        this.laboratorio = p_Laboratorio;
    }

    //Getters
    /** Retorna el codigo
     * @param No utiliza parametros.
     * @return Retorna un int.
     * @exception No dispara ninguna excepcion.
     */
    public int getCodigo() {
        return this.codigo;
    }

    /** Retorna el rubro
     * @param No utiliza parametros
     * @return Devuelve un String
     * @exception No dispara ninguna excepcion
     */
    public String getRubro() {
        return this.rubro;
    }

    /** Retorna la descripcion
     * @param No utiliza parametros
     * @return Devuelve un String
     * @exception No dispara ninguna excepcion
     */
    public String getDescripcion() {
        return this.descripcion;
    }

    /** Devuelve el costo
     * @param No utiliza parametros
     * @return Devuelve un double
     * @exception No dispara ninguna excepcion
     */
    public double getCosto() {
        return this.costo;
    }

    /** Devuelve el stock
     * @param No utiliza parametros
     * @return Retorna un int 
     * @exception No dispara ninguna excepcion
     */
    public int getStock() {
        return this.stock;
    }

    /** Retorna el porcentaje de punto de reposicion.
     * @param No utiliza parametros
     * @return Retorna un double.
     * @exception No dispara ninguna excepcion.
     */
    public double getPorcPtoRepo() {
        return this.porcPtoRepo;
    }

    /** Retorna la existencia minima 
     * @param No utiliza parametros
     * @return Devuelve un int.
     * @exception No dispara ninguna excepcion
     */
    public int getExistMinima() {
        return this.existMinima;
    }

    /** Retorna el objeto laboratorio
     * @param No utiliza parametros
     * @return Devuelve un Laboratorio.
     * @exception No dispara excepciones.
     */
    public Laboratorio getLaboratorio() {
        return this.laboratorio;
    }

    //Metodos
    /** Imprime por pantalla datos tales como los del laboratorio, rubro, descripcion, precio costo, stock y stock valorizado 
     * @param No utiliza parametros.
     * @return No devuelve ningun valor.
     * @exception No dispara excepciones.
     */
    public void mostrar() {
        this.getLaboratorio().mostrar();
        System.out.println("\n" + "Rubro: " + this.getRubro());
        System.out.println("Descripcion: " + this.getDescripcion());
        System.out.println("Precio Costo: " + this.getCosto());
        System.out.println("Stock: " + this.getStock() + " " + "-" + " " + "Stock Valorizado: " + "$" +  this.stockValorizado());
    }

    /** Permite ajustar la cantidad de stock
     * @param p_cantidad de tipo int, utilizado para agregar o quitar stock
     * @return No devuelve ningun valor
     * @exception No dispara ninguna excepcion.
     */
    public void ajuste(int p_cantidad) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Desea agregar o quitar stock? 1-Agregar 2-Quitar: ");
        int respuesta = teclado.nextInt();
        if(respuesta == 1) {
            this.setStock(this.getStock() + p_cantidad);
        } else {
            this.setStock(this.getStock() - p_cantidad);
        }
        
    }

    /** Devuelve el valor que resulta de agregarle un 12% al precio de costo
     * @param No utiliza parametros
     * @return Devuelve un double
     * @exception No dispara excepciones.
     */
    public double precioLista() {
        return (this.getCosto() + (this.getCosto() * 0.12));
    }

    /** Devuelve el valor de pagar al contado, restando un 5% al precio de lista
     * @param No utiliza parametros
     * @return Devuelve un double
     * @exception No dispara ninguna excepcion.
     */
    public double precioContado() {
        return (precioLista() - (precioLista() * 0.05));
    }

    /** Devuelve el valor de multiplicar el stock por el precio de costo mas un 12% de rentabilidad
     * @param No utiliza parametros
     * @return Devuelve un double
     * @exception No dispara excepciones
     */
    public double stockValorizado() {
        return (this.getStock() * this.getCosto() + ((this.getStock() * this.getCosto()) * 0.12));
    }

    /** Permite asignar un nuevo valor a porcPtoRepo
     * @param p_porce de tipo double, utilizado para asignarle un nuevo valor a porcPtoRepo
     * @return No retorna ningun valor
     * @exception No dispara excepciones
     */
    public void ajustarPtoRepo(double p_porce) {
        this.setPorcPtoRepo(p_porce);
    }

    /** Permite asignar un nuevo valor a existMinima
     * @param p_cantidad de tipo int, utilizado para asignarle un nuevo va lor a existMinima
     * @return No devuelve ningun valor
     * @exception No dispara ninguna excepcion
     */
    public void ajustarExistMin(int p_cantidad) {
        this.setExistMinima(p_cantidad);
    } 

    /** Permite imprimir por pantalla la descripcion, el precio de lista y el precio de contado
     * @param No utiliza parametros
     * @return Devuelve un String.
     * @exception No dispara ninguna excepcion
     */
    public String mostrarLinea() {
        return(this.getDescripcion() + "     " + this.precioLista() + "     " + this.precioContado());
    }

}
