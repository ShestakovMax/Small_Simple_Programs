import java.util.Scanner;

public class Application {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int value = 0;
		int attempts = 0;

		do {
			System.out.println("Please enter your age");

			for (; value != 21;) {
				if (value == 0) {

					System.out.println(" ");
					value = scanner.nextInt();
				} else if (value < 21) {
					System.out.println("Aww! You are too small, only " + value
							+ ". Get older and then try again");
					attempts++;
					System.out.println("Number of attempts: " + attempts);
					value = scanner.nextInt();
				} else {
					System.out
							.println("God! you are "
									+ value
									+ ". You are too old. It is too late to use this program. ");
					attempts++;
					System.out.println("Number of attempts: " + attempts);
					value = scanner.nextInt();
				}
			}
			break;
		} while (value == 21);
		System.out.println("Aaa, nice! Correct age.");
		Scanner input = new Scanner(System.in);

		System.out.println("Now please enter your name");
		String text = input.nextLine();

		switch (text) {
		case "Max":
			System.out.println("Ha-ha-ha, nice try. You are not my master.");
			System.out.println("Access denied");
			break;
			
		case "Karyna":
			System.out.println("Access Granted");
			System.out.println("I love you!");
			break;

		default:
			System.out.println("Access denied");
		}
	}
}
