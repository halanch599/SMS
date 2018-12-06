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

import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class testJFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField tfName;
	private JTextField tfSearch;
	private JTable tblSearch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					testJFrame frame = new testJFrame();
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
	public testJFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 816, 569);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(12, 75, 774, 434);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("View Departments", null, panel, null);
		panel.setLayout(null);
		
		table = new JTable();
		table.setBounds(12, 88, 745, 303);
		panel.add(table);
		
		JButton btnNewButton = new JButton("Show Department");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				department d = new department();
				
					ResultSet rs = d.viewDepartment();
					table.setModel(myUtils.buildTableModel(rs));
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(221, 44, 205, 31);
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Add Department", null, panel_1, null);
		panel_1.setLayout(null);
		
		tfName = new JTextField();
		tfName.setBounds(127, 73, 521, 39);
		panel_1.add(tfName);
		tfName.setColumns(10);
		
		JLabel lblMessage = new JLabel("");
		lblMessage.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMessage.setBounds(126, 44, 522, 28);
		panel_1.add(lblMessage);
		
		JButton btnAdd = new JButton("Add Department");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String name = tfName.getText().trim();
					if(name=="")
					{
						lblMessage.setText("Please enter deparment name");
						lblMessage.setForeground(Color.RED);
						return;
					}
					
					department d = new department();
					int result = d.addDepartment(name);
					if(result>0)
					{
						lblMessage.setText("Deparment added");
						lblMessage.setForeground(Color.GREEN);	
					}
					else {
						lblMessage.setText("Deparment NOT added.");
						lblMessage.setForeground(Color.BLACK);
					}
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage(), "System Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAdd.setBounds(123, 141, 179, 39);
		panel_1.add(btnAdd);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblName.setBounds(44, 84, 56, 16);
		panel_1.add(lblName);
		
		
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Search Department", null, panel_2, null);
		panel_2.setLayout(null);
		
		tfSearch = new JTextField();
		tfSearch.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfSearch.setBounds(32, 41, 495, 42);
		panel_2.add(tfSearch);
		tfSearch.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 128, 613, 242);
		panel_2.add(scrollPane);
		
		tblSearch = new JTable();
		scrollPane.setViewportView(tblSearch);
		
		JButton btnNewButton_2 = new JButton("Search");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String name = tfSearch.getText().trim();
					department d = new department();
					ResultSet rs = d.searchDepartmentByName(name);
					tblSearch.setModel(myUtils.buildTableModel(rs));
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage(), "System Error",
							JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_2.setBounds(527, 41, 101, 42);
		panel_2.add(btnNewButton_2);
		
		
		
		
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Delete Department", null, panel_3, null);
	}
}
