package Match_2DArrayWith1DArray;

import java.util.Arrays;

public class Example {

	public static void main(String[] args) {
		int[][] x = { { 23, 33, 46, 50, 56 }, { 3, 8, 65, 34, 90 }, { 2, 7, 46, 50, 56 } };

		int[] y = { 2, 7, 46, 50, 56 };

		for (int i = 0; i < x.length - (x.length) + 1; i++) {
			
			System.out.println(Arrays.toString(x[2]));
			
			for (int j = 0; j < y.length - (y.length) + 1; j++) {
				System.out.println(Arrays.toString(y));
				if (x[2].equals(y)) {
					System.out.println("match");
				} else {
					System.out.println("no match");
				}
			}
		}
	}

}
