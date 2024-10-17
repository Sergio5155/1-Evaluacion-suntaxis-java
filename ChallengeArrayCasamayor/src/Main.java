import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
     Random rand = new Random();
     Scanner scanner = new Scanner(System.in);

     int[] numeros = new int[6];
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = rand.nextInt(6)+1;
        }
        for (int i = 0; i < numeros.length; i++) {
            System.out.println(numeros[i]);
        }
        System.out.println("Ingresa 3 numeros");
        for (int i = 0; i <3; i++) {
            int num_usuario = scanner.nextInt();
            boolean encontrado = false;
            for (int j = 0; j <numeros.length; j++) {
                if (numeros[j]== num_usuario) {
                    numeros[j] =-1;
                    encontrado = true;
                    break;
                }
            }
        if (encontrado) {
            System.out.println("Numero encontrado");
        }else {
            System.out.println("Andrew tontin");
        }
        }
        for (int i = 0; i < numeros.length; i++) {
            System.out.println(numeros[i]);
        }
        }
    }
