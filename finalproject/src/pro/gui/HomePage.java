package pro.gui;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Color;
import java.awt.Rectangle;

public class HomePage extends JFrame implements ActionListener

{

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage frame = new HomePage();
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
	public HomePage()
	{
		setTitle("HOMEPAGE");
		createGui();
	}
	public void createGui()
	{

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(00, 00, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAdministration = new JButton("Administration");
		btnAdministration.setFont(new Font("Gabriola", Font.BOLD, 22));
		btnAdministration.addActionListener(this);
		btnAdministration.setBounds(683, 384, 156, 44);
		contentPane.add(btnAdministration);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1366, 30);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Info");
		mnNewMenu.setBackground(Color.BLUE);
		menuBar.add(mnNewMenu);
		
		JMenu mnAdmissions = new JMenu("Admissions");
		menuBar.add(mnAdmissions);
		
		JMenu mnGallery = new JMenu("Gallery");
		mnGallery.setBounds(new Rectangle(0, 0, 10, 5));
		menuBar.add(mnGallery);
		
		JMenu mnPlacements = new JMenu("Placements");
		menuBar.add(mnPlacements);
		
		JMenu mnScholarship = new JMenu("Scholarship");
		menuBar.add(mnScholarship);
		
		JMenu mnFaculty = new JMenu("Faculty");
		menuBar.add(mnFaculty);
		
		JLabel lblAboutUs = new JLabel("About Us");
		lblAboutUs.setFont(new Font("Gabriola", Font.BOLD, 22));
		lblAboutUs.setBounds(30, 77, 85, 30);
		contentPane.add(lblAboutUs);
		
		JLabel lblAchievements = new JLabel("Achievements");
		lblAchievements.setFont(new Font("Gabriola", Font.BOLD, 20));
		lblAchievements.setBounds(30, 133, 107, 22);
		contentPane.add(lblAchievements);
		
		JLabel lblCourses = new JLabel("Courses");
		lblCourses.setFont(new Font("Gabriola", Font.BOLD, 22));
		lblCourses.setBounds(38, 182, 77, 22);
		contentPane.add(lblCourses);
		
		JLabel lblFees = new JLabel("Fees");
		lblFees.setFont(new Font("Gabriola", Font.BOLD, 22));
		lblFees.setBounds(53, 238, 60, 22);
		contentPane.add(lblFees);
		
		JLabel lblContactUs = new JLabel("Contact Us");
		lblContactUs.setFont(new Font("Gabriola", Font.BOLD, 22));
		lblContactUs.setBounds(42, 302, 95, 22);
		contentPane.add(lblContactUs);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(HomePage.class.getResource("/pro/images/blue_line_182942.jpg")));
		label_1.setBackground(Color.PINK);
		label_1.setBounds(0, 30, 156, 356);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(HomePage.class.getResource("/pro/images/blue_line_182942.jpg")));
		label_2.setBounds(0, 384, 156, 345);
		contentPane.add(label_2);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(HomePage.class.getResource("/pro/images/welcome shiva.jpg")));
		label.setBounds(0, 0, 1366, 729);
		contentPane.add(label);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		String Caption = e.getActionCommand();
		if (Caption.equals("Administration"))
		{
			Admin ad= new Admin();
			ad.setVisible(true);
			this.dispose();
		}
		
	}
}
