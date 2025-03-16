package src.stats;

public class Main {
    private static String doubleToPercent(double x) {
        return Double.toString((double)Math.round(x * 10000) / 100) + '%';
    }

	public static void main(String[] args) {
        NormalDistribution N = new NormalDistribution(0, 1);
        
        System.out.println("normalpdf(-1, 0, 1) = " + doubleToPercent(N.pdf(-1)));
        System.out.println("normalpdf(0, 0, 1) = " + doubleToPercent(N.pdf(0)));
        System.out.println("normalpdf(2, 0, 1) = " + doubleToPercent(N.pdf(2)));

        System.out.println();

        System.out.println("normalcdf(-1, 0, 1) = " + doubleToPercent(N.cdf(-2)));
        System.out.println("normalcdf(0, 0, 1) = " + doubleToPercent(N.cdf(0)));
        System.out.println("normalcdf(2, 0, 1) = " + doubleToPercent(N.cdf(2)));

		System.out.println();

        BinomialDistribution B = new BinomialDistribution(20, 0.5);
        System.out.println("binompmf(3, 20, 0.5) = " + doubleToPercent(B.pmf(3)));
        System.out.println("binompmf(10, 20, 0.5) = " + doubleToPercent(B.pmf(10)));
        System.out.println("binompmf(16, 20, 0.5) = " + doubleToPercent(B.pmf(16)));

        System.out.println();

        System.out.println("binomcdf(3, 20, 0.5) = " + doubleToPercent(B.cdf(3)));
        System.out.println("binomcdf(10, 20, 0.5) = " + doubleToPercent(B.cdf(10)));
        System.out.println("binomcdf(16, 20, 0.5) = " + doubleToPercent(B.cdf(16)));

	}
}