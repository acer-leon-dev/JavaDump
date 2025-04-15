package com.lacerdev.statistics;

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
    public long getNumberOfTrials() {
        return n;
    }

    /**
     * Returns p.
     */
    public double getProbability() {
        return p;
    }

    /**
     * Sets n to a given positive integer.
     */
    public void setNumberOfTrials(long n) {
        if (n < 0) {
            throw new NegativeParameterException("Error: Parameter \"number of trials\" (n) for distribution \"binomial_distribution\" cannot be negative");
        }

        this.n = n;
    }

    /**
     * Returns p.
     */
    public void setProbability(double p) {
        if (p < 0.0) {
            throw new NegativeParameterException("Error: Parameter \"probability\" (p) for distribution \"binomial_distribution\" cannot be negative.");
        }

        this.p = p;
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
