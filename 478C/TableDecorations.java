import java.util.*;

public class TableDecorations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Long[] rgb = new Long[3];
		rgb[0] = (long) sc.nextInt();
		rgb[1] = (long) sc.nextInt();
		rgb[2] = (long) sc.nextInt();
		Arrays.sort(rgb);
		if (rgb[0] + rgb[1] == 0)
			System.out.println(0);
		else if (rgb[2] > 2 * (rgb[0] + rgb[1]))
			System.out.println(rgb[0] + rgb[1]);
		else
			System.out.println((rgb[0] + rgb[1] + rgb[2]) / 3);

	}

}
