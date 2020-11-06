package pro.gui;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JTextField;
import java.awt.Point;
import java.awt.Frame;
import javax.swing.JPasswordField;

public class AdminLogin extends JFrame implements ActionListener
{
	private JTextField textField;
	private JPasswordField txtpass;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() 
			{
				try {
					AdminLogin frame = new AdminLogin();
					frame.setVisible(true);
				}
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public AdminLogin()
	{

		createGui();
		}
	public void createGui()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1366, 768);
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setIconImage(Toolkit.getDefaultToolkit().getImage(AdminLogin.class.getResource("/pro/images/admin.png")));
		getContentPane().setBackground(new Color(102, 153, 153));
		getContentPane().setLayout(null);
//		
//		JLabel label = new JLabel("");
//		label.setLocation(new Point(240, 240));
//		label.setIcon(new ImageIcon(AdminLogin.class.getResource("/pro/images/admin_login_layout.png")));
//		label.setBounds(338, 138, 141, 176);
//		getContentPane().add(label);
		
		JLabel lblAdminid = new JLabel("AdminId");
		lblAdminid.setFont(new Font("Gabriola", Font.BOLD, 22));
		lblAdminid.setBounds(594, 175, 89, 30);
		getContentPane().add(lblAdminid);
		
		textField = new JTextField();
		textField.setBounds(785, 175, 119, 23);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblAdminpassword = new JLabel("AdminPassword");
		lblAdminpassword.setFont(new Font("Gabriola", Font.BOLD, 22));
		lblAdminpassword.setBounds(594, 252, 132, 23);
		getContentPane().add(lblAdminpassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(this);
		btnLogin.setForeground(new Color(102, 0, 102));
		btnLogin.setFont(new Font("Gabriola", Font.BOLD, 22));
		btnLogin.setBounds(677, 342, 119, 30);
		getContentPane().add(btnLogin);
		
		txtpass = new JPasswordField();
		txtpass.setBounds(785, 253, 119, 23);
		getContentPane().add(txtpass);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(AdminLogin.class.getResource("/pro/images/admin shiva.gif")));
		lblNewLabel.setBounds(0, 0, 1366, 768);
		getContentPane().add(lblNewLabel);
		setTitle("AdminLogin");
		
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		{
			String adminid=textField.getText();
			char[]arr=txtpass.getPassword();
			String adminpass=new String(arr);
			if(adminid.isEmpty()||adminpass.isEmpty())
				
			{
				JOptionPane.showMessageDialog(this,"AdminId and AdminPassword needed to process further");
			}
			else
			{
				if(adminid.equals("Admin@1819")&& adminpass.equals("project"))
				{
					RegistrationPortal rp=new RegistrationPortal();
					rp.setVisible(true);
					this.dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Invalid adminId or adminPassword ");
					
				}

		}
		}
		
	}
}
