import java.util.*;

public class PetyaandInequiations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		long x = sc.nextLong();
		long y = sc.nextLong();
		long MaxPossible = y - (n - 1);
		if (MaxPossible * MaxPossible + (n - 1) < x || n > y) {
			System.out.println(-1);
			return;
		}
		System.out.println(MaxPossible);
		for (int i = 0; i < n - 1; i++)
			System.out.println(1);
	}

}
