import java.util.HashSet;
import java.util.Set;


public class Sudoku {
    private int[][] tablero;

    public Sudoku(int[][] matriz) {
        this.tablero = matriz;
    }

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

    private boolean validarFila(int fila) {
        Set<Integer> set = new HashSet<>();
        for (int j = 0; j < 9; j++) {
            int num = tablero[fila][j];
            if (num < 1 || num > 9 || !set.add(num)) return false;
        }
        return true;
    }

    private boolean validarColumna(int col) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            int num = tablero[i][col];
            if (num < 1 || num > 9 || !set.add(num)) return false;
        }
        return true;
    }

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