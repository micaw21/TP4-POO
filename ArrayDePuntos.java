/** Clase Ejecutable
 * @author Wolkowyski, Micaela
 * @version 14/09/2023
 */
import java.util.Scanner;

public class ArrayDePuntos {
    public static void main(String [] args) {
        Punto [] puntos = new Punto [6];

        Scanner teclado = new Scanner(System.in);
        int i = 0;
        for(i = 0; i < 6; i++) {
            System.out.println("Ingrese una coordenada x: ");
            double coorx = teclado.nextDouble();
            System.out.println("Ingrese una coordenada y: ");
            double coory = teclado.nextDouble();
            puntos[i] = new Punto(coorx, coory);
        }

        System.out.println("\n" + "---Coordenadas de Cada Elemento del Array---");
        for (i = 0; i < 6; i++) {
            System.out.println(puntos[i].coordenadas() + "\n");
        }

        System.out.println("--- Distancias entre dos Coordenadas Consecutivas ---");
        System.out.println("Distancia de Coordenada 1 a Coordenada 2: " + puntos[0].distanciaA(puntos[1]));
        System.out.println("Distancia de Coordenada 2 a Coordenada 3: " + puntos[1].distanciaA(puntos[2]));
        System.out.println("Distancia de Coordenada 3 a Coordenada 4: " + puntos[2].distanciaA(puntos[3]));
        System.out.println("Distancia de Coordenada 4 a Coordenada 5: " + puntos[3].distanciaA(puntos[4]));
        System.out.println("Distancia de Coordenada 5 a Coordenada 6: " + puntos[4].distanciaA(puntos[5]));
    }
}
