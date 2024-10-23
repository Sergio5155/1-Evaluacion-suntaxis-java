import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random alea = new Random();
        Scanner leer = new Scanner(System.in);

        // PRIMITVA
        String arrayPrimitiva[] = new String[6];
        for (int i = 0; i < arrayPrimitiva.length; i++) {
            int numAle = alea.nextInt(100);
            // Convertir entero a cadena
            arrayPrimitiva[i] = String.valueOf(numAle);
        }

        // IMPRIMIR EL ARRAY
        System.out.println("Números aleatorios generados:");
        for (int i = 0; i < arrayPrimitiva.length; i++) {
            System.out.println(arrayPrimitiva[i]);
        }

        // Capturar num1
        System.out.println("Dame un num1");
        String cadUsuario1 = leer.next(); // leer el primer número
        for (int i = 0; i < arrayPrimitiva.length; i++) {
            if (cadUsuario1.equals(arrayPrimitiva[i])) {
                arrayPrimitiva[i] = "XX";
            }
        }

        // Capturar num2
        System.out.println("Dame un num2");
        String cadUsuario2 = leer.next(); // leer el segundo número
        for (int i = 0; i < arrayPrimitiva.length; i++) {
            if (cadUsuario2.equals(arrayPrimitiva[i])) {
                arrayPrimitiva[i] = "XX";
            }
        }

        // Capturar num3
        System.out.println("Dame un num3");
        String cadUsuario3 = leer.next(); // leer el tercer número
        for (int i = 0; i < arrayPrimitiva.length; i++) {
            if (cadUsuario3.equals(arrayPrimitiva[i])) {
                arrayPrimitiva[i] = "XX";
            }
        }

        // IMPRIMIR EL ARRAY MODIFICADO
        System.out.println("Array modificado:");
        for (int i = 0; i < arrayPrimitiva.length; i++) {
            System.out.println(arrayPrimitiva[i]);
        }

        // FIN PRIMITIVA
    }
}
