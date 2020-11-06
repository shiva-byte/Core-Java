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
import javax.swing.JComboBox;
import java.awt.Font;

public class StudentEdit extends JFrame implements ActionListener
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
					StudentEdit frame = new StudentEdit();
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
	public StudentEdit()
	{
	cn= CrudOperation.createConnection();
		create();
	}
	

	private void create()
	{
		setTitle("Update Student Detail");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(00, 00, 1365, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterStudentEnrollmentid = new JLabel("Enter  EnrollmentID");
		lblEnterStudentEnrollmentid.setFont(new Font("Gabriola", Font.BOLD, 32));
		lblEnterStudentEnrollmentid.setBounds(598, 277, 239, 37);
		contentPane.add(lblEnterStudentEnrollmentid);
		
		textid = new JTextField();
		textid.setBounds(639, 379, 172, 37);
		contentPane.add(textid);
		textid.setColumns(10);
		
		JButton btnUpdate = new JButton("Update Details");
		btnUpdate.setFont(new Font("Gabriola", Font.BOLD, 26));
		btnUpdate.addActionListener(this);
		btnUpdate.setBounds(474, 520, 172, 43);
		contentPane.add(btnUpdate);
		
		JButton btnDeleteRecord = new JButton("Delete Record");
		btnDeleteRecord.setFont(new Font("Gabriola", Font.BOLD, 26));
		btnDeleteRecord.addActionListener(this);
		btnDeleteRecord.setBounds(820, 520, 177, 43);
		contentPane.add(btnDeleteRecord);
		
		JButton button = new JButton("");
		button.addActionListener(this);
		button.setIcon(new ImageIcon(StudentEdit.class.getResource("/pro/images/adjusthome.jpg")));
		button.setBounds(0, 0, 33, 37);
		contentPane.add(button);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(StudentEdit.class.getResource("/pro/images/upgrade-software-gestionale-illimitati.png")));
		lblNewLabel.setBounds(0, 0, 1339, 730);
		contentPane.add(lblNewLabel);
		
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		String Caption= e.getActionCommand();
		int confirm=0;
		id=textid.getText();
		if(Caption.equals(""))
		{
			RegistrationPortal rg= new RegistrationPortal();
			rg.setVisible(true);
			this.dispose();
		}else {
		if(id.isEmpty())
		{
			JOptionPane.showMessageDialog(this, "Enter the EnrollmentId", "Error", NORMAL);
		}
		else
		{
		
		if(Caption.equals("Update Details"))
		{
			if(checkenroll(id)==true) {
		
			StudentUpdate su= new StudentUpdate();
			su.setVisible(true);
		}
			else
			{
				JOptionPane.showMessageDialog(this, "No such EnrollmentId found", "Wrong Credential", NORMAL);
			}
		}
		if(Caption.equals("Delete Record"))
		{
			if(checkenroll(id)==true) 
			{
		
			  confirm = JOptionPane.showConfirmDialog(this, "are u sure to delete");
			if(confirm==0)
			{
			try
			{
			String sql="delete from studentreg where EnrollmentId=? ";
			psdelete= cn.prepareStatement(sql);
			psdelete.setString(1, StudentEdit.id);
			rw=psdelete.executeUpdate();
			if(rw>0)
			{
				{
					JOptionPane.showMessageDialog(this, "Record Deleted Successfully");
					this.dispose();
					textid.setText("");
				
				}
			}
			
		}catch(SQLException sq)
			{
			System.out.println(sq);
			}
			
			}
			}
			else {
				JOptionPane.showMessageDialog(this,"no such id present");
			}
			}
			
			}
		
			
		}}
		
	
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

