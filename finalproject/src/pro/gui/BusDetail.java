package pro.gui;

import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.dbtable.CrudOperation;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;

public class BusDetail extends JFrame implements ActionListener {

	private JPanel contentPane;
	private Connection cn;
	private PreparedStatement psupdate, psdelete2;
	private ResultSet rs;
	private JLabel lblbusno;
	private JLabel lblid;
	private JLabel lbltts;
	private JLabel lblavs;
	private JLabel lblsts;
	private JLabel lblrtto;
	private JLabel lblrtf;
	private int rw;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BusDetail frame = new BusDetail();
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
	public BusDetail() {
		setTitle("Bus Detail");
		cn = CrudOperation.createConnection();
		createGui();
		get();

	}

	public void createGui() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(00, 00, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblBusNo = new JLabel("Bus No :");
		lblBusNo.setFont(new Font("Gabriola", Font.BOLD, 21));
		lblBusNo.setBounds(490, 157, 115, 23);
		contentPane.add(lblBusNo);

		JLabel lblDriverId = new JLabel("Driver Id :");
		lblDriverId.setFont(new Font("Gabriola", Font.BOLD, 21));
		lblDriverId.setBounds(490, 217, 115, 23);
		contentPane.add(lblDriverId);

		JLabel lblTotalSeats = new JLabel("Total Seats :");
		lblTotalSeats.setFont(new Font("Gabriola", Font.BOLD, 21));
		lblTotalSeats.setBounds(490, 270, 115, 23);
		contentPane.add(lblTotalSeats);

		JLabel lblAvailableSeats = new JLabel("Available Seats :");
		lblAvailableSeats.setFont(new Font("Gabriola", Font.BOLD, 21));
		lblAvailableSeats.setBounds(490, 318, 126, 30);
		contentPane.add(lblAvailableSeats);

		JLabel lblRouteTo = new JLabel("Route To :");
		lblRouteTo.setFont(new Font("Gabriola", Font.BOLD, 21));
		lblRouteTo.setBounds(490, 382, 115, 23);
		contentPane.add(lblRouteTo);

		JLabel lblRouteFrom = new JLabel("Route From :");
		lblRouteFrom.setFont(new Font("Gabriola", Font.BOLD, 21));
		lblRouteFrom.setBounds(490, 433, 126, 30);
		contentPane.add(lblRouteFrom);

		JLabel lblStatus = new JLabel("Status :");
		lblStatus.setFont(new Font("Gabriola", Font.BOLD, 21));
		lblStatus.setBounds(490, 491, 115, 23);
		contentPane.add(lblStatus);

		lblbusno = new JLabel("");

		lblbusno.setBounds(765, 166, 108, 14);
		contentPane.add(lblbusno);

		lblid = new JLabel("");

		lblid.setBounds(795, 226, 93, 14);
		contentPane.add(lblid);

		lbltts = new JLabel("");

		lbltts.setBounds(780, 279, 108, 14);
		contentPane.add(lbltts);

		lblavs = new JLabel("");

		lblavs.setBounds(780, 334, 93, 14);
		contentPane.add(lblavs);

		lblrtto = new JLabel("");

		lblrtto.setBounds(768, 391, 105, 14);
		contentPane.add(lblrtto);

		lblrtf = new JLabel("");

		lblrtf.setBounds(765, 449, 108, 14);
		contentPane.add(lblrtf);

		lblsts = new JLabel("");

		lblsts.setBounds(761, 500, 112, 14);
		contentPane.add(lblsts);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBackground(Color.LIGHT_GRAY);
		btnUpdate.addActionListener(this);
		btnUpdate.setFont(new Font("Gabriola", Font.BOLD, 19));
		btnUpdate.setBounds(531, 579, 89, 23);
		contentPane.add(btnUpdate);

		JButton btnDelete = new JButton("Delete");
		btnUpdate.addActionListener(this);
		btnDelete.setFont(new Font("Gabriola", Font.BOLD, 19));
		btnDelete.setBounds(738, 579, 89, 23);
		contentPane.add(btnDelete);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(this);
		btnNewButton.setIcon(new ImageIcon(BusDetail.class.getResource("/pro/images/adjusthome.jpg")));
		btnNewButton.setBounds(1316, 0, 34, 30);
		contentPane.add(btnNewButton);
		
		JLabel label = new JLabel("");
		label.setFont(new Font("Gabriola", Font.BOLD, 21));
		label.setIcon(new ImageIcon(BusDetail.class.getResource("/pro/images/b6.jpg")));
		label.setBounds(0, 0, 1350, 729);
		contentPane.add(label);

	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		try {
			
			
			String strsql="select * from busentry where busNo=?";
			psupdate=cn.prepareStatement(strsql);
			psupdate.setString(1, ViewBus.bno);
			rs=psupdate.executeQuery();
			if(rs.next())
			{
				String busno=rs.getString("busNo");
				String Driver=rs.getString("DriverId");
				String tts =rs.getString("TotalSeats");
				String avs= rs.getString("AvailableSeats");
				String rto=rs.getString("RouteTo");
				String frt=rs.getString("RouteFrom");
				String stats=rs.getString("status");
				
				lblbusno.setText(busno);
				lblid.setText(Driver);
				lbltts.setText(tts);
				lblavs.setText(avs);
				lblrtto.setText(rto);
				lblrtf.setText(frt);
				lblsts.setText(stats);
				
			}}catch(SQLException se)
	{
		}
			String Caption=e.getActionCommand();
			if(Caption=="Update")
			{
				NewUpdate bu=new NewUpdate();
				bu.setVisible(true);
				this.dispose();
			}
			if(Caption.equals(""))
			{
				RegistrationPortal rg= new RegistrationPortal();
				rg.setVisible(true);
				this.dispose();
			}
			if(Caption.equals("Delete"))
			{
				
			int confirm=0;
				if(checkbusno(ViewBus.bno)==true) 
				{
			
				  confirm = JOptionPane.showConfirmDialog(this, "are you sure to delete");
				if(confirm==0)
				{
				try
				{
				String sql="delete from busentry where busNo=? ";
				psdelete2= cn.prepareStatement(sql);
				psdelete2.setString(1,ViewBus.bno);
				rw=psdelete2.executeUpdate();
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

	}
	}
		
	public void get() {
		lblbusno.setText(ViewBus.bno);
		lblid.setText(ViewBus.drid);
		lbltts.setText(ViewBus.tseats);
		lblavs.setText(ViewBus.aseats);
		lblrtto.setText(ViewBus.rto);
		lblrtf.setText(ViewBus.rfrom);
		lblsts.setText(ViewBus.st);
	}

	public boolean checkbusno(String bno) {

		try {
			String strsql = "select busNo from busentry where busNo=?";
			psdelete2 = cn.prepareStatement(strsql);
			psdelete2.setString(1, bno);
			ResultSet rs = psdelete2.executeQuery();
			if (rs.next()) // next method to move in dataset
				return true;

		} catch (SQLException se) {

		}
		return false;
	}
}
