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

public class BusDetails extends JFrame implements ActionListener
{

	private JPanel contentPane;
	private PreparedStatement psselect,psupdate;
	private Connection cn;
	private java.sql.ResultSet rs;
	private JLabel lblbusno,lbldr,lblts,lblas,lblrto,lblfrom,lblst;
	private JButton button;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BusDetails frame = new BusDetails();
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
	public BusDetails()
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
			lbldr.setText(driver);
			lblts.setText(totalseats);
			lblas.setText(available);
			lblrto.setText(rto);
			lblfrom.setText(rfrom);
			lblst.setText(status);
			
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
		lblBusNo.setFont(new Font("Gabriola", Font.BOLD, 21));
		lblBusNo.setBounds(489, 185, 80, 26);
		contentPane.add(lblBusNo);
		
		JLabel lblDriverId = new JLabel("Driver Id");
		lblDriverId.setFont(new Font("Gabriola", Font.BOLD, 21));
		lblDriverId.setBounds(489, 236, 80, 36);
		contentPane.add(lblDriverId);
		
		JLabel lblTootalSeats = new JLabel("Total Seats");
		lblTootalSeats.setFont(new Font("Gabriola", Font.BOLD, 21));
		lblTootalSeats.setBounds(489, 297, 91, 30);
		contentPane.add(lblTootalSeats);
		
		JLabel lblAvailableSeats = new JLabel("Available seats");
		lblAvailableSeats.setFont(new Font("Gabriola", Font.BOLD, 21));
		lblAvailableSeats.setBounds(489, 358, 121, 30);
		contentPane.add(lblAvailableSeats);
		
		JLabel lblRouteTo = new JLabel("Route To");
		lblRouteTo.setFont(new Font("Gabriola", Font.BOLD, 21));
		lblRouteTo.setBounds(489, 420, 91, 23);
		contentPane.add(lblRouteTo);
		
		JLabel lblRouteFrom = new JLabel("Route From");
		lblRouteFrom.setFont(new Font("Gabriola", Font.BOLD, 21));
		lblRouteFrom.setBounds(489, 477, 121, 23);
		contentPane.add(lblRouteFrom);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setFont(new Font("Gabriola", Font.BOLD, 21));
		lblStatus.setBounds(489, 539, 101, 23);
		contentPane.add(lblStatus);
		
	    lblbusno = new JLabel("");
		lblbusno.setFont(new Font("Gabriola", Font.BOLD, 19));
		lblbusno.setBounds(816, 197, 86, 26);
		contentPane.add(lblbusno);
		
		lbldr = new JLabel("");
		lbldr.setBounds(822, 247, 80, 25);
		contentPane.add(lbldr);
		
		lblts = new JLabel("");
		lblts.setBounds(822, 297, 80, 30);
		contentPane.add(lblts);
		
		lblas = new JLabel("");
		lblas.setBounds(822, 374, 80, 26);
		contentPane.add(lblas);
		
		lblrto = new JLabel("");
		lblrto.setBounds(822, 429, 80, 26);
		contentPane.add(lblrto);
		
		lblfrom = new JLabel("");
		lblfrom.setBounds(822, 477, 80, 23);
		contentPane.add(lblfrom);
		
		lblst = new JLabel("");
		lblst.setBounds(822, 539, 80, 26);
		contentPane.add(lblst);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Gabriola", Font.BOLD, 25));
		btnBack.setBounds(647, 645, 110, 36);
		contentPane.add(btnBack);
		
		button = new JButton("");
		button.addActionListener(this);
		button.setIcon(new ImageIcon(BusDetails.class.getResource("/pro/images/adjusthome.jpg")));
		button.setBounds(1317, 0, 33, 30);
		contentPane.add(button);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(BusDetails.class.getResource("/pro/images/b6.jpg")));
		label.setBounds(0, 0, 1350, 729);
		contentPane.add(label);
	}


	@Override
	public void actionPerformed(ActionEvent e)
	{
		
    	String Caption=e.getActionCommand();
		if (Caption.equals("Back"))
				{
			      RegistrationPortal rp=new RegistrationPortal();
			      rp.setVisible(true);
			      this.dispose();
			
			
			
			
			
			
		
	}if(Caption.equals(""))
	{
		RegistrationPortal rg= new RegistrationPortal();
		rg.setVisible(true);
		this.dispose();
	}

}
}