import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
       //Añadimos las variables que queremos
        int filas=10;
       int columnas=10;
     Random alea=new Random();
       int[][] MatrizNum =new int[filas][columnas];
       String[][] MatrizUsua =new String[filas][columnas];
       //Rellenamos la matriz de numeros
        for (int i = 0; i <filas; i++) {
            for (int j = 0; j <columnas; j++) {
                MatrizNum[i][j]= alea.nextInt(10,100);
            }
        }
        //Rellenamos la matriz del usuario
        for (int i = 0; i <filas; i++) {
            for (int j = 0; j <columnas; j++) {
                MatrizUsua[i][j]="XX";
            }
        }
        //Metemos el escaner y hacemos un bucle para que lea 10 numeros y los compare con la matriz de numeros
        Scanner leer=new Scanner(System.in);
        for (int i = 1; i <11; i++) {
            System.out.println("Matriz Usuario:");
            //Mostramos la matriz de Usuario
            for (int q = 0; q <filas; q++) {
                for (int w = 0; w <columnas; w++) {
                    System.out.print(MatrizUsua[q][w]+" ");
                }
                System.out.println();
            }
            System.out.println("Dame el numero "+i);
            int NumUsua=leer.nextInt();
            //Creamos el bucle para que compare el numero que ha puesto el usuario con cada numero de la matriz de numeros
            for (int j = 0; j <filas; j++) {
                for (int k = 0; k <columnas; k++) {
                    //Si el numero del usuario es encontrado en la matriz de numeros te lo pone en la matriz del usuario
                    if (MatrizNum[j][k]==NumUsua){
                        MatrizUsua[j][k]= String.valueOf(MatrizNum[j][k]);
                    }
                }
            }
        }
        //Imprimimos la matriz final para ver tu resultado
        System.out.println("Tu matriz final es:");
        for (int i = 0; i <filas; i++) {
            for (int j = 0; j <columnas; j++) {
                System.out.print(MatrizUsua[i][j]+" ");
            }
            System.out.println();
        }
    }
}