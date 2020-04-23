import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPanel extends JPanel {
	private GridBagConstraints constraints;
	@SuppressWarnings("unused")
	public Window currWin;
	
	public LoginPanel(Window window) {
		super(new GridBagLayout());
		
		this.currWin = window;
		
		setPreferredSize(Window.DIM);
		setBackground(Color.lightGray);
		this.constraints = new GridBagConstraints();
//		constraints.insets = new Insets(5, 5, 5, 5);
		
		
		JLabel username = new JLabel("Username:");
		constraints.gridx = 0;
		constraints.gridy = 0;
		add(username, constraints);
		
		JLabel password = new JLabel("Password:");
		
		constraints.gridx = 0;
		constraints.gridy = 1;
		
		add(password, constraints);
		
		JTextField usernameField = new JTextField();
		usernameField.setPreferredSize(new Dimension(100, 25));
		constraints.gridx = 1;
		constraints.gridy = 0;
		add(usernameField, constraints);
		
		JPasswordField passwordField = new JPasswordField();
		passwordField.setPreferredSize(new Dimension(100, 25));
		constraints.gridx = 1;
		constraints.gridy = 1;
		add(passwordField, constraints);
		
		JComboBox<String> dropDown = new JComboBox<String>();
		dropDown.setPreferredSize(new Dimension(100, 30));
		dropDown.addItem("Employee");
		dropDown.addItem("Manager");
		dropDown.addItem("System");
		
		JButton loginBtn = new JButton("LOGIN");
		loginBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				EmployeeMain app = new EmployeeMain(window, usernameField.getText());
				window.changePanel(app, "EZShift");
			}
		});
		
		constraints.gridx = 2;
		constraints.gridy = 1;
		add(loginBtn, constraints);
		
		
		
		dropDown.addPropertyChangeListener(new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				invalidate();
				repaint();
			}
		});
		
		constraints.gridx = 0;
		constraints.gridy = 3;
		add(dropDown, constraints);
		
		JLabel logo = new JLabel();
		logo.setIcon(new ImageIcon("images\\logo.gif"));
		
		constraints.gridx = 0;
		constraints.gridwidth = 2;
		constraints.gridy = 4;
		constraints.anchor = GridBagConstraints.PAGE_END;
		add(logo, constraints);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
//		g.drawImage(myImage, 0, 0, null)
	}
}
