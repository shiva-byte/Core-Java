package pro.gui;

import java.awt.BorderLayout;
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
import java.sql.*;
import javax.swing.ImageIcon;

public class NewUpdate extends JFrame implements ActionListener
{

	private JPanel contentPane;
	private JTextField txtdid;
	private JTextField txttts;
	private JTextField txtavs;
	private JTextField txtrto;
	private JTextField txtrfrom;
	private JTextField txtstatus;
	private PreparedStatement psselect,psupdate;
	private Connection cn;
	private java.sql.ResultSet rs;
	private JLabel lblbusno;
	private JButton button;
	private JLabel label;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewUpdate frame = new NewUpdate();
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
	public NewUpdate()
	{
		cn=CrudOperation.createConnection();
		createGui();
		
		
		
		try
    	{
	 		
    	String strsql="select * from busentry where busNo=?";
		psselect=cn.prepareStatement(strsql);
		psselect.setString(1, ViewBus.bno);
		

		rs=psselect.executeQuery();
		while(rs.next())
		{
			String busno=rs.getString("busNo");
			String driver=rs.getString("Driverid");
			String totalseats=rs.getString("TotalSeats");
			String available=rs.getString("AvailableSeats");
			String rto=rs.getString("RouteTo");
			String rfrom=rs.getString("RouteFrom");
			String status=rs.getString("status");
			
			
			lblbusno.setText(busno);
			txtdid.setText(driver);
			txttts.setText(totalseats);
			txtavs.setText(available);
			txtrto.setText(rto);
			txtrfrom.setText(rfrom);
			txtstatus.setText(status);
			
		}
		
    	}catch(SQLException sq)
    	{
    		System.out.println(sq);
    	}
		
		
		
		
		
		
		
		
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
		lblBusNo.setFont(new Font("Gabriola", Font.BOLD, 22));
		lblBusNo.setBounds(591, 85, 80, 20);
		contentPane.add(lblBusNo);
		
		JLabel lblDriverId = new JLabel("Driver Id");
		lblDriverId.setFont(new Font("Gabriola", Font.BOLD, 22));
		lblDriverId.setBounds(591, 153, 80, 20);
		contentPane.add(lblDriverId);
		
		txtdid = new JTextField();
		txtdid.setBounds(871, 153, 86, 20);
		contentPane.add(txtdid);
		txtdid.setColumns(10);
		
		JLabel lblTootalSeats = new JLabel("Total Seats");
		lblTootalSeats.setFont(new Font("Gabriola", Font.BOLD, 22));
		lblTootalSeats.setBounds(591, 221, 91, 31);
		contentPane.add(lblTootalSeats);
		
		txttts = new JTextField();
		txttts.setBounds(871, 226, 86, 20);
		contentPane.add(txttts);
		txttts.setColumns(10);
		
		JLabel lblAvailableSeats = new JLabel("Available seats");
		lblAvailableSeats.setFont(new Font("Gabriola", Font.BOLD, 22));
		lblAvailableSeats.setBounds(591, 303, 121, 20);
		contentPane.add(lblAvailableSeats);
		
		txtavs = new JTextField();
		txtavs.setBounds(871, 303, 86, 20);
		contentPane.add(txtavs);
		txtavs.setColumns(10);
		
		JLabel lblRouteTo = new JLabel("Route To");
		lblRouteTo.setFont(new Font("Gabriola", Font.BOLD, 22));
		lblRouteTo.setBounds(591, 376, 91, 17);
		contentPane.add(lblRouteTo);
		
		txtrto = new JTextField();
		txtrto.setBounds(871, 374, 86, 20);
		contentPane.add(txtrto);
		txtrto.setColumns(10);
		
		JLabel lblRouteFrom = new JLabel("Route From");
		lblRouteFrom.setFont(new Font("Gabriola", Font.BOLD, 22));
		lblRouteFrom.setBounds(591, 443, 121, 20);
		contentPane.add(lblRouteFrom);
		
		txtrfrom = new JTextField();
		txtrfrom.setBounds(871, 443, 86, 20);
		contentPane.add(txtrfrom);
		txtrfrom.setColumns(10);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setFont(new Font("Gabriola", Font.BOLD, 21));
		lblStatus.setBounds(591, 500, 91, 20);
		contentPane.add(lblStatus);
		
		txtstatus = new JTextField();
		txtstatus.setBounds(871, 500, 86, 20);
		contentPane.add(txtstatus);
		txtstatus.setColumns(10);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Gabriola", Font.BOLD, 27));
		btnUpdate.addActionListener(this);
		btnUpdate.setBounds(727, 588, 141, 31);
		contentPane.add(btnUpdate);
		
	    lblbusno = new JLabel("");
		lblbusno.setFont(new Font("Gabriola", Font.BOLD, 19));
		lblbusno.setBounds(871, 85, 86, 20);
		contentPane.add(lblbusno);
		
		button = new JButton("");
		button.addActionListener(this);
		button.setIcon(new ImageIcon(NewUpdate.class.getResource("/pro/images/adjusthome.jpg")));
		button.setBounds(1316, 0, 33, 35);
		contentPane.add(button);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(NewUpdate.class.getResource("/pro/images/upgrade-software-gestionale-illimitati.png")));
		label.setBounds(0, 0, 1349, 730);
		contentPane.add(label);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		
    	String Caption=e.getActionCommand();
			
			if (Caption.equals("Update"))
			{
		
			try {
				 String busupdate="update busentry set DriverId=?, TotalSeats=?, AvailableSeats=?, RouteTo=?, RouteFrom=?,status=? where busNo=?";
		     
			    psupdate=cn.prepareStatement(busupdate);
				String driver=txtdid.getText();
				String totalseats=txttts.getText();
				String availableseats= txtavs.getText();
				String rto=txtrto.getText();
				String rfrom=txtrfrom.getText();
				String status= txtstatus.getText();
				
				psupdate.setString(1, driver);
				psupdate.setString(2, totalseats);
				psupdate.setString(3, availableseats);
				psupdate.setString(4, rto);
				psupdate.setString(5, rfrom);
				psupdate.setString(6, status);
				psupdate.setString(7, ViewBus.bno);
				int row1=psupdate.executeUpdate();
				if(row1>0)
				{
					
			JOptionPane.showMessageDialog(this, "dataupdated", "updation", JOptionPane.INFORMATION_MESSAGE);
			
				}
				

								
							}
							catch(SQLException  se)
							{
								
								System.out.println(se);
							}
							
						}
			if(Caption.equals(""))
			{
				RegistrationPortal rg= new RegistrationPortal();
				rg.setVisible(true);
				this.dispose();
			}


}
}
