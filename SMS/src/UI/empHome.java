package UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class empHome extends JFrame {

	private JPanel contentPane;
	private String Name;
	private int ID;

	JLabel lblNewLabel;
	
	public void setName(String name) {
		Name = name;
	}
	public void setID(int iD) {
		ID = iD;
	}

	
public void displayName()
{
	lblNewLabel.setText("Welcome," +Name + " Your ID is " + ID );
}
	public empHome() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		lblNewLabel = new JLabel("New label");
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
	}

}
