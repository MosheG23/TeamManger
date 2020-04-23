import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class ChangePass extends JFrame {

	private JPanel contentPane;
	private Connection conn;
	private String user;
	private JTextField textField;
	
	/**
	 * Create the frame.
	 */
	
	public ChangePass(Connection conn, String user) {
		this.conn = conn;
		this.user = user;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 391, 191);
		contentPane = new JPanel();
		setTitle("Change Password");
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewPassword = new JLabel("New Password:");
		lblNewPassword.setBounds(48, 44, 111, 16);
		contentPane.add(lblNewPassword);
		
		JTextField newPassword = new JTextField();
		newPassword.setBounds(237, 41, 116, 22);
		contentPane.add(newPassword);
		newPassword.setColumns(10);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame change = new JFrame("Change");
				if (JOptionPane.showConfirmDialog(change, "Confirm  to change", "Change Password", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					sqliteConnection.ChangePassword(conn, user, newPassword.getText());
					JComponent comp = (JComponent) e.getSource();
					Window win = SwingUtilities.getWindowAncestor(comp);
					win.dispose();
				}
			}
		});
		btnConfirm.setBounds(135, 110, 97, 25);
		contentPane.add(btnConfirm);
	}
}
