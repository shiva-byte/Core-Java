package pro.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.dbtable.CrudOperation;
import com.mysql.jdbc.ResultSetMetaData;

public class BusTable extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private PreparedStatement pscount,psdata;
	private ResultSet rscount,rsdata;
	private Connection cn;
	String[][]data;
	String colnames[]={"BusNo","DriverId","TotalSeats","AvailableSeats","RouteTo","RouteFrom","Status"};
	
		
	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BusTable frame = new BusTable();
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
	public BusTable() {
		cn=CrudOperation.createConnection();
		createGui();
		
	}
	
	public void createGui()
	
	
	{
		
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 804, 590);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(50, 50, 624, 456);
		contentPane.add(scrollPane);
		table = new JTable();
		table.setRowHeight(50);
		table.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));
		fillData();
		table.setModel(new DefaultTableModel(
			data,
			colnames
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(166);
		table.getColumnModel().getColumn(1).setPreferredWidth(189);
		table.getColumnModel().getColumn(2).setPreferredWidth(88);
		table.getColumnModel().getColumn(3).setPreferredWidth(88);
		table.getColumnModel().getColumn(4).setPreferredWidth(88);
		table.getColumnModel().getColumn(5).setPreferredWidth(88);
		table.getColumnModel().getColumn(6).setPreferredWidth(88);
		JTableHeader header = table.getTableHeader();
	      header.setBackground(Color.white);
	      header.setForeground(Color.black);
	      header.setFont(new Font("Arial", Font.BOLD, 20));
		table.setBorder(new LineBorder(Color.black, 3));
		table.setFillsViewportHeight(true);
		table.setBackground(Color.white);
		table.setForeground(Color.black);
		scrollPane.setViewportView(table);
	}
	
	
	 void fillData()
		{
		 
		
		
	String strcount="select count(*) from busentry";
	//String strcount="select count(*) from course where courseduration=?";

	try{
		
		/*DatabaseMetaData ds=cn.getMetaData();
		*/
		
			
		pscount=cn.prepareStatement(strcount);
		
		rscount=pscount.executeQuery();
		rscount.next();
		int cnt=rscount.getInt(1);
		data=new String[cnt][7];
		
	//String strdata="select * from course";
	
String strdata="select * from busentry";
	psdata=cn.prepareStatement(strdata);
	
	System.out.println(psdata);
	rsdata=psdata.executeQuery();
	
	
	/*java.sql.ResultSetMetaData rsmd=rsdata.getMetaData();
	
		int totalcount=	rsmd.getColumnCount();
		
		rsmd.getColumnName(column)*/
	int row=0;
	int flag=0;
	while(rsdata.next())
	{	flag=1;
    	data[row][0]=rsdata.getString("busNo");
		data[row][1]=rsdata.getString("DriverId");
		data[row][2]=rsdata.getString("TotalSeats");
		data[row][3]=rsdata.getString("AvailableSeats");
		data[row][4]=rsdata.getString("RouteTo");
		data[row][5]=rsdata.getString("RouteFrom");
		data[row][6]=rsdata.getString("status");
		
		
		
		row++;
		
	}
	if(flag==0)
	{
		JOptionPane.showMessageDialog(this, "no  data present");
		
	}
		
	
		
		
	}
	catch(SQLException se)
	{
		System.out.println(se);
	}
		
		
			
			
			
		
}

	
	
	
}
