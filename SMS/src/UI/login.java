package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;

import Model.Employee;
import Model.Person;
import Model.Student;
import Model.myUtils;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField tfEmail;
	private JPasswordField tfPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();

					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "Error message", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public login() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 755, 553);
		
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 245, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTest = new JLabel("Student Management System");
		lblTest.setForeground(new Color(139, 0, 0));
		lblTest.setFont(new Font("Tahoma", Font.PLAIN, 44));
		lblTest.setBounds(83, 24, 632, 70);
		contentPane.add(lblTest);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 250, 250));
		panel.setBorder(new TitledBorder(null, "Log In Here", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(82, 140, 605, 316);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblMessage = new JLabel("");
		lblMessage.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMessage.setBounds(196, 73, 341, 20);
		panel.add(lblMessage);

		tfEmail = new JTextField();
		tfEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfEmail.setBounds(196, 106, 341, 32);
		panel.add(tfEmail);
		tfEmail.setColumns(10);

		tfPassword = new JPasswordField();
		tfPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfPassword.setBounds(196, 151, 341, 32);
		panel.add(tfPassword);

		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmail.setBounds(109, 114, 56, 16);
		panel.add(lblEmail);

		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPassword.setBounds(80, 156, 89, 20);
		panel.add(lblPassword);

		JComboBox cbPersonType = new JComboBox();
		cbPersonType.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cbPersonType.setModel(new DefaultComboBoxModel(new String[] { "Select Type", "Employee", "Student" }));
		cbPersonType.setBounds(195, 192, 342, 36);
		panel.add(cbPersonType);

		JLabel lblPersonType = new JLabel("Person Type :");
		lblPersonType.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPersonType.setBounds(58, 201, 107, 20);
		panel.add(lblPersonType);

		JButton btnNewButton = new JButton("Log In");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String email = tfEmail.getText().trim();
				String password = new String(tfPassword.getPassword());

				if (myUtils.isEmpty(email)) {
					lblMessage.setText("Please enter email.");
					lblMessage.setForeground(Color.red);
					tfEmail.requestFocus();
					return;
				}

				if (myUtils.isEmpty(password)) {
					lblMessage.setText("Please enter email.");
					lblMessage.setForeground(Color.red);
					tfPassword.requestFocus();
					return;
				}

				if (cbPersonType.getSelectedIndex() == 0) {
					lblMessage.setText("Please select person Type.");
					lblMessage.setForeground(Color.red);
					cbPersonType.requestFocus();
					return;
				}

				//for employee login
				if (cbPersonType.getSelectedIndex() == 1) {
					try {
						Employee e = new Employee();
						ResultSet rs =  e.Login(email, password);
						
						if(rs.next()) {
							empHome home = new  empHome();
							home.setName(rs.getString("Name"));
							home.setID(rs.getInt("EmployeeID"));
							home.displayName();
							
							home.setExtendedState(MAXIMIZED_BOTH);
							home.setVisible(true);
							dispose();
						}
						else
						{
							lblMessage.setText("Invalid email/password.");
							lblMessage.setForeground(Color.red);
						}
						
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, e.getMessage(), "System message", JOptionPane.INFORMATION_MESSAGE);
					}
					//for student login
				} else if (cbPersonType.getSelectedIndex() == 2) {
					try {
						Student s = new Student();
						ResultSet rs =  s.Login(email, password);
						
						if(rs.next()) {
							stdHome home= new stdHome();
							home.setExtendedState(MAXIMIZED_BOTH);
							home.setVisible(true);
							dispose();
						}
						else
						{
							lblMessage.setText("Invalid email/password.");
							lblMessage.setForeground(Color.red);
						}
						
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, e.getMessage(), "System message", JOptionPane.INFORMATION_MESSAGE);
					}

				}
			}
		});
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setIcon(new ImageIcon("C:\\D\\icons\\login"));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(196, 241, 124, 38);
		panel.add(btnNewButton);

	}
}
