package src.stats;

public class NormalDistribution {
    // Mean
    private double mu;
    // Standard deviation
    private double sigma;

    NormalDistribution(double mu, double sigma) {
        this.mu = mu;
        this.sigma = sigma;
    }

    public double getMean() {
        return mu;
    }

    public double getStandardDeviation() {
        return sigma;
    }
    
    // Calculates the cdf at z with this dist's parameters.
    public double cdf(double z) {
        return Dist.normalcdf(z, mu, sigma);
    }

    public double pdf(double z) {
        return Dist.normalpdf(z, mu, sigma);
    }
}
