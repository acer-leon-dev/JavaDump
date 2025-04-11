import java.util.function;

package src.stats;
public final class StatsMath {
    private StatsMath() {

    }

    /**
     * Returns the sum of applying a given function to all numbers in the range [k, n].
     * 
     * @param k
     * @param n
     * @param f
     */
    public static double sum(long k, long n, DoubleUnaryOperator f) {
        double result;
        for (long x = k; x <= n; x++) {
            result += f(x);
        }
        return result;
    }

    /**
     * Returns the sum of all numbers in the range [k, n].
     * 
     * @param k
     * @param n
     */
    public static double sum(long k, long n) {
        // return sum(k, n, () -> x);
        return ((n - k + 1) / 2) * (k + n);
    }

    /**
     * Returns the sum of applying a given function to all values in a list.
     * 
     * @param k
     * @param n
     * @param f
     */
    public static double sum(List<double> list, DoubleUnaryOperator f) {
        double result;
        for (double x : list) {
            result = f(x);  
        }
        return result;
    }

    /**
     * Returns the sum of all values in a list.
     * 
     * @param k
     * @param n
     * @param f
     */
    public static double sum(List<double> list) {
        return sum(list, () -> x);
    }

    /**
     * Returns the sum of applying a given function to all values in a list within the index range [n, k].
     * 
     * @param k
     * @param n
     * @param f
     */
    public static double sum(long k, long n, List<double> list, DoubleUnaryOperator f) {
        double result;
        for (long i = k; i <= n; i++) {
            result += list.get(i);
        }
        return result;
    }

    /**
     * Returns the sum of all values in a list within the index range [n, k].
     * 
     * @param k
     * @param n
     * @param f
     */
    public static double sum(long k, long n, List<double> list) {
        return sum(k, n, list, () -> x);
    }

    /**
     * 
     * @param n
     * @param k
     * @param f
     * @return
     */
    public static double product(long n, long k, DoubleUnaryOperator f) {
        if (k < n) {
            return 1;
        }

        double result = f.invoke(n);
        for (n++; n <= k; n++) {
            result *= f.invoke(n);
        }

        return result;
    }

    public static double product(long n, long k) {
        return product(n, k, NOP);
    }

    /**
    * Calculates the factorial of n.
    * @param n
    */ 
    public static long factorial(long n) {
        return (long)product(1, n, (double x) -> { return x; });        
    }

    /**
     * Calculates the mean of all of the values in a list.
     */
    public static double mean(List<Double> list) {
        return StatsMath.sum(list) / list.size();
    }

    public static double standardDeviation(List<Double> list) {
        final double mu = mean(list);
        return Math.sqrt(sum(list, (double x) -> Math.pow((x - mu), 2)) / list.size())
    }
    
    /**
    * Approximates the integral of f from a to b with n subintervals (using trapezoidal rule).
    * @param a
    * @param b
    * @param f
    * @param n
    */ 
    public static double integral(double a, double b, DoubleUnaryOperator f, long n) {
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

    /**
    * Calls integral with a default subinterval count for n.
    * @param a
    * @param b
    * @param f
    */ 
    public static double integral(double a, double b, DoubleUnaryOperator f) {
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

    /**
    * Calculates the error function of z.
    * @param z
    */ 
    public static double erf(double z) {
        return 2 / Math.sqrt(Math.PI) * integral(0, z, (double t) -> Math.pow(Math.E, -(t * t)), 1000);
    }

    /**
    * Calculates the binomial coefficient of n and k.
    * @param n
    * @param k
    */ 
    public static long binomialCoefficient(long n, long k) {
        return factorial(n) / (factorial(k) * factorial(n - k)); 
    }

    /**
     * 
     * @param z1
     * @param z2
     * @return
     */
    public static double betaFunction(double z1, double z2) {
        return integral(0, 1, (double t) -> Math.pow(t, z1-1) * Math.pow((1-t), z2-1), 100);
    }

    /**
     * 
     * @param x
     * @param a
     * @param b
     * @return
     */
    public static double incompleteBetaFunction(double x, long a, long b) {
        return integral(0, x, (double t) -> Math.pow(t, a-1) * Math.pow((1-t), b-1));
    }

    /**
     * 
     * @param x
     * @param a
     * @param b
     * @return
     */
    public static double regularizedIncompleteBetaFunction(double x, long a, long b) {
        return incompleteBetaFunction(x, a, b) / betaFunction(a, b);
    }
}