package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;

import Model.myUtils;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
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
		lblTest.setBounds(82, 13, 632, 70);
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
		
		JButton btnNewButton = new JButton("Log In");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String email = tfEmail.getText().trim();
				String password = new String(tfPassword.getPassword());
				if(myUtils.isEmpty(email))
				{
					lblMessage.setText("Please enter email.");
					lblMessage.setForeground(Color.red);
					tfEmail.requestFocus();
					return;
				}
				
				if(myUtils.isEmpty(password))
				{
					lblMessage.setText("Please enter email.");
					lblMessage.setForeground(Color.red);
					tfPassword.requestFocus();
					return;
				}
			}
		});
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setIcon(new ImageIcon("C:\\D\\icons\\login"));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(196, 196, 124, 38);
		panel.add(btnNewButton);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmail.setBounds(109, 114, 56, 16);
		panel.add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPassword.setBounds(80, 156, 89, 20);
		panel.add(lblPassword);
	}
}
