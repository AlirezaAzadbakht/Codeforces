import java.util.*;

public class QuasiBinary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = new Scanner(System.in).nextInt();
		int max = -1;
		int[] ans = new int[9];
		int t = 1;
		while (n > 0) {
			int a = n % 10;
			max = Math.max(max, a);
			for (int i = 0; i < a; i++) {
				ans[i] += t;
			}
			n /= 10;
			t *= 10;
		}
		System.out.println(max);
		for (int i : ans) {
			if (i != 0)
				System.out.print(i + " ");
		}

	}

}
