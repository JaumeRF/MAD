package Calc;

public class algorithms {

    public static int[] congruenceSolver(int a, int b, int mod) {
        
        
        // * Si existe una solución entonces tendrá 'd' soluciones 🔥🔥🔥 
        // * Si solo tiene una solución:
        int d = mcdEuclidean(a, mod);
        int[] solutions = new int[d];
        if (d == 1) {
            solutions[0] = oneSolutionCongruence(a, b, mod);
            return solutions; 
        }

        // * Si tiene más de una:
        a /= d;
        b /= d;
        int m = mod/d;
        int sol1 = oneSolutionCongruence(a, b, m);
        for (int i = 0; i < d; i++) {
            solutions[i] = sol1 + i*(mod/d);
        }
        return solutions;
    }
    private static int oneSolutionCongruence(int a, int b, int mod) {
        if (a == 1) {
            
            return b;
        }
        // * la sol. se obtiene multiplicando el inverso de a en Zm por b
        int sol = inverseInZ(a, mod) * b;
        // * Se hace el módulo en caso de que la solución sea mayor que el módulo
        
        sol = Math.abs(sol / mod) >= 1 ? sol % mod : sol;
        
        
        return sol;
    }
    
    // * 🧮 calcula el mcd entre dos números aplicando el algoritmo de euclides
    public static int mcdEuclidean(int a, int b) {
        if (a < b) {
            int aux = a;
            a = b;
            b = aux;
        }

        while (a % b != 0) {
            int res = a % b;
            a = b;
            b = res;
        }
        
        return b;
    }
    
    public static int inverseInZ(int num, int mod) {
        int p0 = 0;
        int p1 = 1;
        int p2 = (mod / num) * p1 + p0;
        int i = 0;

        while (mod % num != 0) {
            int res = mod % num;
            if (i != 0) {
                p0 = p1;
                p1 = p2;
                p2 = (mod / num) * p1 + p0;
                
            }
            mod = num;
            num = res;
            i++;
        }
        int sign = i % 2 == 0 ? 1 : -1;
        
        return sign * p2;

       
    }

}
