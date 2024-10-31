import java.util.Scanner;

public class Main {

    // Método para descifrar el mensaje utilizando el desplazamiento calculado
    public static String descifrarMensaje(String mensaje, int desplazamiento) {
        StringBuilder resultado = new StringBuilder();

        for (char c : mensaje.toCharArray()) {
            if (Character.isLetter(c)) {
                // Ajuste del desplazamiento dependiendo de si es mayúscula o minúscula
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                char descifrado = (char) ((c - base - desplazamiento + 26) % 26 + base);
                resultado.append(descifrado);
            } else {
                resultado.append(c);
            }
        }

        return resultado.toString();
    }

    // Método para contar las vocales no acentuadas en el mensaje
    public static int contarVocales(String mensaje) {
        int contador = 0;
        for (char c : mensaje.toLowerCase().toCharArray()) {
            if ("aeiou".indexOf(c) != -1) {
                contador++;
            }
        }
        return contador;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String linea = sc.nextLine();
            if (linea.isEmpty()) continue;

            // Primer carácter es el código de la letra 'p'
            char codigoLetra = linea.charAt(0);
            String mensajeCifrado = linea.substring(1);

            // Calcular el desplazamiento para que el código sea 'p'
            int desplazamiento = codigoLetra - 'p';

            // Descifrar el mensaje con el desplazamiento calculado
            String mensajeDescifrado = descifrarMensaje(mensajeCifrado, desplazamiento);

            // Si el mensaje descifrado contiene "FIN", terminamos
            if (mensajeDescifrado.equalsIgnoreCase("FIN")) {
                break;
            }

            // Contar las vocales en el mensaje cifrado
            int numeroVocales = contarVocales(mensajeCifrado);
            System.out.println(numeroVocales);
        }

        sc.close();
    }
}
