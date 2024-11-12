import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] palabras = {"sol", "luna", "estrella", "cielo", "mar", "montaña", "río", "nube", "flor", "árbol"};
        iniciarJuego(scanner, palabras);
        scanner.close();
    }
    // Función para iniciar el juego
    private static void iniciarJuego(Scanner scanner, String[] palabras) {
        String[] respuestas = new String[palabras.length];
        for (int i = 0; i < palabras.length; i++) {
            mostrarPalabra(palabras[i], respuestas, i);

            System.out.print("Escribe todas las palabras memorizadas hasta ahora: ");
            String entrada = scanner.nextLine();

            if (!verificarRespuesta(entrada, respuestas, i)) {
                System.out.println("¡Incorrecto! La secuencia era: " + construirRespuestaCorrecta(respuestas, i));
                System.out.println("Intenta de nuevo desde el inicio.");
                i = -1; // Reiniciar el juego
            } else {
                System.out.println("¡Correcto! Sigue a la siguiente palabra.\n");
            }
        }
        System.out.println("¡Felicidades! Has memorizado todas las palabras correctamente.");
    }
    // Función para mostrar la palabra actual
    private static void mostrarPalabra(String palabra, String[] respuestas, int index) {
        System.out.println("Palabra a memorizar: " + palabra);
        respuestas[index] = palabra;
    }
    // Función para verificar la respuesta del usuario
    private static boolean verificarRespuesta(String entrada, String[] respuestas, int index) {
        String respuestaCorrecta = construirRespuestaCorrecta(respuestas, index);
        return entrada.equals(respuestaCorrecta.trim());
    }
    // Función para construir la respuesta correcta usando StringBuilder
    private static String construirRespuestaCorrecta(String[] respuestas, int index) {
        StringBuilder correctas = new StringBuilder();
        for (int j = 0; j <= index; j++) {
            correctas.append(respuestas[j]).append(" ");
        }
        return correctas.toString();
    }
}
