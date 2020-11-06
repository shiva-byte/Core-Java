package pro.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.dbtable.CrudOperation;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import java.awt.event.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;

public class SearchStudent extends JFrame implements ActionListener
{

	private JPanel contentPane;
	private JTextField textid;
	public static String id;
	private PreparedStatement psdelete,psdelete2;
	private Connection cn;
	private int rw;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchStudent frame = new SearchStudent();
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
	public SearchStudent()
	{
	cn= CrudOperation.createConnection();
		create();
	}
	

	private void create()
	{
		setTitle("Update Student Detail");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(00, 00, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 102, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterStudentEnrollmentid = new JLabel("Enter  EnrollmentID");
		lblEnterStudentEnrollmentid.setFont(new Font("Gabriola", Font.BOLD, 32));
		lblEnterStudentEnrollmentid.setBounds(574, 227, 255, 47);
		contentPane.add(lblEnterStudentEnrollmentid);
		
		textid = new JTextField();
		textid.setBounds(557, 336, 288, 37);
		contentPane.add(textid);
		textid.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Gabriola", Font.BOLD, 26));
		btnSubmit.addActionListener(this);
		btnSubmit.setBounds(640, 471, 120, 37);
		contentPane.add(btnSubmit);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(SearchStudent.class.getResource("/pro/images/maxresdefault.jpg")));
		label.setBounds(66, 0, 1200, 720);
		contentPane.add(label);
		
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		String Caption= e.getActionCommand();
		int confirm=0;
		id=textid.getText();
		if(id.isEmpty())
		{
			JOptionPane.showMessageDialog(this, "Enter the EnrollmentId", "Error", NORMAL);
		}
		else
		{
		
		if(Caption.equals("Submit"))
		{
			if(checkenroll(id)==true) {
		
			StudentDetails su= new StudentDetails();
			su.setVisible(true);
			this.dispose();
		}
			else
			{
				JOptionPane.showMessageDialog(this, "No such EnrollmentId found", "Wrong Credential", NORMAL);
			}
		}
		}
		
		}
		
	
	public boolean checkenroll(String id)
	{
		
		try
		{
			String strsql="select EnrollmentId from studentreg where EnrollmentId=?";
			psdelete2=cn.prepareStatement(strsql);
			psdelete2.setString(1, id);
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

