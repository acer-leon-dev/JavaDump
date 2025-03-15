package Stats;

public class StatMath {
    // Calculates the factorial of `n`.
    public static long factorial(long n) {
        if (n == 0) {
            return 1;
        }
        
        long v = 1;
        for (long i = 2; i <= n; i++) {
            v *= i;
        }
        
        return v;
    }

    // Calculates the binomial coefficient of `n` and `k`.
    public static long binomial_coefficient(long n, long k) {
        return factorial(n) / (factorial(k) * factorial(n - k)); 
    }    

    // Approximates the integral of `f` from `a` to `b` with `n` subintervals (using trapezoidal rule).
    public static double integral(DoubleFunctionDouble f, double a, double b, long n) {
        double domain = Math.abs(b - a);

        if (domain == 0) {
            return 0;
        }
        
        double dtx = domain / n;
        double area = 0;
        for (double x1 = a; x1 < b; x1 += dtx) {
            double x2 = x1 + dtx;
            area += (f.invoke(x1) + f.invoke(x2));
        }

        area *= dtx / 2;

        // Account for negative integral
        if (a > b) {
            area *= -1;
        }

        return area;
    }

    // Calls `integral` with a default subinterval count for `n`.
    public static double integral(DoubleFunctionDouble f, double a, double b) {
        double domain = Math.abs(b - a);
        double n;
        if (domain >= 1) {
            n = 9 * domain + 9;
        }
        else if (domain > 0) {
            n = -24 * Math.log10(domain) + 9;
        }
        else {
            n = 0;
        }

        return integral(f, a, b, (int)Math.ceil(n));
    }
    
    // Calculates the error function of `z`.
    public static double erf(double z) {
        return 2 / Math.sqrt(Math.PI) * integral((double t) -> Math.pow(Math.E, -(t * t)), 0, z);
    }
}