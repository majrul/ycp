import java.util.Date;
import java.util.Scanner;

public class HelloWorld {

	public static void main(String[] args) {
		System.out.println("Namaste Duniya!");
		System.out.println("Aaj ki taarikh " + new Date());
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your name ");
		String name = sc.next();
		System.out.println("Hello " + name);
		
	}
}
