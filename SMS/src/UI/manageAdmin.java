package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableColumn;

import Model.Admin;
import Model.myUtils;
import javafx.scene.paint.ImagePattern;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Color;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.UUID;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class manageAdmin extends JFrame {

	private JPanel contentPane;
	private JTable tableAdmin;
	private JTextField tfName;
	private JTextField tfSalary;
	
	private String defaultImage ="C:\\imagedata\\0.jpg";
	String parent ="C:\\imagedata\\";
	private String savepath="";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					manageAdmin frame = new manageAdmin();
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
	public manageAdmin() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 836, 438);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmAdd = new JMenuItem("Show");
		mntmAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Admin adm = new Admin();
					ResultSet rs =  adm.viewAdmin();
					tableAdmin.setModel(myUtils.buildTableModel(rs));
					//tableAdmin.removeColumn(tableAdmin.getColumnModel().getColumn(3));
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		});
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 13, 310, 351);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblImage = new JLabel("");
		lblImage.setIcon(new ImageIcon("C:\\imagedata\\0.jpg"));
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblImage.setBounds(101, 146, 150, 150);
		panel.add(lblImage);
		
		
		
		mnFile.add(mntmAdd);

		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				
			}
		});
		scrollPane.setBounds(334, 13, 472, 351);
		contentPane.add(scrollPane);
		
		//JPanel panel_1 = new JPanel();
		//scrollPane.setViewportView(panel_1);
		//panel_1.setLayout(null);
		
		tableAdmin = new JTable();
		tableAdmin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					int rowindex  = tableAdmin.getSelectedRow();
					if(rowindex>-1)
					{
						 tfName.setText(tableAdmin.getValueAt(rowindex, 1).toString());
						 tfSalary.setText(tableAdmin.getValueAt(rowindex, 2).toString());
						 String imgpath = tableAdmin.getValueAt(rowindex, 3).toString();
						
						 // System.out.println(imgpath);
						 lblImage.setIcon(new ImageIcon(imgpath));
						 savepath =  imgpath;
						 //System.out.println(tableAdmin.getValueAt(rowindex, 2).toString());
						 
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null,e.getMessage());
				}
			}
		});
		tableAdmin.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableAdmin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tableAdmin.setBounds(12, 13, 446, 323);
		scrollPane.setViewportView(tableAdmin);
		//panel_1.add(tableAdmin);
		
		
		
		
		JLabel lblMessage = new JLabel("");
		lblMessage.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMessage.setBounds(99, 13, 199, 26);
		panel.add(lblMessage);
		
		tfName = new JTextField();
		tfName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfName.setBounds(101, 49, 197, 36);
		panel.add(tfName);
		tfName.setColumns(10);
		
		tfSalary = new JTextField();
		tfSalary.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfSalary.setColumns(10);
		tfSalary.setBounds(101, 98, 197, 36);
		panel.add(tfSalary);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(26, 59, 64, 16);
		panel.add(lblNewLabel);
		
		JLabel lblSalary = new JLabel("Salary");
		lblSalary.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSalary.setBounds(26, 108, 64, 26);
		panel.add(lblSalary);
		

		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String name =tfName.getText().trim();
					double salary = Double.parseDouble(tfSalary.getText().trim());
					
					if(name=="")
					{
						lblMessage.setText("Enter name");
						tfName.requestFocus();
						return;
					}
					
					if(tfSalary.getText().trim()=="")
					{
						lblMessage.setText("Enter salary");
						tfSalary.requestFocus();
						return;
					}
					
					
					
					Admin adm = new Admin();
					adm.setImagePath(defaultImage);
					adm.setName(name);
					adm.setSalary(salary);
					
					if(savepath!="")
					{
						ImageIcon icon = (ImageIcon)lblImage.getIcon();
						Image image = icon.getImage();
						BufferedImage img = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_RGB);
						img.getGraphics().drawImage(image,0,0, null);
						File file = new File(savepath);
						ImageIO.write(img, "jpg", file);
						adm.setImagePath(savepath);
					}
					
					int r =  adm.addAdmin(adm); 

					if(r==1)
					{
						lblMessage.setText("admin Added.");
						lblMessage.setForeground(Color.GREEN);
						ResultSet rs =  adm.viewAdmin();
						tableAdmin.setModel(myUtils.buildTableModel(rs));
					}
					else
						lblMessage.setText("Not Added.");
				
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage());
				}
				
			}
		});
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(12, 313, 78, 25);
		panel.add(btnNewButton);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					int index = tableAdmin.getSelectedRow();
					if(index>-1)
					{
						int ID = Integer.parseInt(tableAdmin.getValueAt(index, 0).toString());
						//savepath = tableAdmin.getValueAt(index, 3).toString();
						String Name = tfName.getText().trim();
						double salary = Double.parseDouble(tfSalary.getText().trim());
						
						Admin a = new Admin();
						a.setAdminID(ID);
						a.setImagePath(savepath);
						a.setName(Name);
						a.setSalary(salary);
						
						if(savepath!="")
						{
							ImageIcon icon = (ImageIcon)lblImage.getIcon();
							Image image = icon.getImage();
							BufferedImage img = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_INT_RGB);
							img.getGraphics().drawImage(image,0,0, null);
							File file = new File(savepath);
							ImageIO.write(img, "jpg", file);
							a.setImagePath(savepath);
						}
						
						int r= a.udpateAdmin(a);
						if(r>0)
						{
							lblMessage.setText("Updaetd successfully");
							lblImage.setForeground(Color.GREEN);
							ResultSet rs =  a.viewAdmin();
							tableAdmin.setModel(myUtils.buildTableModel(rs));
							
							
							
						}
						
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage());
				}
			}
		});
		btnUpdate.setBackground(Color.WHITE);
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpdate.setBounds(101, 312, 89, 25);
		panel.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					int index =  tableAdmin.getSelectedRow();
					
					if(index>-1)
					{

						if(JOptionPane.showConfirmDialog(null, "Are you sure to delete?","System Message", JOptionPane.YES_NO_OPTION)==0)
						{
							int id = Integer.parseInt(tableAdmin.getValueAt(index, 0).toString());
							Admin a= new Admin();
							int result =  a.deleteAdmin(id);
							if(result==1)
							{
								lblMessage.setText("Admin Deleted");
								ResultSet rs =  a.viewAdmin();
								tableAdmin.setModel(myUtils.buildTableModel(rs));
								
								File file = new File(savepath);
								
								if(file.exists())
								{
									if(!file.getPath().toString().toLowerCase().equalsIgnoreCase(defaultImage))
									{
										file.delete();
									}
								}
							}
							else
								lblMessage.setText("Admin NOT Deleted");
						}
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null,e2.getMessage());
				}
			}
		});
		btnDelete.setBackground(Color.WHITE);
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDelete.setBounds(201, 312, 97, 25);
		panel.add(btnDelete);
		
		JButton btnNewButton_1 = new JButton("Change");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				JFileChooser fc = new JFileChooser();
				if(fc.showOpenDialog(null)==JFileChooser.APPROVE_OPTION)
				{
					
						try {
							File file=new File(fc.getSelectedFile().getAbsolutePath());
							Image  image = ImageIO.read(file);
							Image newImage =image.getScaledInstance(150, 150, Image.SCALE_DEFAULT);
							lblImage.setIcon(new ImageIcon(newImage));
							String id = UUID.randomUUID().toString();
							savepath = parent + id + ".jpg";
							//System.out.println("First " + savepath);
						} catch (IOException e1) {
							JOptionPane.showMessageDialog(null,e1.getMessage());
						}
					
				}
				
			}
			
			
		});
		btnNewButton_1.setBounds(12, 205, 78, 25);
		panel.add(btnNewButton_1);
	}
}
