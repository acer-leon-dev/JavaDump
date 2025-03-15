package Source.Stats;

public class BinomialDistribution {
    // Number of trials
    private long n;
    // Probability of success
    private double p;

    BinomialDistribution(long n, double p) {
        this.n = n;
        this.p = p;
    }

    public long getTrials() {
        return n;
    }
    
    public double getProbability() {
        return p;
    }

    // Calculates the probability mass function of a binomial distribution with parameters `k`, 'n', 'p'.   
    public static double pmf(long k, long n, double p) {
        return StatsMath.binomialCoefficient(n, k) * Math.pow(p, k) * Math.pow((1 - p), n - k);
    }

    public double pmf(long k) {
        return pmf(k, n, p);
    }
    
}    
