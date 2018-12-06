package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.department;
import Model.myUtils;

import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class testHome extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField tfName;
	private JTextField tfSearch;
	private JTable tableSearch;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					testHome frame = new testHome();
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
	public testHome() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 836, 565);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(12, 57, 783, 411);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Show Department", null, panel, null);
		panel.setLayout(null);
		
		table = new JTable();
		table.setBounds(12, 87, 754, 281);
		panel.add(table);
		
		JButton btnShowDepartment = new JButton("Show Department");
		btnShowDepartment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					department d = new department();
					ResultSet rs = d.viewDepartment();
						
					table.setModel(myUtils.buildTableModel(rs));
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage(), "System error",
							JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnShowDepartment.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnShowDepartment.setBounds(238, 38, 212, 36);
		panel.add(btnShowDepartment);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Add Department", null, panel_1, null);
		panel_1.setLayout(null);
		
		tfName = new JTextField();
		tfName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfName.setBounds(182, 105, 406, 39);
		panel_1.add(tfName);
		tfName.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblName.setBounds(87, 118, 68, 16);
		panel_1.add(lblName);
		
		JLabel lblMessage = new JLabel("");
		lblMessage.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMessage.setBounds(183, 65, 405, 28);
		panel_1.add(lblMessage);
		
		JButton btnAddDepartment = new JButton("Add Department");
		btnAddDepartment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String name = tfName.getText().trim();
					
					if(name=="")
					{
						lblMessage.setText("Please enter name.");
						tfName.requestFocus();
						lblMessage.setForeground(Color.RED);
						return;
					}
					
					department d = new department();
					int result = d.addDepartment(name);
					
					if(result>0)
					{
						lblMessage.setText("Department Added");
						lblMessage.setForeground(Color.GREEN);
					}
					else {
						lblMessage.setText("Not able to add.");
					}
					
					
				} catch (Exception e2) {
					
					JOptionPane.showMessageDialog(null, e2.getMessage(), "System error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnAddDepartment.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAddDepartment.setBounds(267, 169, 185, 39);
		panel_1.add(btnAddDepartment);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Search Department", null, panel_2, null);
		panel_2.setLayout(null);
		
		tfSearch = new JTextField();
		tfSearch.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfSearch.setBounds(24, 39, 616, 48);
		panel_2.add(tfSearch);
		tfSearch.setColumns(10);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String name =  tfSearch.getText().trim();
					if(name=="")
						return;
					
					
					department d = new department();
					
					ResultSet rs =  d.searchDepartmentByName(name);
					tableSearch.setModel(myUtils.buildTableModel(rs));
					
					
//					if(rs.next()) {
//					
//					}
					
				} catch (Exception e2) {
					
					JOptionPane.showMessageDialog(null, e2.getMessage(), "System error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\D\\icons\\search.png"));
		btnNewButton.setBounds(640, 37, 50, 50);
		panel_2.add(btnNewButton);
		
		tableSearch = new JTable();
		tableSearch.setBounds(24, 117, 680, 232);
		panel_2.add(tableSearch);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Delete Department", null, panel_3, null);
		panel_3.setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.setBounds(69, 59, 205, 33);
		panel_3.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(301, 63, 153, 33);
		panel_3.add(btnDelete);
	}

}
