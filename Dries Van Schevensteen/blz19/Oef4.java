import java.lang.*;

public class Oef4 {

	public static void main(String[] args) {
		System.out.println(invertNumber(4302));
	}

	private static int invertNumber(int number) {
		number = ~number;
		number++;
		return(number);
	}

}