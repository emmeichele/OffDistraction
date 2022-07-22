package app;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.List;
import java.awt.CardLayout;
import javax.swing.JLayeredPane;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import java.awt.Canvas;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.TextArea;
import javax.swing.JTextField;
import javax.swing.JList;

public class MessageLog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	
	
	
	/**
	 * When launch the application.
	 
	public static void main(String[] args) {
		try {
			MessageLog dialog = new MessageLog("example","1"," is already disabled for ");
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	*/
	/**
	 * Create the message dialog when press lock button
	 */
	public MessageLog(String app, String hour, String message) {
		setTitle("DistractiOFF");
		setBounds(100, 100, 412, 221);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new CardLayout(0, 0));
		{
			JLayeredPane layeredPane = new JLayeredPane();
			contentPanel.add(layeredPane, "name_19956488101127");
			
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
			lblNewLabel.setBounds(352, 59, 32, 32);
			layeredPane.add(lblNewLabel);
			
			ImageIcon img = new ImageIcon("/Users/michelecorcione/eclipse-workspace/OffDistraction/src/app/static/accept1.png");
			lblNewLabel.setIcon(img);
			
			Label label = new Label("Message:");
			label.setBounds(0, 0, 141, 24);
			layeredPane.add(label);
			
			if(app == null)
				app = "";
			
			if(hour == null)
				hour="";
			
			JLabel lblNewLabel_1 = new JLabel(app + message + hour);
			lblNewLabel_1.setBounds(25, 69, 291, 16);
			layeredPane.add(lblNewLabel_1);
			
			
			
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						dispose();
						
					}
				});
				
				JButton btnNewButton = new JButton("disabled list");
				buttonPane.add(btnNewButton);
				
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						//fare frame per la vista delle app disabilitate
						//creare azione 
						
					}
				});
				
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			
			
			
		}
	}
}
