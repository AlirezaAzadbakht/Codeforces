import java.text.DecimalFormat;
import java.util.*;

public class supermarket {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		double k = sc.nextInt();
		double best = Double.MAX_VALUE;
		while (n-- > 0) {
			double a = sc.nextInt();
			double b = sc.nextInt();
			double temp = k * a / b;
			if (best > temp)
				best = temp;
		}
		DecimalFormat df = new DecimalFormat("#0.00000000");
		System.out.println(df.format(best));
	}

}
