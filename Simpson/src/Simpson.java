public class Simpson {
    // Visible a nivel de la clase Simpson
    static char[][] tablero = new char[10][10];
    char personaje = '*';
    // Método para rellenar el tablero
    public void rellenarTablero() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                tablero[i][j] = personaje; // Rellenar el tablero con el personaje
            }
        }
    }
    public static void main(String[] args) {
        Simpson simpson = new Simpson();
        simpson.rellenarTablero(); // Llamar al método para rellenar el tablero
        System.out.println("Tablero rellenado:");
        // Mostrar el tablero en la consola
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j <10; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println(); // Nueva línea después de cada fila
        }
    }
}