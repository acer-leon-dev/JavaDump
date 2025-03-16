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

    // Calculates the cumulative distribution function at `z` of a normal distribition with mean `mu` and standard deviation `sigma`.
    public static double cdf(double z, double mu, double sigma) {
        return 0.5 * (1 + StatsMath.erf((z - mu) / (sigma * Math.sqrt(2))));
    }
    
    // Calculates the cdf at z with this dist's parameters.
    public double cdf(double z) {
        return cdf(z, mu, sigma);
    }

    public static double pdf(double z, double mu, double sigma) {
        double variance = sigma * sigma;
        return Math.pow(Math.E, -Math.pow(z - mu, 2) / (2 * variance)) / Math.sqrt(2 * Math.PI * variance);
    }

    public double pdf(double z) {
        return pdf(z, mu, sigma);
    }
}
