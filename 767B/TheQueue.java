import java.util.*;

public class TheQueue {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long ts = sc.nextLong();
		long tf = sc.nextLong();
		long t = sc.nextLong();
		int n = sc.nextInt();
		// sol1(ts, tf, t, n);
		sol2(ts, tf, t, n);
	}

	public static void sol2(long ts, long tf, long t, int n) {
		long result = ts;
		long min = Long.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			long a = sc.nextLong();
			if (a <= tf - t) {
				if (Math.max(ts, a - 1) <= tf - t && ts - a + 1 < min) {
					min = ts - a + 1;
					result = Math.min(ts, a - 1);
				}
			}
			ts = Math.max(ts, a) + t;
			//System.out.println(min + " "+ result + " "+ ts);
		}
		if (ts <= tf - t)
			result = ts;
		System.out.println(result);
	}

	public static void sol1(long ts, long tf, long t, int n) {
		// TLE
		ArrayList<Long> data = new ArrayList<>();
		for (int i = 0; i < n; i++)
			data.add(sc.nextLong());
		int inQ = 0;
		int minI = 0;
		long min = tf;
		long delayTime = tf;
		for (int i = 0; i < tf; i++) {
			while (data.contains(i)) {
				inQ += t;
				data.remove(data.indexOf(i));
			}
			if (i < ts)
				delayTime = ts - i + inQ;
			else
				delayTime = inQ;

			if (min >= delayTime && i + t + delayTime <= tf) {
				min = delayTime;
				minI = i;
			}

			if (data.isEmpty() && inQ == 0 && i >= ts)
				break;
			if (inQ > 0 && i >= ts)
				inQ--;
			// System.out.print(i+">"+inQ+" ");
		}
		// System.out.println("\n"+delayTime);
		System.out.println(minI);
	}

}
