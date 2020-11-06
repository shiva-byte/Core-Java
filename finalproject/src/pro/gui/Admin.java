package pro.gui;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;
public class Admin extends JFrame implements ActionListener
{

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin frame = new Admin();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public Admin()
	{
		setResizable(false);
		setRootPaneCheckingEnabled(false);
		createGui();
	}
	public void createGui()
	{

		setTitle("Welcome");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(00, 00, 1365, 768);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcome = new JLabel("WELCOME!");
		lblWelcome.setFont(new Font("Gabriola", Font.BOLD, 48));
		lblWelcome.setBounds(635, 99, 261, 41);
		contentPane.add(lblWelcome);
		
		JButton btnAdminLogin = new JButton("Admin Login");
		btnAdminLogin.addActionListener(this);
		btnAdminLogin.setBackground(new Color(0, 102, 51));
		btnAdminLogin.setFont(new Font("Gabriola", Font.BOLD, 22));
		btnAdminLogin.setBounds(689, 347, 152, 41);
		contentPane.add(btnAdminLogin);
		
		JLabel label = new JLabel("");
		label.setMinimumSize(new Dimension(100, 100));
		label.setMaximumSize(new Dimension(100, 100));
		label.setBackground(new Color(0, 102, 51));
		label.setIcon(new ImageIcon(Admin.class.getResource("/pro/images/8931656_Travancore-Engineering-College-x.jpg")));
		label.setBounds(0,0, 1359, 741);
		contentPane.add(label);

	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String caption= e.getActionCommand();
		if(caption.equals("Admin Login"))
		{
			AdminLogin adl= new AdminLogin();
			adl.setVisible(true);
			this.dispose();
		}
		
	}
}
