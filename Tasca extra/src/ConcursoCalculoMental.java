import java.util.Scanner;

public class ConcursoCalculoMental {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (sc.hasNextInt()) {
            int numCasos = sc.nextInt();

            for (int i = 0; i < numCasos; i++) {
                // 1. Leemos el primer número de la serie (el valor inicial)
                if (!sc.hasNextInt()) break;
                int acumulado = sc.nextInt();

                boolean esPrimerResultado = true;

                // 2. Procesamos el resto de la línea hasta el punto
                while (sc.hasNext()) {
                    String token = sc.next();

                    // Si es el punto, terminamos este caso de prueba
                    if (token.equals(".")) {
                        break;
                    }

                    // Si no es un punto, es un operador (+ o -)
                    String operador = token;

                    // Ahora leemos el siguiente número obligatorio
                    if (sc.hasNextInt()) {
                        int proximoNumero = sc.nextInt();

                        if (operador.equals("+")) {
                            acumulado += proximoNumero;
                        } else if (operador.equals("-")) {
                            acumulado -= proximoNumero;
                        }

                        // Imprimimos el resultado con la coma si corresponde
                        if (!esPrimerResultado) {
                            System.out.print(", ");
                        }
                        System.out.print(acumulado);
                        esPrimerResultado = false;
                    }
                }
                // Salto de línea al terminar cada secuencia
                System.out.println();
            }
        }
        sc.close();
    }
}