
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import java.awt.Component;
import java.awt.Cursor;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.event.ActionEvent;
import java.awt.Choice;

@SuppressWarnings("serial")
public class EmployeeMain extends JFrame {
	private Connection conn = null;
	private JPanel contentPane;
	private String user;
	private Employee employee;
	private JTable table;

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public EmployeeMain(Connection connection, String userSend) throws IOException {
		this.conn = connection;
		this.user = userSend;
		this.employee = sqliteConnection.CreateEmployeeByEID(connection, userSend);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle(employee.GetFullName());
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		int xWinSize = 1200, yWinSize = 800;
		setSize(xWinSize, yWinSize);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(dim.width/2-xWinSize/2, dim.height/2-yWinSize/2);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("Button.shadow"));
		panel.setBounds(870, 13, 312, 502);
		panel.setBorder(BorderFactory.createLineBorder(Color.black));
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblMyInfo = new JLabel("My Info");
		lblMyInfo.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblMyInfo.setBounds(121, 13, 79, 24);
		panel.add(lblMyInfo);

		JLabel firstNameLabel = new JLabel("First Name:");
		firstNameLabel.setBounds(12, 50, 67, 16);
		panel.add(firstNameLabel);
		
		JLabel firstName = new JLabel(this.employee.GetFirstName());
		firstName.setBounds(132, 50, 167, 16);
		panel.add(firstName);
		
		JLabel lastNameLabel = new JLabel("Last Name:");
		lastNameLabel.setBounds(12, 79, 67, 16);
		panel.add(lastNameLabel);
		
		JLabel lastName = new JLabel(this.employee.GetLastName());
		lastName.setBounds(133, 79, 166, 16);
		panel.add(lastName);
		
		JLabel addressLabel = new JLabel("Address:");
		addressLabel.setBounds(12, 108, 56, 16);
		panel.add(addressLabel);
		
		JLabel address = new JLabel(this.employee.GetAddress());
		address.setBounds(133, 108, 166, 16);
		panel.add(address);
		
		JLabel startDateLabel = new JLabel("Start Date:");
		startDateLabel.setBounds(12, 137, 67, 16);
		panel.add(startDateLabel);
		
		JLabel startDate = new JLabel(Employee.ConvertDateToString(employee.GetStartDate()));
		startDate.setBounds(132, 137, 167, 16);
		panel.add(startDate);
		
		JLabel salaryLabel = new JLabel("Salary:");
		salaryLabel.setBounds(12, 166, 56, 16);
		panel.add(salaryLabel);
		 
		JLabel lblNewLabel = new JLabel(((Float)(employee.GetSalary())).toString());
		lblNewLabel.setBounds(133, 166, 56, 16);
		panel.add(lblNewLabel);
		
		JLabel numberOfTasksLabel = new JLabel("Number Of Tasks:");
		numberOfTasksLabel.setBounds(12, 195, 109, 16);
		panel.add(numberOfTasksLabel);
		
		JLabel numberOfTasks = new JLabel(((Integer)(this.employee.GetNumberOfTasks())).toString());
		numberOfTasks.setBounds(133, 195, 56, 16);
		panel.add(numberOfTasks);
		
		String imgUrl = "/workers/" + employee.GetFirstName() + ".jpg";
		JLabel lblNewLabel_1 = new JLabel("");
		Image loginImg = new ImageIcon(this.getClass().getResource(imgUrl)).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(loginImg));
		lblNewLabel_1.setBounds(12, 224, 287, 260);
		panel.add(lblNewLabel_1);
		
		JPanel taskPanel = new JPanel();
		taskPanel.setBounds(870, 538, 312, 191);
		contentPane.add(taskPanel);
		taskPanel.setLayout(null);
		
		table = new JTable();
		table.setBounds(42, 98, 225, 80);
		taskPanel.add(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
		
		JLabel tasksLabel = new JLabel("Tasks");
		tasksLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		tasksLabel.setBounds(111, 13, 79, 24);
		taskPanel.add(tasksLabel);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame exit = new JFrame("Logout");
				if (JOptionPane.showConfirmDialog(exit, "Confirm  to logout", "Login System", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					setVisible(false);
					Login.main(null);
				}
			}
		});
		btnLogout.setForeground(Color.WHITE);
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLogout.setFocusPainted(false);
		btnLogout.setBackground(new Color(255, 0, 102));
		btnLogout.setBounds(0, 0, 89, 25);
		contentPane.add(btnLogout);
		
		JPanel contacts = new JPanel();
		contacts.setBackground(UIManager.getColor("Button.shadow"));
		contacts.setBorder(BorderFactory.createLineBorder(Color.black));
		contacts.setBounds(12, 527, 256, 114);
		contentPane.add(contacts);
		contacts.setLayout(null);
		
		JLabel lblContacts = new JLabel("Contacts");
		lblContacts.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblContacts.setBounds(74, 13, 92, 22);
		contacts.add(lblContacts);
		
		Choice choice = new Choice();
		choice.setFont(new Font("Dialog", Font.BOLD, 12));
		ArrayList<Employee> namesOfOtherEmployees = sqliteConnection.GetAllEmployeeButOne(connection, this.employee);
		int numberOfOtherEmployees = namesOfOtherEmployees.size();
//		JOptionPane.showMessageDialog(null, namesOfOtherEmployees.get(i));
		choice.setName(" ");
		for (int i = 0; i< numberOfOtherEmployees; i++) {
			choice.add(namesOfOtherEmployees.get(i).GetFullName());
		}
		choice.setBounds(10, 41, 148, 22);
		contacts.add(choice);
		
		JLabel phoneNumber = new JLabel("", SwingConstants.CENTER);
		phoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
		phoneNumber.setBounds(25, 79, 187, 22);
		contacts.add(phoneNumber);
		
		JButton showPhone = new JButton("Show");
		showPhone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				phoneNumber.setText(namesOfOtherEmployees.get(choice.getSelectedIndex()).GetPhoneNumber());
			}
		});
		showPhone.setFont(new Font("Tahoma", Font.PLAIN, 9));
		showPhone.setBounds(169, 41, 75, 22);
		contacts.add(showPhone);

//		Image loginImg = new ImageIcon(this.getClass().getResource(imgUrl)).getImage();
		Image buttonIcon = new ImageIcon(this.getClass().getResource("/icons/google.png")).getImage();
		
		Image buttonIconM = new ImageIcon(this.getClass().getResource("/icons/morfix.png")).getImage();
		
		Image buttonIconU = new ImageIcon(this.getClass().getResource("/icons/ubisoftlogo.png")).getImage();
		
		Image buttonIconY = new ImageIcon(this.getClass().getResource("/icons/youtube.png")).getImage();
		
		JPanel links = new JPanel();
		links.setBackground(UIManager.getColor("Button.shadow"));
		links.setBorder(BorderFactory.createLineBorder(Color.black));
		links.setBounds(12, 654, 256, 98);
		contentPane.add(links);
		links.setLayout(null);
		JButton btnGoogle = new JButton(new ImageIcon(buttonIcon));
		btnGoogle.setBounds(12, 51, 34, 34);
		links.add(btnGoogle);
		btnGoogle.setBorder(BorderFactory.createEmptyBorder());
		btnGoogle.setContentAreaFilled(false);
		btnGoogle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					java.awt.Desktop.getDesktop().browse(new URI("http://www.google.com"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (URISyntaxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		JButton btnMorfix = new JButton(new ImageIcon(buttonIconM));
		btnMorfix.setBounds(58, 51, 34, 34);
		links.add(btnMorfix);
		btnMorfix.setBorder(BorderFactory.createEmptyBorder());
		btnMorfix.setContentAreaFilled(false);
		btnMorfix.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					java.awt.Desktop.getDesktop().browse(new URI("https://www.morfix.co.il/"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (URISyntaxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		JButton btnUbiSoft = new JButton(new ImageIcon(buttonIconU));
		btnUbiSoft.setBounds(104, 51, 34, 34);
		links.add(btnUbiSoft);
		btnUbiSoft.setBorder(BorderFactory.createEmptyBorder());
		btnUbiSoft.setContentAreaFilled(false);

		btnUbiSoft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					java.awt.Desktop.getDesktop().browse(new URI("https://www.ubisoft.com/en-US/"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (URISyntaxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		JButton btnYouTube = new JButton(new ImageIcon(buttonIconY));
		btnYouTube.setBounds(150, 51, 34, 34);
		links.add(btnYouTube);
		btnYouTube.setBorder(BorderFactory.createEmptyBorder());
		btnYouTube.setContentAreaFilled(false);
		
		btnYouTube.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					java.awt.Desktop.getDesktop().browse(new URI("https://www.youtube.com/user/ubisoft"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (URISyntaxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
//		btnYouTube.addMouseMotionListener(new MouseMotionListener() {
//			
//			@Override
//			public void mouseMoved(MouseEvent e) {
//				final int x = e.getX();
//		        final int y = e.getY();
//		        // only display a hand if the cursor is over the items
//		        if (cellBounds != null && cellBounds.getHeight() cellBounds.get(x, y)) {
//		        	btnYouTube.setCursor(new Cursor(Cursor.HAND_CURSOR));
//		        } else {
//		        	btnYouTube.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
//		        }
//			}
//			
//			@Override
//			public void mouseDragged(MouseEvent e) {
//			}
//		});
		
		JLabel lblUsefulLinks = new JLabel("Useful Links");
		lblUsefulLinks.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblUsefulLinks.setBounds(55, 13, 133, 22);
		links.add(lblUsefulLinks);
		
		JLabel quote = new JLabel(sqliteConnection.GetQuote(connection));
		quote.setBounds(280, 690, 478, 62);
		contentPane.add(quote);
		
		JButton btnGenarate = new JButton("Genarate");
		btnGenarate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				quote.setText(sqliteConnection.GetQuote(connection));
			}
		});
		btnGenarate.setBounds(761, 709, 97, 25);
		contentPane.add(btnGenarate);
		
		JButton btnChangePassword = new JButton("Change Password");
		btnChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangePass changePassWin = new ChangePass(connection, userSend);
				changePassWin.setVisible(true);
			}
		});
		btnChangePassword.setBounds(91, 0, 135, 25);
		contentPane.add(btnChangePassword);
	}
}
