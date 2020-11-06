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

public class BusUpdate extends JFrame implements ActionListener
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
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BusUpdate frame = new BusUpdate();
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
	public BusUpdate()
	{
		cn=CrudOperation.createConnection();
		createGui();
		
		
		
		try
    	{
	 		
    	String strsql="select * from busentry where busNo=?";
		psselect=cn.prepareStatement(strsql);
		psselect.setString(1, BusEdit.bno);
		

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
		lblBusNo.setBounds(536, 170, 80, 30);
		contentPane.add(lblBusNo);
		
		JLabel lblDriverId = new JLabel("Driver Id");
		lblDriverId.setFont(new Font("Gabriola", Font.BOLD, 19));
		lblDriverId.setBounds(498, 244, 80, 14);
		contentPane.add(lblDriverId);
		
		txtdid = new JTextField();
		txtdid.setBounds(906, 241, 86, 20);
		contentPane.add(txtdid);
		txtdid.setColumns(10);
		
		JLabel lblTootalSeats = new JLabel("Total Seats");
		lblTootalSeats.setFont(new Font("Gabriola", Font.BOLD, 22));
		lblTootalSeats.setBounds(498, 306, 91, 20);
		contentPane.add(lblTootalSeats);
		
		txttts = new JTextField();
		txttts.setBounds(906, 306, 86, 20);
		contentPane.add(txttts);
		txttts.setColumns(10);
		
		JLabel lblAvailableSeats = new JLabel("Available seats");
		lblAvailableSeats.setFont(new Font("Gabriola", Font.BOLD, 22));
		lblAvailableSeats.setBounds(498, 367, 121, 30);
		contentPane.add(lblAvailableSeats);
		
		txtavs = new JTextField();
		txtavs.setBounds(906, 372, 86, 20);
		contentPane.add(txtavs);
		txtavs.setColumns(10);
		
		JLabel lblRouteTo = new JLabel("Route To");
		lblRouteTo.setFont(new Font("Gabriola", Font.BOLD, 22));
		lblRouteTo.setBounds(498, 438, 91, 17);
		contentPane.add(lblRouteTo);
		
		txtrto = new JTextField();
		txtrto.setBounds(906, 436, 86, 20);
		contentPane.add(txtrto);
		txtrto.setColumns(10);
		
		JLabel lblRouteFrom = new JLabel("Route From");
		lblRouteFrom.setFont(new Font("Gabriola", Font.BOLD, 19));
		lblRouteFrom.setBounds(498, 503, 121, 14);
		contentPane.add(lblRouteFrom);
		
		txtrfrom = new JTextField();
		txtrfrom.setBounds(906, 500, 86, 20);
		contentPane.add(txtrfrom);
		txtrfrom.setColumns(10);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setFont(new Font("Gabriola", Font.BOLD, 22));
		lblStatus.setBounds(498, 558, 103, 17);
		contentPane.add(lblStatus);
		
		txtstatus = new JTextField();
		txtstatus.setBounds(906, 556, 86, 20);
		contentPane.add(txtstatus);
		txtstatus.setColumns(10);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Gabriola", Font.BOLD, 22));
		btnUpdate.addActionListener(this);
		btnUpdate.setBounds(722, 636, 109, 36);
		contentPane.add(btnUpdate);
		
	    lblbusno = new JLabel("");
		lblbusno.setFont(new Font("Gabriola", Font.BOLD, 19));
		lblbusno.setBounds(906, 170, 86, 24);
		contentPane.add(lblbusno);
		
		button = new JButton("");
		button.addActionListener(this);
		button.setIcon(new ImageIcon(BusUpdate.class.getResource("/pro/images/adjusthome.jpg")));
		button.setBounds(1317, 0, 33, 30);
		contentPane.add(button);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(BusUpdate.class.getResource("/pro/images/upgrade-software-gestionale-illimitati.png")));
		lblNewLabel.setBounds(0, 0, 1350, 729);
		contentPane.add(lblNewLabel);
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
					psupdate.setString(7, BusEdit.bno);
					int row1=psupdate.executeUpdate();
					if(row1>0)
					{
						
				JOptionPane.showMessageDialog(this, "dataupdated", "updation", JOptionPane.INFORMATION_MESSAGE);
				this.dispose();
				
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
