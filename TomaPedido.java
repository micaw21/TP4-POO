/** Clase Ejecutable
 * @author Wolkowyski, Micaela
 * @version 14/09/2023
 */

import java.util.*;
import java.util.Scanner;

public class TomaPedido {
    public static void main(String [] args) {
        Scanner teclado = new Scanner(System.in);

        //Instancia de Fecha
        Calendar fechaHoy = Calendar.getInstance();
        fechaHoy.get(Calendar.YEAR);
        fechaHoy.get((Calendar.MONTH) + 1); 
        fechaHoy.get(Calendar.DAY_OF_MONTH);
    
        //Instanicia de Cliente
        Cliente unCliente = new Cliente(45649603, "Perez", "Juan", 10000);
        
        //Instancia de Laboratorio
        Laboratorio unLaboratorio = new Laboratorio("Montpellier","Las Vegas 1234","11-92587645-12");

        //Instancia de Productos
        int respuesta;
        Pedido miPedido = null;
        int op;
        do {

            System.out.println("--- Toma de Pedidos ---");
            System.out.println("1 - Agregar producto a pedido");
            System.out.println("2 - Quitar producto de pedido");
            System.out.println("3 - Mostrar pedido");
            System.out.println("4 - Salir");
            respuesta = teclado.nextInt();

            switch (respuesta) {
                case 1:
                    do {
                        System.out.print("Ingrese codigo del producto: ");
                        int codigo = teclado.nextInt();
                        System.out.println("Ingrese el rubro: ");
                        String rubro = teclado.next();
                        System.out.print("Ingrese la descripción: ");
                        String desc = teclado.next();
                        System.out.print("Ingrese el costo: ");
                        double costo = teclado.nextDouble();
                        Producto unProducto = new Producto(codigo, rubro, desc, costo, unLaboratorio);
                        if (miPedido == null) {
                            miPedido = new Pedido(fechaHoy, unCliente, unProducto);
                        } else {
                            miPedido.agregarProducto(unProducto); 
                        }
                    System.out.print("Desea ingresar otro producto? 1-Si 2-No: ");
                    op = teclado.nextInt();
                    } while (op == 1);
                break;
                case 2:
                    do {
                        if (miPedido == null || miPedido.getProducto().size() <= 1) {
                            System.out.println("No se pueden eliminar productos!");
                        } else {
                            System.out.println("Que producto desea eliminar? ");
                            for (int i = 0; i < miPedido.getProducto().size(); i++) {
                                System.out.println("Nro Producto: " + (i + 1) + " " + miPedido.getProducto().get(i).getDescripcion());
                            }
                            int objetoABorrar = teclado.nextInt();
                            miPedido.quitarProducto(miPedido.getProducto().get(objetoABorrar)); 
                        }
                        System.out.print("Desea borrar otro producto? 1-Si 2-No: ");
                        op = teclado.nextInt();
                    } while (op == 1);
                break;
                case 3:
                if (miPedido == null || miPedido.getProducto().isEmpty() == true) {
                        System.out.println("No hay elementos en el pedido!");
                    } else {
                        miPedido.mostrarPedido();
                    }
                break;
                case 4:
                    System.out.println("Menú Cerrado!");
                break;
                default:
                    System.out.println("Valor Erróneo!");
                break;
            }
        } while (respuesta != 4 && (respuesta >= 1 && respuesta <= 3));
    }
}

