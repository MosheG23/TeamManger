import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.*;
import javax.swing.*;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Choice;

public class Login {

	private JFrame frame;
	private Connection connection = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
					window.frame.setResizable(false);
					window.frame.setTitle("EZShift");
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	 private JPasswordField passwordField;
	 private JTextField textFieldUsername;
	 public static Choice choice;
	 
	/**
	 * Create the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws IOException 
	 */
	public Login() throws IOException {
//		JOptionPane.showMessageDialog(null, "Check");
		this.connection = sqliteConnection.connect();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		frame = new JFrame();
		int xWinSize = 570, yWinSize = 400;
		frame.setBounds(100, 100, xWinSize, yWinSize);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width/2-xWinSize/2, dim.height/2-yWinSize/2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setForeground(new Color(255, 255, 255));
		btnExit.setBackground(new Color(255, 0, 102));
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnExit.setFocusPainted(false);
		btnExit.setBounds(0, 0, 89, 25);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				sqliteConnection.disconnect();
				JFrame exit = new JFrame("Exit");
				if (JOptionPane.showConfirmDialog(exit, "Confirm  to exit", "Login System", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btnExit);
		
		JLabel lblLoginSystem = new JLabel("Login System", SwingConstants.CENTER);
		lblLoginSystem.setForeground(Color.BLACK);
		lblLoginSystem.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLoginSystem.setBounds(193, 38, 222, 48);
		frame.getContentPane().add(lblLoginSystem);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUsername.setBounds(218, 120, 105, 19);
		frame.getContentPane().add(lblUsername);
		
		textFieldUsername = new JTextField();
		textFieldUsername.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldUsername.setBounds(335, 117, 155, 28);
		frame.getContentPane().add(textFieldUsername);
		textFieldUsername.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPassword.setBounds(218, 189, 94, 19);
		frame.getContentPane().add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		passwordField.setBounds(335, 184, 155, 28);
		frame.getContentPane().add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(250, 281, 89, 25);
		btnLogin.setBackground(new Color(59, 89, 182));
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setFocusPainted(false);
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLogin.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				Integer i = null;
				String type = choice.getSelectedItem();
				try {
					i = sqliteConnection.selectUsernameAndPasswordFromDB(connection, type, textFieldUsername.getText(),passwordField.getText());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1);
				}
				if (i == 1) {
					String user = textFieldUsername.getText();
					JOptionPane.showMessageDialog(null, "Hi " + sqliteConnection.GetFName(connection, type, textFieldUsername.getText()));
					frame.dispose();
					if (type.equals("Employee")) {
						EmployeeMain empMain;
						try {
							empMain = new EmployeeMain(connection, user);
							empMain.setVisible(true);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null, e1);;
						}
					}
					else if(type.equals("Manager")) {
						ManagerMain manMain;
						manMain = new ManagerMain(connection, user);
						manMain.setVisible(true);
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Username or Password is incorrect");
					passwordField.setText("");
				}
			}
		});
		frame.getContentPane().add(btnLogin);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBounds(372, 281, 89, 25);
		btnReset.setBackground(new Color(59, 89, 182));
		btnReset.setForeground(Color.WHITE);
		btnReset.setFocusPainted(false);
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldUsername.setText("");
				passwordField.setText("");
			}
		});
		frame.getContentPane().add(btnReset);
//		Image loginImg = new ImageIcon(this.getClass().getResource("/user-login-icon.png")).getImage();
		
		JLabel isConnected = new JLabel("");
		isConnected.setOpaque(true);
		if (this.connection != null) {
			isConnected.setText("Connected To DB!");
			isConnected.setBackground(Color.GREEN);
			isConnected.setForeground(Color.WHITE);
		}
		else {
			isConnected.setText("Not Connected To DB!");
			isConnected.setBackground(Color.RED);
			isConnected.setForeground(Color.BLACK);
		}
		isConnected.setBounds(437, 0, 115, 25);
		frame.getContentPane().add(isConnected);
		
		JLabel lblNewLabel = new JLabel("New label");
		Image loginImg2 = new ImageIcon(this.getClass().getResource("/icons/ubisoft.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(loginImg2));
		lblNewLabel.setBounds(12, 123, 200, 147);
		frame.getContentPane().add(lblNewLabel);
		
		Login.choice = new Choice();
		choice.setFont(new Font("Dialog", Font.BOLD, 18));
		choice.add("Employee");
		choice.add("Manager");
		choice.setBounds(292, 235, 155, 30);
		frame.getContentPane().add(choice);
	}
}
