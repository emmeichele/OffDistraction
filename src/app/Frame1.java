package app;
import app.WelcomeFrame;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import app.Admin;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import app.Application;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JFormattedTextField;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import java.awt.Panel;
import java.awt.Button;

public class Frame1 extends JFrame implements ActionListener{

	private JPanel contentPane;
	private TextField textField;
	public static String apps;
	private static ArrayList<String> apps_name = new ArrayList<String>();
	//private final ImageIcon icon = new ImageIcon("./static/accept.png");
	private ArrayList<String> disabledapps = new ArrayList<String>();
	private static String hours = null;
	private ImageIcon lock = new ImageIcon(System.getProperty("user.dir") + "/src/app/static/lock.png");
	private ImageIcon list = new ImageIcon(System.getProperty("user.dir") + "/src/app/static/application_view_list.png");
	private boolean flag=false;
	private static String passs;
	private Admin root = new Admin();
	
	
	
	/**
	 *	OffDistraction parental control
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					System.getProperty("user.dir");
					WelcomeFrame first = new WelcomeFrame();
					first.setVisible(true);
					
				//mi serve passare la password dell'admin per lanciare lo script bash da root
					//da finire 
					//System.out.println("primo passo al mainframe: "+ first.getAdministrator());
					
					
			
				/*	first.addWindowListener((WindowListener) new WindowAdapter() {
						
						
						public void windowClosing(WindowEvent e) {
							
							System.exit(0);
							
						}
						
					});
				*/
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Creo il main frame
	 */
	public Frame1() {
		
		
		setTitle("DistractOff");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 450, 403);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(50, 50, 50, 50));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(60, -1085, 276, 1216);
		String x = executeCmd();
		textArea.setText(x.replace(" ", ""));
		textArea.setEditable(false);	
		contentPane.add(textArea, BorderLayout.CENTER);
		
		JScrollPane scrollBar = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollBar.setBounds(30, 108, 295, 140);
		contentPane.add(scrollBar);
		
		
		
		JButton btnNewButton = new JButton(lock);
		btnNewButton.setLocation(331, 253);
		btnNewButton.setSize(66,60);
		btnNewButton.addActionListener(this);
		contentPane.add(btnNewButton);
		
		textField = new TextField();
		textField.setBounds(30, 273, 295, 22);
		textField.setText("Please paste here the app's name...");
		textField.setForeground(Color.RED);
		contentPane.add(textField);
		
		
		/*TextField textField_1 = new TextField();
		textField_1.setBounds(50, 207, 212, 22);
		textField_1.setText("Please paste here the app...");
		textField_1.setForeground(Color.RED);*/
		
		//contentPane.add(textField_1);
		
		JLabel lblNewLabel = new JLabel("Options:");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(337, 110, 74, 29);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		contentPane.add(lblNewLabel);
		
		
		JLabel lblPleaseSelectOne = new JLabel();
		String y ="<html>Welcome in OffDistraction parental control <br/>" + "<br/>"+ 
						"Start with copy app's name  (CRTL + C) and paste it to disable <br/>"+
						"Options: Select how much time the app will be disable <br/>"
						+"</html>";
		
		lblPleaseSelectOne.setText("<html>Welcome in DistractOff parental control <br/><br/>"
				+ "Start with copy app's name  (CRTL + C) paste and push  lock icon to disable <br/>"
				+ "Options: Select how much time the app will be disable <br/></html>");
		lblPleaseSelectOne.setVerticalAlignment(SwingConstants.TOP);
		lblPleaseSelectOne.setBounds(20, 6, 384, 90);
		contentPane.add(lblPleaseSelectOne);
		
		JRadioButton rdbtn_1 = new JRadioButton("1h");
		rdbtn_1.setBounds(337, 137, 74, 22);
		contentPane.add(rdbtn_1);
		
		
		
		
		JRadioButton rdbtnh_3 = new JRadioButton("3h");
		rdbtnh_3.setBounds(337, 171, 74, 22);
		contentPane.add(rdbtnh_3);
		
		
		
		JRadioButton rdbtnh_24 = new JRadioButton("24h");
		rdbtnh_24.setBounds(337, 205, 74, 22);
		contentPane.add(rdbtnh_24);
		
		JLabel lblNewLabel_1 = new JLabel("<html>Show disabled apps list:</html>");
		lblNewLabel_1.setBounds(173, 321, 152, 37);
		contentPane.add(lblNewLabel_1);
		
		Panel panel = new Panel();
		panel.setBounds(331, 108, 108, 140);
		contentPane.add(panel);
		
		JButton button = new JButton(list);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				//Azione del bottone lista 
				Frame2 list = new Frame2();
				
				if(root.getlock() == false) {
					
					String message = "Nessuna Applicazione è stata disabilitata";
					MessageLog dialog = new MessageLog(apps,hours,message);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				}
				else {
				list.setVisible(true);
				}
				
			}
		});
		button.setBounds(331, 311, 66, 60);
		contentPane.add(button);
		
		rdbtnh_24.addActionListener(new ActionListener () {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				JRadioButton btn = new JRadioButton();
				btn = (JRadioButton) e.getSource();
				
				hours ="24";
				System.out.println("tempo:" + hours + "\n");
				//rdbtn_1.setEnabled(false);
				//rdbtnh_3.setEnabled(false);
				//System.out.println("hours: " + hours);
			}
		
		});
		
		rdbtn_1.addActionListener(new ActionListener () {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				JRadioButton btn = (JRadioButton)e.getSource();
				hours = "1";
				System.out.println("tempo:" + hours + "\n");
				//rdbtnh_3.setEnabled(false);
				//rdbtnh_24.setEnabled(false);
			}
			
			
		});
		
		rdbtnh_3.addActionListener(new ActionListener() {
	
	@Override
		public void actionPerformed(ActionEvent e) {
		
			JRadioButton btn = (JRadioButton) e.getSource();
			hours = "3";
			System.out.println("tempo:" + hours + "\n");
			//rdbtn_1.setEnabled(false);
			//rdbtnh_24.setEnabled(false);
			}
	
		});

	}
	
	/*
	 * Metodo che esegue lo script per la chiusura delle applicazioni 
	*/
	public static void quittingApps() {
		
	Admin copy = new Admin();
	copy = Admin.getAdmins(0);
		
	String xxx = copy.getPassword() + "\n";
	System.out.println("sto dentro il quit: " + xxx);
	
		try {
			System.out.println("path: " + System.getProperty("user.dir"));
			Process p = Runtime.getRuntime().exec("sudo -S sh " + System.getProperty("user.dir") + "/src/app/static/quittingapps2.sh " + apps + " " + hours);
			OutputStream os = p.getOutputStream();
			    os.write(xxx.getBytes());
			    os.flush();
			    os.close();
			  
			    
		} catch (IOException e) {
			
			e.printStackTrace();
		}	
	}
	
	/*
	* Metodo per la stampa delle applicazioni in textArea;
	*/
	public static String executeCmd() {
		
		String line = null;
		String get = "";
		
		try {
			Process p = Runtime.getRuntime().exec("ls /Applications");								//esegue il comando ls 
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));	//salva la stampa in un buffer
			
			while(true) {
				if(!((line = reader.readLine()) != null)) break;
				
				get = get + line + "\n";
				apps_name.add(line.replace(" ", ""));
				//System.out.println("we fratm questa è una linea: " + line.replace(" ", ""));
				
			}
		}
		catch(Exception e ) {e.printStackTrace();}
		
		return get;
		
	}
	
	/*
	*	Metodo per la cattura del comportamento del bottone "disable (icona lucchetto)"
	*/
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
			root.setlock(true);
		//	System.out.println("password:" + pw + "prova dello slash n");
			textField.repaint();										//aggiorno il valore del textField 
			apps = textField.getText();									//con il nome dell'app passata dal costumer;
		
			
			if(apps.equals("Please paste here the app's name..."))
			{
				
				MessageLog notSelected = new MessageLog(null,null,"Please select a app to disable...");
				notSelected.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				notSelected.setVisible(true);
			//	showMessageDialog(null,"Please select a app to disable...");
				
			}
			else if(apps.equals(""))
			{
				MessageLog Selected = new MessageLog(null,null,"Plese select a app to disable");
				Selected.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				Selected.setVisible(true);
				
				
				//showMessageDialog(null,"Plese select a app to disable!");
			}
		
			for(int i =0;i<apps_name.size();i++) {
			//	System.out.println(apps_name.get(i) + "\n");
				if(!apps_name.get(i).equals(apps))
					continue;
				else
				{
					
					if(!disabledapps.isEmpty()) {
					
						for(int j = 0;j<disabledapps.size();j++) {
							
							if(disabledapps.get(j).equals(apps)) {
								
								String message = "is already disabled for ";
								MessageLog dialog = new MessageLog(apps,hours,message);
								dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
								dialog.setVisible(true);
								/*
									showMessageDialog(null, apps +" is already disabled for " + hours);
								*/
								flag=true;
								
							}else {
								continue;
							}	
						}
					}
					else
						disabledapps.add(apps);
						
					if(flag) {
						
						flag=false;
						break;
					}else {
						
						quittingApps();
					}
					
					//FINIRE LA PARTE DEL MESSAGE DIALOG PER MOSTRARE LE APP DISABILITATE
					String message1 = " has been disabled for ";
					MessageLog dialog = new MessageLog(apps,hours,message1);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
					/*
					
					showMessageDialog(null, apps +" has been disabled for " + hours);
					//break;
					*/
				}		
			}	
	}
	
	public String getNameApp() {return apps;}
}
