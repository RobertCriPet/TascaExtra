/**
 * Clase de prueba para verificar el funcionamiento de la lógica del Sudoku.
 */
public class PruebaSudoku {
    public static void main(String[] args) {

        // 1. Definimos un tablero de Sudoku que sabemos que es CORRECTO
        int[][] tableroValido = {
                {5, 3, 4, 6, 7, 8, 9, 1, 2},
                {6, 7, 2, 1, 9, 5, 3, 4, 8},
                {1, 9, 8, 3, 4, 2, 5, 6, 7},
                {8, 5, 9, 7, 6, 1, 4, 2, 3},
                {4, 2, 6, 8, 5, 3, 7, 9, 1},
                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                {9, 6, 1, 5, 3, 7, 2, 8, 4},
                {2, 8, 7, 4, 1, 9, 6, 3, 5},
                {3, 4, 5, 2, 8, 6, 1, 7, 9}
        };

        // 2. Definimos un tablero INCORRECTO (tiene dos '5' en la primera fila)
        int[][] tableroInvalido = {
                {5, 5, 4, 6, 7, 8, 9, 1, 2}, // El segundo 5 es un error
                {6, 7, 2, 1, 9, 5, 3, 4, 8},
                {1, 9, 8, 3, 4, 2, 5, 6, 7},
                {8, 5, 9, 7, 6, 1, 4, 2, 3},
                {4, 2, 6, 8, 5, 3, 7, 9, 1},
                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                {9, 6, 1, 5, 3, 7, 2, 8, 4},
                {2, 8, 7, 4, 1, 9, 6, 3, 5},
                {3, 4, 5, 2, 8, 6, 1, 7, 9}
        };

        // 3. Probamos el Sudoku correcto
        Sudoku sudoku1 = new Sudoku(tableroValido);
        System.out.println("Prueba 1 (Sudoku correcto):");
        if (sudoku1.esCorrecte()) {
            System.out.println("Resultado: ¡El Sudoku es válido!");
        } else {
            System.out.println("Resultado: El Sudoku es incorrecto.");
        }

        System.out.println("-----------------------------------");

        // 4. Probamos el Sudoku incorrecto
        Sudoku sudoku2 = new Sudoku(tableroInvalido);
        System.out.println("Prueba 2 (Sudoku con errores):");
        if (sudoku2.esCorrecte()) {
            System.out.println("Resultado: ¡El Sudoku es válido!");
        } else {
            System.out.println("Resultado: El Sudoku es incorrecto (detectado con éxito).");
        }
    }
}