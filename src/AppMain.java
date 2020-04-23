import java.awt.BorderLayout;
import java.awt.GridBagConstraints;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AppMain extends JPanel {
	private GridBagConstraints constraints;
	private String user;
	private JButton btn;
	private JTextField textArea;
	
	public AppMain(String user) {
		super();
		this.user = user;
		setLayout(new BorderLayout());
		setPreferredSize(Window.DIM);
		
		btn = new JButton(user);
		textArea = new JTextField();
		
		
		
		add(textArea, BorderLayout.CENTER);
		add(btn, BorderLayout.SOUTH);
		
		setVisible(true);
	}
}
