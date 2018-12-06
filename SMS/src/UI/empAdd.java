package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import javax.swing.BoxLayout;
import javax.swing.ComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.sql.ResultSet;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JDateChooser;

import Model.Country;
import Model.Employee;
import Model.myUtils;

import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class empAdd extends JFrame {

	private JPanel contentPane;
	private JTextField tfName;
	private JTextField tfEmail;
	private JComboBox cbGender;
	private JTextField tfMobile;
	private JTextField tfSalary;
	private JLabel lblError;
	private JLabel lblWelcomeToEmployee;
	private JLabel lblNewLabel;
	private JLabel lblEmail;
	private JLabel lblPassword;
	private JLabel lblGender;
	private JLabel lblDateOfBirth;
	private JLabel lblHireDate;
	private JLabel lblMobileNo;
	private JLabel lblCountry;
	private JLabel lblSalary;
	private JLabel lblRole;
	private JLabel lblEmployeeType;
	private JLabel lblAddress;
	private JComboBox cbRole;
	private JComboBox cbEmpType;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JPasswordField tfPassword;
	private JLabel label_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					empAdd frame = new empAdd();
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
	public empAdd() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 881, 902);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("control"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("info"));
		
		lblWelcomeToEmployee = new JLabel("Welcome to Employee Management");
		lblWelcomeToEmployee.setForeground(new Color(100, 149, 237));
		lblWelcomeToEmployee.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToEmployee.setFont(new Font("Tahoma", Font.PLAIN, 30));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(44)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 766, Short.MAX_VALUE)
					.addGap(43))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(92, Short.MAX_VALUE)
					.addComponent(lblWelcomeToEmployee, GroupLayout.PREFERRED_SIZE, 708, GroupLayout.PREFERRED_SIZE)
					.addGap(53))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblWelcomeToEmployee, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 763, GroupLayout.PREFERRED_SIZE)
					.addGap(28))
		);
		panel.setLayout(null);
		
		tfName = new JTextField();
		tfName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfName.setBounds(206, 62, 442, 37);
		panel.add(tfName);
		tfName.setColumns(10);
		
		tfEmail = new JTextField();
		tfEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfEmail.setColumns(10);
		tfEmail.setBounds(206, 112, 442, 37);
		panel.add(tfEmail);
		
		cbGender = new JComboBox();
		cbGender.setModel(new DefaultComboBoxModel(new String[] {"Select Gender", "Male", "Female"}));
		cbGender.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cbGender.setBounds(206, 212, 442, 37);
		panel.add(cbGender);
		
		JDateChooser tfDOB = new JDateChooser();
		tfDOB.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfDOB.setDateFormatString("dd.MM.yyyy");
		tfDOB.setBounds(206, 262, 442, 37);
		panel.add(tfDOB);
		
		JDateChooser tfHD = new JDateChooser();
		tfHD.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfHD.setDateFormatString("dd.MM.yyyy");
		tfHD.setBounds(206, 312, 442, 37);
		panel.add(tfHD);
		
		tfMobile = new JTextField();
		tfMobile.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfMobile.setColumns(10);
		tfMobile.setBounds(206, 362, 442, 37);
		panel.add(tfMobile);
		
		tfSalary = new JTextField();
		tfSalary.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfSalary.setColumns(10);
		tfSalary.setBounds(206, 462, 442, 37);
		panel.add(tfSalary);
		
		JTextArea tfAddress = new JTextArea();
		tfAddress.setBackground(UIManager.getColor("controlLtHighlight"));
		tfAddress.setBounds(206, 615, 447, 72);
		panel.add(tfAddress);
		
		cbRole = new JComboBox();
		cbRole.setModel(new DefaultComboBoxModel(new String[] {"Select Role", "Admin", "Professor", "Assistant Professsor", "Operator"}));
		cbRole.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cbRole.setBounds(206, 512, 442, 37);
		panel.add(cbRole);
		
		cbEmpType = new JComboBox();
		cbEmpType.setModel(new DefaultComboBoxModel(new String[] {"Select Employee Type", "Fulltime", "Partime", "Visiting", "Temporary", "Permanent"}));
		cbEmpType.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cbEmpType.setBounds(206, 562, 442, 37);
		panel.add(cbEmpType);
		
		label = new JLabel("*");
		label.setForeground(Color.RED);
		label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label.setBounds(651, 74, 20, 16);
		panel.add(label);
		
		label_1 = new JLabel("*");
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_1.setBounds(651, 124, 20, 16);
		panel.add(label_1);
		
		label_2 = new JLabel("*");
		label_2.setForeground(Color.RED);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_2.setBounds(651, 174, 20, 16);
		panel.add(label_2);
		
		label_3 = new JLabel("*");
		label_3.setForeground(Color.RED);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_3.setBounds(651, 222, 20, 16);
		panel.add(label_3);
		
		label_4 = new JLabel("*");
		label_4.setForeground(Color.RED);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_4.setBounds(651, 271, 20, 16);
		panel.add(label_4);
		
		tfPassword = new JPasswordField();
		tfPassword.setBounds(206, 162, 442, 37);
		panel.add(tfPassword);
		
		JComboBox cbCountry = new JComboBox();
		cbCountry.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cbCountry.setBounds(206, 412, 442, 37);
		
		
		try {
			Country c = new Country();
			ResultSet rs =  c.listCountry();
			DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
			
			while(rs.next()) {
				model.addElement(rs.getString("Name"));
			}
			
			cbCountry.setModel(model);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		panel.add(cbCountry);
		
		
		
		JButton btnClear = new JButton("Clear");
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnClear.setBounds(374, 711, 119, 37);
		panel.add(btnClear);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		
		btnClose.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnClose.setBounds(505, 711, 119, 37);
		panel.add(btnClose);
		
		lblError = new JLabel("");
		lblError.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblError.setBounds(206, 33, 442, 16);
		panel.add(lblError);
		
		lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(77, 74, 89, 16);
		panel.add(lblNewLabel);
		
		lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEmail.setBounds(77, 124, 89, 16);
		panel.add(lblEmail);
		
		lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPassword.setBounds(77, 174, 89, 16);
		panel.add(lblPassword);
		
		lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblGender.setBounds(77, 224, 89, 16);
		panel.add(lblGender);
		
		lblDateOfBirth = new JLabel("Date of Birth");
		lblDateOfBirth.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDateOfBirth.setBounds(46, 283, 101, 16);
		panel.add(lblDateOfBirth);
		
		lblHireDate = new JLabel("Hire Date");
		lblHireDate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblHireDate.setBounds(77, 333, 89, 16);
		panel.add(lblHireDate);
		
		lblMobileNo = new JLabel("Mobile No");
		lblMobileNo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMobileNo.setBounds(77, 374, 89, 16);
		panel.add(lblMobileNo);
		
		lblCountry = new JLabel("Country");
		lblCountry.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCountry.setBounds(77, 424, 89, 25);
		panel.add(lblCountry);
		
		lblSalary = new JLabel("Salary");
		lblSalary.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSalary.setBounds(77, 474, 89, 25);
		panel.add(lblSalary);
		
		lblRole = new JLabel("Role");
		lblRole.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRole.setBounds(77, 524, 89, 16);
		panel.add(lblRole);
		
		lblEmployeeType = new JLabel("Employee Type");
		lblEmployeeType.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEmployeeType.setBounds(22, 577, 144, 25);
		panel.add(lblEmployeeType);
		
		lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAddress.setBounds(77, 636, 89, 16);
		panel.add(lblAddress);
		
		JButton btnAddEmployee = new JButton("Add ");
		btnAddEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String  Name = tfName.getText().trim();
					String  Email = tfEmail.getText().trim();
					String  Password = new String(tfPassword.getPassword());			
					String  MobileNo = tfMobile.getText().trim();
					float  Salary =  Float.parseFloat(tfSalary.getText().trim());
					String  Address = tfAddress.getText().trim();
					
					
					// validation
					if(myUtils.isEmpty(Name))
					{
						lblError.setText("Please enter your name.");
						tfName.requestFocus();
						lblError.setForeground(Color.RED);
						return;
					}
					
					if(myUtils.isEmpty(Email))
					{
						lblError.setText("Please enter your email.");
						tfEmail.requestFocus();
						lblError.setForeground(Color.RED);
						return;
					}
					
					if(myUtils.isEmpty(Password))
					{
						lblError.setText("Please enter your Password.");
						tfPassword.requestFocus();
						lblError.setForeground(Color.RED);
						return;
					}
					
					
					if(cbGender.getSelectedIndex()==0) {
						lblError.setText("Please select gender.");
						lblError.setForeground(Color.RED);
						cbGender.requestFocus();
						return;
					}
					String  Gender   =cbGender.getSelectedIndex()==1?"Male":"Female";
					
					String  DateOfBirth="";
					try {
						DateOfBirth = tfDOB.getDate().toString();
					} catch (Exception e2) {
						lblError.setText("Please select date of birth.");
						lblError.setForeground(Color.RED);
						tfDOB.requestFocus();
						return;
					}
					String  HireDate = "";
					try {
						HireDate = tfHD.getDate().toString();
					} catch (Exception e2) {
						lblError.setText("Please select hire date .");
						lblError.setForeground(Color.RED);
						tfDOB.requestFocus();
						return;
					}
					
					
					String  Role  = cbRole.getSelectedItem().toString();
					String  EmployementType = cbEmpType.getSelectedItem().toString();
					String  country = cbCountry.getSelectedItem().toString();

					Employee emp = new Employee();
					emp.setAddress(Address);
					emp.setCountry(country);
					emp.setDateofBirth(DateOfBirth);
					emp.setEmail(Email);
					emp.setEployeeType(EmployementType);
					emp.setGender(Gender);
					emp.setHireDate(HireDate);
					emp.setMobileNo(MobileNo);
					emp.setName(Name);
					emp.setPassword(Password);
					emp.setRole(Role);
					emp.setSalary(Salary);
					
					int result = emp.addEmployee(emp); 
					if(result>0)
					{
						lblError.setText("Employee Added successfully");
						lblError.setForeground(Color.GREEN);
					}
					else {
						lblError.setText("Could not add employee");
						lblError.setForeground(Color.black);
					}
					
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage(), "System Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnAddEmployee.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAddEmployee.setBounds(243, 711, 119, 37);
		panel.add(btnAddEmployee);
		
		label_5 = new JLabel("*");
		label_5.setForeground(Color.RED);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_5.setBounds(651, 322, 20, 16);
		panel.add(label_5);
		
		
		contentPane.setLayout(gl_contentPane);
	}
}
