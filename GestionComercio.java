/** Clase Ejecutable
 * @author Wolkowyski, Micaela
 * @version 23/09/2023
 */

import java.util.Scanner;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;

public class GestionComercio {
    public static void main(String [] args) {
        Scanner teclado = new Scanner(System.in);

        Comercio unComercio = new Comercio(args[0]);

        int respuesta, op;
        do {
            System.out.println("\n" + "**** MENÚ COMERCIO ****");
            System.out.println("1 - Alta Empleados");
            System.out.println("2 - Baja Empleados");
            System.out.println("3 - Mostrar cantidad de empleados");
            System.out.println("4 - Verificar si es empleado según su CUIL");
            System.out.println("5 - Mostrar Sueldo Neto de un empleado");
            System.out.println("6 - Mostrar Nómina de Empleados");
            System.out.println("0 - Salir");
            respuesta = teclado.nextInt();

            switch(respuesta) {
                case 1:
                    do {
                        System.out.print("Ingrese su CUIL: ");
                        long cuil = teclado.nextLong();
                        System.out.print("Ingrese su apellido: ");
                        String apellido = teclado.next();
                        System.out.print("Ingrese su nombre: ");
                        String nombre = teclado.next();
                        System.out.print("Ingrese su sueldo básico: ");
                        double sueldo = teclado.nextDouble();
                        System.out.print("Ingrese su año de ingreso: ");
                        Calendar añoIngreso = new GregorianCalendar();
                        añoIngreso.set(Calendar.YEAR, teclado.nextInt());
                        Empleado unEmpleado = new Empleado(cuil, apellido, nombre, sueldo, añoIngreso);
                        unComercio.altaEmpleado(unEmpleado);
                        System.out.print("¿Desea dar de alta a otro empleado? 1-Si 2-No: ");
                        op = teclado.nextInt();
                    } while (op == 1);
                break;
                case 2:
                    do {
                        if(unComercio.getEmpleados().isEmpty() == true) {
                            System.out.println("No hay empleados en el comercio!");
                        } else {
                            System.out.println("Ingrese el CUIL del empleado: ");
                            for(HashMap.Entry<Long, Empleado> empleados: unComercio.getEmpleados().entrySet()) {
                                System.out.println("CUIL: " + empleados.getKey() + " ---- " + "Apellido y Nombre: " + empleados.getValue().apeYNombre());
                            }
                            long cuilBaja = teclado.nextLong();
                            unComercio.bajaEmpleado(cuilBaja);
                        }
                        System.out.print("¿Desea dar de baja otro empleado? 1-Si 2-No: ");
                        op = teclado.nextInt();
                    } while (op == 1);
                break;
                case 3:
                    if(unComercio.getEmpleados().isEmpty() == true) {
                        System.out.println("No hay empleados para mostrar!");
                    } else {
                        System.out.println("Cantidad de Empleados: " + unComercio.cantidadDeEmpleados());
                    }
                break;
                case 4:
                    if(unComercio.getEmpleados().isEmpty() == true) {
                        System.out.println("No hay empleados!");
                    } else {
                        System.out.print("Ingrese CUIL para verificar: ");
                        long cuilVerif = teclado.nextLong();
                        System.out.println("¿Es empleado " + cuilVerif + "?" + " " + unComercio.esEmpleado(cuilVerif));
                    }
                break;
                case 5:
                    if(unComercio.getEmpleados().isEmpty() == true) {
                        System.out.println("No hay empleados para mostrar!");
                    } else {
                        System.out.print("Ingrese CUIL del empleado: ");
                        long cuilSueld = teclado.nextLong();
                        if (unComercio.esEmpleado(cuilSueld) == true) {
                            unComercio.sueldoNeto(cuilSueld);
                        } else {
                            System.out.println("Empleado no encontrado!");
                        }
                    }
                break;
                case 6:
                    if(unComercio.getEmpleados().isEmpty() == true) {
                        System.out.println("No hay empleados para mostrar!");
                    } else {
                        unComercio.nomina();
                    }
                break;
                case 0:
                    System.out.println("Menú Cerrado!");
                break;
                default:
                    System.out.println("Valor Erróneo!");
                break;
            }
        } while (respuesta != 0 && (respuesta >= 1 && respuesta <= 6));
    }
}
