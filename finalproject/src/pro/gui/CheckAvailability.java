package pro.gui;
import java.sql.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Rectangle;
import java.awt.TrayIcon.MessageType;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.dbtable.CrudOperation;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;

public class CheckAvailability extends JFrame implements ActionListener,KeyListener
{

	private JPanel contentPane;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private PreparedStatement psentry,pscheck;
	private Connection cn;
	private ResultSet rs,rs1;
	private JComboBox comboBox_2; 
		private int avail=0;
	 static String b;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckAvailability frame = new CheckAvailability();
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
	
	public void fillCombo()
	{
	
		try {
			String strsql="select RouteFrom from busentry";
			psentry=cn.prepareStatement(strsql);
			rs=psentry.executeQuery();
			while(rs.next())
			{
				String rto= rs.getString("RouteFrom");
				comboBox.addItem(rto);
			}
		}
		catch(SQLException se)
		{
			System.out.println(se);
		}
		finally {
			try {
				psentry.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
				
	}	
	public void fillCombo_1()
	{
	
		try {
			String strsql="select RouteTo from busentry";
			psentry=cn.prepareStatement(strsql);
			rs=psentry.executeQuery();
			while(rs.next())
			{
				String rtf= rs.getString("RouteTo");
				comboBox_1.addItem(rtf);
				
			}
		}
		catch(SQLException se)
		{
			System.out.println(se);
		}
		finally {
			try {
				psentry.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
				
	}	
	public void fillCombo_2()
	{
		String altto=(String) comboBox.getSelectedItem();
		String altfom=(String) comboBox_1.getSelectedItem();
		String sql2="select busNo from busentry where RouteTo =? and Routefrom=?";
	
		
			try {
				psentry=cn.prepareStatement(sql2);
				psentry.setString(1, altfom);
				psentry.setString(2, altto);
				rs1=psentry.executeQuery();
				
			
				
				  while(rs1.next())
				{

				String buso=rs1.getString("busNo");
				comboBox_2.addItem(buso);
				
			}} 
				catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	
		
		
		
	
		
	}
				
				
	public CheckAvailability()
	{
		cn= CrudOperation.createConnection();
		setTitle("CheckAvailability");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(new Rectangle(0, 0, 1366, 768));
		contentPane = new JPanel();
		contentPane.setBackground(new Color(173, 216, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSelectRoute = new JLabel("Select Route From");
		lblSelectRoute.setFont(new Font("Gabriola", Font.BOLD, 23));
		lblSelectRoute.setBounds(402, 147, 157, 37);
		contentPane.add(lblSelectRoute);
		
		JLabel lblSelectRouteFrom = new JLabel(" Select Route To");
		lblSelectRouteFrom.setFont(new Font("Gabriola", Font.BOLD, 23));
		lblSelectRouteFrom.setBounds(402, 247, 139, 37);
		contentPane.add(lblSelectRouteFrom);
		
	    comboBox = new JComboBox();
	    comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select Starting Point"}));
	   	    fillCombo();
		comboBox.setBounds(951, 151, 117, 29);
		contentPane.add(comboBox);
		
		comboBox_1 = new JComboBox();
		
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Select Destination"}));
		fillCombo_1();
	    comboBox_1.addActionListener(this);
		comboBox_1.setBounds(951, 251, 117, 29);
		contentPane.add(comboBox_1);
		
		JLabel lblSelectBus = new JLabel("Select Busses");
		lblSelectBus.setFont(new Font("Gabriola", Font.BOLD, 22));
		lblSelectBus.setBounds(403, 334, 104, 37);
		contentPane.add(lblSelectBus);
	 /*  comboBox_2 = new JComboBox();
	   fillCombo_2();
	    
		comboBox_2.setBounds(203, 177, 104, 20);
		contentPane.add(comboBox_2);*/
		
		JButton btnCheckAvailability = new JButton("Check Availability");
		btnCheckAvailability.setFont(new Font("Gabriola", Font.BOLD, 23));
		btnCheckAvailability.addActionListener(this);
		btnCheckAvailability.setBounds(508, 524, 175, 37);
		contentPane.add(btnCheckAvailability);
		
		JButton btnNewButton = new JButton("Proceed");
		btnNewButton.setFont(new Font("Gabriola", Font.BOLD, 23));
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(882, 524, 104, 37);
		contentPane.add(btnNewButton);
		
		/*JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(CheckAvailability.class.getResource("/pro/images/b6.jpg")));
		lblNewLabel.setBounds(0, 0, 1350, 729);
		contentPane.add(lblNewLabel);*/
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		String caption = e.getActionCommand();
		String combo1=(String)comboBox.getSelectedItem();
		String combo=(String)comboBox_1.getSelectedItem();
		if(combo.equalsIgnoreCase("Select Destination")||combo1.equalsIgnoreCase("Select Starting Point"))
		{
			JOptionPane.showMessageDialog(this, "Select Starting And Destination Point");
			
		}

		else 
		{
		if(e.getSource().equals(comboBox_1))
		{
			comboBox_2 = new JComboBox();
		    comboBox_2.addActionListener(this);
		    
			comboBox_2.setBounds(964, 334, 104, 20);
			 fillCombo_2();
			contentPane.add(comboBox_2);
			 getavail();
		}
		{
			
		}
		
		if (caption.equals("Proceed"))
		{
			if(avail>0)
			{
			StudentRegistration sr=new StudentRegistration();
			sr.setVisible(true);
			this.dispose();
		    }
			else 
			{
				JOptionPane.showMessageDialog(this, "No seat Available in this Bus", "Information", NORMAL);
			}
		 }
	     
		if(caption.equals("Check Availability"))
		{
			if(avail>0)
			JOptionPane.showMessageDialog(this, "Available Seats"+avail, "Availability Info",DO_NOTHING_ON_CLOSE );
			
				
		}
		}		
	}			
		
			
		public void getavail()
		{
			String combo2=(String)comboBox_2.getSelectedItem();
			b=combo2;
			String avl= "select AvailableSeats from busentry where busNo=? ";
			try {
				pscheck= cn.prepareStatement(avl);
				pscheck.setString(1, combo2);
				rs1=pscheck.executeQuery();
				if(rs1.next())
				{
					avail=rs1.getInt("AvailableSeats");
					}
			}
				catch(SQLException se)
				{
					
				}
			
		}
					
		
	

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
