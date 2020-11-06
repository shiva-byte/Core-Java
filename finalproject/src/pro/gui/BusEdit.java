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
import javax.swing.ImageIcon;
import java.awt.Color;

public class BusEdit extends JFrame implements ActionListener

{

	private JPanel contentPane;
	private JTextField txtbusno;
	private PreparedStatement psdelete,psdelete2;
	private Connection cn;
	public static String bno;
	private int rw;
	
	

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BusEdit frame = new BusEdit();
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
	public BusEdit() 
	{
		setTitle("Search Bus");
		setBounds(new Rectangle(0, 0, 1366, 768));
		cn= CrudOperation.createConnection();
		createGui();
		
	}
	public void createGui()
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(00, 00, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBusNo = new JLabel("Bus No");
		lblBusNo.setBackground(Color.LIGHT_GRAY);
		lblBusNo.setFont(new Font("Gabriola", Font.BOLD, 38));
		lblBusNo.setBounds(661, 226, 198, 58);
		contentPane.add(lblBusNo);
		
		txtbusno = new JTextField();
		txtbusno.setBounds(623, 327, 225, 38);
		contentPane.add(txtbusno);
		txtbusno.setColumns(10);
		
		JButton btnUpdateDetails = new JButton("Update Details");
		btnUpdateDetails.addActionListener(this);
		btnUpdateDetails.setFont(new Font("Gabriola", Font.BOLD, 23));
		btnUpdateDetails.setBounds(491, 467, 181, 58);
		contentPane.add(btnUpdateDetails);
		
		JButton btnDeleteRecord = new JButton("Delete Record");
		btnDeleteRecord.addActionListener(this);
		btnDeleteRecord.setFont(new Font("Gabriola", Font.BOLD, 23));
		btnDeleteRecord.setBounds(820, 467, 173, 58);
		contentPane.add(btnDeleteRecord);
		
		JButton button = new JButton("");
		button.addActionListener(this);
		button.setIcon(new ImageIcon(BusEdit.class.getResource("/pro/images/adjusthome.jpg")));
		button.setBounds(1317, 0, 33, 31);
		contentPane.add(button);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(BusEdit.class.getResource("/pro/images/buscliff.jpg")));
		lblNewLabel.setBounds(0, 0, 1350, 729);
		contentPane.add(lblNewLabel);

	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String Caption= e.getActionCommand();
		int confirm=0;
		bno=txtbusno.getText();
		if(Caption.equals(""))
		{
			RegistrationPortal rg= new RegistrationPortal();
			rg.setVisible(true);
			this.dispose();
		}else {
		if(bno.isEmpty())
		{
			JOptionPane.showMessageDialog(this, "Enter the busno", "Error", NORMAL);
		}
		else
		{
		
		if(Caption.equals("Update Details"))
		{
			if(checkbusno(bno)==true) {
		
			BusUpdate bu= new BusUpdate();
			bu.setVisible(true);
		}
			else
			{
				JOptionPane.showMessageDialog(this, "No such busno found", "Wrong Credential", NORMAL);
			}
		}
	
		if(Caption.equals("Delete Record"))
		{
			if(checkbusno(bno)==true) 
			{
		
			  confirm = JOptionPane.showConfirmDialog(this, "are u sure to delete");
			if(confirm==0)
			{
			try
			{
			String sql="delete from busentry where busNo=? ";
			psdelete= cn.prepareStatement(sql);
			psdelete.setString(1, bno);
			rw=psdelete.executeUpdate();
			if(rw>0)
			
				{
					JOptionPane.showMessageDialog(this, "Record Deleted Successfully");
				
				}
			
			
		}catch(SQLException sq)
			{
			System.out.println(sq);
			}
			
			}
			}
			else {
				JOptionPane.showMessageDialog(this,"no such bno present");
			}
			}
			
			}
		
			
		}}
		
	
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
