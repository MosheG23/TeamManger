package behavioral;

import java.util.List;
import java.util.Observable;
import java.util.Observer;


public class MultObserver implements Observer{

	@Override
	public void update(Observable arg0, Object arg1) {
		double mult = 1;
		List<Double> numbers = (List)arg1;
		for (int i = 0; i < numbers.size(); i++) {
			mult *= numbers.get(i);
		}
		System.out.println(mult);
	}

}
