package Model;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;

public class deptHome extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField tfName;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					deptHome frame = new deptHome();
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
	public deptHome() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 820, 618);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(SystemColor.activeCaption);
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmClose = new JMenuItem("Close");
		mnFile.add(mntmClose);
		
		JMenu mnDepartment = new JMenu("Department");
		menuBar.add(mnDepartment);
		
		JMenuItem mntmView = new JMenuItem("View Department");
		mntmView.setIcon(new ImageIcon(deptHome.class.getResource("/com/sun/java/swing/plaf/windows/icons/Inform.gif")));
		mnDepartment.add(mntmView);
		
		JSeparator separator = new JSeparator();
		mnDepartment.add(separator);
		
		JMenuItem mntmAddDepartment = new JMenuItem("Add Department");
		mntmAddDepartment.setIcon(new ImageIcon(deptHome.class.getResource("/javax/swing/plaf/metal/icons/ocean/floppy.gif")));
		mnDepartment.add(mntmAddDepartment);
		
		JMenuItem mntmDeleteDepartment = new JMenuItem("Delete Department");
		mntmDeleteDepartment.setIcon(new ImageIcon(deptHome.class.getResource("/javax/swing/plaf/metal/icons/ocean/error.png")));
		mnDepartment.add(mntmDeleteDepartment);
		
		JMenuItem mntmUpdateDepartment = new JMenuItem("Update department");
		mntmUpdateDepartment.setIcon(new ImageIcon(deptHome.class.getResource("/com/sun/javafx/scene/control/skin/caspian/fxvk-capslock-button.png")));
		mnDepartment.add(mntmUpdateDepartment);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setToolTipText("This shows all the controls");
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane.setBounds(42, 74, 719, 455);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("View Department", null, panel, null);
		panel.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBounds(0, 0, 714, 425);
		panel.add(panel_5);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		table.setBounds(56, 68, 611, 298);
		panel_5.add(table);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Delete Department", null, panel_2, null);
		panel_2.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("Select Department");
		comboBox.setBounds(77, 86, 411, 36);
		panel_2.add(comboBox);
		
		
		
		
		table_1 = new JTable();
		table_1.setBounds(77, 135, 544, 217);
		panel_2.add(table_1);
		
		department d = new department();
		ResultSet rs;
		try {
			rs = d.viewDepartment();
			//ResultSet r = rs;
			//table_1.setModel(myUtils.buildTableModel(r));
			
			while(rs.next())
			{
				comboBox.addItem(rs.getString("Name") + "-" + rs.getString("DepartmentID"));
				//System.out.println(rs.getString("Name"));
			}
			
			
			
		} catch (Exception e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		

		JLabel lblDeleteMessage = new JLabel("New label");
		lblDeleteMessage.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDeleteMessage.setBounds(77, 43, 544, 30);
		panel_2.add(lblDeleteMessage);
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedIndex()>0)
				{
					int index =  comboBox.getSelectedIndex();
					String item =comboBox.getSelectedItem().toString();
					long dID = Long.parseLong(item.substring(item.lastIndexOf("-")));
					try {
						department d = new department();
						int result = d.deleteDepartment(dID);
						if(result>0) {
							lblDeleteMessage.setText(dID + "deleted from databse");
							lblDeleteMessage.setForeground(Color.GREEN);
						}
						else {
							lblDeleteMessage.setText(dID + "CANNOT be deleted");
							lblDeleteMessage.setForeground(Color.RED);
						}
						
					} catch (Exception e2) {
						lblDeleteMessage.setText("Error:"+e2.getMessage());
						lblDeleteMessage.setForeground(Color.RED);
					}
					
					
				}
				
			}
		});
		btnNewButton.setBounds(500, 86, 121, 36);
		panel_2.add(btnNewButton);
		

		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(230, 230, 250));
		tabbedPane.addTab("Insert Department", null, panel_3, null);
		panel_3.setLayout(null);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(255, 255, 255));
		panel_6.setBounds(153, 97, 392, 240);
		panel_3.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Name :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(28, 84, 68, 28);
		panel_6.add(lblNewLabel_1);
		
		JLabel lblAddMessage = new JLabel("");
		lblAddMessage.setBounds(110, 52, 243, 16);
		panel_6.add(lblAddMessage);
		
		tfName = new JTextField();
		tfName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfName.setBounds(110, 81, 243, 31);
		panel_6.add(tfName);
		tfName.setColumns(10);
		
		JButton btnAddDepartment = new JButton("Add Department");
		btnAddDepartment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String name = tfName.getText().trim();
					if(myUtils.isEmpty(name))
					{
						lblAddMessage.setText("Please enter name");
						lblAddMessage.setForeground(Color.red);
						tfName.requestFocus();
						return;
					}
					
					department d = new department();
					d.setName(name);
				int result=	d.addDepartment(d);
				if(result>0) {
					lblAddMessage.setText("Department added");
					lblAddMessage.setForeground(Color.green);
					tfName.setText("");
				}
				else
				{
					lblAddMessage.setText("Department is not added");
					lblAddMessage.setForeground(Color.red);
				
				}
					
				} catch (Exception e2) {
										
				}
				
			}
		});
		btnAddDepartment.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAddDepartment.setBounds(110, 125, 173, 31);
		panel_6.add(btnAddDepartment);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Update Department", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblMessage = new JLabel("");
		lblMessage.setBounds(42, 58, 719, 16);
		contentPane.add(lblMessage);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Search Department", null, panel_4, null);
		
		JLabel lblNewLabel = new JLabel("Department Control");
		lblNewLabel.setForeground(SystemColor.textHighlight);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lblNewLabel.setBounds(152, 0, 494, 61);
		contentPane.add(lblNewLabel);
		
		
		JButton button = new JButton("Show Department");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				department d = new department();
				try {
					ResultSet rs= d.viewDepartment();
					table.setModel(myUtils.buildTableModel(rs));
				} catch (Exception e1) {
					lblMessage.setText("An error occured while showing departments.");
					lblMessage.setForeground(Color.RED);
				}
				
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button.setBounds(56, 13, 193, 42);
		panel_5.add(button);
		
		
		
		
		
		
	}
}
