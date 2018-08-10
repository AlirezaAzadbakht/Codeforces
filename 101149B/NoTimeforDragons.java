import java.util.*;

public class NoTimeforDragons {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] data = new int[n][2];
		for (int i = 0; i < n; i++) {
			data[i][0] = sc.nextInt();
			data[i][1] = sc.nextInt();
		}
		Arrays.sort(data, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				if (o2[0] - o2[1] == o1[0] - o1[1])
					return Integer.compare(o2[0], o1[0]);
				return Integer.compare(o2[0] - o2[1], o1[0] - o1[1]);
			}
		});

		Long used = (long) 0;
		Long remained = (long) 0;
		for (int i = 0; i < n; i++) {
			int a = data[i][0];
			int b = data[i][1];
			if (remained < a) {
				used += (a - remained);
				remained = (long) a;
			}
			remained = remained - b;
			// System.out.println(a + " " + b);
		}
		System.out.println(used);
	}

}
