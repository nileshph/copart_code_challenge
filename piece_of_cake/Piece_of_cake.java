import java.util.ArrayList;
import java.util.Scanner;

public class Piece_of_cake {

	/*
	 * Author: Nilesh Balasaheb Pharate
	 * Tag Number: 16 
	 */
	
	/*
	 * Instruction to run code: Get input in given format from stdin
	 * output will be diplayed on stdout
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * get number of cakes and their areas
		 */

		Scanner sc = new Scanner(System.in);

		int numCake = sc.nextInt();
		ArrayList<Double> area = new ArrayList<>();

		for (int i = 0; i < numCake; i++) {
			try{
				area.add(sc.nextDouble());
			}
			catch(Exception e)
			{
				System.out.println("Error in input");
			}
		}

		ArrayList<Double> perimeter = new ArrayList<>();
		for (int i = 0; i < area.size(); i++) {

			Double ar = area.get(i);

			Double x = Math.floor(Math.sqrt(ar));
			
			while(ar % x !=0)
			{
				x--;
			}
			
			try{
			double y = ar / x;
			perimeter.add(2*x + 2*y);
			}
			
			catch(ArithmeticException e)
			{
				System.out.println("Error in division");
			}
	
		}

		for (int i = 0; i < perimeter.size(); i++) {
			System.out.println(perimeter.get(i));
		}
		sc.close();
	}

}
