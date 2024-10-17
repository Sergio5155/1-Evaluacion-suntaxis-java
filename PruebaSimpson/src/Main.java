import java.util.Random;
import java.util.Scanner;
//Sergio Casamayor
public class Main {
   //Definimos el tablero y variables
    private static final int maxfila = 10;
    private static final int  maxcolumna = 10;
    private static char [][] tablero;
    private static int fila_bart;
    private static int columna_bart;
    //Hacemos  funciones para imprimir nuestro tablero y rellenarlo
    private static void imprimir_tablero(){
        System.out.println("Tablero:");
        for (int i = 0; i <maxfila; i++) {
            for (int j = 0; j <maxcolumna; j++) {
                System.out.print(tablero[i][j]+" " );
            }
            System.out.println(" ");
        }
    }
    private static void rellenar_tablero_de_eles(){
        for (int i = 0; i <maxfila; i++) {
            for (int j = 0; j <maxcolumna; j++) {
                tablero[i][j]='L';
            }
            }
        }
    private static void rellenar_tablero_de_bart(){
       //Creamos dos variables para que nos coloque a bart en una posicion aleatoria
        int fila_aleatoria = 0;
        int columna_aleatoria =0;
        Random aleatorio = new Random();
        fila_aleatoria = aleatorio.nextInt(maxfila);
        columna_aleatoria = aleatorio.nextInt(maxcolumna);
        tablero[fila_aleatoria][columna_aleatoria]='B';
    }
    private static void rellenar_tablero_de_homer(){
        Random aleatorio = new Random();
        int filaaleatoriahomer;
        int columnaaleatoriahomer;
        for (int i = 0; i <5; i++) {
            do {
                filaaleatoriahomer=aleatorio.nextInt(maxfila);
                columnaaleatoriahomer=aleatorio.nextInt(maxcolumna);
            }while (tablero[filaaleatoriahomer][columnaaleatoriahomer]!='L');
            tablero[filaaleatoriahomer][columnaaleatoriahomer] = 'H';
        }
    }
    private static void poner_muros_al_tablero(){
        Random aleatorio = new Random();
        int filaaleatoriamuro;
        int columnaaleatoriamuro;
        for (int i = 0; i <5; i++) {
            do {
                filaaleatoriamuro=aleatorio.nextInt(maxfila);
                columnaaleatoriamuro=aleatorio.nextInt(maxcolumna);
            }while (tablero[filaaleatoriamuro][columnaaleatoriamuro]!='L');
            tablero[filaaleatoriamuro][columnaaleatoriamuro] = 'M';
        }
    }
    public static void main(String[] args) {
       //Nos vamos al public y añadimos nuestro tablero y ponemos las funciones para rellenarlo
        tablero =new char[maxfila][maxcolumna];
        rellenar_tablero_de_eles();
        rellenar_tablero_de_bart();
        rellenar_tablero_de_homer();
        poner_muros_al_tablero();
        imprimir_tablero();
        //Movemos nuestro personaje
        Scanner leer = new Scanner(System.in);
        int vidas = maxfila;
        do {
            System.out.println("A donde te quieres mover");
            System.out.println("W=arriba S=abajo A=izquierda D=derecha");
            String movimiento = leer.nextLine();
            switch (movimiento){
                case "A":
                    if ((columna_bart - 1)>=0){
                        columna_bart = columna_bart -1; switch (tablero[fila_bart][columna_bart]){
                            case 'H':
                                vidas=vidas-1;
                                System.out.println("has perdido una vida= " + vidas);
                                break;
                            case 'L':
                                tablero[fila_bart][columna_bart]= 'B';
                                tablero[fila_bart][columna_bart+1]= 'L';
                                break;
                            case 'M':
                                System.out.println("El muro no te deja desplazarte ");
                                columna_bart=columna_bart+1;
                                break;
                        }
                        tablero[fila_bart][columna_bart]= 'B';
                        tablero[fila_bart][columna_bart+1]= 'L';
                    }else {
                        System.out.println("Desplazammiento prohibido.Limite del tablero");
                    }

                    break;
                case "S":// mover a la abajo y liberar la casilla donde se encontraba
                    if ((fila_bart + 1 ) >= 0){
                        fila_bart = fila_bart +1;
                        switch (tablero[fila_bart][columna_bart]){
                            case 'H':
                                vidas=vidas-1;
                                System.out.println("has perdido una vida= " + vidas);
                                break;
                            case 'L':
                                tablero[fila_bart][columna_bart]= 'B';
                                tablero[fila_bart-1][columna_bart]= 'L';
                                break;
                            case 'M':
                                System.out.println("El muro no te deja desplazarte ");
                                fila_bart=fila_bart-1;
                                break;
                        }
                        tablero[fila_bart][columna_bart]= 'B';
                        tablero[fila_bart-1][columna_bart]= 'L';
                    }else {
                        System.out.println("Desplazammiento prohibido.Limite del tablero");
                    }
                    break;
                case "D":// mover a la derecha y liberar la casilla donde se encontraba
                    fila_bart = fila_bart;
                    columna_bart = columna_bart -1;
                    tablero[fila_bart][columna_bart]= 'B';
                    tablero[fila_bart][columna_bart+1]= 'L';
                    break;
                case "W":// mover a la arriba y liberar la casilla donde se encontraba
                    fila_bart = fila_bart -1;
                    columna_bart = columna_bart ;
                    tablero[fila_bart][columna_bart]= 'B';
                    tablero[fila_bart][columna_bart]= 'L';
                    break;
                default:
                    break;
            }
            imprimir_tablero();
        }while(vidas > 0);

    }
            }

