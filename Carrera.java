/** Clase ejecutable
 * @version 20/09/2023
 * @author Wolkowyski, Micaela
 */

import java.util.Scanner;

public class Carrera {
    public static void main(String [] args) {
        Alumno alumno1 = new Alumno(32555, "Pedro", "Gomez");
        Alumno alumno2 = new Alumno(23564, "Maria","Vasques");
        Alumno alumno3 = new Alumno(30123, "Juan", "Perez");
        Alumno alumno4 = new Alumno(32655, "Marcela", "Martinez");
        
        alumno1.setNota1(6);
        alumno1.setNota2(7.20);

        alumno2.setNota1(8.50);
        alumno2.setNota2(9);

        alumno3.setNota1(10);
        alumno3.setNota2(5.60);

        alumno4.setNota1(2.40);
        alumno4.setNota2(7.50);

        Curso miCurso = new Curso("Lic. en Sistemas");
        miCurso.inscribirAlumno(alumno1);
        miCurso.inscribirAlumno(alumno2);
        miCurso.inscribirAlumno(alumno3);
        miCurso.inscribirAlumno(alumno4);    

        System.out.println("****-- Cantidad de inscriptos: " + miCurso.cantidadDeAlumnos());

        miCurso.mostrarInscriptos();

        System.out.println("****-- Se le da de baja a Pedro porque abandona el curso --****");
        miCurso.quitarAlumno(32555);
        System.out.println("¿Está Pedro Gomez inscripto? --> " + miCurso.estaInscripto(32555));

        System.out.println("****-- Alumnos inscriptos actualmente: " + miCurso.cantidadDeAlumnos());
        miCurso.mostrarInscriptos();

        System.out.println("****-- Busca y muestra el alumno con número de libreta: 30123 --****");
        if(miCurso.estaInscripto(30123)) {
            miCurso.buscarAlumno(30123).mostrar();
        }

        System.out.println("****-- Mostrar promedio del alumno 23564 --****");
        miCurso.imprimirPromedio(23564);

        //HashMap alumnos = null;
        Curso otroCurso = new Curso("Abogacía");
        int respuesta, op;
        Scanner teclado = new Scanner(System.in);

        do {
            System.out.println("\n" + "**** MENÚ DE CURSO DE ABOGACÍA ****");
            System.out.println("1 - Inscribir alumno");
            System.out.println("2 - Quitar alumno");
            System.out.println("3 - Mostrar cantidad de alumnos inscriptos");
            System.out.println("4 - Verificar inscripción");
            System.out.println("5 - Mostrar promedio de un alumno según LU");
            System.out.println("6 - Mostrar inscriptos");
            System.out.println("7 - Subir notas de alumno");
            System.out.println("0 - Salir");
            respuesta = teclado.nextInt();
            switch (respuesta) {
                case 1:
                    do {
                        System.out.print("Ingrese su LU: ");
                        int lu = teclado.nextInt();
                        System.out.print("Ingrese su nombre: ");
                        String nombre = teclado.next();
                        System.out.print("Ingrese su apellido: ");
                        String apellido = teclado.next();
                        Alumno unAlumno = new Alumno(lu, nombre, apellido);
                        otroCurso.inscribirAlumno(unAlumno);
                        System.out.print("¿Desea inscribir otro alumno? 1-Si 2-No: ");
                        op = teclado.nextInt();
                    } while (op == 1);
                break;
                case 2:
                    do {
                        if(otroCurso.getAlumnos().isEmpty() == true) {
                            System.out.println("No hay alumnos para eliminar!");
                        } else {
                            System.out.print("Ingrese el LU del alumno a eliminar: ");
                            otroCurso.mostrarInscriptos();
                            int LU = teclado.nextInt();
                            otroCurso.quitarAlumno(LU);
                        }
                        System.out.print("¿Desea eliminar otro alumno? 1-Si 2-No: ");
                        op = teclado.nextInt();
                    } while (op == 1);
                break;
                case 3:
                    if(otroCurso.getAlumnos().isEmpty() == true) {
                            System.out.println("No hay alumnos para mostrar!");
                    } else {
                            System.out.println("Cantidad de alumnos inscriptos: " + otroCurso.cantidadDeAlumnos());
                    }
                break;
                case 4:
                    System.out.print("Ingrese LU a verificar: ");
                    int verifLu = teclado.nextInt();
                    System.out.println("¿Está inscripto " + verifLu + "?" + " " + otroCurso.estaInscripto(verifLu));
                break;
                case 5:
                    if(otroCurso.getAlumnos().isEmpty() == true) {
                        System.out.println("No hay alumnos para mostrar su promedio!");
                    } else {
                        System.out.print("Ingrese su LU: ");
                        int promedLu = teclado.nextInt();
                        if(otroCurso.estaInscripto(promedLu) == true) {
                            otroCurso.imprimirPromedio(promedLu);
                        } else {
                            System.out.println("Alumno no encontrado!");
                        }
                    }
                break;
                case 6:
                    if(otroCurso.getAlumnos().isEmpty() == true) {
                        System.out.println("No hay alumnos inscriptos!");
                    } else {
                        otroCurso.mostrarInscriptos();
                    }
                break;
                case 7:
                    do {
                        if(otroCurso.getAlumnos().isEmpty() == true) {
                            System.out.println("No hay alumnos inscriptos!");
                        } else {
                            System.out.println("Ingrese el LU del alumno: ");
                            otroCurso.mostrarInscriptos();
                            int LU = teclado.nextInt();
                            System.out.print("Ingrese su primer nota: ");
                            double nota1 = teclado.nextDouble();
                            System.out.print("Ingrese su segunda nota: ");
                            double nota2 = teclado.nextDouble();
                            otroCurso.buscarAlumno(LU).setNota1(nota1);
                            otroCurso.buscarAlumno(LU).setNota2(nota2);
                        }
                        System.out.print("¿Desea subir más notas? 1-Si 2-No: ");
                        op = teclado.nextInt();
                    } while (op == 1);
                break;
                case 0:
                    System.out.println("Menú Cerrado!");
                break;
                default:
                    System.out.println("Valor erróneo!");
                break;
            }
        } while (respuesta != 0 && (respuesta >= 1 && respuesta <= 7));
    }
}
