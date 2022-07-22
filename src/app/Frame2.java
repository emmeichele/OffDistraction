package app;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JLabel;

public class Frame2 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private String pid;
	private String pidfile;
	/**
	 * Launch the application disable list frame.
	 */

	/**
	 * Create the application disable list frame.
	 */
	public Frame2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 324, 240);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(42, 181, 130, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Active");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textField.repaint();										//aggiorno il valore del textField 
				pid = textField.getText();	
				pidfile = executeCmd();
				
				if(pid.equals(pidfile)) {
					
					activeapps();
					
				}
				else if(pid.equals("")) {
					
					MessageLog Selected = new MessageLog(null,null,"Plese select a app to disable");
					Selected.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					Selected.setVisible(true);
				}
				
				
				
			}
		});
		btnNewButton.setBounds(170, 178, 74, 29);
		contentPane.add(btnNewButton);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(42, 33, 130, 136);
		contentPane.add(textArea);
		String x = executeCmd();
		textArea.setText(x);
		textArea.setEditable(false);	
		contentPane.add(textArea, BorderLayout.CENTER);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
		});
		btnNewButton_1.setBounds(244, 178, 74, 29);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Pid:");
		lblNewLabel.setBounds(6, 183, 30, 16);
		contentPane.add(lblNewLabel);
	}
	
	public void activeapps() {
		
		try {
			System.out.println("path: " + System.getProperty("user.dir"));
			Process p = Runtime.getRuntime().exec("sudo -S sh " + System.getProperty("user.dir") + "/src/app/static/activeapps.sh " + pid );
			OutputStream os = p.getOutputStream();
			    os.write("codaslowpoke\n".getBytes());
			    os.flush();
			    os.close();
			   		
			    
		} catch (IOException e) {
			
			e.printStackTrace();
		}	
		
		
	}
	
	public String executeCmd() { //metodo che legge il pid file (myShell.pid) e killa il processo tramite activeapps.sh
		
		String extract_pid = null;
		
		 try {
		      File myObj = new File("myShell.pid");
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        extract_pid = data;
		        System.out.println("pid: "+ extract_pid);
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("Error on read id.pid or id.pid file doesn't exist");
		      e.printStackTrace();
		    }
		 
		 
		 return extract_pid;
	}
}
