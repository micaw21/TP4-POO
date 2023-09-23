/** Permite crear y manipular objetos de tipo Pedido
 * @author Wolkowyski, Micaela
 * @version 14/09/2023
 */

import java.text.SimpleDateFormat;
import java.util.*;

public class Pedido {
    private Cliente cliente;
    private ArrayList<Producto> productos;
    private Calendar fecha;

    //Metodos Constructores
    /** Permite instanciar objetos de tipo Pedido
     * @param p_fecha de tipo Calendar, utilizado para asignar el estado de fecha.
     * @param p_cliente de tipo Cliente, utilizado para asiganr el estado de cliente.
     * @param p_productos de tipo ArrayList, utilizado para asignar la lista a productos.
     * @return No devuelve ningun valor
     * @exception No dispara ninguna excepcion
     */
    public Pedido(Calendar p_fecha, Cliente p_cliente, ArrayList<Producto> p_productos) {
        this.setFecha(p_fecha);
        this.setCliente(p_cliente);
        this.setProductos(p_productos);
    }

    /** Permite instanciar objetos de tipo Pedido
     * @param p_fecha de tipo Calendar, utilizado para asignar el estado de fecha.
     * @param p_cliente de tipo Cliente, utilizado para asiganr el estado de cliente.
     * @param p_productos de tipo Producto, utilizado para asignar el estado de productos
     * @return No devuelve ningun valor
     * @exception No dispara ninguna excepcion
     */
    public Pedido(Calendar p_fecha, Cliente p_cliente, Producto p_producto){
        this.setFecha(p_fecha);
        this.setCliente(p_cliente);
        this.setProductos(new ArrayList<Producto>());
        this.agregarProducto(p_producto);
    }

    //Setters y Getters
    private void setCliente(Cliente p_cliente) {
        this.cliente = p_cliente;
    }

    private void setProductos(ArrayList<Producto> p_productos) {
        this.productos = p_productos;
    }

    private void setFecha(Calendar p_fecha) {
        this.fecha = p_fecha;
    }

    /** Retorna el cliente
     * @param No utiliza parametros
     * @return devuelve un objeto de tipo Cliente
     * @exception No dispara ninguna excepcion
     */
    public Cliente getCliente() {
        return this.cliente;
    }

    /** Devuelve una ArrayList<Producto>
     * @param No utiliza parametros
     * @return retorna un ArrayList<Producto>
     * @exception No dispara ninguna excepcion
     */
    public ArrayList<Producto> getProducto() {
        return this.productos;
    }

    /** Retorna la fecha
     * @param No utiliza parametros
     * @return Retorna un objeto de tipo Calendar
     * @exception No dispara ninguna excepcion
     */
    public Calendar getFecha() {
        return this.fecha;
    }

    //Metodos
    /** Agrega un producto a la lista
     * @exception No dispara ninguna excepcion
     * @param p_producto de tipo Producto, es el producto a agregar a la lista
     * @return Retorna un boolean
     */
    public boolean agregarProducto(Producto p_producto) {
        return this.getProducto().add(p_producto);
    }

    /** Remueve un producto de la lista
     * @exception No dispara ninguna excepcion
     * @param p_producto de tipo Producto, es el producto a remover
     * @return Retorna un boolean
     */
    public boolean quitarProducto(Producto p_producto) {
        return this.getProducto().remove(p_producto);
    }

    /** Calcula y devuelve el precio total al contado
     * @exception No dispara ninguna excepcion
     * @return Devuelve un double
     * @param No utiliza parametros
     */
    public double totalAlContado() {
        double totalContado = 0;
        for(Producto prod: this.getProducto()){
            totalContado = totalContado + prod.precioContado();
        }
        return totalContado;
    }

    /** Calcula y devuelve el precio total financiado
     * @param No utiliza parametros
     * @return Devuelve un double
     * @exception No dispara ninguna excepcion
     */
    public double totalFinanciado() {
        double totalFinanciado = 0;
        for(Producto prod: productos) {
            totalFinanciado = totalFinanciado + prod.precioLista();
        }
        return totalFinanciado;
    }

    /** Imprime por pantalla los pedidos
     * @param No utiliza parametros
     * @exception No dispara ninguna excepcion
     * @return No devuelve ningun valor
     */
    public void mostrarPedido() {
        SimpleDateFormat fecha = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy", new Locale("es", "ES"));
        String fechaFormateada = fecha.format(this.getFecha().getTime());
        
        System.out.println("****** Detalle del Pedido ****** Fecha: " + fechaFormateada);
        System.out.println("Producto" + "     " + "Precio Lista" + "     " + "Precio Contado");
        System.out.println("--------------------------------------------");
        for(Producto prod: this.productos) {
            System.out.println(prod.mostrarLinea() + "\n");
        }
        System.out.println("--------------------------------------------");
        System.out.println("*** Total----" + this.totalFinanciado() + "     " + this.totalAlContado());
    }
}
