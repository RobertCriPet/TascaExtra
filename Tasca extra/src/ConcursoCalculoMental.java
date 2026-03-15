import java.util.Scanner;

/**
 * Clase que resuelve el concurso de cálculo mental de Diego.
 * Procesa secuencias de sumas y restas y muestra resultados parciales.
 */
public class ConcursoCalculoMental {

    /**
     * Método principal que ejecuta la lógica del concurso.
     * @param args Argumentos de línea de comandos.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Verifica si existe el número que indica la cantidad de casos
        if (sc.hasNextInt()) {
            int numCasos = sc.nextInt();

            // Itera según el número de casos de prueba indicados
            for (int i = 0; i < numCasos; i++) {

                // 1. Leemos el primer número de la serie (el valor inicial)
                if (!sc.hasNextInt()) break;
                int acumulado = sc.nextInt();

                boolean esPrimerResultado = true;

                // 2. Procesamos el resto de la línea hasta encontrar el punto '.'
                while (sc.hasNext()) {
                    String token = sc.next();

                    // Si el token es un punto, termina la secuencia actual
                    if (token.equals(".")) {
                        break;
                    }

                    // Si no es un punto, el token es un operador (+ o -)
                    String operador = token;

                    // Se lee el número que sigue al operador
                    if (sc.hasNextInt()) {
                        int proximoNumero = sc.nextInt();

                        // Aplicamos la operación aritmética correspondiente
                        if (operador.equals("+")) {
                            acumulado += proximoNumero;
                        } else if (operador.equals("-")) {
                            acumulado -= proximoNumero;
                        }

                        // Imprimimos el resultado con coma si no es el primero
                        if (!esPrimerResultado) {
                            System.out.print(", ");
                        }
                        System.out.print(acumulado);
                        esPrimerResultado = false;
                    }
                }
                // Salto de línea obligatorio al terminar cada caso de prueba
                System.out.println();
            }
        }
        sc.close();
    }
}