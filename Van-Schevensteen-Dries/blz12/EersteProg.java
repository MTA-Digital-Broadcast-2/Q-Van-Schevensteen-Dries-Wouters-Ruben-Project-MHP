import java.lang.*;

/**
* Information about class
* @author Dries Van Schevensteen
* @version 1.0
*/


public class EersteProg {

	public static void main(String[] args) {
		drukAf(100);
	}

	/**
	* This method prints integers from 0 to m
	* @param m Integer max loop to print from 0
	*/
	private static void drukAf(int m) {
		int a;
		for (a = 0; a < m; a++)
			System.out.println(a);
	}

}