import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window {
	public static final Dimension DIM = new Dimension(1000, 700);
	
	private JFrame frame;
	private JPanel mainPanel;
	public JPanel currentPanel;
	
	public Window() {
		this.frame = new JFrame();
		frame.setSize(DIM);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setResizable(false);
		
		this.mainPanel = new JPanel();
		mainPanel.setPreferredSize(DIM);
		mainPanel.setBackground(Color.BLUE);
		
		frame.add(mainPanel);
		currentPanel = mainPanel;
		
		frame.pack();
	}
	
	public void changePanel(JPanel panel, String title) {
		if (currentPanel != null) {
			frame.remove(currentPanel);
		}
		
		frame.setTitle(title);
		frame.add(panel);
		currentPanel = panel;
		
		frame.invalidate();
		frame.repaint();
		frame.pack();
	}
	
	public void changePanel(JFrame frame, String title) {
		if (currentPanel != null) {
			frame.remove(currentPanel);
		}
		frame.setTitle(title);
		frame.add(frame);
		
		frame.invalidate();
		frame.repaint();
		frame.pack();
	}
}
