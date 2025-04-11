package src.stats;

public final class Dist {
    /**
     * Private constructor.
     */
    private Dist() {

    }

    /**
    * Calculates the cumulative distribution function of a normaldist with parameters z, mu, sigma.
    */
    public static double normalcdf(double z, double mu, double sigma) {
        return 0.5 * (1 + StatsMath.erf((z - mu) / (sigma * Math.sqrt(2))));
    }

    /**
    * Calculates the probability density function of normaldist with parameters z, mu, sigma.
    */
    public static double normalpdf(double z, double mu, double sigma) {
        double variance = sigma * sigma;
        return Math.pow(Math.E, -Math.pow(z - mu, 2) / (2 * variance)) / Math.sqrt(2 * Math.PI * variance);
    }

    /**
    * Calculates the probability mass function of a binomial distribution with parameters k, n, p.
    */
    public static double binomialpmf(long k, long n, double p) {
        return StatsMath.binomialCoefficient(n, k) * Math.pow(p, k) * Math.pow((1 - p), n - k);
    }

    /**
    * Calculates the cumulative distribution function of a binomial distribution with parameters k, n, p.
    */
    public static double binomialcdf(long k, long n, double p) {
        return StatsMath.regularizedIncompleteBetaFunction(1 - p, n - k, k + 1);
    }

    /**
     * 
     */
    public static long simulateBernoulliProcess(long n, double p) {
        long successes = 0;
        
        for (long i = 0; i < n; i++) {
            if (Math.random() < p) {
                successes++;
            }
        }

        return successes;
    }
}
