/**
 * Each new term in the Fibonacci sequence is generated by adding the previous
 * two terms. By starting with 1 and 2, the first 10 terms will be: 1, 2, 3, 5,
 * 8, 13, 21, 34, 55, 89, ... By considering the terms in the Fibonacci sequence
 * whose values do not exceed four million, find the sum of the even-valued
 * terms.
 * 
 * @author Cosmina
 *
 */

public class FibonacciSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 1, b = 2;// primii 2 termeni ai sirului
		int LIMIT = 4000000;
		int sum, evenSum = 2;
		while ((a < LIMIT) && (b < LIMIT)) {
			sum = a + b;
			a = b;
			b = sum;
			if (sum % 2 == 0)
				evenSum = evenSum + sum;

		}
		System.out.println("Suma termenilor pari este " + evenSum);

	}

}
