package behavioral;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Scanner;


public class Subject extends Observable implements Runnable{
	
	public void run() {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		List<Double> numbers = new ArrayList<>();
		while(!input.equals("exit")){
			numbers.add(Double.valueOf(input));
			input = scan.nextLine();
		}
		setChanged();
		notifyObservers(numbers);
		scan.close();
	}
}

