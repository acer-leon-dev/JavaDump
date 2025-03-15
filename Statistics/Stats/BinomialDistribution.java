package Stats;

public class BinomialDistribution {
    long n;
    double p;

    BinomialDistribution(long n, double p) {
        this.n = n;
        this.p = p;
    }

    // Calculates the probability mass function of a binomial distribution with parameters `k`, 'n', 'p'.   
    public static double pmf(long k, long n, double p) {
        return StatMath.binomial_coefficient(n, k) * Math.pow(p, k) * Math.pow((1 - p), n - k);
    }

    public double pmf(long k) {
        return pmf(k, n, p);
    }
    
}    
