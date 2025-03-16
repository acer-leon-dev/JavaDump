package src.stats;

public class BinomialDistribution {
    // Number of trials
    private long n;
    // Probability of success
    private double p;

    /**
     * 
     */
    BinomialDistribution(long n, double p) {
        this.n = n;
        this.p = p;
    }

    /**
     * Returns n.
     */
    public long getNTrials() {
        return n;
    }

    /**
     * Returns p.
     */
    public double getProbability() {
        return p;
    }

    /**
     * 
     */
    public double pmf(long k) {
        return Dist.binomialpmf(k, this.n, this.p);
    }

    /**
     * 
     */
    public double cdf(long k) {
        return Dist.binomialcdf(k, this.n, this.p);
    }

    /**
     * 
     */
    public long simulateProcess() {
        return Dist.simulateBernoulliProcess(n, p);
    }
    
}    
