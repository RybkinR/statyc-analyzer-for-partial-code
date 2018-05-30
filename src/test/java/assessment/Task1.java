package assessment;

public class Task1 {

	public static void main(String[] args) {
		int amount = Integer.parseInt(args[0]);
		for (int i = 1; i < amount * 2; i++) {
		    if (i % 2 == 0) {
		        System.out.println(i + ";");
		    }
		}
	}
}

