import java.util.Scanner;
import Calc.*;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.println("Solucionar de problemas de matemáticas discretas");

        System.out.println("Introduce por orden los valores de a, b y m en la ecuación ax = b (mod m)");
        int a = scan.nextInt();
        int b = scan.nextInt();
        int mod = scan.nextInt();

        int d = algorithms.mcdEuclidean(a, mod);

        // * 🤩 Comprueba si tiene solución, es decir mcd(a, m) | c
        if (b % d != 0) {
            System.out.println("No tiene solución");
        } else {
            System.out.println("la solución a la ecuación " + a + "x = " + b + " (mod " + mod + ") son: ");
            int[] sol = algorithms.congruenceSolver(a, b, mod);
            for (int i : sol) {
                System.err.println(i + " ");
            }
        }
    }
}
