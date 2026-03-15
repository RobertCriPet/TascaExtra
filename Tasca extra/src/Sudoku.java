import java.util.HashSet;
import java.util.Set;

/**
 * Clase que representa un tablero de Sudoku y permite verificar su validez
 * utilizando estructuras de datos Set para detectar duplicados.
 */
public class Sudoku {
    private int[][] tablero;

    /**
     * Constructor que inicializa el tablero del Sudoku.
     * @param matriz Matriz de 9x9 con números del 1 al 9.
     */
    public Sudoku(int[][] matriz) {
        this.tablero = matriz;
    }

    /**
     * Verifica si el sudoku es correcto comprobando filas, columnas y regiones.
     * Utiliza HashSet para asegurar que cada número del 1 al 9 aparece exactamente una vez.
     * @return true si el sudoku es válido, false en caso contrario.
     */
    public boolean esCorrecte() {
        for (int i = 0; i < 9; i++) {
            // Validar fila i y columna i
            if (!validarFila(i) || !validarColumna(i)) {
                return false;
            }
        }

        // Validar las 9 regiones 3x3
        for (int fila = 0; fila < 9; fila += 3) {
            for (int col = 0; col < 9; col += 3) {
                if (!validarRegion(fila, col)) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Comprueba que una fila no tenga duplicados usando un HashSet.
     */
    private boolean validarFila(int fila) {
        Set<Integer> set = new HashSet<>();
        for (int j = 0; j < 9; j++) {
            int num = tablero[fila][j];
            if (num < 1 || num > 9 || !set.add(num)) return false;
        }
        return true;
    }

    /**
     * Comprueba que una columna no tenga duplicados usando un HashSet.
     */
    private boolean validarColumna(int col) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            int num = tablero[i][col];
            if (num < 1 || num > 9 || !set.add(num)) return false;
        }
        return true;
    }

    /**
     * Comprueba que una región 3x3 no tenga duplicados usando un HashSet.
     */
    private boolean validarRegion(int inicioFila, int inicioCol) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int num = tablero[inicioFila + i][inicioCol + j];
                if (num < 1 || num > 9 || !set.add(num)) return false;
            }
        }
        return true;
    }
}