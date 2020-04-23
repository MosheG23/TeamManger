package behavioral;

import java.util.ArrayList;
import java.util.List;

public class TextFileOperationExecutor {
    
    private final List<TextFileOperation> textFileOperations = new ArrayList<>();
     
    public String executeOperation() {
    	StringBuilder builder = new StringBuilder();
    	for (TextFileOperation textFileOperation : textFileOperations) {
			builder.append(textFileOperation.execute());
		}
        return builder.toString();
    }
    
    public void addOperation(TextFileOperation textFileOperation) {
    	textFileOperations.add(textFileOperation);    	
    }
}
