package Stats;

public class NormalDistribution {
    double mu;
    double sigma;

    NormalDistribution(double mu, double sigma) {
        this.mu = mu;
        this.sigma = sigma;
    }

    // Calculates the cumulative distribution function at `z` of a normal distribition with mean `mu` and standard deviation `sigma`.
    public static double cdf(double z, double mu, double sigma) {
        return 0.5 * (1 + StatMath.erf((z - mu) / (sigma * Math.sqrt(2))));
    }
    
    // Calculates the cdf at z with this dist's parameters.
    public double cdf(double z) {
        return cdf(z, mu, sigma);
    }
}
