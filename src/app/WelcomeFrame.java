package app;
import app.Frame1;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Canvas;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

public class WelcomeFrame extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private String passw;
	private  Admin administrator = new Admin();
	private JTextField textField;
	
	/**
	 * Welcome Frame
	 */
	public WelcomeFrame() {
		setTitle("DistractOff");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 307);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/*	passwordField = new JPasswordField();
			passwordField.setBounds(76, 178, 307, 26);					password field
			contentPane.add(passwordField);					*/
		
		JLabel lblNewLabel = new JLabel("\t \t DistractiOFF Parental Control\n");
		lblNewLabel.setBounds(121, 152, 217, 16);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Start");
		btnNewButton.setBounds(168, 228, 117, 29);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener () {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				textField.repaint();										//aggiorno il valore del textField 
				passw = textField.getText();
				System.out.println(" "+ passw);
				Admin first = new Admin();
				first.setPassword(passw);
				Admin.setAdmins(first);
				System.out.println("we questo è il get passwd: " + first.getPassword());
			//	@SuppressWarnings("deprecation")
				
				//String x =  passwordField.getText();
				//qui devo passare la password;
				//System.out.println("pass in welcomeframe: "+x);
				
				//administrator.setPassword(String.valueOf(passwordField.getPassword()));		password field and storage
				//System.out.println("pass in welcomeframe: "+administrator.getPassword());
				setVisible(false);
				Frame1 frame = new Frame1();
				frame.setVisible(true);
				System.out.println(System.getProperty("user.dir"));
				
			}
			
			
		});
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("/Users/michelecorcione/Desktop/style_app/icontest.png"));
		lblNewLabel_1.setBounds(111, 17, 237, 135);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(121, 197, 217, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
	}
	
	public void setAdministrator(String x) {
		
		administrator.setPassword(x);
		
	}
	
	public String getAdministrator() {return administrator.getPassword();}
}
