import java.util.*;

public class CinemaLine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int s25 = 0;
		int s50 = 0;
		while (n-- > 0) {
			int a = sc.nextInt();
			if (a == 25)
				s25++;
			if (a == 50) {
				s50++;
				if (s25 == 0) {
					System.out.println("NO");
					return;
				}
				s25--;
			}
			if (a == 100) {
				if (s50 > 0 && s25 > 0) {
					s50--;
					s25--;
				} else if (s25 >= 3) {
					s25 -= 3;
				} else {
					System.out.println("NO");
					return;
				}
			}

		}
		System.out.println("YES");
	}
}
