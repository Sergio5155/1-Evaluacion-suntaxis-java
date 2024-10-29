import java.util.Scanner;

public class Main {

    // Mapeo de símbolos jeroglíficos a las potencias de 10
    private static final char[] SIMBOLOS = {'H', 'R', 'D', 'F', 'C', 'G', 'T'};
    private static final int[] VALORES = {1000000, 100000, 10000, 1000, 100, 10, 1};

    // Método que convierte un número en su representación jeroglífica
    public static String convertirAJeroglifico(int numero) {
        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < VALORES.length; i++) {
            int cantidad = numero / VALORES[i];
            numero %= VALORES[i];

            for (int j = 0; j < cantidad; j++) {
                resultado.append(SIMBOLOS[i]);
            }
        }

        return resultado.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int numero = scanner.nextInt();

            if (numero == 0) {
                break; // Fin de entrada
            }

            System.out.println(convertirAJeroglifico(numero));
        }

        scanner.close();
    }
}
