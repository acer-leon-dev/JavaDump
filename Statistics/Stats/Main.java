package Stats;

public class Main {
	public static void main(String[] args) {
        NormalDistribution N = new NormalDistribution(0, 1);
        System.out.println("normalcdf(-1, 0, 1) = " + Double.toString(N.cdf(-1)));
        System.out.println("normalcdf(0, 0, 1) = " + Double.toString(N.cdf(0)));
        System.out.println("normalcdf(2, 0, 1) = " + Double.toString(N.cdf(2)));

        BinomialDistribution B = new BinomialDistribution(20, 0.5);
        System.out.println("binompmf(3, 20, 0.5) = " + Double.toString(B.pmf(3)));
        System.out.println("binompmf(10, 20, 0.5) = " + Double.toString(B.pmf(10)));
        System.out.println("binompmf(16, 20, 0.5) = " + Double.toString(B.pmf(16)));
	}
}