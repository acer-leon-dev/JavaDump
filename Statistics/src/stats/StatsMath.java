package src.stats;
public class StatsMath {
    private StatsMath() {

    }

    public static double product(long n, long k, DoubleFunctionDouble f) {
        if (k < n) {
            return 1;
        }

        double result = f.invoke(n);
        for (n++; n <= k; n++) {
            result *= f.invoke(n);
        }

        return result;
    }

    // Calculates the factorial of `n`.
    public static long factorial(long n) {
        return (long)product(1, n, (double x) -> { return x; });        
    }

    // Calculates the binomial coefficient of `n` and `k`.
    public static long binomialCoefficient(long n, long k) {
        return factorial(n) / (factorial(k) * factorial(n - k)); 
    }    

    // Approximates the integral of `f` from `a` to `b` with `n` subintervals (using trapezoidal rule).
    public static double integral(double a, double b, DoubleFunctionDouble f, long n) {
        double domain = Math.abs(b - a);

        if (domain == 0) {
            return 0;
        }
        
        double dx = domain / n;
        double area = 0;
        double max = Math.max(a, b);
        
        for (double x1 = Math.min(a, b); x1 < max; x1 += dx) {
            double x2 = x1 + dx;
            area += (f.invoke(x1) + f.invoke(x2));
        }

        area *= dx / 2;

        // Account for negative integral
        if (a > b) {
            area *= -1;
        }

        return area;
    }

    // Calls `integral` with a default subinterval count for `n`.
    public static double integral(double a, double b, DoubleFunctionDouble f) {
        double domain = Math.abs(b - a);
        double n;
        if (domain >= 1) {
            n = 24 * domain;
        }
        else if (domain > 0) {
            n = -48 * Math.log10(domain) + 24;
        }
        else {
            n = 0;
        }

        return integral(a, b, f, (int)Math.ceil(n));
    }
    
    // Calculates the error function of `z`.
    public static double erf(double z) {
        return 2 / Math.sqrt(Math.PI) * integral(0, z, (double t) -> Math.pow(Math.E, -(t * t)), 1000);
    }

    public static double betaFunction(double z1, double z2) {
        return integral(0, 1, (double t) -> Math.pow(t, z1-1) * Math.pow((1-t), z2-1), 1000);
    }

    public static double incompleteBetaFunction(double x, long a, long b) {
        return integral(0, x, (double t) -> Math.pow(t, a-1) * Math.pow((1-t), b-1));
    }

    public static double regularizedIncompleteBetaFunction(double x, long a, long b) {
        return incompleteBetaFunction(x, a, b) / betaFunction(a, b);
    }
}