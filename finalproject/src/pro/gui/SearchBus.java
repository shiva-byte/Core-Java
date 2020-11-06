package pro.gui;

import java.awt.BorderLayout;
import java.sql.*;
import java.awt.event.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.dbtable.CrudOperation;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Rectangle;

public class SearchBus extends JFrame implements ActionListener

{

	private JPanel contentPane;
	private JTextField txtbusno;
	private PreparedStatement psdelete,psdelete2;
	private Connection cn;
	public static String bno;
	private int rw;
	private JButton btnSubmit;
	
	

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchBus frame = new SearchBus();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public SearchBus() 
	{
		setTitle("Search Bus");
		setBounds(new Rectangle(0, 0, 1366, 768));
		cn= CrudOperation.createConnection();
		createGui();
		
	}
	public void createGui()
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 630, 584);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBusNo = new JLabel("Bus No");
		lblBusNo.setFont(new Font("Gabriola", Font.BOLD, 19));
		lblBusNo.setBounds(155, 196, 92, 14);
		contentPane.add(lblBusNo);
		
		txtbusno = new JTextField();
		txtbusno.setBounds(306, 193, 86, 20);
		contentPane.add(txtbusno);
		txtbusno.setColumns(10);
		
		btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(this);
		btnSubmit.setBounds(189, 332, 89, 23);
		contentPane.add(btnSubmit);

	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String Caption= e.getActionCommand();
		bno=txtbusno.getText();
		if(bno.isEmpty())
		{
			JOptionPane.showMessageDialog(this, "Enter the busno", "Error", NORMAL);
		}
		else
		{
		
		if(Caption.equals("Submit"))
		{
			if(checkbusno(bno)==true) {
		
			SearchBus bu= new SearchBus();
			bu.setVisible(true);
		}
			else
			{
				JOptionPane.showMessageDialog(this, "No such busno found", "Wrong Credential", NORMAL);
			}
		}
		
			}
			
			}
		
			
		
		
	
	public boolean checkbusno(String bno)
	{
		
		try
		{
			String strsql="select busNo from busentry where busNo=?";
			psdelete2=cn.prepareStatement(strsql);
			psdelete2.setString(1, bno);
			ResultSet rs = psdelete2.executeQuery();
			if(rs.next()) //next method to move in dataset
			return true;

}
		catch(SQLException se)
		{
			System.out.println(se);
		}
		return false;

		
	}
}
