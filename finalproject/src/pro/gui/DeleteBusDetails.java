package pro.gui;
import java.awt.event.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.sql.*;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
public class DeleteBusDetails extends JFrame implements ActionListener,KeyListener 
{

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteBusDetails frame = new DeleteBusDetails();
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
	public DeleteBusDetails() 
	{
		setTitle("DeleteBusDetails");
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
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(this);
		btnDelete.addKeyListener(this);
		btnDelete.setFont(new Font("Gabriola", Font.BOLD, 26));
		btnDelete.setBounds(435, 672, 116, 32);
		contentPane.add(btnDelete);
		
		JButton btnSaveExit = new JButton("Save & Exit");
		btnSaveExit.addActionListener(this);
		btnSaveExit.addKeyListener(this); 
		btnSaveExit.setFont(new Font("Gabriola", Font.BOLD, 26));
		btnSaveExit.setBounds(957, 667, 143, 32);
		contentPane.add(btnSaveExit);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(DeleteBusDetails.class.getResource("/pro/images/Transport (1).jpg")));
		label.setBounds(0, 0, 1350, 729);
		contentPane.add(label);
	
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
