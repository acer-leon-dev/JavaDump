package src.stats;

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
     * Returns mu.
     * @return this.mu
     */
    public double getMean() {
        return mu;
    }

    /**
     * Returns sigma.
     * @return this.sigma
     */
    public double getStandardDeviation() {
        return sigma;
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
