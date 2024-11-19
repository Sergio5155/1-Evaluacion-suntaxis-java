import java.util.Random;

public class SopaLetras {
    // Array de palabras a buscar en la sopa de letras
    static String palabras[] = {
            "helada",
            "mesa",
            "patata"
    };

    // Matrices para la sopa de letras y su copia (para verificar posiciones)
    static char sopaLetras[][] = new char[10][10];
    static char sopaLetrasCopia[][] = new char[10][10];

    // Objeto Random para generar números aleatorios
    static Random ale = new Random();

    // Método para rellenar la matriz sopaLetras con letras aleatorias
    static void rellenarMatriz() {
        // Recorremos todas las posiciones de la matriz 10x10
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                // Generamos un número aleatorio entre 0 y 25 para seleccionar una letra
                int numAle = ale.nextInt(26);
                sopaLetras[i][j] = letras[numAle];  // Asignamos la letra aleatoria en la matriz
            }
        }
    }

    // Array de letras del alfabeto (A-Z)
    static char[] letras = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    // Método para rellenar la matriz sopaLetrasCopia con valores '0'
    static void rellenarMatrizCopia() {
        // Recorremos todas las posiciones de la matriz 10x10
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                sopaLetrasCopia[i][j] = '0';  // Inicializamos cada casilla con el valor '0'
            }
        }
    }

    // Método para imprimir la sopa de letras
    public static void imprimirMatriz() {
        // Recorremos todas las posiciones de la matriz 10x10
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(sopaLetras[i][j] + " ");  // Imprimimos cada letra seguida de un espacio
            }
            System.out.println();  // Salto de línea al final de cada fila
        }
    }

    // Método para imprimir la copia de la sopa de letras
    public static void imprimirMatrizCopia() {
        // Recorremos todas las posiciones de la matriz 10x10
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(sopaLetrasCopia[i][j] + " ");  // Imprimimos cada valor (copia) seguido de un espacio
            }
            System.out.println();  // Salto de línea al final de cada fila
        }
    }

    public static void main(String[] args) {
        // Rellenamos las matrices con letras aleatorias y con valores iniciales '0' respectivamente
        rellenarMatriz();
        rellenarMatrizCopia();

        // Recorremos todas las palabras para insertarlas en la sopa de letras
        for (int i = 0; i < palabras.length; i++) {
            int filaAl = 0;
            int colAl = 0;

            // Buscamos una posición libre aleatoria para colocar la palabra
            do {
                filaAl = ale.nextInt(10);  // Generamos una fila aleatoria (0-9)
                colAl = ale.nextInt(10);  // Generamos una columna aleatoria (0-9)
            } while (sopaLetrasCopia[filaAl][colAl] != '0');  // Nos aseguramos de que la casilla esté libre

            // Comprobamos si la palabra cabe horizontalmente (sin exceder el límite de 10 columnas)
            if (colAl + palabras[i].length() > 10) {  // Verificamos si la palabra excede los límites de la columna
                i--;  // Si no cabe, volvemos a intentar con la siguiente palabra
            } else {
                boolean isLibre = true;
                // Calculamos la última columna donde se debe colocar la palabra
                int max = colAl + palabras[i].length() - 1;  // Ajustamos para no desbordar el índice
                // Verificamos que todas las casillas donde va la palabra estén libres
                for (int z = colAl; z <= max; z++) {
                    if (sopaLetrasCopia[filaAl][z] != '0') {
                        isLibre = false;  // Si encontramos una casilla ocupada, marcamos como no libre
                        break;
                    }
                }

                // Si todas las casillas son libres, colocamos la palabra
                if (isLibre) {
                    int contador = 0;  // Contador para recorrer los caracteres de la palabra
                    // Colocamos la palabra en la matriz
                    for (int z = colAl; z <= max; z++) {
                        sopaLetras[filaAl][z] = palabras[i].charAt(contador);  // Asignamos la letra en la sopa de letras
                        sopaLetrasCopia[filaAl][z] = palabras[i].charAt(contador);  // También en la copia
                        contador++;  // Incrementamos el contador para la siguiente letra de la palabra
                    }
                }
            }
        }

        // Imprimimos la matriz original con las palabras insertadas
        imprimirMatriz();
        // Imprimimos la copia de la matriz, donde cada palabra se ha marcado
        System.out.println();
        imprimirMatrizCopia();
    }
}