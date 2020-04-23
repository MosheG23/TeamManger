package behavioral;

public class Driver {

	public static void main(String[] args) {
		
		//Adapter process
		Movable bugattiVeyron = new BugattiVeyron();
	    MovableAdapter bugattiVeyronAdapter = new MovableAdapterImpl(bugattiVeyron);
	    System.out.println(bugattiVeyronAdapter.getSpeed());
	    
	    //Command process
	    TextFileOperationExecutor textFileOperationExecutor = new TextFileOperationExecutor();
	    textFileOperationExecutor.addOperation(new OpenTextFileOperation(new TextFile("file1.txt")));
	    textFileOperationExecutor.addOperation(new SaveTextFileOperation(new TextFile("file2.txt")));
	    System.out.println(textFileOperationExecutor.executeOperation());
	    
	    //Observer process
	    Subject subject = new Subject();
		subject.addObserver(new SumObserver());
		subject.addObserver(new MultObserver());
		new Thread(subject).start();
	}

}
