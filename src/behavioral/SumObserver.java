package behavioral;

import java.util.List;
import java.util.Observable;
import java.util.Observer;


public class SumObserver implements Observer{

	@Override
	public void update(Observable arg0, Object arg1) {
		double sum = 0;
		List<Double> numbers = (List)arg1;
		for (int i = 0; i < numbers.size(); i++) {
			sum += numbers.get(i);
		}
		System.out.println(sum);
	}

}
