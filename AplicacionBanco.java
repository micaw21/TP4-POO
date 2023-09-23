/** Clase Ejecutable
 * @author Wolkowyski, Micaela
 * @version 18/09/2023
 */

import java.util.*;

public class AplicacionBanco {
    public static void main(String [] args) {
        Scanner teclado = new Scanner(System.in);

        Localidad unaLocalidad = new Localidad("Corrientes", "Corrientes");

        Banco miBanco = null;
        CuentaBancaria misCuentas = null;
        int respuesta;
        int op;

        do {
            System.out.println("----- MENU BANCO -----");
            System.out.println("1 - Contratar Empleado");
            System.out.println("2 - Despedir Empleado");
            System.out.println("3 - Listar Sueldos");
            System.out.println("4 - Mostrar Nomina de Empleados" + "\n");
            System.out.println("5 - Crear Cuenta Bancaria");
            System.out.println("6 - Eliminar Cuenta Bancaria");
            System.out.println("7 - Mostrar Resumen de Cuentas Bancarias");
            System.out.println("8 - Depositar");
            System.out.println("9 - Extraer");
            System.out.println("10 - Mostrar Datos de Cuenta");
            System.out.println("0 - Salir");
            respuesta = teclado.nextInt();
            
            switch(respuesta) {
                case 1:
                    do {
                        if(miBanco == null) {
                            System.out.print("Ingrese su CUIL: ");
                            long cuil = teclado.nextLong();
                            System.out.print("Ingrese su apellido: ");
                            String apellido = teclado.next();
                            System.out.print("Ingrese su nombre: ");
                            String nombre = teclado.next();
                            System.out.print("Ingrese su sueldo basico: ");
                            double sueldo = teclado.nextDouble();
                            System.out.print("Ingrese año de ingreso: ");
                            Calendar fechaIngreso = new GregorianCalendar();
                            fechaIngreso.set(Calendar.YEAR, teclado.nextInt());
                            Empleado unEmpleado = new Empleado(cuil, nombre, apellido, sueldo, fechaIngreso);
                            miBanco = new Banco("ICBC", unaLocalidad, 21, unEmpleado);
                            System.out.println("Empleado contratado!");
                        } else {
                            System.out.print("Ingrese su CUIL: ");
                            long cuil = teclado.nextLong();
                            System.out.print("Ingrese su apellido: ");
                            String apellido = teclado.next();
                            System.out.print("Ingrese su nombre: ");
                            String nombre = teclado.next();
                            System.out.print("Ingrese su sueldo basico: ");
                            double sueldo = teclado.nextDouble();
                            System.out.print("Ingrese año de ingreso: ");
                            Calendar fechaIngreso = new GregorianCalendar();
                            fechaIngreso.set(Calendar.YEAR, teclado.nextInt());
                            Empleado unEmpleado = new Empleado(cuil, nombre, apellido, sueldo, fechaIngreso);
                            miBanco.agregarEmpleado(unEmpleado);
                            System.out.println("Empleado contratado!");
                            }
                        System.out.print("Desea agregar otro Empleado? 1-Si 2-No: ");
                        op = teclado.nextInt();
                    } while (op == 1);
                break;
                case 2:
                    do {
                        if(miBanco == null || miBanco.getEmpleados().size() <= 1) {
                            System.out.println("No se pueden despedir empleados!" + "\n");
                        } else {
                            System.out.println("Elija empleado a despedir: ");
                            int i;
                            for(i = 0; i < miBanco.getEmpleados().size(); i++) {
                                System.out.println("Empleado nro: " + (i + 1) + "-------------- " + ((Empleado)miBanco.getEmpleados().get(i)).apeYNombre()); 
                            }
                            miBanco.quitarEmpleado((Empleado)miBanco.getEmpleados().get(teclado.nextInt() - 1));
                            System.out.println("Empleado despedido!");
                        }
                        System.out.print("Desea despedir otro usuario? 1-Si 2-No: ");
                        op = teclado.nextInt();
                    } while (op == 1);
                break;
                case 3:
                    if(miBanco == null || miBanco.getEmpleados().isEmpty() == true){
                        System.out.println("No hay empleados registrados" + "\n");
                    } else {
                        miBanco.listarSueldos();
                    }
                break;
                case 4:
                    if(miBanco == null || miBanco.getEmpleados().isEmpty() == true){
                        System.out.println("No hay empleados registrados" + "\n");
                    } else {
                        miBanco.mostrar();
                    }
                break;
                case 5:
                    if(miBanco == null) {
                        System.out.println("Debe contrar un empleado primero!" + "\n");
                    } else {
                        System.out.print("Ingrese el numero de cuenta: ");
                        int nroCuenta = teclado.nextInt();
                        System.out.print("Ingrese su saldo: ");
                        double saldo = teclado.nextDouble();
                        System.out.println("Datos del Titular");
                        System.out.print("Ingrese su DNI: ");
                        int dni = teclado.nextInt();
                        System.out.print("Ingrese su nombre: ");
                        String nombre = teclado.next();
                        System.out.print("Ingrese su apellido: ");
                        String apellido = teclado.next();
                        System.out.print("Ingrese su anio de nacimiento: ");
                        Calendar anioNac = new GregorianCalendar();
                        anioNac.set(Calendar.YEAR, teclado.nextInt());
                        Persona unaPersona = new Persona(dni, nombre, apellido, anioNac);

                        if(saldo == 0) {
                            misCuentas = new CuentaBancaria(nroCuenta, unaPersona);
                            miBanco.agregarCuentaBancaria(misCuentas);
                            System.out.println("Cuenta creada!");
                        } else {
                            misCuentas = new CuentaBancaria(nroCuenta, unaPersona, saldo);
                            miBanco.agregarCuentaBancaria(misCuentas);
                            System.out.println("Cuenta creada!");
                        }
                    }
                break;
                case 6:
                    do {
                        if(miBanco == null || miBanco.getCuentasBancarias().isEmpty() == true) {
                                System.out.println("No hay cuentas para eliminar!" + "\n");
                        } else {
                            System.out.println("Elija el nro de cuenta a eliminar: ");
                            int i;

                            for(i = 0; i < miBanco.getCuentasBancarias().size(); i++) {
                                System.out.println("Nro de Cuenta: " + miBanco.getCuentasBancarias().get(i).getNroCuenta() + " " + "Titular:" + miBanco.getCuentasBancarias().get(i).getTitular().apeYNom()); 
                            }

                            int nroCue = teclado.nextInt();

                            for(i = 0; i < miBanco.getCuentasBancarias().size(); i++) {
                                if(nroCue == miBanco.getCuentasBancarias().get(i).getNroCuenta()) {
                                    miBanco.quitarCuentaBancaria(miBanco.getCuentasBancarias().get(i));
                                    System.out.println("Cuenta eliminada!");
                                }
                            }
                        }
                            System.out.print("Desea eliminar otra cuenta? 1-Si 2-No: ");
                            op = teclado.nextInt();
                    } while (op == 1);
                break;
                case 7:
                        if(miBanco == null || miBanco.getCuentasBancarias().isEmpty() == true) {
                            System.out.println("No hay cuentas registradas!" + "\n");
                        } else {
                            miBanco.mostrarResumen();
                        }
                break;
                case 8:
                    if(miBanco == null || miBanco.getCuentasBancarias().isEmpty() == true) {
                        System.out.println("No hay cuentas registradas!" + "\n");
                    } else {
                        System.out.println("Elija cuenta para depositar: ");
                        for(CuentaBancaria cuentas: miBanco.getCuentasBancarias()) {
                            System.out.println(cuentas.toString());
                        }

                        int nroCuent = teclado.nextInt();
                        for(CuentaBancaria cuents: miBanco.getCuentasBancarias()) {
                            if(nroCuent == cuents.getNroCuenta()) {
                                System.out.print("Ingrese monto a depositar: ");
                                double importe = teclado.nextDouble();
                                cuents.depositar(importe);
                                System.out.println("Monto depositado!");
                            }
                        }
                    }
                break;
                case 9:
                    if(miBanco == null || miBanco.getCuentasBancarias().isEmpty() == true) {
                        System.out.println("No hay cuentas registradas!");
                    } else {
                        System.out.println("Elija cuenta para extraer: ");
                        for(CuentaBancaria cuentas: miBanco.getCuentasBancarias()) {
                            System.out.println(cuentas.toString());
                        }

                        int nroCuen = teclado.nextInt();

                        for(CuentaBancaria cuents: miBanco.getCuentasBancarias()) {
                            if(nroCuen == cuents.getNroCuenta() && cuents.getSaldo() != 0) {
                                System.out.print("Ingrese monto a extraer: ");
                                double importe = teclado.nextDouble();
                                cuents.extraer(importe);
                                System.out.println("Monto extraído!");
                            } else {
                                System.out.println("No se puede extraer!");
                            }
                        }
                    }
                break;
                case 10:
                    if(miBanco == null || miBanco.getCuentasBancarias().isEmpty() == true) {
                        System.out.println("No hay cuentas registradas!");
                    } else {
                        System.out.println("Elija cuenta para mostrar: ");
                        for(CuentaBancaria cuentas: miBanco.getCuentasBancarias()) {
                            System.out.println(cuentas.toString());
                        }

                        int nroCuen = teclado.nextInt();

                        for(CuentaBancaria cuents: miBanco.getCuentasBancarias()) {
                            if(nroCuen == cuents.getNroCuenta()) {
                                cuents.mostrar();
                            }
                        }
                    }
                break;
                case 0:
                    System.out.println("Menu Cerrado!");
                break;
                default:
                    System.out.println("Valor erroneo!" + "\n");
                break;
            }
        } while (respuesta != 0 && (respuesta >= 1 && respuesta <= 10));
    }
}