public class ArraysDemo {

	public static void main(String[] args) {
		int[] ar = {10, 20, 30, 40, 50};
		
		for (int i = 0; i < ar.length; i++) {
			System.out.println(ar[i]);
		}
		
		for (int i : ar) {
			System.out.println(i);
		}
		
		int[][] jag = { {1,2,3}, {4,5,6,7}, {8,9}};
		for (int[] row : jag) {
			for (int i : row) {
				System.out.printf("%-4d", i);
			}
			System.out.println();
		}
		
		// Sort this array
		int[] mess = {3, 5, 2, 4, 1};
		
		
		// String array to sort
		String fruits = "Kiwi-Cherry-Banana-Apple-Fig-Grapes";
		
	}
}
