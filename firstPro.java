import java.util.Scanner;
import java.util.Stack;

public class firstPro {
	static int getMaxArea(int hist[], int n) {

		Stack<Integer> s = new Stack<Integer>();

		int max_area = 0;
		int tp;
		int area_with_top;

		int i = 0;
		while (i < n) {

			if (s.empty() || hist[s.peek()] <= hist[i])
				s.push(i++);

			else {
				tp = s.peek();
				s.pop();

				area_with_top = hist[tp] * (s.empty() ? i : i - s.peek() - 1);

				if (max_area < area_with_top)
					max_area = area_with_top;
			}
		}

		while (s.empty() == false) {
			tp = s.peek();
			s.pop();
			area_with_top = hist[tp] * (s.empty() ? i : i - s.peek() - 1);

			if (max_area < area_with_top)
				max_area = area_with_top;
		}

		return max_area;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt(), m = in.nextInt();
		int[][] a = new int[n][m];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				a[i][j] = in.nextInt();
		int[] h = new int[m];
		int max = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (a[i][j] == 0)
					h[j] = 0;
				else {
					h[j]++;
				}
			}
			int area = getMaxArea(h, h.length);
			if (area > max)
				max = area;
		}
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				if(a[i][j] == 1)
					a[i][j] = 0 ;
				else
					a[i][j] = 1 ;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (a[i][j] == 0)
					h[j] = 0;
				else {
					h[j]++;
				}
			}
			int area = getMaxArea(h, h.length);
			if (area > max)
				max = area;
		}
		System.out.println(max);
	}

}
