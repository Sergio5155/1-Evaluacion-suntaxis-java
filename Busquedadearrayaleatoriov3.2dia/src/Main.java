import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        Random random = new Random();
        String array [] = new String [6];
        for (int i = 0; i < array.length; i++) {
            int numrandom = random.nextInt(6)+1;
            array[i]=String.valueOf(numrandom);
        }
        for (int i = 0; i < array.length ; i++) {
            System.out.println(array[i]);
        }
        System.out.println("Dame un numero 1");
        String numusuario1 = leer.next();
        for (int i = 0; i < array.length; i++) {
            if (numusuario1.equals(array[i])){
                array[i] ="XX";
            }
        }
        System.out.println("Dame un numero 2");
        String numusuario2 = leer.next();
        for (int i = 0; i < array.length; i++) {
            if (numusuario2.equals(array[i])){
                array[i] ="XX";
            }
        }
        System.out.println("Dame un numero 3");
        String numusuario3 = leer.next();
        for (int i = 0; i < array.length; i++) {
            if (numusuario3.equals(array[i])){
                array[i] ="XX";
            }
        }
        for (int i = 0; i < array.length ; i++) {
            System.out.println(array[i]);
        }
    }
}