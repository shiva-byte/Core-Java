package pro.gui;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Bus extends JFrame implements ActionListener
{

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bus frame = new Bus();
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
	public Bus() 
	{
		setTitle("Bus Entry");
		createGui();
	}
	
	public void createGui()
	{

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	
		setBounds(00, 00, 1366, 760);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 205, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("View Bus");
		btnNewButton.addActionListener(this);
		btnNewButton.setFont(new Font("Gabriola", Font.BOLD, 22));
		btnNewButton.setBounds(636, 238, 114, 42);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Add Bus");
		btnNewButton_1.addActionListener(this);
		btnNewButton_1.setFont(new Font("Gabriola", Font.BOLD, 22));
		btnNewButton_1.setBounds(650, 358, 114, 35);
		contentPane.add(btnNewButton_1);
		
		JLabel label = new JLabel("");
		label.setFont(new Font("Sitka Heading", Font.BOLD, 16));
		label.setIcon(new ImageIcon(Bus.class.getResource("/pro/images/stock-vector-vector-bus-111822605.jpg")));
		label.setBounds(451, 137, 486, 434);
		contentPane.add(label);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(this);
		btnNewButton_2.setIcon(new ImageIcon(Bus.class.getResource("/pro/images/adjusthome.jpg")));
		btnNewButton_2.setBounds(1309, 0, 41, 35);
		contentPane.add(btnNewButton_2);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Bus.class.getResource("/pro/images/Busdetail4.png")));
		label_1.setBounds(0, 0, 1350, 721);
		contentPane.add(label_1);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		String Caption = e.getActionCommand();
		if(Caption.equals("Add Bus"))
		{
			BusEntry be= new BusEntry();
			be.setVisible(true);
			
			this.dispose();
		}
			if(Caption.equals("View Bus"))
			{
				 ViewBus vb=new ViewBus();
				vb.setVisible(true);
				this.dispose();
			
			
		}
			if(Caption.equals(""))
			{
				RegistrationPortal rg= new RegistrationPortal();
				rg.setVisible(true);
				this.dispose();
			}
		
	}
}
