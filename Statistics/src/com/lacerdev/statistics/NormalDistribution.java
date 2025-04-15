package com.lacerdev.statistics;

public class NormalDistribution {
    // Mean
    private double mu;
    // Standard deviation
    private double sigma;

    /**
     * 
     * @param mu
     * @param sigma
     */
    NormalDistribution(double mu, double sigma) {
        this.mu = mu;
        this.sigma = sigma;
    }

    /**
     * Returns the mean of this normal distribution.
     * @return this.mu
     */
    public double getMean() {
        return mu;
    }

    /**
     * Returns the standard deviation of this normal distribution.
     * @return this.sigma
     */
    public double getStandardDeviation() {
        return sigma;
    }

    /**
     * Sets the mean of this normal distribution.
     */
    public void setMean(double mu) {
        this.mu = mu;
    }

    /**
     * Sets the standard deviation of this normal distribution.
     */
    public void setStandardDeviation(double sigma) {
        if (sigma < 0) {
            throw new NegativeParameterException("Error: Parameter \"sigma\" (standard deviation) for distribution \"normal_distribution\" cannot be negative.");
        }
        this.sigma = sigma;
    }
    
    /**
     * Calculates the cdf at z with this dist's parameters.
     * @param z
     * @return
     */
    public double cdf(double z) {
        return Dist.normalcdf(z, mu, sigma);
    }

    /**
     * 
     */
    public double pdf(double z) {
        return Dist.normalpdf(z, mu, sigma);
    }
}
