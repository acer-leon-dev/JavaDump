package com.lacerdev.statistics;
import java.util.List;
import java.util.function.DoubleUnaryOperator;

public final class StatsMath {
    private StatsMath() {}

    static final DoubleUnaryOperator DOUBLE_IDENTITY = (double x) -> x;

    /**
     * Returns the sum of applying a given function to all numbers in the range [k, n].
     *
     * @param k The first number in the range
     * @param n The last number in the rang
     * @param f The function to apply
     */
    public static double sum(long k, long n, DoubleUnaryOperator f) {
        double result = 0;
        for (long x = k; x <= n; x++) {
            result += f.applyAsDouble(x);
        }
        return result;
    }

    /**
     * Returns the sum of all numbers in the range [k, n].
     *
     * @param k The first number in the range
     * @param n The last number in the rang
     */
    public static double sum(long k, long n) {
        return ((double)(n - k + 1) / 2) * (k + n);
    }

    /**
     * Returns the sum of applying a given function to all numbers in a list.
     *
     * @param list The list of numbers
     * @param f The function to apply
     */
    public static double sum(List<Double> list, DoubleUnaryOperator f) {
        return sum(0, list.size() - 1, list, f);
    }

    /**
     * Returns the sum of all numbers in a list.
     *
     * @param list The list of numbers
     */
    public static double sum(List<Double> list) {
        return sum(list, DOUBLE_IDENTITY);
    }

    /**
     * Returns the sum of applying a given function to all numbers in a list within the index range [n, k].
     *
     * @param k The beginning position of the range
     * @param n The end position of the range (inclusive)
     * @param f The function to apply
     */
    public static double sum(int k, int n, List<Double> list, DoubleUnaryOperator f) {
        double result = 0;
        for (int i = k; i <= n; i++) {
            result += f.applyAsDouble(list.get(i));
        }
        return result;
    }

    /**
     * Returns the sum of all numbers in a list within the index range [n, k].
     *
     * @param k The starting position of the range
     * @param n The end position of the range (inclusive)
     */
    public static double sum(int k, int n, List<Double> list) {
        return sum(k, n, list, DOUBLE_IDENTITY);
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

        double result = f.applyAsDouble(n);
        for (n++; n <= k; n++) {
            result *= f.applyAsDouble(n);
        }

        return result;
    }

    public static double product(long n, long k) {
        return product(n, k, DOUBLE_IDENTITY);
    }

    /**
     * Calculates the factorial of n.
     * @param n The input number
     */
    public static long factorial(long n) {
        if (n < 0) {
            throw new IllegalArgumentException("The input of a factorial cannot be negative");
        }
        return (long)product(1, n, DOUBLE_IDENTITY);
    }

    /**
     * Calculates the mean of all of the numbers in a list.
     */
    public static double mean(List<Double> list) {
        return StatsMath.sum(list) / list.size();
    }

    public static double standardDeviation(List<Double> list) {
        final double mu = mean(list);
        return Math.sqrt(sum(list, (double x) -> Math.pow((x - mu), 2)) / list.size());
    }

    /**
     * Approximates the integral of f from a to b with n subintervals.
     * <p>
     * Implemented using the trapezoidal rule.
     * @param a The lower limit of the integral
     * @param b The upper limit of the integral
     * @param f The integrand
     * @param n The number of subintervals
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
            area += (f.applyAsDouble(x1) + f.applyAsDouble(x2));
        }

        area *= dx / 2;

        // Account for negative integral
        if (a > b) {
            area *= -1;
        }

        return area;
    }

    /**
     * Approximates the integral of f from a to b, with a default-determined number of subinterval.
     * <p>
     * Implemented using the trapezoidal rule.
     * @param a The lower limit of the integral
     * @param b The upper limit of the integral
     * @param f The integrand
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
     * Returns the beta function of x, a, and b.
     * @param z1
     * @param z2
     * @return
     */
    public static double betaFunction(double z1, double z2) {
        return integral(0, 1, (double t) -> Math.pow(t, z1-1) * Math.pow((1-t), z2-1), 100);
    }

    /**
     * Returns the incomplete beta function of x, a, and b.
     * @param x
     * @param a
     * @param b
     * @return
     */
    public static double incompleteBetaFunction(double x, long a, long b) {
        return integral(0, x, (double t) -> Math.pow(t, a-1) * Math.pow((1-t), b-1));
    }

    /**
     * Returns the regularized incomplete beta function of x, a, and b.
     * @param x
     * @param a
     * @param b
     * @return
     */
    public static double regularizedIncompleteBetaFunction(double x, long a, long b) {
        return incompleteBetaFunction(x, a, b) / betaFunction(a, b);
    }
}